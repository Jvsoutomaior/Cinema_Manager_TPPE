import os
import pytest
from fastapi.testclient import TestClient
from sqlalchemy import create_engine
from sqlalchemy.orm import sessionmaker
from sqlalchemy.pool import StaticPool

# Set testing environment variable
os.environ["TESTING"] = "true"

from app.main import app
from app.database import get_db, Base

# Create an in-memory SQLite database for testing
SQLALCHEMY_DATABASE_URL = "sqlite:///./test.db"

test_engine = create_engine(
    SQLALCHEMY_DATABASE_URL,
    connect_args={"check_same_thread": False},
    poolclass=StaticPool,
)

TestingSessionLocal = sessionmaker(autocommit=False, autoflush=False, bind=test_engine)

@pytest.fixture(scope="session", autouse=True)
def setup_test_database():
    """Create all tables at the start of test session and drop them at the end"""
    Base.metadata.create_all(bind=test_engine)
    yield
    # Optionally drop tables after all tests (uncomment if needed)
    Base.metadata.drop_all(bind=test_engine)

@pytest.fixture(scope="function")
def db_session():
    """
    Create a database session with transaction rollback after each test.
    This ensures complete isolation between tests.
    """
    connection = test_engine.connect()
    transaction = connection.begin()
    session = TestingSessionLocal(bind=connection)
    
    yield session
    
    session.close()
    transaction.rollback()
    connection.close()

@pytest.fixture(scope="function")
def client(db_session):
    """
    Create a test client with overridden database dependency.
    Each test gets a fresh database state.
    """
    def override_get_db():
        try:
            yield db_session
        finally:
            pass
    
    app.dependency_overrides[get_db] = override_get_db
    
    with TestClient(app) as test_client:
        yield test_client
    
    # Clean up the override after each test
    app.dependency_overrides.clear()

# Helper functions for test data cleanup (if needed as backup)
def truncate_tables(session, *table_names):
    """Helper function to truncate specific tables if rollback fails"""
    for table_name in table_names:
        try:
            session.execute(f"TRUNCATE TABLE {table_name} RESTART IDENTITY CASCADE;")
            session.commit()
        except Exception as e:
            session.rollback()
            print(f"Warning: Could not truncate {table_name}: {e}")

def delete_all_records(session, model_class):
    """Helper function to delete all records from a specific model"""
    try:
        session.query(model_class).delete()
        session.commit()
    except Exception as e:
        session.rollback()
        print(f"Warning: Could not delete records from {model_class.__name__}: {e}")

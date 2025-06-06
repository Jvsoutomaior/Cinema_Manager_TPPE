from fastapi.testclient import TestClient
from app.main import app
import pytest
from sqlalchemy.orm import Session
from app.database import SessionLocal, Base, engine
from app.models.filme import Filme

client = TestClient(app)

@pytest.fixture(scope="function")
def db():
    # Create all tables
    Base.metadata.create_all(bind=engine)
    
    # Create a new database session for the test
    db = SessionLocal()
    try:
        yield db
    finally:
        db.close()
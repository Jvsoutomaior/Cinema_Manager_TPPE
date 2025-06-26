import os
from sqlalchemy import create_engine
from sqlalchemy.orm import sessionmaker, declarative_base
from typing import Generator

# Use environment variable for database URL, with fallback for Docker
DATABASE_URL = os.getenv("DATABASE_URL", "postgresql://admin:password@database:5432/MyDatabase")

# For local testing, use SQLite instead of PostgreSQL
if os.getenv("TESTING") == "true":
    DATABASE_URL = "sqlite:///./test.db"

# Configure engine based on database type
if "sqlite" in DATABASE_URL:
    engine = create_engine(DATABASE_URL, echo=True, connect_args={"check_same_thread": False})
else:
    engine = create_engine(DATABASE_URL, echo=True)

SessionLocal = sessionmaker(autocommit=False, autoflush=False, bind=engine)

Base = declarative_base()

# Create the tables (can also be done with Alembic later)
def init_db():
    # Only create tables if not in testing mode or if explicitly requested
    if os.getenv("TESTING") != "true":
        Base.metadata.create_all(bind=engine)

# Dependency to get DB session
def get_db() -> Generator:
    db = SessionLocal()
    try:
        yield db
    finally:
        db.close()

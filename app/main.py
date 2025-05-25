from fastapi import FastAPI, Depends, HTTPException
from sqlalchemy.orm import Session
from app.database import SessionLocal, init_db
from app.models import User
from fastapi.middleware.cors import CORSMiddleware
from .routers import router
from .database import engine, Base

app = FastAPI(
    title="Cinema API",
    description="API for managing a cinema system",
    version="1.0.0"
)

# Configure CORS
app.add_middleware(
    CORSMiddleware,
    allow_origins=["*"],  # Allows all origins
    allow_credentials=True,
    allow_methods=["*"],  # Allows all methods
    allow_headers=["*"],  # Allows all headers
)

# Dependency
def get_db():
    db = SessionLocal()
    try:
        yield db
    finally:
        db.close()

# Create tables at startup
init_db()

# Create database tables
Base.metadata.create_all(bind=engine)

# Include router
app.include_router(router, prefix="/api/v1")

@app.get("/health")
def orm_health_check(db: Session = Depends(get_db)):
    try:
        # Check if we can query the User table
        users = db.query(User).limit(1).all()
        return {"status": "ok", "user_count": len(users)}
    except Exception as e:
        raise HTTPException(status_code=500, detail=f"DB Error: {e}")

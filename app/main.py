from fastapi import FastAPI, Depends, HTTPException
from sqlalchemy.orm import Session
from app.database import SessionLocal, init_db
from app.models import User

app = FastAPI()

# Dependency
def get_db():
    db = SessionLocal()
    try:
        yield db
    finally:
        db.close()

# Create tables at startup
init_db()

@app.get("/health")
def orm_health_check(db: Session = Depends(get_db)):
    try:
        # Check if we can query the User table
        users = db.query(User).limit(1).all()
        return {"status": "ok", "user_count": len(users)}
    except Exception as e:
        raise HTTPException(status_code=500, detail=f"DB Error: {e}")

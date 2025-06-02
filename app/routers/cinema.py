from fastapi import APIRouter, Depends, HTTPException
from sqlalchemy.orm import Session
from typing import List
from .. import models
from ..schemas import cinema as schemas
from ..database import get_db

router = APIRouter()

# @router.post("/", response_model=schemas.Cinema)
# def create_cinema(cinema: schemas.CinemaCreate, db: Session = Depends(get_db)):
#     db_cinema = models.Cinema(**cinema.model_dump())
#     db.add(db_cinema)
#     db.commit()
#     db.refresh(db_cinema)
#     return db_cinema

# @router.get("/", response_model=List[schemas.Cinema])
# def read_cinemas(skip: int = 0, limit: int = 100, db: Session = Depends(get_db)):
#     cinemas = db.query(models.Cinema).offset(skip).limit(limit).all()
#     return cinemas

# @router.get("/{cinema_id}", response_model=schemas.Cinema)
# def read_cinema(cinema_id: int, db: Session = Depends(get_db)):
#     db_cinema = db.query(models.Cinema).filter(models.Cinema.id == cinema_id).first()
#     if db_cinema is None:
#         raise HTTPException(status_code=404, detail="Cinema not found")
#     return db_cinema

# @router.put("/{cinema_id}", response_model=schemas.Cinema)
# def update_cinema(cinema_id: int, cinema: schemas.CinemaUpdate, db: Session = Depends(get_db)):
#     db_cinema = db.query(models.Cinema).filter(models.Cinema.id == cinema_id).first()
#     if db_cinema is None:
#         raise HTTPException(status_code=404, detail="Cinema not found")
    
#     for key, value in cinema.model_dump(exclude_unset=True).items():
#         setattr(db_cinema, key, value)
    
#     db.commit()
#     db.refresh(db_cinema)
#     return db_cinema

# @router.delete("/{cinema_id}")
# def delete_cinema(cinema_id: int, db: Session = Depends(get_db)):
#     db_cinema = db.query(models.Cinema).filter(models.Cinema.id == cinema_id).first()
#     if db_cinema is None:
#         raise HTTPException(status_code=404, detail="Cinema not found")
    
#     db.delete(db_cinema)
#     db.commit()
#     return {"message": "Cinema deleted successfully"} 
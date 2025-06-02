from fastapi import APIRouter, Depends, HTTPException
from sqlalchemy.orm import Session
from typing import List
from .. import models
from ..schemas import ingresso as schemas
from ..database import get_db

router = APIRouter()

# @router.post("/", response_model=schemas.Ingresso)
# def create_ingresso(ingresso: schemas.IngressoCreate, db: Session = Depends(get_db)):
#     db_ingresso = models.Ingresso(**ingresso.model_dump())
#     db.add(db_ingresso)
#     db.commit()
#     db.refresh(db_ingresso)
#     return db_ingresso

# @router.get("/", response_model=List[schemas.Ingresso])
# def read_ingressos(skip: int = 0, limit: int = 100, db: Session = Depends(get_db)):
#     ingressos = db.query(models.Ingresso).offset(skip).limit(limit).all()
#     return ingressos

# @router.get("/{ingresso_id}", response_model=schemas.Ingresso)
# def read_ingresso(ingresso_id: int, db: Session = Depends(get_db)):
#     db_ingresso = db.query(models.Ingresso).filter(models.Ingresso.id == ingresso_id).first()
#     if db_ingresso is None:
#         raise HTTPException(status_code=404, detail="Ingresso not found")
#     return db_ingresso

# @router.put("/{ingresso_id}", response_model=schemas.Ingresso)
# def update_ingresso(ingresso_id: int, ingresso: schemas.IngressoUpdate, db: Session = Depends(get_db)):
#     db_ingresso = db.query(models.Ingresso).filter(models.Ingresso.id == ingresso_id).first()
#     if db_ingresso is None:
#         raise HTTPException(status_code=404, detail="Ingresso not found")
    
#     for key, value in ingresso.model_dump(exclude_unset=True).items():
#         setattr(db_ingresso, key, value)
    
#     db.commit()
#     db.refresh(db_ingresso)
#     return db_ingresso

# @router.delete("/{ingresso_id}")
# def delete_ingresso(ingresso_id: int, db: Session = Depends(get_db)):
#     db_ingresso = db.query(models.Ingresso).filter(models.Ingresso.id == ingresso_id).first()
#     if db_ingresso is None:
#         raise HTTPException(status_code=404, detail="Ingresso not found")
    
#     db.delete(db_ingresso)
#     db.commit()
#     return {"message": "Ingresso deleted successfully"} 
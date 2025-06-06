from fastapi import APIRouter, Depends, HTTPException
from sqlalchemy.orm import Session
from typing import List
from ..models.filme import Filme as filmeModel
from ..schemas.filme import Filme, FilmeCreate, FilmeUpdate
from ..database import get_db

router = APIRouter()

@router.post("/", response_model=Filme)
def create_filme(filme: FilmeCreate, db: Session = Depends(get_db)):
    new_filme = filmeModel(**filme.model_dump())
    db.add(new_filme)
    db.commit()
    db.refresh(new_filme)
    return new_filme

@router.get("/{filme_id}", response_model=Filme)
def read_filme(filme_id: int, db: Session = Depends(get_db)):
    db_filme = db.query(filmeModel).filter(filmeModel.id == filme_id).first()
    if db_filme is None:
        raise HTTPException(status_code=404, detail="Filme not found")
    return db_filme

@router.get("/", response_model=List[Filme])
def read_filmes(skip: int = 0, limit: int = 100, db: Session = Depends(get_db)):
    filmes = db.query(filmeModel).offset(skip).limit(limit).all()
    return filmes


@router.put("/{filme_id}", response_model=Filme)
def update_filme(filme_id: int, filme: FilmeUpdate, db: Session = Depends(get_db)):
    db_filme = db.query(filmeModel).filter(filmeModel.id == filme_id).first()
    if db_filme is None:
        raise HTTPException(status_code=404, detail="Filme not found")
    
    for key, value in filme.model_dump(exclude_unset=True).items():
        setattr(db_filme, key, value)
    
    db.commit()
    db.refresh(db_filme)
    return db_filme

@router.delete("/{filme_id}")
def delete_filme(filme_id: int, db: Session = Depends(get_db)):
    db_filme = db.query(filmeModel).filter(filmeModel.id == filme_id).first()
    if db_filme is None:
        raise HTTPException(status_code=404, detail="Filme not found")
    
    db.delete(db_filme)
    db.commit()
    return {"message": "Filme deleted successfully"} 
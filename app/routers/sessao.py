from fastapi import APIRouter, Depends, HTTPException
from sqlalchemy.orm import Session
from typing import List
from .. import models
from ..schemas import sessao as schemas
from ..database import get_db

router = APIRouter()

# Sessao endpoints
@router.post("/", response_model=schemas.Sessao)
def create_sessao(sessao: schemas.SessaoCreate, db: Session = Depends(get_db)):
    db_sessao = models.Sessao(**sessao.model_dump())
    db.add(db_sessao)
    db.commit()
    db.refresh(db_sessao)
    return db_sessao

@router.get("/", response_model=List[schemas.Sessao])
def read_sessoes(skip: int = 0, limit: int = 100, db: Session = Depends(get_db)):
    sessoes = db.query(models.Sessao).offset(skip).limit(limit).all()
    return sessoes

@router.get("/{sessao_id}", response_model=schemas.Sessao)
def read_sessao(sessao_id: int, db: Session = Depends(get_db)):
    db_sessao = db.query(models.Sessao).filter(models.Sessao.id == sessao_id).first()
    if db_sessao is None:
        raise HTTPException(status_code=404, detail="Sessao not found")
    return db_sessao

@router.put("/{sessao_id}", response_model=schemas.Sessao)
def update_sessao(sessao_id: int, sessao: schemas.SessaoUpdate, db: Session = Depends(get_db)):
    db_sessao = db.query(models.Sessao).filter(models.Sessao.id == sessao_id).first()
    if db_sessao is None:
        raise HTTPException(status_code=404, detail="Sessao not found")
    
    for key, value in sessao.model_dump(exclude_unset=True).items():
        setattr(db_sessao, key, value)
    
    db.commit()
    db.refresh(db_sessao)
    return db_sessao

@router.delete("/{sessao_id}")
def delete_sessao(sessao_id: int, db: Session = Depends(get_db)):
    db_sessao = db.query(models.Sessao).filter(models.Sessao.id == sessao_id).first()
    if db_sessao is None:
        raise HTTPException(status_code=404, detail="Sessao not found")
    
    db.delete(db_sessao)
    db.commit()
    return {"message": "Sessao deleted successfully"}

# DataHorario endpoints
@router.post("/datas-horarios/", response_model=schemas.DataHorario)
def create_data_horario(data_horario: schemas.DataHorarioCreate, db: Session = Depends(get_db)):
    db_data_horario = models.DataHorario(**data_horario.model_dump())
    db.add(db_data_horario)
    db.commit()
    db.refresh(db_data_horario)
    return db_data_horario

@router.get("/datas-horarios/", response_model=List[schemas.DataHorario])
def read_datas_horarios(skip: int = 0, limit: int = 100, db: Session = Depends(get_db)):
    datas_horarios = db.query(models.DataHorario).offset(skip).limit(limit).all()
    return datas_horarios

@router.get("/datas-horarios/{data_horario_id}", response_model=schemas.DataHorario)
def read_data_horario(data_horario_id: int, db: Session = Depends(get_db)):
    db_data_horario = db.query(models.DataHorario).filter(models.DataHorario.id == data_horario_id).first()
    if db_data_horario is None:
        raise HTTPException(status_code=404, detail="DataHorario not found")
    return db_data_horario

@router.put("/datas-horarios/{data_horario_id}", response_model=schemas.DataHorario)
def update_data_horario(data_horario_id: int, data_horario: schemas.DataHorarioUpdate, db: Session = Depends(get_db)):
    db_data_horario = db.query(models.DataHorario).filter(models.DataHorario.id == data_horario_id).first()
    if db_data_horario is None:
        raise HTTPException(status_code=404, detail="DataHorario not found")
    
    for key, value in data_horario.model_dump(exclude_unset=True).items():
        setattr(db_data_horario, key, value)
    
    db.commit()
    db.refresh(db_data_horario)
    return db_data_horario

@router.delete("/datas-horarios/{data_horario_id}")
def delete_data_horario(data_horario_id: int, db: Session = Depends(get_db)):
    db_data_horario = db.query(models.DataHorario).filter(models.DataHorario.id == data_horario_id).first()
    if db_data_horario is None:
        raise HTTPException(status_code=404, detail="DataHorario not found")
    
    db.delete(db_data_horario)
    db.commit()
    return {"message": "DataHorario deleted successfully"} 
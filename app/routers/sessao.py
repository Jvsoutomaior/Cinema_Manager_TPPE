from fastapi import APIRouter, Depends, HTTPException
from sqlalchemy.orm import Session
from typing import List
from ..models.sessao import Sessao as SessaoModel
from ..models.sessao import DataHorario as DataHorarioModel
from ..schemas.sessao import Sessao, SessaoCreate, SessaoUpdate, DataHorario, DataHorarioCreate, DataHorarioUpdate
from ..database import get_db

router = APIRouter()

# Sessao endpoints
@router.post("/", response_model=Sessao)
def create_sessao(sessao: SessaoCreate, db: Session = Depends(get_db)):
    db_sessao = SessaoModel(**sessao.model_dump())
    db.add(db_sessao)
    db.commit()
    db.refresh(db_sessao)
    return db_sessao

@router.get("/", response_model=List[Sessao])
def read_sessoes(skip: int = 0, limit: int = 100, db: Session = Depends(get_db)):
    sessoes = db.query(SessaoModel).offset(skip).limit(limit).all()
    return sessoes

@router.get("/{sessao_id}", response_model=Sessao)
def read_sessao(sessao_id: int, db: Session = Depends(get_db)):
    db_sessao = db.query(SessaoModel).filter(SessaoModel.id == sessao_id).first()
    if db_sessao is None:
        raise HTTPException(status_code=404, detail="Sessao not found")
    return db_sessao

@router.put("/{sessao_id}", response_model=Sessao)
def update_sessao(sessao_id: int, sessao: SessaoUpdate, db: Session = Depends(get_db)):
    db_sessao = db.query(SessaoModel).filter(SessaoModel.id == sessao_id).first()
    if db_sessao is None:
        raise HTTPException(status_code=404, detail="Sessao not found")
    
    for key, value in sessao.model_dump(exclude_unset=True).items():
        setattr(db_sessao, key, value)
    
    db.commit()
    db.refresh(db_sessao)
    return db_sessao

@router.delete("/{sessao_id}")
def delete_sessao(sessao_id: int, db: Session = Depends(get_db)):
    db_sessao = db.query(SessaoModel).filter(SessaoModel.id == sessao_id).first()
    if db_sessao is None:
        raise HTTPException(status_code=404, detail="Sessao not found")
    
    db.delete(db_sessao)
    db.commit()
    return {"message": "Sessao deleted successfully"}

# DataHorario endpoints
@router.post("/datas-horarios/", response_model=DataHorario)
def create_data_horario(data_horario: DataHorarioCreate, db: Session = Depends(get_db)):
    db_data_horario = DataHorarioModel(**data_horario.model_dump())
    db.add(db_data_horario)
    db.commit()
    db.refresh(db_data_horario)
    return db_data_horario

@router.get("/datas-horarios/", response_model=List[DataHorario])
def read_datas_horarios(skip: int = 0, limit: int = 100, db: Session = Depends(get_db)):
    datas_horarios = db.query(DataHorarioModel).offset(skip).limit(limit).all()
    return datas_horarios

@router.get("/datas-horarios/{data_horario_id}", response_model=DataHorario)
def read_data_horario(data_horario_id: int, db: Session = Depends(get_db)):
    db_data_horario = db.query(DataHorarioModel).filter(DataHorarioModel.id == data_horario_id).first()
    if db_data_horario is None:
        raise HTTPException(status_code=404, detail="DataHorario not found")
    return db_data_horario

@router.put("/datas-horarios/{data_horario_id}", response_model=DataHorario)
def update_data_horario(data_horario_id: int, data_horario: DataHorarioUpdate, db: Session = Depends(get_db)):
    db_data_horario = db.query(DataHorarioModel).filter(DataHorarioModel.id == data_horario_id).first()
    if db_data_horario is None:
        raise HTTPException(status_code=404, detail="DataHorario not found")
    
    for key, value in data_horario.model_dump(exclude_unset=True).items():
        setattr(db_data_horario, key, value)
    
    db.commit()
    db.refresh(db_data_horario)
    return db_data_horario

@router.delete("/datas-horarios/{data_horario_id}")
def delete_data_horario(data_horario_id: int, db: Session = Depends(get_db)):
    db_data_horario = db.query(DataHorarioModel).filter(DataHorarioModel.id == data_horario_id).first()
    if db_data_horario is None:
        raise HTTPException(status_code=404, detail="DataHorario not found")
    
    db.delete(db_data_horario)
    db.commit()
    return {"message": "DataHorario deleted successfully"} 
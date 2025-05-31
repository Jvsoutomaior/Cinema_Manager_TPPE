from fastapi import APIRouter, Depends, HTTPException
from sqlalchemy.orm import Session
from typing import List
from .. import models
from ..schemas import pessoa as schemas
from ..database import get_db

router = APIRouter()

# Funcionario endpoints
@router.post("/funcionarios/", response_model=schemas.Funcionario)
def create_funcionario(funcionario: schemas.FuncionarioCreate, db: Session = Depends(get_db)):
    db_funcionario = models.Funcionario(**funcionario.model_dump())
    db.add(db_funcionario)
    db.commit()
    db.refresh(db_funcionario)
    return db_funcionario

@router.get("/funcionarios/", response_model=List[schemas.Funcionario])
def read_funcionarios(skip: int = 0, limit: int = 100, db: Session = Depends(get_db)):
    funcionarios = db.query(models.Funcionario).offset(skip).limit(limit).all()
    return funcionarios

@router.get("/funcionarios/{funcionario_id}", response_model=schemas.Funcionario)
def read_funcionario(funcionario_id: int, db: Session = Depends(get_db)):
    db_funcionario = db.query(models.Funcionario).filter(models.Funcionario.id == funcionario_id).first()
    if db_funcionario is None:
        raise HTTPException(status_code=404, detail="Funcionario not found")
    return db_funcionario

@router.put("/funcionarios/{funcionario_id}", response_model=schemas.Funcionario)
def update_funcionario(funcionario_id: int, funcionario: schemas.FuncionarioUpdate, db: Session = Depends(get_db)):
    db_funcionario = db.query(models.Funcionario).filter(models.Funcionario.id == funcionario_id).first()
    if db_funcionario is None:
        raise HTTPException(status_code=404, detail="Funcionario not found")
    
    for key, value in funcionario.model_dump(exclude_unset=True).items():
        setattr(db_funcionario, key, value)
    
    db.commit()
    db.refresh(db_funcionario)
    return db_funcionario

@router.delete("/funcionarios/{funcionario_id}")
def delete_funcionario(funcionario_id: int, db: Session = Depends(get_db)):
    db_funcionario = db.query(models.Funcionario).filter(models.Funcionario.id == funcionario_id).first()
    if db_funcionario is None:
        raise HTTPException(status_code=404, detail="Funcionario not found")
    
    db.delete(db_funcionario)
    db.commit()
    return {"message": "Funcionario deleted successfully"}

# Cliente endpoints
@router.post("/clientes/", response_model=schemas.Cliente)
def create_cliente(cliente: schemas.ClienteCreate, db: Session = Depends(get_db)):
    db_cliente = models.Cliente(**cliente.model_dump())
    db.add(db_cliente)
    db.commit()
    db.refresh(db_cliente)
    return db_cliente

@router.get("/clientes/", response_model=List[schemas.Cliente])
def read_clientes(skip: int = 0, limit: int = 100, db: Session = Depends(get_db)):
    clientes = db.query(models.Cliente).offset(skip).limit(limit).all()
    return clientes

@router.get("/clientes/{cliente_id}", response_model=schemas.Cliente)
def read_cliente(cliente_id: int, db: Session = Depends(get_db)):
    db_cliente = db.query(models.Cliente).filter(models.Cliente.id == cliente_id).first()
    if db_cliente is None:
        raise HTTPException(status_code=404, detail="Cliente not found")
    return db_cliente

@router.put("/clientes/{cliente_id}", response_model=schemas.Cliente)
def update_cliente(cliente_id: int, cliente: schemas.ClienteUpdate, db: Session = Depends(get_db)):
    db_cliente = db.query(models.Cliente).filter(models.Cliente.id == cliente_id).first()
    if db_cliente is None:
        raise HTTPException(status_code=404, detail="Cliente not found")
    
    for key, value in cliente.model_dump(exclude_unset=True).items():
        setattr(db_cliente, key, value)
    
    db.commit()
    db.refresh(db_cliente)
    return db_cliente

@router.delete("/clientes/{cliente_id}")
def delete_cliente(cliente_id: int, db: Session = Depends(get_db)):
    db_cliente = db.query(models.Cliente).filter(models.Cliente.id == cliente_id).first()
    if db_cliente is None:
        raise HTTPException(status_code=404, detail="Cliente not found")
    
    db.delete(db_cliente)
    db.commit()
    return {"message": "Cliente deleted successfully"} 
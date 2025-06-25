from fastapi import APIRouter, Depends, HTTPException
from sqlalchemy.orm import Session
from typing import List
from ..models.pessoa import Funcionario as FuncionarioModel
from ..models.pessoa import Cliente as clienteModel
from ..schemas.pessoa import Funcionario, FuncionarioCreate, FuncionarioUpdate, Cliente, ClienteCreate, ClienteUpdate
from ..database import get_db

router = APIRouter()

# Funcionario endpoints
@router.post("/funcionarios/", response_model=Funcionario)
def create_funcionario(funcionario: FuncionarioCreate, db: Session = Depends(get_db)):
    db_funcionario = FuncionarioModel(**funcionario.model_dump())
    db.add(db_funcionario)
    db.commit()
    db.refresh(db_funcionario)
    return db_funcionario

@router.get("/funcionarios/", response_model=List[Funcionario])
def read_funcionarios(skip: int = 0, limit: int = 100, db: Session = Depends(get_db)):
    funcionarios = db.query(FuncionarioModel).offset(skip).limit(limit).all()
    return funcionarios

@router.get("/funcionarios/{cpf}", response_model=Funcionario)
def read_funcionario(cpf: str, db: Session = Depends(get_db)):
    db_funcionario = db.query(FuncionarioModel).filter(FuncionarioModel.cpf == cpf).first()
    if db_funcionario is None:
        raise HTTPException(status_code=404, detail="Funcionario not found")
    return db_funcionario

@router.put("/funcionarios/{cpf}", response_model=Funcionario)
def update_funcionario(cpf: str, funcionario: FuncionarioUpdate, db: Session = Depends(get_db)):
    db_funcionario = db.query(FuncionarioModel).filter(FuncionarioModel.cpf == cpf).first()
    if db_funcionario is None:
        raise HTTPException(status_code=404, detail="Funcionario not found")
    for key, value in funcionario.model_dump(exclude_unset=True).items():
        setattr(db_funcionario, key, value)
    db.commit()
    db.refresh(db_funcionario)
    return db_funcionario

@router.delete("/funcionarios/{cpf}")
def delete_funcionario(cpf: str, db: Session = Depends(get_db)):
    db_funcionario = db.query(FuncionarioModel).filter(FuncionarioModel.cpf == cpf).first()
    if db_funcionario is None:
        raise HTTPException(status_code=404, detail="Funcionario not found")
    
    db.delete(db_funcionario)
    db.commit()
    return {"message": "Funcionario deleted successfully"}

# Cliente endpoints
@router.post("/clientes/", response_model=Cliente)
def create_cliente(cliente: ClienteCreate, db: Session = Depends(get_db)):
    db_cliente = clienteModel(**cliente.model_dump())
    db.add(db_cliente)
    db.commit()
    db.refresh(db_cliente)
    return db_cliente

@router.get("/clientes/", response_model=List[Cliente])
def read_clientes(skip: int = 0, limit: int = 100, db: Session = Depends(get_db)):
    clientes = db.query(clienteModel).offset(skip).limit(limit).all()
    return clientes

@router.get("/clientes/{cpf}", response_model=Cliente)
def read_cliente(cpf: str, db: Session = Depends(get_db)):
    db_cliente = db.query(clienteModel).filter(clienteModel.cpf == cpf).first()
    if db_cliente is None:
        raise HTTPException(status_code=404, detail="Cliente not found")
    return db_cliente

@router.put("/clientes/{cpf}", response_model=Cliente)
def update_cliente(cpf: str, cliente: ClienteUpdate, db: Session = Depends(get_db)):
    db_cliente = db.query(clienteModel).filter(clienteModel.cpf == cpf).first()
    if db_cliente is None:
        raise HTTPException(status_code=404, detail="Cliente not found")
    
    for key, value in cliente.model_dump(exclude_unset=True).items():
        setattr(db_cliente, key, value)
    
    db.commit()
    db.refresh(db_cliente)
    return db_cliente

@router.delete("/clientes/{cpf}")
def delete_cliente(cpf: str, db: Session = Depends(get_db)):
    db_cliente = db.query(clienteModel).filter(clienteModel.cpf == cpf).first()
    if db_cliente is None:
        raise HTTPException(status_code=404, detail="Cliente not found")
    
    db.delete(db_cliente)
    db.commit()
    return {"message": "Cliente deleted successfully"}
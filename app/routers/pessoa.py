from fastapi import APIRouter, Depends, HTTPException, status, Response
from sqlalchemy.orm import Session
from typing import List
from ..models.pessoa import Funcionario as FuncionarioModel
from ..models.pessoa import Cliente as clienteModel
from ..schemas.pessoa import Funcionario, FuncionarioCreate, FuncionarioUpdate, Cliente, ClienteCreate, ClienteUpdate
from ..database import get_db
from ..repository.pessoa import ClienteRepository, FuncionarioRepository

router = APIRouter()

# Cliente endpoints
@router.post("/clientes/", response_model=Cliente)
def create_cliente(cliente: ClienteCreate, db: Session = Depends(get_db)):
    """ POST endpoint to create a new cliente. """
    new_cliente = ClienteRepository.create_cliente(db, clienteModel(**cliente.model_dump()))
    return new_cliente

@router.get("/clientes/", response_model=List[Cliente])
def read_clientes(db: Session = Depends(get_db)):
    """ GET endpoint to retrieve all clientes. """
    clientes = ClienteRepository.get_all_clientes(db)
    return clientes

@router.get("/clientes/{cpf}", response_model=Cliente)
def read_cliente(cpf: str, db: Session = Depends(get_db)):
    """ GET endpoint to retrieve a cliente by CPF. """
    db_cliente = ClienteRepository.get_cliente_by_cpf(db, cpf)
    if db_cliente is None:
        raise HTTPException(status_code=status.HTTP_404_NOT_FOUND, detail="Cliente not found")
    return db_cliente

@router.put("/clientes/{cpf}", response_model=Cliente)
def update_cliente(cpf: str, cliente: ClienteUpdate, db: Session = Depends(get_db)):
    """ PUT endpoint to update an existing cliente. """
    try:
        db_cliente = ClienteRepository.update_cliente(db, cpf, cliente)
    except ValueError as e:
        raise HTTPException(status_code=status.HTTP_404_NOT_FOUND, detail=str(e))
    return db_cliente

@router.delete("/clientes/{cpf}")
def delete_cliente(cpf: str, db: Session = Depends(get_db)):
    """ DELETE endpoint to remove a cliente by CPF. """
    try:
        ClienteRepository.delete_cliente(db, cpf)
    except ValueError as e:
        raise HTTPException(status_code=status.HTTP_404_NOT_FOUND, detail=str(e))
    return Response(status_code=status.HTTP_200_OK, content=None)


# Funcionario endpoints
@router.post("/funcionarios/", response_model=Funcionario)
def create_funcionario(funcionario: FuncionarioCreate, db: Session = Depends(get_db)):
    """ POST endpoint to create a new funcionario. """
    new_funcionario = FuncionarioRepository.create_funcionario(db, FuncionarioModel(**funcionario.model_dump()))
    return new_funcionario

@router.get("/funcionarios/", response_model=List[Funcionario])
def read_funcionarios(db: Session = Depends(get_db)):
    """ GET endpoint to retrieve all funcionarios. """
    funcionarios = FuncionarioRepository.get_all_funcionarios(db)
    return funcionarios

@router.get("/funcionarios/{cpf}", response_model=Funcionario)
def read_funcionario(cpf: str, db: Session = Depends(get_db)):
    """ GET endpoint to retrieve a funcionario by CPF. """
    db_funcionario = FuncionarioRepository.get_funcionario_by_cpf(db, cpf)
    if db_funcionario is None:
        raise HTTPException(status_code=status.HTTP_404_NOT_FOUND, detail="Funcionario not found")
    return db_funcionario

@router.put("/funcionarios/{cpf}", response_model=Funcionario)
def update_funcionario(cpf: str, funcionario: FuncionarioUpdate, db: Session = Depends(get_db)):
    """ PUT endpoint to update an existing funcionario. """
    try:
        db_funcionario = FuncionarioRepository.update_funcionario(db, cpf, funcionario)
    except ValueError as e:
        raise HTTPException(status_code=status.HTTP_404_NOT_FOUND, detail=str(e))
    return db_funcionario

@router.delete("/funcionarios/{cpf}")
def delete_funcionario(cpf: str, db: Session = Depends(get_db)):
    """ DELETE endpoint to remove a funcionario by CPF. """
    try:
        FuncionarioRepository.delete_funcionario(db, cpf)
    except ValueError as e:
        raise HTTPException(status_code=status.HTTP_404_NOT_FOUND, detail=str(e))
    return Response(status_code=status.HTTP_200_OK, content=None)
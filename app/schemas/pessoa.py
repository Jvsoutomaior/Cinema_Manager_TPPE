from pydantic import BaseModel, EmailStr
from typing import Optional
from datetime import date

class PessoaBase(BaseModel):
    nome: str
    data_nascimento: Optional[date] = None
    email: Optional[EmailStr] = None

class FuncionarioBase(PessoaBase):
    turno: Optional[str] = None
    salario: Optional[float] = None

class ClienteBase(PessoaBase):
    fidelidade: float = 0.0

class FuncionarioCreate(FuncionarioBase):
    cpf: str

class ClienteCreate(ClienteBase):
    cpf: str

class Funcionario(FuncionarioBase):
    cpf: str
    type: str = "funcionario"

    class Config:
        from_attributes = True

class Cliente(ClienteBase):
    cpf: str
    type: str = "cliente"

    class Config:
        from_attributes = True

class FuncionarioUpdate(BaseModel):
    nome: Optional[str] = None
    data_nascimento: Optional[date] = None
    email: Optional[EmailStr] = None
    turno: Optional[str] = None
    salario: Optional[float] = None

class ClienteUpdate(BaseModel):
    nome: Optional[str] = None
    data_nascimento: Optional[date] = None
    email: Optional[EmailStr] = None
    fidelidade: Optional[float] = None 
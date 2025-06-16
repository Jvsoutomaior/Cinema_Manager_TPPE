from pydantic import BaseModel, EmailStr, ConfigDict
from typing import Optional, TYPE_CHECKING
from datetime import date

if TYPE_CHECKING:
    from .cinema import Cinema

# Pessoa 
class PessoaBase(BaseModel):
    nome: str
    data_nascimento: Optional[date] = None
    email: Optional[EmailStr] = None
    cinema_id_FK: Optional[int] = None

# Funcionario
class FuncionarioBase(PessoaBase):
    turno: Optional[str] = None
    salario: Optional[float] = None

class FuncionarioCreate(FuncionarioBase):
    cpf: str

class Funcionario(FuncionarioBase):
    cpf: str
    type: str = "funcionario"
    cinema: Optional["Cinema"] = None
    model_config = ConfigDict(from_attributes=True)

class FuncionarioUpdate(BaseModel):
    nome: Optional[str] = None
    data_nascimento: Optional[date] = None
    email: Optional[EmailStr] = None
    turno: Optional[str] = None
    salario: Optional[float] = None

# Cliente
class ClienteBase(PessoaBase):
    fidelidade: float = 0.0

class ClienteCreate(ClienteBase):
    cpf: str

class Cliente(ClienteBase):
    cpf: str
    type: str = "cliente"
    cinema: Optional["Cinema"] = None
    model_config = ConfigDict(from_attributes=True)

class ClienteUpdate(BaseModel):
    nome: Optional[str] = None
    data_nascimento: Optional[date] = None
    email: Optional[EmailStr] = None
    fidelidade: Optional[float] = None
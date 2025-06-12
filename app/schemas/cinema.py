from pydantic import BaseModel, ConfigDict
from typing import List, Optional, TYPE_CHECKING

if TYPE_CHECKING:
    from .sessao import Sessao
    from .pessoa import PessoaBase

class CinemaBase(BaseModel):
    nome: str
    endereco: Optional[str] = None
    telefone: Optional[str] = None
    email: Optional[str] = None

class CinemaCreate(CinemaBase):
    pass

class Cinema(CinemaBase):
    id: int
    sessoes: List["Sessao"] = []
    pessoas: List["PessoaBase"] = []
    model_config = ConfigDict(from_attributes=True)

class CinemaUpdate(BaseModel):
    nome: Optional[str] = None
    endereco: Optional[str] = None
    telefone: Optional[str] = None
    email: Optional[str] = None


from pydantic import BaseModel, ConfigDict
from typing import List, Optional

class CinemaBase(BaseModel):
    nome: str
    endereco: Optional[str] = None
    telefone: Optional[str] = None
    email: Optional[str] = None

class CinemaCreate(CinemaBase):
    pass

class Cinema(CinemaBase):
    id: int
    model_config = ConfigDict(from_attributes=True)

class CinemaUpdate(BaseModel):
    nome: Optional[str] = None
    endereco: Optional[str] = None
    telefone: Optional[str] = None
    email: Optional[str] = None


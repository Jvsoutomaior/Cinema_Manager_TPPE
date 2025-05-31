from pydantic import BaseModel
from typing import List, Optional, ForwardRef

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

    class Config:
        from_attributes = True

class CinemaUpdate(BaseModel):
    nome: Optional[str] = None
    endereco: Optional[str] = None
    telefone: Optional[str] = None
    email: Optional[str] = None

# Forward reference
Sessao = ForwardRef("Sessao") 
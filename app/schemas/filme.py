from pydantic import BaseModel
from typing import List, Optional
from .sessao import Sessao

class FilmeBase(BaseModel):
    titulo: str
    ano: str
    genero: str
    sinopse: Optional[str] = None
    classificacao_indicativa: Optional[str] = None
    duracao: Optional[str] = None

class FilmeCreate(FilmeBase):
    pass

class Filme(FilmeBase):
    id: int
    sessoes: List[Sessao] = []

    class Config:
        from_attributes = True

class FilmeUpdate(BaseModel):
    titulo: Optional[str] = None
    ano: Optional[str] = None
    genero: Optional[str] = None
    sinopse: Optional[str] = None
    classificacao_indicativa: Optional[str] = None
    duracao: Optional[str] = None 
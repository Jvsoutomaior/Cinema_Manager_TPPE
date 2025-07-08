from pydantic import BaseModel, ConfigDict
from typing import Optional
from app.enums import GeneroEnum, ClassificacaoIndicativaEnum

class FilmeBase(BaseModel):
    titulo: str
    ano: int
    genero: GeneroEnum
    sinopse: Optional[str] = None
    classificacao_indicativa: Optional[ClassificacaoIndicativaEnum] = None
    duracao: Optional[int]

class FilmeCreate(FilmeBase):
    pass

class Filme(FilmeBase):
    id: int
    model_config = ConfigDict(from_attributes=True)

class FilmeUpdate(BaseModel):
    titulo: Optional[str] = None
    ano: Optional[int] = None
    genero: Optional[GeneroEnum] = None
    sinopse: Optional[str] = None
    classificacao_indicativa: Optional[ClassificacaoIndicativaEnum] = None
    duracao: Optional[int] = None

from pydantic import BaseModel, ConfigDict, Field
from typing import Optional
from app.enums import GeneroEnum, ClassificacaoIndicativaEnum

class FilmeBase(BaseModel):
    titulo: str
    ano: int = Field(..., ge=1888, le=2100, description="Year must be between 1888 and 2100")
    genero: GeneroEnum
    sinopse: Optional[str] = None
    classificacao_indicativa: Optional[ClassificacaoIndicativaEnum] = None
    duracao: Optional[int] = Field(None, ge=1, le=600, description="Duration in minutes, between 1 and 600")

class FilmeCreate(FilmeBase):
    pass

class Filme(FilmeBase):
    id: int
    model_config = ConfigDict(from_attributes=True)

class FilmeUpdate(BaseModel):
    titulo: Optional[str] = None
    ano: Optional[int] = Field(None, ge=1888, le=2100, description="Year must be between 1888 and 2100")
    genero: Optional[GeneroEnum] = None
    sinopse: Optional[str] = None
    classificacao_indicativa: Optional[ClassificacaoIndicativaEnum] = None
    duracao: Optional[int] = Field(None, ge=1, le=600, description="Duration in minutes, between 1 and 600")

from pydantic import BaseModel, ConfigDict
from typing import List, Optional, TYPE_CHECKING

if TYPE_CHECKING:
   from .sessao import Sessao
else:
    Sessao = None

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
    sessoes: List["Sessao"] = []
    model_config = ConfigDict(from_attributes=True)

class FilmeUpdate(BaseModel):
    titulo: Optional[str] = None
    ano: Optional[str] = None
    genero: Optional[str] = None
    sinopse: Optional[str] = None
    classificacao_indicativa: Optional[str] = None
    duracao: Optional[str] = None



from .sessao import Sessao
Filme.model_rebuild()

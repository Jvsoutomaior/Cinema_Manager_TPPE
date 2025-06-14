from pydantic import BaseModel, ConfigDict
from typing import List, Optional, TYPE_CHECKING
from datetime import datetime

if TYPE_CHECKING:
   from .filme import Filme
   from .cinema import Cinema

class DataHorarioBase(BaseModel):
    data: datetime
    sessao_id_FK: int

class DataHorarioCreate(DataHorarioBase):
    pass

class DataHorario(DataHorarioBase):
    id: int
    model_config = ConfigDict(from_attributes=True)

class SessaoBase(BaseModel):
    linguagem: Optional[str] = None
    is_3d: bool = False
    sala: str
    cinema_id_FK: int
    filme_id_FK: int

class SessaoCreate(SessaoBase):
    pass

class Sessao(SessaoBase):
    id: int
    filme: Optional["Filme"] = None
    cinema: Optional["Cinema"] = None
    horarios: List[DataHorario] = []
    model_config = ConfigDict(from_attributes=True)

class SessaoUpdate(BaseModel):
    linguagem: Optional[str] = None
    is_3d: Optional[bool] = None
    sala: Optional[str] = None
    cinema_id_FK: Optional[int] = None
    filme_id_FK: Optional[int] = None

class DataHorarioUpdate(BaseModel):
    dataHora: Optional[datetime] = None
    sessao_id_FK: Optional[int] = None 
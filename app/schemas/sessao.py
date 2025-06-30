from pydantic import BaseModel, ConfigDict
from typing import List, Optional, TYPE_CHECKING
from datetime import datetime

from .filme import Filme

class DataHorarioBase(BaseModel):
    dataHora: datetime

class DataHorarioCreate(DataHorarioBase):
    pass

class DataHorario(DataHorarioBase):
    id: int
    sessao_id: int
    model_config = ConfigDict(from_attributes=True)

class DataHorarioUpdate(BaseModel):
    dataHora: Optional[datetime] = None


class SessaoBase(BaseModel):
    linguagem: Optional[str] = None
    is_3d: bool = False
    sala: str
    filme_id_FK: int

class SessaoCreate(SessaoBase):
    pass

class Sessao(SessaoBase):
    id: int
    filme: Optional["Filme"] = None
    datas_horarios: List[DataHorario] = []
    model_config = ConfigDict(from_attributes=True)

class SessaoUpdate(BaseModel):
    linguagem: Optional[str] = None
    is_3d: Optional[bool] = None
    sala: Optional[str] = None
    filme_id_FK: Optional[int] = None



Sessao.model_rebuild()
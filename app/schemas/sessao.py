from pydantic import BaseModel
from typing import List, Optional, ForwardRef
from datetime import datetime

class DataHorarioBase(BaseModel):
    dataHora: datetime
    sessao_id_FK: int

class DataHorarioCreate(DataHorarioBase):
    pass

class DataHorario(DataHorarioBase):
    id: int
    sessao: Optional["Sessao"] = None

    class Config:
        from_attributes = True

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
    cinema: Optional["Cinema"] = None
    filme: Optional["Filme"] = None
    datas_horarios: List[DataHorario] = []

    class Config:
        from_attributes = True

class SessaoUpdate(BaseModel):
    linguagem: Optional[str] = None
    is_3d: Optional[bool] = None
    sala: Optional[str] = None
    cinema_id_FK: Optional[int] = None
    filme_id_FK: Optional[int] = None

class DataHorarioUpdate(BaseModel):
    dataHora: Optional[datetime] = None
    sessao_id_FK: Optional[int] = None

# Forward references
Cinema = ForwardRef("Cinema")
Filme = ForwardRef("Filme") 
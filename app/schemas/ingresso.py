from pydantic import BaseModel
from typing import Optional
from .sessao import Sessao
from .pessoa import Cliente

class IngressoBase(BaseModel):
    preco: float
    tipo: str
    sessao_id_FK: int
    cliente_cpf_FK: str

class IngressoCreate(IngressoBase):
    pass

class Ingresso(IngressoBase):
    id: int
    sessao: Optional[Sessao] = None
    clientes: Optional[Cliente] = None

    class Config:
        from_attributes = True

class IngressoUpdate(BaseModel):
    preco: Optional[float] = None
    tipo: Optional[str] = None
    sessao_id_FK: Optional[int] = None
    cliente_cpf_FK: Optional[str] = None 
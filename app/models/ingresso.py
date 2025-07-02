from sqlalchemy import Column, Integer, String, Float, ForeignKey, UniqueConstraint
from sqlalchemy.orm import relationship
from app.database import Base
from typing import TYPE_CHECKING

if TYPE_CHECKING:
    from .sessao import Sessao
    from .pessoa import Cliente

class Ingresso(Base):
    __tablename__ = "ingressos"
    id = Column(Integer, primary_key=True, index=True)
    preco = Column(Float, nullable=False)
    tipo = Column(String, nullable=False)
    sessao_id_FK = Column(Integer, ForeignKey("sessoes.id"))
    cliente_cpf_FK = Column(String, ForeignKey("clientes.cpf"))
    sessao = relationship("Sessao")
    cliente = relationship("Cliente")
    
    # Add unique constraint to prevent duplicate tickets for same client and session
    __table_args__ = (UniqueConstraint('sessao_id_FK', 'cliente_cpf_FK', name='unique_client_session'),)
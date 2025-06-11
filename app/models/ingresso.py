from sqlalchemy import Column, Integer, String, Float, ForeignKey
from sqlalchemy.orm import relationship
from app.database import Base

class Ingresso(Base):
    __tablename__ = "ingressos"
    id = Column(Integer, primary_key=True, index=True)
    preco = Column(Float, nullable=False)
    tipo = Column(String, nullable=False)
    sessao_id_FK = Column(Integer, ForeignKey("sessoes.id"))
    cliente_cpf_FK = Column(String, ForeignKey("clientes.cpf"))
    sessao = relationship("Sessao", back_populates="ingressos")
    clientes = relationship("Cliente", back_populates="ingressos") 
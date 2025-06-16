from sqlalchemy import Column, Integer, String, Boolean, DateTime, ForeignKey
from sqlalchemy.orm import relationship
from app.database import Base
from typing import TYPE_CHECKING

if TYPE_CHECKING:
    from .filme import Filme

class Sessao(Base):
    __tablename__ = "sessoes"
    id = Column(Integer, primary_key=True, index=True)
    linguagem = Column(String, nullable=True)
    is_3d = Column(Boolean, default=False)
    sala = Column(String, nullable=False)
    filme_id_FK = Column(Integer, ForeignKey("filmes.id"))
    filme = relationship("Filme")
    datas_horarios = relationship("DataHorario", back_populates="sessao")

class DataHorario(Base):
    __tablename__ = "datas_horarios"
    id = Column(Integer, primary_key=True, index=True)
    dataHora = Column(DateTime, index=True)
    sessao_id_FK = Column(Integer, ForeignKey("sessoes.id"))
    sessao = relationship("Sessao", back_populates="datas_horarios") 
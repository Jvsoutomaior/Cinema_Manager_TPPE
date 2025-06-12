from sqlalchemy import Column, Integer, String
from sqlalchemy.orm import relationship
from app.database import Base
from typing import TYPE_CHECKING

if TYPE_CHECKING:
    from .sessao import Seessao

class Filme(Base):
    __tablename__ = "filmes"
    id = Column(Integer, primary_key=True, index=True)
    titulo = Column(String, nullable=False)
    ano = Column(String, nullable=False)
    genero = Column(String, nullable=False)
    sinopse = Column(String, nullable=True)
    classificacao_indicativa = Column(String, nullable=True)
    duracao = Column(String, nullable=True)
    sessoes = relationship("Sessao", back_populates="filme") 
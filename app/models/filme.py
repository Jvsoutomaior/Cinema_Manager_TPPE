from sqlalchemy import Column, Integer, String, Enum as SQLEnum
from app.database import Base
from app.enums import GeneroEnum, ClassificacaoIndicativaEnum

class Filme(Base):
    __tablename__ = "filmes"
    id = Column(Integer, primary_key=True, index=True)
    titulo = Column(String, nullable=False)
    ano = Column(Integer, nullable=False)
    genero = Column(SQLEnum(GeneroEnum), nullable=False)
    sinopse = Column(String, nullable=True)
    classificacao_indicativa = Column(SQLEnum(ClassificacaoIndicativaEnum), nullable=True)
    duracao = Column(Integer, nullable=True)

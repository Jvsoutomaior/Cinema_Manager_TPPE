from sqlalchemy import Column, Integer, String, Enum as SQLEnum
from app.database import Base
from app.enums import GeneroEnum, ClassificacaoIndicativaEnum

class Filme(Base):
    __tablename__ = "filmes"
    id = Column(Integer, primary_key=True, index=True)
    titulo = Column(String, nullable=False)
    ano = Column(Integer, nullable=False)  # Changed from String to Integer
    genero = Column(SQLEnum(GeneroEnum), nullable=False)  # Changed to Enum
    sinopse = Column(String, nullable=True)
    classificacao_indicativa = Column(SQLEnum(ClassificacaoIndicativaEnum), nullable=True)  # Changed to Enum
    duracao = Column(Integer, nullable=True)  # Changed from String to Integer (minutes)

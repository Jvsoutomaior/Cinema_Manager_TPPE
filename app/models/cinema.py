from sqlalchemy import Column, Integer, String
# from sqlalchemy.orm import relationship
from app.database import Base

class Cinema(Base):
    __tablename__ = "cinemas"
    id = Column(Integer, primary_key=True, index=True)
    nome = Column(String, nullable=False)
    endereco = Column(String, nullable=True)
    telefone = Column(String, nullable=True)
    email = Column(String, nullable=True)
    # sessoes = relationship("Sessao", back_populates="cinema")
    # pessoas = relationship("Pessoa", back_populates="cinema") 
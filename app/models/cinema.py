from sqlalchemy import Column, Integer, String
from app.database import Base

class Cinema(Base):
    __tablename__ = "cinemas"
    id = Column(Integer, primary_key=True, index=True)
    nome = Column(String, nullable=False)
    endereco = Column(String, nullable=True)
    telefone = Column(String, nullable=True)
    email = Column(String, nullable=True)
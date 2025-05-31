from sqlalchemy import Column, Integer, String, Float, Date, ForeignKey
from sqlalchemy.orm import relationship
from app.database import Base

class Pessoa(Base):
    __tablename__ = "pessoas"
    cpf = Column(String, primary_key=True, index=True)
    nome = Column(String, nullable=False)
    data_nascimento = Column(Date, nullable=True)
    email = Column(String, nullable=True)
    tipo = Column(String)
    cinema_id_FK = Column(Integer, ForeignKey("cinemas.id"))
    cinema = relationship("Cinema", back_populates="pessoas")
    __mapper_args__ = {"polymorphic_identity": "pessoa", "polymorphic_on": tipo}

class Funcionario(Pessoa):
    __tablename__ = "funcionarios"
    cpf = Column(String, ForeignKey("pessoas.cpf"), primary_key=True)
    turno = Column(String, nullable=True)
    salario = Column(Float, nullable=True)
    __mapper_args__ = {"polymorphic_identity": "funcionario"}

class Cliente(Pessoa):
    __tablename__ = "clientes"
    cpf = Column(String, ForeignKey("pessoas.cpf"), primary_key=True)
    fidelidade = Column(Float, default=0.0)
    ingressos = relationship("Ingresso", back_populates="clientes")
    __mapper_args__ = {"polymorphic_identity": "cliente"} 
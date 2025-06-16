from sqlalchemy import Column, Integer, String, Float, Date, ForeignKey
from sqlalchemy.orm import relationship
from app.database import Base

class Pessoa(Base):
    __tablename__ = "pessoas"
    cpf = Column(String, primary_key=True, index=True)
    nome = Column(String, nullable=False)
    data_nascimento = Column(Date, nullable=False)
    email = Column(String, nullable=False)
    tipo = Column(String)
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
    __mapper_args__ = {"polymorphic_identity": "cliente"} 
from sqlalchemy import Column, Integer, String, Float, Boolean, Date, DateTime, ForeignKey
from sqlalchemy.orm import relationship
from app.database import Base

class Unidade(Base):
    __tablename__ = "unidades"
    id = Column(Integer, primary_key=True, index=True)
    nome = Column(String, nullable=False)
    endereco = Column(String, nullable=True)
    telefone = Column(String, nullable=True)
    email = Column(String, nullable=True)
    rede = Column(String, nullable=True)
    sessoes = relationship("Sessao", back_populates="unidade")
    pessoas = relationship("Pessoa", back_populates="unidade")

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

class Sessao(Base):
    __tablename__ = "sessoes"
    id = Column(Integer, primary_key=True, index=True)
    linguagem = Column(String, nullable=True)
    is_3d = Column(Boolean, default=False)
    sala = Column(String, nullable=False)
    unidade_id_FK = Column(Integer, ForeignKey("unidades.id"))
    filme_id_FK = Column(Integer, ForeignKey("filmes.id"))
    unidade = relationship("Unidade", back_populates="sessoes")
    filme = relationship("Filme", back_populates="sessoes")
    datas_horarios = relationship("DataHorario", back_populates="sessao")

class DataHorario(Base):
    __tablename__ = "datas_horarios"
    id = Column(Integer, primary_key=True, index=True)
    dataHora = Column(DateTime, index=True)
    sessao_id_FK = Column(Integer, ForeignKey("sessoes.id"))
    sessao = relationship("Sessao", back_populates="datas_horarios")

class Pessoa(Base):
    __tablename__ = "pessoas"
    cpf = Column(String, primary_key=True, index=True)
    nome = Column(String, nullable=False)
    data_nascimento = Column(Date, nullable=True)
    email = Column(String, nullable=True)
    tipo = Column(String)
    unidade_id_FK = Column(Integer, ForeignKey("unidades.id"))
    unidade = relationship("Unidade", back_populates="pessoas")
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

from sqlalchemy import Column, Integer, String, Bool, ForeignKey, Table
from sqlalchemy.orm import relationship
from database import Base

'''
class Pessoa(Base):
    __tablename__ = "PESSOA"
    cpf = Column(String, primary_key=True, index=True)
    nome = Column(String, index=True)
    dataNascimento = Column(Integer)
    email = Column(String, index=True)
    tipo = Column(String, index=True)  # Tipo da pessoa (cliente ou funcionário)
    
    __mapper_args__ = {
        "polymorphic_identity": "pessoa",
        "polymorphic_on": tipo
    }    

class Cliente(Pessoa):
    __tablename__ = "CLIENTE"
    cpf = Column(String, ForeignKey("PESSOA.cpf"), primary_key=True)
    fidelidade = Column(Integer)
    
    __mapper_args__ = {"polymorphic_identity": "cliente"}

class Funcionario(Pessoa):
    __tablename__ = "FUNCIONARIO"
    cpf = Column(String, ForeignKey("PESSOA.cpf"), primary_key=True)
    salario = Column(Integer)
    turno = Column(String)
    
    __mapper_args__ = {"polymorphic_identity": "funcionario"}
'''



class Unidade(Base):
    __tablename__ = "UNIDADE"
    id = Column(Integer, primary_key=True, index=True)
    nome = Column(String, index=True)


class Sala(Base):
    __tablename__ = "SALA"
    id = Column(Integer, primary_key=True, index=True)
    nome = Column(String, index=True)
    unidade_id = Column(Integer, ForeignKey("UNIDADE.id"))
    unidade = relationship("Unidade", back_populates="salas")  # Relacionamento inverso

SALA_SESSAO = Table(
    "SALA_SESSAO",
    Base.metadata,
    Column("sala_id", Integer, ForeignKey("SALA.id"), primary_key=True),
    Column("sessao_id", Integer, ForeignKey("SESSAO.id"), primary_key=True),
)

class Sessao(Base):
    __tablename__ = "SESSAO"
    id = Column(Integer, primary_key=True, index=True)
    linguagem = Column(String, index=True)
    _3d = Column(Bool, index=True)
    filme = relationship("Filme", back_populates="sessoes")  # Relacionamento 1-N

class Data_horario(Base):
    __tablename__ = "DATA_HORARIO"
    id = Column(Integer, primary_key=True, index=True)
    dataHora = Column(String, index=True)
    sessao_id = Column(Integer, ForeignKey("SESSAO.id"))  # Chave estrangeira
    sessao = relationship("Sessao", back_populates="data_horario")  # Relacionamento inverso

class Filme(Base):
    __tablename__ = "FILME"
    id = Column(Integer, primary_key=True, index=True)
    titulo = Column(String, index=True)
    genero = Column(String, index=True)
    duracao = Column(Integer)  # Duração em minutos
    sinopse = Column(String, index=True)
    classificaçãoIndicativa = Column(String, index=True)

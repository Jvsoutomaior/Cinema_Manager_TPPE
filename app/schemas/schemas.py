from pydantic import BaseModel
from datetime import datetime, time, date

class Pessoa(BaseModel):
    cpf: str #id
    nome: str
    email: str
    dataNascimento: str

    class Config:
        orm_mode = True

class Cliente(Pessoa):
    fidelidade: int

    class Config:
        orm_mode = True

class Funcionario(Pessoa):
    turno: str
    salario: float

    class Config:
        orm_mode = True

class Unidade(BaseModel):
    id: int
    nome: str
    telefone: str
    email: str
    rede: str
    endereco: str

    class Config:
        orm_mode = True

class Sala(BaseModel):
    id: int
    numero: int

    class Config:
        orm_mode = True

class Sessao(BaseModel):
    _3d: bool
    linguagem: str

    class Config:
        orm_mode = True

class Filme(BaseModel):
    id: int
    titulo: str
    ano: int
    genero: str
    duracao: int
    classificacaoIndicativa: str
    sinopse: str

    class Config:
        orm_mode = True




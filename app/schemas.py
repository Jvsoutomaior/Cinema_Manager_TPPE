from pydantic import BaseModel, EmailStr
from typing import List, Optional
from datetime import date, datetime

# Base Schemas

class UnidadeBase(BaseModel):
    nome: str
    endereco: Optional[str] = None
    telefone: Optional[str] = None
    email: Optional[str] = None
    rede: Optional[str] = None

class SessaoBase(BaseModel):
    linguagem: Optional[str] = None
    is_3d: bool = False
    sala: str
    unidade_id_FK: int
    filme_id_FK: int

class DataHorarioBase(BaseModel):
    dataHora: datetime
    sessao_id_FK: int

class FilmeBase(BaseModel):
    titulo: str
    ano: str
    genero: str
    sinopse: Optional[str] = None
    classificacao_indicativa: Optional[str] = None
    duracao: Optional[str] = None

class PessoaBase(BaseModel):
    nome: str
    data_nascimento: Optional[date] = None
    email: Optional[EmailStr] = None

class FuncionarioBase(PessoaBase):
    turno: Optional[str] = None
    salario: Optional[float] = None

class ClienteBase(PessoaBase):
    fidelidade: float = 0.0

# Create Schemas

class UnidadeCreate(UnidadeBase):
    pass

class SessaoCreate(SessaoBase):
    pass

class DataHorarioCreate(DataHorarioBase):
    pass

class FilmeCreate(FilmeBase):
    pass

class FuncionarioCreate(FuncionarioBase):
    cpf: str

class ClienteCreate(ClienteBase):
    cpf: str

# Response Schemas
class DataHorario(DataHorarioBase):
    id: int
    sessao: Optional['Sessao'] = None

    class Config:
        from_attributes = True

class Sessao(SessaoBase):
    id: int
    unidade: Optional['Unidade'] = None
    filme: Optional['Filme'] = None
    datas_horarios: List[DataHorario] = []

    class Config:
        from_attributes = True

class Unidade(UnidadeBase):
    id: int
    sessoes: List[Sessao] = []

    class Config:
        from_attributes = True

class Filme(FilmeBase):
    id: int
    sessoes: List[Sessao] = []

    class Config:
        from_attributes = True

class Funcionario(FuncionarioBase):
    cpf: str
    type: str = "funcionario"

    class Config:
        from_attributes = True

class Cliente(ClienteBase):
    cpf: str
    type: str = "cliente"

    class Config:
        from_attributes = True

# Update Schemas
class UnidadeUpdate(BaseModel):
    nome: Optional[str] = None
    endereco: Optional[str] = None
    telefone: Optional[str] = None
    email: Optional[str] = None
    rede: Optional[str] = None

class SessaoUpdate(BaseModel):
    linguagem: Optional[str] = None
    is_3d: Optional[bool] = None
    sala: Optional[str] = None
    unidade_id_FK: Optional[int] = None
    filme_id_FK: Optional[int] = None

class DataHorarioUpdate(BaseModel):
    dataHora: Optional[datetime] = None
    sessao_id_FK: Optional[int] = None

class FilmeUpdate(BaseModel):
    titulo: Optional[str] = None
    ano: Optional[str] = None
    genero: Optional[str] = None
    sinopse: Optional[str] = None
    classificacao_indicativa: Optional[str] = None
    duracao: Optional[str] = None

class FuncionarioUpdate(BaseModel):
    nome: Optional[str] = None
    data_nascimento: Optional[date] = None
    email: Optional[EmailStr] = None
    turno: Optional[str] = None
    salario: Optional[float] = None

class ClienteUpdate(BaseModel):
    nome: Optional[str] = None
    data_nascimento: Optional[date] = None
    email: Optional[EmailStr] = None
    fidelidade: Optional[float] = None

# Forward references for circular dependencies
Sessao.model_rebuild()
Unidade.model_rebuild()
Filme.model_rebuild()
DataHorario.model_rebuild() 
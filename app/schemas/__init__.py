# Import all schemas to ensure they're loaded
from .filme import Filme, FilmeCreate, FilmeUpdate
from .pessoa import Cliente, ClienteCreate, ClienteUpdate, Funcionario, FuncionarioCreate, FuncionarioUpdate
from .sessao import Sessao, SessaoCreate, SessaoUpdate, DataHorario, DataHorarioCreate, DataHorarioUpdate
from .ingresso import Ingresso, IngressoCreate, IngressoUpdate

# Rebuild all models with forward references after all imports are complete
Filme.model_rebuild()
Cliente.model_rebuild()
Funcionario.model_rebuild()
DataHorario.model_rebuild()
Sessao.model_rebuild()
Ingresso.model_rebuild()

__all__ = [
    "Filme", "FilmeCreate", "FilmeUpdate",
    "Cliente", "ClienteCreate", "ClienteUpdate",
    "Funcionario", "FuncionarioCreate", "FuncionarioUpdate",
    "Sessao", "SessaoCreate", "SessaoUpdate",
    "DataHorario", "DataHorarioCreate", "DataHorarioUpdate",
    "Ingresso", "IngressoCreate", "IngressoUpdate"
]

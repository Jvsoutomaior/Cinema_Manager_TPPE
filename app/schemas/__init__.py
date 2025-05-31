# Import all models first
from .cinema import Cinema, CinemaCreate, CinemaUpdate
from .pessoa import (
    Funcionario, FuncionarioCreate, FuncionarioUpdate,
    Cliente, ClienteCreate, ClienteUpdate
)
from .filme import Filme, FilmeCreate, FilmeUpdate
from .sessao import (
    Sessao, SessaoCreate, SessaoUpdate,
    DataHorario, DataHorarioCreate, DataHorarioUpdate
)
from .ingresso import Ingresso, IngressoCreate, IngressoUpdate

# Rebuild models in the correct order to resolve forward references
# First rebuild the models that are referenced by others
Sessao.model_rebuild()
DataHorario.model_rebuild()
# Then rebuild the models that reference them
Cinema.model_rebuild() 
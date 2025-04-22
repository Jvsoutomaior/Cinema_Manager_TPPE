from pydantic import BaseModel

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
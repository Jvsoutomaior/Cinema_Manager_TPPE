from fastapi import APIRouter, Depends, HTTPException
from schemas.filme import Filme

api_router = APIRouter(tags=["Filme"])

FILMES = [
    {
        "id": 1,
        "titulo": "A Espera de um Milagre",
        "ano": 1999,
        "genero": "Drama",
        "duracao": 189,
        "classificacaoIndicativa": "14",
        "sinopse": "Um guarda prisional é encarregado de cuidar de um prisioneiro com habilidades especiais.",
    },
    {
        "id": 2,
        "titulo": "O Senhor dos Anéis: A Sociedade do Anel",
        "ano": 2001,
        "genero": "Fantasia",
        "duracao": 178,
        "classificacaoIndicativa": "12",
        "sinopse": "Um jovem hobbit embarca em uma jornada épica para destruir um poderoso anel.",
    }
]

@api_router.post("/filme/", response_model=Filme, status_code=201)
def create_filme(*, filme_in: Filme) -> dict:
    """
    Endpoint to create a new filme.
    """
    new_id = len(FILMES) + 1
    new_filme = Filme(
        id=new_id,
        titulo=filme_in.titulo,
        ano=filme_in.ano,
        genero=filme_in.genero,
        duracao=filme_in.duracao,
        classificacaoIndicativa=filme_in.classificacaoIndicativa,
        sinopse=filme_in.sinopse
    )
    FILMES.append(new_filme.dict())
    return new_filme

@api_router.get("/filme/{filme.id}", status_code=200)
def get_filme(*, film_id: int) -> dict:
    """
    Endpoint to get a filme.
    """
    for filme in FILMES:
        if filme["id"] == film_id:
            return filme
    raise HTTPException(status_code=404, detail="Filme not found")


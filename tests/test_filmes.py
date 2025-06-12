from .test_main import client
from app.models.filme import Filme
import pytest


# teste de criação de filme

def test_create_filme():
    filme_data = {
        "titulo": "O Senhor dos Anéis",
        "ano": "2001",
        "genero": "Fantasia",
        "sinopse": "Uma aventura épica na Terra Média.",
        "classificacao_indicativa": "12",
        "duracao": "3h48min"
    }
    response = client.post("/filmes/", json=filme_data)
    assert response.status_code == 200
    data = response.json()
    assert data["titulo"] == filme_data["titulo"]
    assert data["ano"] == filme_data["ano"]
    assert data["genero"] == filme_data["genero"]
    assert data["sinopse"] == filme_data["sinopse"]
    assert data["classificacao_indicativa"] == filme_data["classificacao_indicativa"]
    assert data["duracao"] == filme_data["duracao"]
    assert "id" in data


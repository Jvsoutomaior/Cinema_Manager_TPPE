from .test_main import client, db
from app.models.filme import Filme
from sqlalchemy.orm import Session
import pytest


# teste de criação de filme
def test_create_filme(db: Session):
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


# teste de leitura de filme
def test_read_filme(db: Session):
    #create a filme
    filme_data = {
        "titulo": "Shrek",
        "ano": "2001",
        "genero": "Animação",
        "sinopse": "Um ogro solitário embarca em uma jornada para salvar uma princesa.",
        "classificacao_indicativa": "Livre",
        "duracao": "1h30min"
    }
    response = client.post("/filmes/", json=filme_data)
    if response.status_code != 200:
        return
    created_filme = response.json()
    
    # Now read the filme by its ID
    response = client.get(f"/filmes/{created_filme['id']}")
    assert response.status_code == 200
    data = response.json()
    assert data["id"] == created_filme["id"]
    assert data["titulo"] == filme_data["titulo"]
    assert data["ano"] == filme_data["ano"]
    assert data["genero"] == filme_data["genero"]
    assert data["sinopse"] == filme_data["sinopse"]
    assert data["classificacao_indicativa"] == filme_data["classificacao_indicativa"]
    assert data["duracao"] == filme_data["duracao"]

def test_read_filmes(db: Session):
    # Create multiple filmes to read
    filmes = [
        {
            "titulo": "Matrix",
            "ano": "1999",
            "genero": "Sci-Fi",
            "sinopse": "Um hacker descobre a verdade sobre a realidade.",
            "classificacao_indicativa": "14",
            "duracao": "2h16min"
        },
        {
            "titulo": "Inception",
            "ano": "2010",
            "genero": "Sci-Fi",
            "sinopse": "Um ladrão de sonhos é contratado para implantar uma ideia.",
            "classificacao_indicativa": "12",
            "duracao": "2h28min"
        }
    ]
    for filme in filmes:
        client.post("/filmes/", json=filme)
    
    response = client.get("/filmes/")
    assert response.status_code == 200
    response_data = response.json()
    assert len(response_data) >= 2

def test_update_filme(db: Session):
    # Create a filme to update
    filme_data = {
        "titulo": "Avatar",
        "ano": "2009",
        "genero": "Aventura",
        "sinopse": "Um ex-fuzileiro se torna parte de uma civilização alienígena.",
        "classificacao_indicativa": "12",
        "duracao": "2h42min"
    }
    response = client.post("/filmes/", json=filme_data)
    assert response.status_code == 200
    if response.status_code != 200:
        return
    created_filme = response.json()
    
    # Update the filme
    updated_data = {
        "titulo": "Avatar - Edição Especial",
        "ano": "2010",
        "genero": "Aventura/Sci-Fi",
        "sinopse": "Uma nova edição do épico de James Cameron.",
        "classificacao_indicativa": "12",
        "duracao": "2h50min"
    }
    response = client.put(f"/filmes/{created_filme['id']}", json=updated_data)
    assert response.status_code == 200
    data = response.json()
    assert data["titulo"] == updated_data["titulo"]
    assert data["ano"] == updated_data["ano"]
    assert data["genero"] == updated_data["genero"]
    assert data["sinopse"] == updated_data["sinopse"]
    assert data["classificacao_indicativa"] == updated_data["classificacao_indicativa"]
    assert data["duracao"] == updated_data["duracao"]


# teste de deleção de filme
def test_delete_filme(db: Session):
    # Create a filme
    filme_data = {
        "titulo": "Titanic",
        "ano": "1997",
        "genero": "Romance",
        "sinopse": "Uma história de amor a bordo do navio Titanic.",
        "classificacao_indicativa": "12",
        "duracao": "3h14min"
    }
    response = client.post("/filmes/", json=filme_data)
    assert response.status_code == 200
    if response.status_code != 200:
        return
    created_filme = response.json()

    # Delete the filme
    response = client.delete(f"/filmes/{created_filme['id']}")
    assert response.status_code == 200
    # Verify the filme is deleted
    response = client.get(f"/filmes/{created_filme['id']}")
    assert response.status_code == 404

# Clean up the database after the test

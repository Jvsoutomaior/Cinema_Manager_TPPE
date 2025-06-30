import pytest
from fastapi import status

@pytest.fixture
def sample_filme():
    return {
        "titulo": "O Senhor dos Anéis",
        "ano": 2001,
        "genero": "Fantasia",
        "sinopse": "Uma aventura épica na Terra Média.",
        "classificacao_indicativa": "12",
        "duracao": 228
    }

@pytest.fixture
def created_filme(client, sample_filme):
    response = client.post("/filmes/", json=sample_filme)
    return response.json()

def test_create_filme(client, sample_filme):
    response = client.post("/filmes/", json=sample_filme)
    assert response.status_code == status.HTTP_201_CREATED
    data = response.json()
    assert data["titulo"] == sample_filme["titulo"]
    assert data["ano"] == sample_filme["ano"]
    assert data["genero"] == sample_filme["genero"]
    assert data["sinopse"] == sample_filme["sinopse"]
    assert data["classificacao_indicativa"] == sample_filme["classificacao_indicativa"]
    assert data["duracao"] == sample_filme["duracao"]
    assert "id" in data

def test_read_filme(client, created_filme):
    response = client.get(f"/filmes/{created_filme['id']}")
    assert response.status_code == status.HTTP_200_OK
    data = response.json()
    assert data["id"] == created_filme["id"]
    assert data["titulo"] == created_filme["titulo"]

def test_read_nonexistent_filme(client):
    response = client.get("/filmes/99999")
    assert response.status_code == status.HTTP_404_NOT_FOUND

def test_read_all_filmes(client, created_filme):
    response = client.get("/filmes/")
    assert response.status_code == status.HTTP_200_OK
    data = response.json()
    assert isinstance(data, list)
    assert len(data) > 0
    assert any(filme["id"] == created_filme["id"] for filme in data)

def test_update_filme(client, created_filme):
    update_data = {
        "titulo": "O Senhor dos Anéis: A Sociedade do Anel",
        "sinopse": "Uma nova aventura épica na Terra Média."
    }
    response = client.put(f"/filmes/{created_filme['id']}", json=update_data)
    assert response.status_code == status.HTTP_200_OK
    data = response.json()
    assert data["id"] == created_filme["id"]
    assert data["titulo"] == update_data["titulo"]
    assert data["sinopse"] == update_data["sinopse"]
    # Unchanged fields should remain the same
    assert data["ano"] == created_filme["ano"]
    assert data["genero"] == created_filme["genero"]

def test_update_nonexistent_filme(client):
    update_data = {"titulo": "Novo Título"}
    response = client.put("/filmes/99999", json=update_data)
    assert response.status_code == status.HTTP_404_NOT_FOUND

def test_delete_filme(client, created_filme):
    response = client.delete(f"/filmes/{created_filme['id']}")
    assert response.status_code == status.HTTP_200_OK
    
    # Verify the film was actually deleted
    get_response = client.get(f"/filmes/{created_filme['id']}")
    assert get_response.status_code == status.HTTP_404_NOT_FOUND

def test_delete_nonexistent_filme(client):
    response = client.delete("/filmes/99999")
    assert response.status_code == status.HTTP_404_NOT_FOUND

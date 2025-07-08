import pytest
from fastapi import status

sample_filme = {
    "titulo": "O Senhor dos Anéis",
    "ano": 2001,
    "genero": "Fantasia",
    "sinopse": "Uma aventura épica na Terra Média.",
    "classificacao_indicativa": "12",
    "duracao": 228
    }

@pytest.fixture
def create_filme(client):
    response = client.post("/filmes/", json=sample_filme)
    return response.json()

def test_create_filme(client):
    '''Função para testar cadastro de filme'''
    response = client.post("/filmes/", json=sample_filme)
    assert response.status_code == status.HTTP_201_CREATED

def test_read_filme(client, create_filme):
    '''Função para testar leitura de um filme'''
    response = client.get(f"/filmes/{create_filme['id']}")
    assert response.status_code == status.HTTP_200_OK

def test_read_all_filmes(client):
    '''Função para testar leitura de todos os filmes'''
    response = client.get("/filmes/")
    assert response.status_code == status.HTTP_200_OK

def test_update_filme(client, create_filme):
    '''Função para testar atualização de dados de filme'''
    update_data = {
        "titulo": "O Senhor dos Anéis: A Sociedade do Anel",
        "sinopse": "Uma nova aventura épica na Terra Média."
    }
    response = client.put(f"/filmes/{create_filme['id']}", json=update_data)
    assert response.status_code == status.HTTP_200_OK

def test_delete_filme(client, create_filme):
    response = client.delete(f"/filmes/{create_filme['id']}")
    assert response.status_code == status.HTTP_200_OK

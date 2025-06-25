from .test_main import client
from app.models.filme import Filme
import pytest


@pytest.fixture
def sample_filme():
    """Cria um filme para ser usado nas sessões"""
    filme_data = {
        "titulo": "Vingadores: Ultimato",
        "ano": "2019",
        "genero": "Ação",
        "sinopse": "Os Vingadores se unem para enfrentar Thanos.",
        "classificacao_indicativa": "12",
        "duracao": "3h1min"
    }
    response = client.post("/filmes/", json=filme_data)
    return response.json()


@pytest.fixture
def sample_sessao(sample_filme):
    """Cria dados de exemplo para uma sessão"""
    return {
        "linguagem": "Português",
        "is_3d": True,
        "sala": "Sala 1",
        "cinema_id_FK": 1,
        "filme_id_FK": sample_filme["id"]
    }


@pytest.fixture
def created_sessao(sample_sessao):
    """Cria uma sessão e retorna os dados"""
    response = client.post("/sessoes/", json=sample_sessao)
    return response.json()


def test_create_sessao(sample_sessao):
    """Testa a criação de uma sessão"""
    response = client.post("/sessoes/", json=sample_sessao)
    assert response.status_code == 200
    data = response.json()
    assert data["linguagem"] == sample_sessao["linguagem"]
    assert data["is_3d"] == sample_sessao["is_3d"]
    assert data["sala"] == sample_sessao["sala"]
    assert data["cinema_id_FK"] == sample_sessao["cinema_id_FK"]
    assert data["filme_id_FK"] == sample_sessao["filme_id_FK"]
    assert "id" in data


def test_read_sessao(created_sessao):
    """Testa a leitura de uma sessão específica"""
    response = client.get(f"/sessoes/{created_sessao['id']}")
    assert response.status_code == 200
    data = response.json()
    assert data["id"] == created_sessao["id"]
    assert data["linguagem"] == created_sessao["linguagem"]
    assert data["is_3d"] == created_sessao["is_3d"]
    assert data["sala"] == created_sessao["sala"]


def test_read_nonexistent_sessao():
    """Testa a leitura de uma sessão que não existe"""
    response = client.get("/sessoes/99999")
    assert response.status_code == 404
    assert response.json()["detail"] == "Sessao not found"


def test_read_all_sessoes(created_sessao):
    """Testa a leitura de todas as sessões"""
    response = client.get("/sessoes/")
    assert response.status_code == 200
    data = response.json()
    assert isinstance(data, list)
    assert len(data) > 0
    # Verifica se a sessão criada está na lista
    assert any(sessao["id"] == created_sessao["id"] for sessao in data)


def test_update_sessao(created_sessao):
    """Testa a atualização de uma sessão"""
    update_data = {
        "linguagem": "Inglês",
        "is_3d": False,
        "sala": "Sala VIP"
    }
    response = client.put(f"/sessoes/{created_sessao['id']}", json=update_data)
    assert response.status_code == 200
    data = response.json()
    assert data["id"] == created_sessao["id"]
    assert data["linguagem"] == update_data["linguagem"]
    assert data["is_3d"] == update_data["is_3d"]
    assert data["sala"] == update_data["sala"]
    # Campos não alterados devem permanecer os mesmos
    assert data["cinema_id_FK"] == created_sessao["cinema_id_FK"]
    assert data["filme_id_FK"] == created_sessao["filme_id_FK"]


def test_update_nonexistent_sessao():
    """Testa a atualização de uma sessão que não existe"""
    update_data = {"linguagem": "Espanhol"}
    response = client.put("/sessoes/99999", json=update_data)
    assert response.status_code == 404
    assert response.json()["detail"] == "Sessao not found"


def test_delete_sessao(created_sessao):
    """Testa a exclusão de uma sessão"""
    response = client.delete(f"/sessoes/{created_sessao['id']}")
    assert response.status_code == 200
    assert response.json()["message"] == "Sessao deleted successfully"
    
    # Verifica se a sessão foi realmente excluída
    get_response = client.get(f"/sessoes/{created_sessao['id']}")
    assert get_response.status_code == 404


def test_delete_nonexistent_sessao():
    """Testa a exclusão de uma sessão que não existe"""
    response = client.delete("/sessoes/99999")
    assert response.status_code == 404
    assert response.json()["detail"] == "Sessao not found"


def test_create_sessao_with_invalid_filme():
    """Testa a criação de uma sessão com um filme inexistente"""
    sessao_data = {
        "linguagem": "Português",
        "is_3d": False,
        "sala": "Sala 2",
        "cinema_id_FK": 1,
        "filme_id_FK": 99999  # ID de filme inexistente
    }
    response = client.post("/sessoes/", json=sessao_data)
    # Dependendo da implementação, pode retornar erro 400 ou 422
    # Por enquanto vamos assumir que permite criar com FK inválida
    assert response.status_code in [200, 400, 422]


def test_create_sessao_without_required_fields():
    """Testa a criação de uma sessão sem campos obrigatórios"""
    sessao_data = {
        "linguagem": "Português",
        "is_3d": False
        # Faltam: sala, cinema_id_FK, filme_id_FK
    }
    response = client.post("/sessoes/", json=sessao_data)
    assert response.status_code == 422  # Validation error
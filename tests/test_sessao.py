import pytest

@pytest.fixture
def sample_filme():
    """Cria um filme para ser usado nas sessões"""
    return {
        "titulo": "Vingadores: Ultimato",
        "ano": 2019,
        "genero": "Ação",
        "sinopse": "Os Vingadores se unem para enfrentar Thanos.",
        "classificacao_indicativa": "12",
        "duracao": 181
    }

@pytest.fixture
def created_filme(client, sample_filme):
    """Creates a filme and returns the response data"""
    response = client.post("/filmes/", json=sample_filme)
    return response.json()


@pytest.fixture
def sample_sessao(created_filme):
    """Cria dados de exemplo para uma sessão"""
    return {
        "linguagem": "Português",
        "is_3d": True,
        "sala": "Sala 1",
        "filme_id_FK": created_filme["id"]
    }

@pytest.fixture
def created_sessao(client, sample_sessao):
    """Cria uma sessão e retorna os dados"""
    response = client.post("/sessoes/", json=sample_sessao)
    return response.json()

@pytest.fixture
def sample_data_horario():
    """Cria dados de exemplo para um horário de sessão"""
    return {
        "dataHora": "2023-10-01T15:30:00"
    }

def test_create_sessao(client, sample_sessao):
    """Testa a criação de uma sessão"""
    response = client.post("/sessoes/", json=sample_sessao)
    assert response.status_code == 200
    data = response.json()
    assert data["linguagem"] == sample_sessao["linguagem"]
    assert data["is_3d"] == sample_sessao["is_3d"]
    assert data["sala"] == sample_sessao["sala"]
    assert data["filme_id_FK"] == sample_sessao["filme_id_FK"]
    assert "id" in data

def test_read_sessao(client, created_sessao):
    """Testa a leitura de uma sessão específica"""
    response = client.get(f"/sessoes/{created_sessao['id']}")
    assert response.status_code == 200
    data = response.json()
    assert data["id"] == created_sessao["id"]
    assert data["linguagem"] == created_sessao["linguagem"]
    assert data["is_3d"] == created_sessao["is_3d"]
    assert data["sala"] == created_sessao["sala"]

def test_read_all_sessoes(client, created_sessao):
    """Testa a leitura de todas as sessões"""
    response = client.get("/sessoes/")
    assert response.status_code == 200
    data = response.json()
    assert isinstance(data, list)
    assert len(data) > 0
    assert any(sessao["id"] == created_sessao["id"] for sessao in data)

def test_update_sessao(client, created_sessao):
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
    assert data["filme_id_FK"] == created_sessao["filme_id_FK"]

def test_delete_sessao(client, created_sessao):
    """Testa a exclusão de uma sessão"""
    response = client.delete(f"/sessoes/{created_sessao['id']}")
    assert response.status_code == 200


def test_create_data_horario(client, created_sessao, sample_data_horario):
    """Testa a criação de um horário de sessão associado a uma sessão específica"""
    response = client.post(f"/sessoes/{created_sessao['id']}/datas-horarios/", json=sample_data_horario)
    assert response.status_code == 200
    data = response.json()
    assert data["dataHora"] == sample_data_horario["dataHora"]
    assert data["sessao_id"] == created_sessao["id"]
    assert "id" in data

# def test_read_datas_horarios(client, created_sessao):
#     """Testa a leitura de todos os horários de sessão de uma sessão específica"""
#     response = client.get(f"/sessoes/{created_sessao['id']}/datas-horarios/")
#     assert response.status_code == 200
#     data = response.json()
#     assert isinstance(data, list)
#     assert len(data) > 0
#     assert all(dh["sessao_id"] == created_sessao["id"] for dh in data)

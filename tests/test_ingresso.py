import pytest

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
def create_sample_filme(client, sample_filme):
    """Create a sample movie for testing."""
    response = client.post("/filmes/", json=sample_filme)
    return response.json()

@pytest.fixture
def sample_sessao(create_sample_filme):
    """Sample session data for testing."""
    return {
        "linguagem": "Português",
        "is_3d": True,
        "sala": "Sala 1",
        "filme_id_FK": create_sample_filme["id"]
    }

@pytest.fixture
def create_sample_sessao(client, sample_sessao):
    """Create a sample session for testing."""
    response = client.post("/sessoes/", json=sample_sessao)
    return response.json()

@pytest.fixture
def sample_pessoa():
    """Sample person data for testing."""
    return {
        "nome": "John Doe",
        "email": "cliente@gmail.com",
        "cpf": "12345678901",
        "data_nascimento": "1990-01-01",
        "fidelidade": 100.0
    }

@pytest.fixture
def create_sample_pessoa(client, sample_pessoa):
    """Create a sample client for testing."""
    response = client.post("/pessoas/clientes/", json=sample_pessoa)
    return response.json()

## --------------------
@pytest.fixture
def sample_ingresso(create_sample_pessoa, create_sample_sessao):
    """Sample ingresso data for testing."""
    return {
        "sessao_id_FK": create_sample_sessao["id"],
        "cliente_cpf_FK": create_sample_pessoa["cpf"],
        "preco": 30.0,
        "tipo": "inteira"
    }

@pytest.fixture
def create_sample_ingresso(client, sample_ingresso):
    """Create a sample ingresso for testing."""
    response = client.post("/ingressos/", json=sample_ingresso)
    return response.json()

def test_create_ingresso(client, sample_ingresso):
    response = client.post("/ingressos/", json=sample_ingresso)
    assert response.status_code == 201
    data = response.json()
    assert data["sessao_id_FK"] == sample_ingresso["sessao_id_FK"]
    assert data["cliente_cpf_FK"] == sample_ingresso["cliente_cpf_FK"]
    assert data["preco"] == sample_ingresso["preco"]
    assert data["tipo"] == sample_ingresso["tipo"]

def test_get_ingresso_by_id(client, create_sample_ingresso):
    ingresso_id = create_sample_ingresso["id"]
    response = client.get(f"/ingressos/{ingresso_id}")
    assert response.status_code == 200
    data = response.json()
    assert data["id"] == ingresso_id

def test_get_all_ingressos(client, create_sample_ingresso):
    response = client.get("/ingressos/")
    assert response.status_code == 200
    data = response.json()
    assert isinstance(data, list)
    assert any(ing["id"] == create_sample_ingresso["id"] for ing in data)

def test_get_ingressos_by_sessao_id(client, create_sample_ingresso, create_sample_sessao):
    sessao_id = create_sample_sessao["id"]
    response = client.get(f"/ingressos/sessao/{sessao_id}")
    assert response.status_code == 200
    data = response.json()
    assert isinstance(data, list)
    assert any(ing["sessao_id_FK"] == sessao_id for ing in data)

def test_get_ingressos_by_cliente_cpf(client, create_sample_ingresso, create_sample_pessoa):
    cpf = create_sample_pessoa["cpf"]
    response = client.get(f"/ingressos/cliente/{cpf}")
    assert response.status_code == 200
    data = response.json()
    assert isinstance(data, list)
    assert any(ing["cliente_cpf_FK"] == cpf for ing in data)

def test_update_ingresso(client, create_sample_ingresso):
    ingresso_id = create_sample_ingresso["id"]
    updated_data = create_sample_ingresso.copy()
    updated_data["preco"] = 40.0
    response = client.put(f"/ingressos/{ingresso_id}", json=updated_data)
    assert response.status_code == 200
    data = response.json()
    assert data["preco"] == 40.0

def test_delete_ingresso(client, create_sample_ingresso):
    ingresso_id = create_sample_ingresso["id"]
    response = client.delete(f"/ingressos/{ingresso_id}")
    assert response.status_code == 204
    # Confirm deletion
    get_response = client.get(f"/ingressos/{ingresso_id}")
    assert get_response.status_code == 404

def test_create_duplicate_ingresso_fails(client, create_sample_ingresso, sample_ingresso):
    # Try to create the same ingresso again using the original sample data (should fail)
    response = client.post("/ingressos/", json=sample_ingresso)
    assert response.status_code == 400 or response.status_code == 422

def test_update_nonexistent_ingresso(client):
    updated_data = {
        "sessao_id_FK": 9999,
        "cliente_cpf_FK": "00000000000",
        "preco": 50.0,
        "tipo": "meia"
    }
    response = client.put("/ingressos/9999", json=updated_data)
    assert response.status_code == 404 or response.status_code == 400

def test_delete_nonexistent_ingresso(client):
    response = client.delete("/ingressos/9999")
    assert response.status_code == 404 or response.status_code == 400

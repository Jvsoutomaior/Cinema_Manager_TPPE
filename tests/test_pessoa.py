import pytest

# FUNCIONARIO
@pytest.fixture
def sample_funcionario():
    funcionario_data = {
        "cpf": "12345678901",
        "nome": "João Silva",
        "data_nascimento": "1990-01-01",
        "email": "funcionario@gmail.com",
        "turno": "Manhã",
        "salario": 3000.00
    }
    return funcionario_data

# Create
def test_create_funcionario(client, sample_funcionario):
    """Testa a criação de um funcionário"""
    response = client.post("/pessoas/funcionarios/", json=sample_funcionario)
    assert response.status_code == 200
    data = response.json()
    assert data["cpf"] == sample_funcionario["cpf"]
    assert data["nome"] == sample_funcionario["nome"]
    assert data["data_nascimento"] == sample_funcionario["data_nascimento"]
    assert data["email"] == sample_funcionario["email"]
    assert data["turno"] == sample_funcionario["turno"]
    assert data["salario"] == sample_funcionario["salario"]

@pytest.fixture
def created_funcionario(client, sample_funcionario):
    """Creates a funcionario and returns the response data"""
    response = client.post("/pessoas/funcionarios/", json=sample_funcionario)
    return response.json()

# Read
def test_read_funcionario(client, created_funcionario):
    """Testa a leitura de um funcionário específico"""
    response = client.get(f"/pessoas/funcionarios/{created_funcionario['cpf']}")
    assert response.status_code == 200
    data = response.json()
    assert data["cpf"] == created_funcionario["cpf"]
    assert data["nome"] == created_funcionario["nome"]

# Update
def test_update_funcionario(client, created_funcionario):
    """Testa a atualização de um funcionário"""
    updated_data = {
        "nome": "João Silva Atualizado",
        "turno": "Tarde"
    }
    response = client.put(f"/pessoas/funcionarios/{created_funcionario['cpf']}", json=updated_data)
    assert response.status_code == 200
    data = response.json()
    assert data["nome"] == updated_data["nome"]
    assert data["turno"] == updated_data["turno"]

# Read All
def test_read_all_funcionarios(client, created_funcionario):
    """Testa a leitura de todos os funcionários"""
    response = client.get("/pessoas/funcionarios/")
    assert response.status_code == 200
    data = response.json()
    assert isinstance(data, list)
    assert len(data) > 0
    # Verifica se o funcionário criado está na lista
    assert any(funcionario["cpf"] == created_funcionario["cpf"] for funcionario in data)

# Delete
def test_delete_funcionario(client, created_funcionario):
    """Testa a exclusão de um funcionário"""
    response = client.delete(f"/pessoas/funcionarios/{created_funcionario['cpf']}")
    assert response.status_code == 200


# CLIENTE

@pytest.fixture
def sample_cliente():
    """Cria um cliente para ser usado nos testes"""
    cliente_data = {
        "cpf": "10987654321",
        "nome": "Maria Oliveira",
        "data_nascimento": "1995-05-05",
        "email": "cliente@gmail.com",
        "fidelidade": 100.0
    }
    return cliente_data

@pytest.fixture
def created_cliente(client, sample_cliente):
    """Creates a cliente and returns the response data"""
    response = client.post("/pessoas/clientes/", json=sample_cliente)
    return response.json()

# Create
def test_create_cliente(client, sample_cliente):
    """Testa a criação de um cliente"""
    response = client.post("/pessoas/clientes/", json=sample_cliente)
    assert response.status_code == 200
    data = response.json()
    assert data["cpf"] == sample_cliente["cpf"]
    assert data["nome"] == sample_cliente["nome"]
    assert data["data_nascimento"] == sample_cliente["data_nascimento"]
    assert data["email"] == sample_cliente["email"]
    assert data["fidelidade"] == sample_cliente["fidelidade"]

# Read
def test_read_cliente(client, created_cliente):
    """Testa a leitura de um cliente específico"""
    response = client.get(f"/pessoas/clientes/{created_cliente['cpf']}")
    assert response.status_code == 200
    data = response.json()
    assert data["cpf"] == created_cliente["cpf"]
    assert data["nome"] == created_cliente["nome"]

# Update
def test_update_cliente(client, created_cliente):
    """Testa a atualização de um cliente"""
    updated_data = {
        "nome": "Maria Oliveira Atualizada",
        "fidelidade": 150.0
    }
    response = client.put(f"/pessoas/clientes/{created_cliente['cpf']}", json=updated_data)
    assert response.status_code == 200
    data = response.json()
    assert data["nome"] == updated_data["nome"]
    assert data["fidelidade"] == updated_data["fidelidade"]

# Read All
def test_read_all_clientes(client, created_cliente):
    """Testa a leitura de todos os clientes"""
    response = client.get("/pessoas/clientes/")
    assert response.status_code == 200
    data = response.json()
    assert isinstance(data, list)
    assert len(data) > 0
    # Verifica se o cliente criado está na lista
    assert any(cliente["cpf"] == created_cliente["cpf"] for cliente in data)

# Delete
def test_delete_cliente(client, created_cliente):
    """Testa a exclusão de um cliente"""
    response = client.delete(f"/pessoas/clientes/{created_cliente['cpf']}")
    assert response.status_code == 200

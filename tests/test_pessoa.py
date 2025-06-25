from .test_main import client, delete_all_registries
from app.models.pessoa import Pessoa, Funcionario, Cliente
import pytest


delete_all_registries("funcionarios")
delete_all_registries("clientes")

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
def test_create_funcionario(sample_funcionario):
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

# Read
def test_read_funcionario(sample_funcionario):
    """Testa a leitura de um funcionário específico"""
    response = client.get(f"/pessoas/funcionarios/{sample_funcionario['cpf']}")
    assert response.status_code == 200
    data = response.json()
    assert data["cpf"] == sample_funcionario["cpf"]
    assert data["nome"] == sample_funcionario["nome"]
    assert data["data_nascimento"] == sample_funcionario["data_nascimento"]
    assert data["email"] == sample_funcionario["email"]
    assert data["turno"] == sample_funcionario["turno"]
    assert data["salario"] == sample_funcionario["salario"]

# Update
def test_update_funcionario(sample_funcionario):
    """Testa a atualização de um funcionário"""
    updated_data = {
        "nome": "João Silva Atualizado",
        "turno": "Tarde"
    }
    response = client.put(f"/pessoas/funcionarios/{sample_funcionario['cpf']}", json=updated_data)
    assert response.status_code == 200
    data = response.json()
    assert data["nome"] == updated_data["nome"]
    assert data["turno"] == updated_data["turno"]

# Read All
def test_read_all_funcionarios(sample_funcionario):
    """Testa a leitura de todos os funcionários"""
    response = client.get("/pessoas/funcionarios/")
    assert response.status_code == 200
    data = response.json()
    assert isinstance(data, list)
    assert len(data) > 0
    # Verifica se o funcionário criado está na lista
    assert any(funcionario["cpf"] == sample_funcionario["cpf"] for funcionario in data)

# Delete
def test_delete_funcionario(sample_funcionario):
    """Testa a exclusão de um funcionário"""
    response = client.delete(f"/pessoas/funcionarios/{sample_funcionario['cpf']}")
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

# Create
def test_create_cliente(sample_cliente):
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
def test_read_cliente(sample_cliente):
    """Testa a leitura de um cliente específico"""
    response = client.get(f"/pessoas/clientes/{sample_cliente['cpf']}")
    assert response.status_code == 200
    data = response.json()
    assert data["cpf"] == sample_cliente["cpf"]
    assert data["nome"] == sample_cliente["nome"]
    assert data["data_nascimento"] == sample_cliente["data_nascimento"]
    assert data["email"] == sample_cliente["email"]
    assert data["fidelidade"] == sample_cliente["fidelidade"]

# Update
def test_update_cliente(sample_cliente):
    """Testa a atualização de um cliente"""
    updated_data = {
        "nome": "Maria Oliveira Atualizada",
        "fidelidade": 150.0
    }
    response = client.put(f"/pessoas/clientes/{sample_cliente['cpf']}", json=updated_data)
    assert response.status_code == 200
    data = response.json()
    assert data["nome"] == updated_data["nome"]
    assert data["fidelidade"] == updated_data["fidelidade"]

# Read All
def test_read_all_clientes(sample_cliente):
    """Testa a leitura de todos os clientes"""
    response = client.get("/pessoas/clientes/")
    assert response.status_code == 200
    data = response.json()
    assert isinstance(data, list)
    assert len(data) > 0
    # Verifica se o cliente criado está na lista
    assert any(cliente["cpf"] == sample_cliente["cpf"] for cliente in data)

# Delete
def test_delete_cliente(sample_cliente):
    """Testa a exclusão de um cliente"""
    response = client.delete(f"/pessoas/clientes/{sample_cliente['cpf']}")
    assert response.status_code == 200

delete_all_registries("funcionarios")
delete_all_registries("clientes")
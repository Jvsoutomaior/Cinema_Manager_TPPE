from .test_main import client, db
from app.models.cinema import Cinema
from sqlalchemy.orm import Session
import pytest

# teste de criação de cinema
def test_create_cinema(db: Session):
    cinema_data ={
        "nome": "Cine Teste",
        "endereco": "Rua Teste, 123",
        "telefone": "1234567890",
        "email": "cinema@gmail.com"
    }
    response = client.post("/cinemas/", json=cinema_data)
    assert response.status_code == 200
    data = response.json()
    assert data["nome"] == cinema_data["nome"]
    assert data["endereco"] == cinema_data["endereco"]
    assert data["telefone"] == cinema_data["telefone"]
    assert data["email"] == cinema_data["email"]

# teste de leitura de cinema
def test_read_cinema(db: Session):
    cinema_data = {
        "nome": "Cine Teste",
        "endereco": "Rua Teste, 123",
        "telefone": "1234567890",
        "email": "cinema@gmail.com"
    }
    response = client.post("/cinemas/", json=cinema_data)
    assert response.status_code == 200
    cinema_id = response.json()["id"]
    response = client.get(f"/cinemas/{cinema_id}")
    assert response.status_code == 200
    data = response.json()
    assert data["id"] == cinema_id
    assert data["nome"] == cinema_data["nome"]
    assert data["endereco"] == cinema_data["endereco"]
    assert data["telefone"] == cinema_data["telefone"]
    assert data["email"] == cinema_data["email"]

# teste de leitura de todos os cinemas
def test_read_all_cinemas(db: Session):
    cinemas = [
            {
            "nome" : "cine teste",
            "endereco": "Rua Teste, 123",
            "telefone": "1234567890",
            "email": "cinema@gmail.com"
            },
            {
            "nome" : "cine teste 2",
            "endereco": "Rua Teste, 456",
            "telefone": "0987654321",
            "email": "cinema@gmail.com"
            }
        ]
    for cinema_data in cinemas:
        response = client.post("/cinemas/", json=cinema_data)
        assert response.status_code == 200
    response = client.get("/cinemas/")
    assert response.status_code == 200
    data = response.json()
    assert len(data) >= 2

# teste de atualização de cinema
def test_update_cinema(db: Session):
    cinema_data = {
        "nome": "Cine Teste",
        "endereco": "Rua Teste, 123",
        "telefone": "1234567890",
        "email": "cinema@gmail.com"
    }
    response = client.post("/cinemas/", json=cinema_data)
    assert response.status_code == 200
    cinema_id = response.json()["id"]
    updated_data = {
        "nome": "Cine Atualizado",
        "endereco": "Rua Atualizada, 456",
        "telefone": "0987654321",
        "email": "cinema@gmail.com"
    }
    response = client.put(f"/cinemas/{cinema_id}", json=updated_data)
    assert response.status_code == 200
    data = response.json()
    assert data["id"] == cinema_id
    assert data["nome"] == updated_data["nome"]
    assert data["endereco"] == updated_data["endereco"]
    assert data["telefone"] == updated_data["telefone"]
    assert data["email"] == updated_data["email"]

# teste de exclusão de cinema
def test_delete_cinema(db: Session):
    cinema_data = {
        "nome": "Cine Teste",
        "endereco": "Rua Teste, 123",
        "telefone": "1234567890",
        "email": "cinema@gmail.com"
    }
    response = client.post("/cinemas/", json=cinema_data)
    assert response.status_code == 200
    cinema_id = response.json()["id"]
    response = client.delete(f"/cinemas/{cinema_id}")
    assert response.status_code == 200
    data = response.json()
    assert data["message"] == "Cinema deleted successfully"

# teste de leitura de cinema inexistente
def test_read_nonexistent_cinema(db: Session):
    response = client.get("/cinemas/9999")  # Assuming 9999 is a non-existent ID
    assert response.status_code == 404
    data = response.json()
    assert data["detail"] == "Cinema not found"


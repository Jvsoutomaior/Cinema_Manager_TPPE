from fastapi.testclient import TestClient
from app.main import app
import pytest
from datetime import date
from sqlalchemy.orm import Session
from app.database import SessionLocal, Base, engine

client = TestClient(app)

# @pytest.mark.skip(reason="Not implemented yet")
# @pytest.fixture(scope="function")
# def db():
#     # Create all tables
#     Base.metadata.create_all(bind=engine)
    
#     # Create a new database session for the test
#     db = SessionLocal()
#     try:
#         yield db
#     finally:
#         db.close()
#         # Drop all tables after the test
#         Base.metadata.drop_all(bind=engine)

# def test_create_cliente(db: Session):
#     # Test data
#     cliente_data = {
#         "nome": "Alice Silva",
#         "cpf": "123.321.456-00",
#         "data_nascimento": "1990-01-01",
#         "email": "alice@example.com",
#         "fidelidade": 0.0
#     }
    
#     # Create cliente
#     response = client.post("/pessoas/clientes/", json=cliente_data)
#     assert response.status_code == 201
#     data = response.json()
#     assert data["nome"] == cliente_data["nome"]
#     assert data["cpf"] == cliente_data["cpf"]
#     assert data["email"] == cliente_data["email"]
#     assert data["type"] == "cliente"
#     assert data["fidelidade"] == 0.0
    
#     # Cleanup - delete the test cliente
#     delete_response = client.delete(f"/pessoas/clientes/{unique_cpf}")
#     assert delete_response.status_code == 204        

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
    assert response.status_code == 201
    data = response.json()
    assert data["titulo"] == filme_data["titulo"]
    assert data["ano"] == filme_data["ano"]
    assert data["genero"] == filme_data["genero"]
    assert data["sinopse"] == filme_data["sinopse"]
    assert data["classificacao_indicativa"] == filme_data["classificacao_indicativa"]
    assert data["duracao"] == filme_data["duracao"]
    assert "id" in data        
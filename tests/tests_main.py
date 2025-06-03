from fastapi.testclient import TestClient
from app.main import app
import pytest
from sqlalchemy.orm import Session
from app.database import SessionLocal, Base, engine
from app.models.filme import Filme

client = TestClient(app)

# @pytest.mark.skip(reason="Not implemented yet")



@pytest.fixture(scope="function")
def db():
    # Create all tables
    Base.metadata.create_all(bind=engine)
    
    # Create a new database session for the test
    db = SessionLocal()
    try:
        yield db
    finally:
        db.close()

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
    #create a filme to read
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



# Clean up the database after the test
Base.metadata.drop_all(bind=engine)
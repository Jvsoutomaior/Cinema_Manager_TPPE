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
        Base.metadata.drop_all(bind=engine)
        db.close()
        
    
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

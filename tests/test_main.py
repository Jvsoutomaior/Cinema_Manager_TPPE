from fastapi.testclient import TestClient
from app.database import Session
from app.main import app

client = TestClient(app)

def test_read_root():
    response = client.get("/")
    assert response.status_code == 200
    assert response.json() == {"message": "Hello World"}

def test_read_item_endpoint( client: TestClient, db: Session ) -> None:
    item = criar_Filme(db)
    response = client.get("filmes/{filme.id}")
    assert response.status_code == 200
    content = response.json()
    assert content["id"] == str(filme.id)
    assert content["titulo"] == filme.titulo
    assert content["ano"] == filme.ano
    assert content["classificacao"] == filme.classificacao
    assert content["genero"] == filme.genero

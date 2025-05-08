from fastapi.testclient import TestClient
from app.main import app
import pytest

client = TestClient(app)

@pytest.mark.skip(reason="Not implemented yet")
def test_create_user():
    response = client.post("/users/", json={
        "username": "alice",
        "email": "alice@example.com",
        "password": "secret"
    })
    assert response.status_code == 201
    data = response.json()
    assert data["username"] == "alice"
    assert data["email"] == "alice@example.com"
    assert "id" in data

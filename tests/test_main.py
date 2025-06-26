# This file now only contains basic API tests
# The client fixture and database session are handled in conftest.py

def test_read_root(client):
    """Test the root endpoint"""
    response = client.get("/")
    assert response.status_code == 200
    assert response.json() == {"message": "Welcome to Cinema Manager API"}

def test_api_health(client):
    """Test that the API is responsive"""
    response = client.get("/")
    assert response.status_code == 200

from fastapi.testclient import TestClient
from sqlalchemy import text
from app.main import app
from app.database import get_db
from app.models.filme import Filme


client = TestClient(app)

def delete_all_registries(table_name: str):
    db = next(get_db())
    try:
        db.execute(text(f'TRUNCATE {table_name} RESTART IDENTITY CASCADE;'))
        db.commit()
    except Exception as e:
        print(f"Error: {str(e)}")
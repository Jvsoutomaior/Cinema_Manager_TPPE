from fastapi import FastAPI, APIRouter
from routes import filme

app = FastAPI(
    title="KinoderToten API",
    openapi_url="/api/v1/openapi.json",
)

app.include_router(filme.api_router)

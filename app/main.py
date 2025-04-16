from fastapi import FastAPI, APIRouter

app = FastAPI(
    title="KinoderToten API",
    openapi_url="/api/v1/openapi.json",
)

api_router = APIRouter()

@api_router.get("/", status_code=200)
def root() -> dict:
    """
    Root endpoint.
    """
    return {"message": "Hello World"}


app.include_router(api_router)


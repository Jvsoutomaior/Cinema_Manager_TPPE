"""Main entrypoint for the Cinema Manager API."""

from fastapi import FastAPI
from fastapi.middleware.cors import CORSMiddleware
from .database import engine, Base, init_db
from .routers import filme, ingresso, pessoa, sessao

app = FastAPI(
    title="Cinema Manager API",
    description="API for managing cinemas, movies, sessions, and tickets",
    version="1.0.0"
)

# Configure CORS
app.add_middleware(
    CORSMiddleware,
    allow_origins=["*"],  # Allows all origins
    allow_credentials=True,
    allow_methods=["*"],  # Allows all methods
    allow_headers=["*"],  # Allows all headers
)

# Create tables at startup
init_db()
Base.metadata.create_all(bind=engine)

# Include all routers
app.include_router(filme.router, prefix="/filmes", tags=["filmes"])
app.include_router(ingresso.router, prefix="/ingressos", tags=["ingressos"])
app.include_router(pessoa.router, prefix="/pessoas", tags=["pessoas"])
app.include_router(sessao.router, prefix="/sessoes", tags=["sessoes"])

@app.get("/")
def read_root():
    """Root endpoint for health check and welcome message."""
    return {"message": "Welcome to Cinema Manager API"}

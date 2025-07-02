"""Main entrypoint for the Cinema Manager API."""

from fastapi import FastAPI
from fastapi.middleware.cors import CORSMiddleware
from .database import init_db
from .routers import router

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

app.include_router(router)

@app.get("/")
def read_root():
    """Root endpoint for health check and welcome message."""
    return {"message": "Welcome to Cinema Manager API"}

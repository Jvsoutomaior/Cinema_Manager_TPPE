from fastapi import FastAPI, Depends, HTTPException
from sqlalchemy.orm import Session
from .database import engine, Base, SessionLocal, init_db
from fastapi.middleware.cors import CORSMiddleware
from .routers import router
from .routers import cinema, filme, ingresso, pessoa, sessao

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

# Dependency
def get_db():
    db = SessionLocal()
    try:
        yield db
    finally:
        db.close()

# Create tables at startup
init_db()

# Create database tables
Base.metadata.create_all(bind=engine)

# Include all routers
app.include_router(cinema.router, prefix="/cinemas", tags=["cinemas"])
app.include_router(filme.router, prefix="/filmes", tags=["filmes"])
app.include_router(ingresso.router, prefix="/ingressos", tags=["ingressos"])
app.include_router(pessoa.router, prefix="/pessoas", tags=["pessoas"])
app.include_router(sessao.router, prefix="/sessoes", tags=["sessoes"])

@app.get("/")
def read_root():
    return {"message": "Welcome to Cinema Manager API"}

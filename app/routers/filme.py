from fastapi import APIRouter, Depends, HTTPException, Response, status
from sqlalchemy.orm import Session
from typing import List
from ..models.filme import Filme as filmeModel
from ..schemas.filme import Filme, FilmeCreate, FilmeUpdate
from ..database import get_db
from ..repository.filme import FilmeRepository

router = APIRouter()

@router.post("/", response_model=Filme, status_code=status.HTTP_201_CREATED)
def create_filme(request: FilmeCreate, db: Session = Depends(get_db)):
    """ POST endpoint to create a new movie.    """
    filme = FilmeRepository.create_filme(db, filmeModel(**request.model_dump()))
    return filme


@router.get("/{filme_id}", response_model=Filme)
def get_filme_by_id(filme_id: int, db: Session = Depends(get_db)):
    """ GET endpoint to retrieve a movie by its ID. """
    db_filme = FilmeRepository.get_filme_by_id(db, filme_id)
    if db_filme is None:
        raise HTTPException(status_code=status.HTTP_404_NOT_FOUND, detail="Filme not found")
    return db_filme


@router.get("/", response_model=List[Filme])
def get_all_filmes(db: Session = Depends(get_db)):
    """ GET endpoint to retrieve all movies. """
    filmes = FilmeRepository.get_all_filmes(db)
    return filmes


@router.put("/{filme_id}", response_model=Filme)
def update_filme(filme_id: int, filme: FilmeUpdate, db: Session = Depends(get_db)):
    """ PUT endpoint to update an existing movie. """
    try:
        db_filme = FilmeRepository.update_filme(db, filme_id, filme)
    except ValueError as e:
        raise HTTPException(status_code=status.HTTP_404_NOT_FOUND, detail=str(e))
    return db_filme

@router.delete("/{filme_id}")
def delete_filme(filme_id: int, db: Session = Depends(get_db)):
    """ DELETE endpoint to delete a movie by its ID. """
    try:
        FilmeRepository.delete_filme(db, filme_id)
    except ValueError as e:
        raise HTTPException(status_code=status.HTTP_404_NOT_FOUND, detail=str(e))
    return Response(status_code=status.HTTP_200_OK, content=None)
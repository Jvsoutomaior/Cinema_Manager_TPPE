from sqlalchemy.orm import Session
from ..models.filme import Filme as FilmeModel

class FilmeRepository:
    @staticmethod
    def get_filme_by_id(db: Session, filme_id: int) -> FilmeModel:
        """
        Retrieve a movie by its ID from the database.
        """
        return db.query(FilmeModel).filter(FilmeModel.id == filme_id).first()

    @staticmethod
    def get_all_filmes(db: Session) -> list[FilmeModel]:
        """
        Retrieve all movies from the database.
        """
        return db.query(FilmeModel).all()

    @staticmethod
    def create_filme(db: Session, filme: FilmeModel) -> FilmeModel:
        """
        Create a new movie in the database.
        """
        if FilmeRepository.get_filme_by_id(db, filme.id):
            raise ValueError(f"Filme with id {filme.id} already exists.")
        else:
            db.add(filme)
            db.commit()
            db.refresh(filme)
        return filme
    
    @staticmethod
    def update_filme(db: Session, filme_id: int, updated_filme: FilmeModel) -> FilmeModel:
        """
        Update an existing movie in the database.
        """
        db_filme = FilmeRepository.get_filme_by_id(db, filme_id)
        if not db_filme:
            raise ValueError(f"Filme with id {filme_id} not found.")
        
        update_data = updated_filme.model_dump(exclude_unset=True)
        
        for key, value in update_data.items():
            setattr(db_filme, key, value)
        
        db.commit()
        db.refresh(db_filme)
        return db_filme
    
    @staticmethod
    def delete_filme(db: Session, filme_id: int) -> None:
        """
        Delete a movie from the database.
        """
        db_filme = FilmeRepository.get_filme_by_id(db, filme_id)
        if not db_filme:
            raise ValueError(f"Filme with id {filme_id} not found.")
        
        db.delete(db_filme)
        db.commit()
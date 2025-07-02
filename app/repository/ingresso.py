from sqlalchemy.orm import Session
from sqlalchemy.exc import IntegrityError
from ..models.ingresso import Ingresso as IngressoModel

class IngressoRepository:
    @staticmethod
    def get_ingresso_by_id(db: Session, ingresso_id: int) -> IngressoModel:
        """
        Retrieve a ticket by its ID from the database.
        """
        return db.query(IngressoModel).filter(IngressoModel.id == ingresso_id).first()

    @staticmethod
    def get_all_ingressos(db: Session) -> list[IngressoModel]:
        """
        Retrieve all movies from the database.
        """
        return db.query(IngressoModel).all()
    
    @staticmethod
    def get_ingressos_by_sessao_id(db: Session, sessao_id: int) -> list[IngressoModel]:
        """
        Retrieve all tickets associated with a specific session ID from the database.
        """
        return db.query(IngressoModel).filter(IngressoModel.sessao_id_FK == sessao_id).all()
    
    @staticmethod
    def get_ingressos_by_cliente_cpf(db: Session, cliente_cpf: str) -> list[IngressoModel]:
        """
        Retrieve all tickets associated with a specific client CPF from the database.
        """
        return db.query(IngressoModel).filter(IngressoModel.cliente_cpf_FK == cliente_cpf).all()

    @staticmethod
    def create_ingresso(db: Session, ingresso: IngressoModel) -> IngressoModel:
        """
        Create a new ticket in the database.
        """
        if IngressoRepository.get_ingresso_by_id(db, ingresso.id):
            raise ValueError(f"ingresso with id {ingresso.id} already exists.")
        else:
            db.add(ingresso)
            try:
                db.commit()
                db.refresh(ingresso)
            except IntegrityError as e:
                db.rollback()
                if "UNIQUE constraint failed" in str(e):
                    raise ValueError("Ticket already exists for this client and session.")
                else:
                    raise ValueError(f"Database constraint violation: {str(e)}")
        return ingresso
    
    @staticmethod
    def update_ingresso(db: Session, ingresso_id: int, updated_ingresso: IngressoModel) -> IngressoModel:
        """
        Update an existing ticket in the database.
        """
        db_ingresso = IngressoRepository.get_ingresso_by_id(db, ingresso_id)
        if not db_ingresso:
            raise ValueError(f"ingresso with id {ingresso_id} not found.")
        
        update_data = updated_ingresso.model_dump(exclude_unset=True)
        
        for key, value in update_data.items():
            setattr(db_ingresso, key, value)
        
        db.commit()
        db.refresh(db_ingresso)
        return db_ingresso
    
    @staticmethod
    def delete_ingresso(db: Session, ingresso_id: int) -> None:
        """
        Delete a ticket from the database.
        """
        db_ingresso = IngressoRepository.get_ingresso_by_id(db, ingresso_id)
        if not db_ingresso:
            raise ValueError(f"ingresso with id {ingresso_id} not found.")
        
        db.delete(db_ingresso)
        db.commit()
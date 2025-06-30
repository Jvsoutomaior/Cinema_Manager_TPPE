from sqlalchemy.orm import Session
from ..models.sessao import Sessao as SessaoModel
from ..models.sessao import DataHorario as DataHorarioModel

class sessaoRepository:
    @staticmethod
    def get_sessao_by_id(db: Session, sessao_id: int) -> SessaoModel:
        """
        Retrieve a session by its ID from the database.
        """
        return db.query(SessaoModel).filter(SessaoModel.id == sessao_id).first()

    @staticmethod
    def get_all_sessaos(db: Session) -> list[SessaoModel]:
        """
        Retrieve all sessions from the database.
        """
        return db.query(SessaoModel).all()

    @staticmethod
    def create_sessao(db: Session, sessao: SessaoModel) -> SessaoModel:
        """
        Create a new session in the database.
        """
        if sessaoRepository.get_sessao_by_id(db, sessao.id):
            raise ValueError(f"sessao with id {sessao.id} already exists.")
        else:
            db.add(sessao)
            db.commit()
            db.refresh(sessao)
        return sessao
    
    @staticmethod
    def update_sessao(db: Session, sessao_id: int, updated_sessao: SessaoModel) -> SessaoModel:
        """
        Update an existing session in the database.
        """
        db_sessao = sessaoRepository.get_sessao_by_id(db, sessao_id)
        if not db_sessao:
            raise ValueError(f"sessao with id {sessao_id} not found.")
        
        update_data = updated_sessao.model_dump(exclude_unset=True)
        
        for key, value in update_data.items():
            setattr(db_sessao, key, value)
        
        db.commit()
        db.refresh(db_sessao)
        return db_sessao
    
    @staticmethod
    def delete_sessao(db: Session, sessao_id: int) -> None:
        """
        Delete a session from the database.
        """
        db_sessao = sessaoRepository.get_sessao_by_id(db, sessao_id)
        if not db_sessao:
            raise ValueError(f"sessao with id {sessao_id} not found.")
        
        db.delete(db_sessao)
        db.commit()

# ======================== DataHorario ========================
class DataHorarioRepository:
    @staticmethod
    def get_DataHorario_by_id(db: Session, DataHorario_id: int) -> DataHorarioModel:
        """
        Retrieve a DataHorario by its ID from the database.
        """
        return db.query(DataHorarioModel).filter(DataHorarioModel.id == DataHorario_id).first()

    @staticmethod
    def get_all_DataHorarios_from_specif_session(db: Session, sessao_id: int) -> list[DataHorarioModel]:
        """
        Retrieve all DataHorarios associated with a specific session from the database.
        """
        sessao = sessaoRepository.get_sessao_by_id(db, sessao_id)
        if not sessao:
            raise ValueError(f"Sessao with id {sessao_id} not found.")
        return db.query(DataHorarioModel).filter(DataHorarioModel.sessao_id == sessao_id).all()

    @staticmethod
    def create_DataHorario_associated_with_session(db: Session, DataHorario: DataHorarioModel, sessao_id: int) -> DataHorarioModel:
        """
        Create a new DataHorario in the database.
        """
        if DataHorarioRepository.get_DataHorario_by_id(db, DataHorario.id):
            raise ValueError(f"DataHorario with id {DataHorario.id} already exists.")
        else:
            DataHorario.sessao_id = sessao_id
            db.add(DataHorario)
            db.commit()
            db.refresh(DataHorario)
        return DataHorario
    
    # @staticmethod
    # def update_DataHorario(db: Session, DataHorario_id: int, updated_DataHorario: DataHorarioModel) -> DataHorarioModel:
    #     """
    #     Update an existing DataHorario in the database.
    #     """
    #     db_DataHorario = DataHorarioRepository.get_DataHorario_by_id(db, DataHorario_id)
    #     if not db_DataHorario:
    #         raise ValueError(f"DataHorario with id {DataHorario_id} not found.")
        
    #     update_data = updated_DataHorario.model_dump(exclude_unset=True)
        
    #     for key, value in update_data.items():
    #         setattr(db_DataHorario, key, value)
        
    #     db.commit()
    #     db.refresh(db_DataHorario)
    #     return db_DataHorario
    
    @staticmethod
    def delete_DataHorario(db: Session, DataHorario_id: int) -> None:
        """
        Delete a DataHorario from the database.
        """
        db_DataHorario = DataHorarioRepository.get_DataHorario_by_id(db, DataHorario_id)
        if not db_DataHorario:
            raise ValueError(f"DataHorario with id {DataHorario_id} not found.")
        
        db.delete(db_DataHorario)
        db.commit()
from fastapi import APIRouter, Depends, HTTPException, status, Response
from sqlalchemy.orm import Session
from typing import List
from ..models.sessao import Sessao as SessaoModel
from ..models.sessao import DataHorario as DataHorarioModel
from ..schemas.sessao import Sessao, SessaoCreate, SessaoUpdate, DataHorario, DataHorarioCreate, DataHorarioUpdate
from ..repository.sessao import sessaoRepository, DataHorarioRepository
from ..database import get_db

router = APIRouter()

# Sessao endpoints
@router.post("/", response_model=Sessao)

def create_sessao(sessao: SessaoCreate, db: Session = Depends(get_db)):
    """ POST endpoint to create a new session. """
    sessao = sessaoRepository.create_sessao(db, SessaoModel(**sessao.model_dump()))
    return sessao

@router.get("/", response_model=List[Sessao])
def read_sessoes(db: Session = Depends(get_db)):
    """ GET endpoint to retrieve all sessions. """
    sessoes = sessaoRepository.get_all_sessaos(db)
    return sessoes

@router.get("/{sessao_id}", response_model=Sessao)
def read_sessao(sessao_id: int, db: Session = Depends(get_db)):
    """ GET session by id endpoint"""
    sessao = sessaoRepository.get_sessao_by_id(db, sessao_id)
    if sessao is None:
        raise HTTPException(status_code=status.HTTP_404_NOT_FOUND, detail="Sessao not found")
    return sessao

@router.put("/{sessao_id}", response_model=Sessao)
def update_sessao(sessao_id: int, sessao: SessaoUpdate, db: Session = Depends(get_db)):
    """ PUT (update) session endpoint"""
    try:
        db_sessao = sessaoRepository.update_sessao(db, sessao_id, sessao)
    except ValueError as e:
        raise HTTPException(status_code=status.HTTP_404_NOT_FOUND, detail=str(e))
    return db_sessao

@router.delete("/{sessao_id}")
def delete_sessao(sessao_id: int, db: Session = Depends(get_db)):
    """Delete session endpoint"""
    try:
        sessaoRepository.delete_sessao(db, sessao_id)
    except ValueError as e:
        raise HTTPException(status_code=status.HTTP_404_NOT_FOUND, detail=str(e))
    return Response(status_code=status.HTTP_200_OK, content=None)


# =========================== DataHorario endpoints ============================
@router.post("/{sessao_id}/datas-horarios/", response_model=DataHorario)
def create_data_horario(sessao_id: int, data_horario: DataHorarioCreate, db: Session = Depends(get_db)):
    """(POST) Endpoint to create a data_horario(date) for especific session """
    try:
        new_data_horario = DataHorarioRepository.create_DataHorario_associated_with_session(db, DataHorarioModel(**data_horario.model_dump()), sessao_id)
    except ValueError as e:
        raise HTTPException(status_code=status.HTTP_404_NOT_FOUND, detail=str(e))
    return new_data_horario


@router.get("/{sessao_id}/datas-horarios/", response_model=List[DataHorario])
def read_datas_horarios(sessao_id: int, db: Session = Depends(get_db)):
    """(GET) Endpoint to retrieve all data_horarios from a specific session"""
    datas_horarios = DataHorarioRepository.get_all_DataHorarios_from_specif_session(db, sessao_id)
    if not datas_horarios:
        raise HTTPException(status_code=status.HTTP_404_NOT_FOUND, detail="No DataHorarios found for this Sessao")
    return datas_horarios

@router.get("/datas-horarios/{data_horario_id}", response_model=DataHorario)
def read_data_horario(data_horario_id: int, db: Session = Depends(get_db)):
    """(GET) Endpoint to retrieve a specific data_horario by its ID"""
    dataHorario = DataHorarioRepository.get_DataHorario_by_id(db, data_horario_id)
    if dataHorario is None:
        raise HTTPException(status_code=status.HTTP_404_NOT_FOUND, detail="DataHorario not found")
    return dataHorario

# @router.put("/datas-horarios/{data_horario_id}", response_model=DataHorario)
# def update_data_horario(data_horario_id: int, data_horario: DataHorarioUpdate, db: Session = Depends(get_db)):
#     """(PUT) Endpoint to update a specific data_horario by its ID"""
#     try:
#         db_data_horario = DataHorarioRepository.update_DataHorario(db, data_horario_id, data_horario)
#     except ValueError as e:
#         raise HTTPException(status_code=status.HTTP_404_NOT_FOUND, detail=str(e))
#     return db_data_horario

@router.delete("/datas-horarios/{data_horario_id}")
def delete_data_horario(data_horario_id: int, db: Session = Depends(get_db)):
    """(DELETE) Endpoint to delete a specific data_horario by its ID"""
    try:
        DataHorarioRepository.delete_DataHorario(db, data_horario_id)
    except ValueError as e:
        raise HTTPException(status_code=status.HTTP_404_NOT_FOUND, detail=str(e))
    return Response(status_code=status.HTTP_200_OK, content=None)
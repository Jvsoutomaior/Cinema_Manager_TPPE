from fastapi import APIRouter, Depends, HTTPException, Response, status
from sqlalchemy.orm import Session
from typing import List
from ..models.ingresso import Ingresso as IngressoModel
from ..schemas import Ingresso, IngressoCreate, IngressoUpdate
from ..database import get_db
from ..repository.ingresso import IngressoRepository

router = APIRouter()

@router.post("/", response_model=Ingresso, status_code=status.HTTP_201_CREATED)
def create_ingresso(request: IngressoCreate, db: Session = Depends(get_db)):
    """ POST endpoint to create a new ticket.    """
    try:
        ingresso = IngressoRepository.create_ingresso(db, IngressoModel(**request.model_dump()))
        return ingresso
    except ValueError as e:
        raise HTTPException(status_code=status.HTTP_400_BAD_REQUEST, detail=str(e))


@router.get("/{ingresso_id}", response_model=Ingresso)
def get_ingresso_by_id(ingresso_id: int, db: Session = Depends(get_db)):
    """ GET endpoint to retrieve a ticket by its ID. """
    db_ingresso = IngressoRepository.get_ingresso_by_id(db, ingresso_id)
    if db_ingresso is None:
        raise HTTPException(status_code=status.HTTP_404_NOT_FOUND, detail="ingresso not found")
    return db_ingresso


@router.get("/", response_model=List[Ingresso])
def get_all_ingressos(db: Session = Depends(get_db)):
    """ GET endpoint to retrieve all tickets. """
    ingressos = IngressoRepository.get_all_ingressos(db)
    return ingressos


@router.put("/{ingresso_id}", response_model=Ingresso)
def update_ingresso(ingresso_id: int, ingresso: IngressoUpdate, db: Session = Depends(get_db)):
    """ PUT endpoint to update an existing ticket. """
    try:
        db_ingresso = IngressoRepository.update_ingresso(db, ingresso_id, ingresso)
    except ValueError as e:
        raise HTTPException(status_code=status.HTTP_404_NOT_FOUND, detail=str(e))
    return db_ingresso

@router.delete("/{ingresso_id}")
def delete_ingresso(ingresso_id: int, db: Session = Depends(get_db)):
    """ DELETE endpoint to delete a ticket by its ID. """
    try:
        IngressoRepository.delete_ingresso(db, ingresso_id)
    except ValueError as e:
        raise HTTPException(status_code=status.HTTP_404_NOT_FOUND, detail=str(e))
    return Response(status_code=status.HTTP_204_NO_CONTENT)

@router.get("/sessao/{sessao_id}", response_model=List[Ingresso])
def get_ingressos_by_sessao_id(sessao_id: int, db: Session = Depends(get_db)):
    """ GET endpoint to retrieve all tickets associated with a specific session ID. """
    ingressos = IngressoRepository.get_ingressos_by_sessao_id(db, sessao_id)
    if not ingressos:
        raise HTTPException(status_code=status.HTTP_404_NOT_FOUND, detail="No ingressos found for this sessao")
    return ingressos

@router.get("/cliente/{cliente_cpf}", response_model=List[Ingresso])
def get_ingressos_by_cliente_cpf(cliente_cpf: str, db: Session = Depends(get_db)):
    """ GET endpoint to retrieve all tickets associated with a specific client CPF. """
    ingressos = IngressoRepository.get_ingressos_by_cliente_cpf(db, cliente_cpf)
    if not ingressos:
        raise HTTPException(status_code=status.HTTP_404_NOT_FOUND, detail="No ingressos found for this cliente")
    return ingressos
from fastapi import APIRouter, Depends, HTTPException
from sqlalchemy.orm import Session
from typing import List
from . import models, schemas
from .database import get_db

router = APIRouter()

# Unidade endpoints
@router.post("/unidades/", response_model=schemas.Unidade)
def create_unidade(unidade: schemas.UnidadeCreate, db: Session = Depends(get_db)):
    db_unidade = models.Unidade(**unidade.model_dump())
    db.add(db_unidade)
    db.commit()
    db.refresh(db_unidade)
    return db_unidade

@router.get("/unidades/", response_model=List[schemas.Unidade])
def read_unidades(skip: int = 0, limit: int = 100, db: Session = Depends(get_db)):
    unidades = db.query(models.Unidade).offset(skip).limit(limit).all()
    return unidades

@router.get("/unidades/{unidade_id}", response_model=schemas.Unidade)
def read_unidade(unidade_id: int, db: Session = Depends(get_db)):
    db_unidade = db.query(models.Unidade).filter(models.Unidade.id == unidade_id).first()
    if db_unidade is None:
        raise HTTPException(status_code=404, detail="Unidade not found")
    return db_unidade

@router.put("/unidades/{unidade_id}", response_model=schemas.Unidade)
def update_unidade(unidade_id: int, unidade: schemas.UnidadeUpdate, db: Session = Depends(get_db)):
    db_unidade = db.query(models.Unidade).filter(models.Unidade.id == unidade_id).first()
    if db_unidade is None:
        raise HTTPException(status_code=404, detail="Unidade not found")
    
    for key, value in unidade.model_dump(exclude_unset=True).items():
        setattr(db_unidade, key, value)
    
    db.commit()
    db.refresh(db_unidade)
    return db_unidade

@router.delete("/unidades/{unidade_id}")
def delete_unidade(unidade_id: int, db: Session = Depends(get_db)):
    db_unidade = db.query(models.Unidade).filter(models.Unidade.id == unidade_id).first()
    if db_unidade is None:
        raise HTTPException(status_code=404, detail="Unidade not found")
    
    db.delete(db_unidade)
    db.commit()
    return {"message": "Unidade deleted successfully"}

# Filme endpoints
@router.post("/filmes/", response_model=schemas.Filme)
def create_filme(filme: schemas.FilmeCreate, db: Session = Depends(get_db)):
    db_filme = models.Filme(**filme.model_dump())
    db.add(db_filme)
    db.commit()
    db.refresh(db_filme)
    return db_filme

@router.get("/filmes/", response_model=List[schemas.Filme])
def read_filmes(skip: int = 0, limit: int = 100, db: Session = Depends(get_db)):
    filmes = db.query(models.Filme).offset(skip).limit(limit).all()
    return filmes

@router.get("/filmes/{filme_id}", response_model=schemas.Filme)
def read_filme(filme_id: int, db: Session = Depends(get_db)):
    db_filme = db.query(models.Filme).filter(models.Filme.id == filme_id).first()
    if db_filme is None:
        raise HTTPException(status_code=404, detail="Filme not found")
    return db_filme

@router.put("/filmes/{filme_id}", response_model=schemas.Filme)
def update_filme(filme_id: int, filme: schemas.FilmeUpdate, db: Session = Depends(get_db)):
    db_filme = db.query(models.Filme).filter(models.Filme.id == filme_id).first()
    if db_filme is None:
        raise HTTPException(status_code=404, detail="Filme not found")
    
    for key, value in filme.model_dump(exclude_unset=True).items():
        setattr(db_filme, key, value)
    
    db.commit()
    db.refresh(db_filme)
    return db_filme

@router.delete("/filmes/{filme_id}")
def delete_filme(filme_id: int, db: Session = Depends(get_db)):
    db_filme = db.query(models.Filme).filter(models.Filme.id == filme_id).first()
    if db_filme is None:
        raise HTTPException(status_code=404, detail="Filme not found")
    
    db.delete(db_filme)
    db.commit()
    return {"message": "Filme deleted successfully"}

# Sessao endpoints
@router.post("/sessoes/", response_model=schemas.Sessao)
def create_sessao(sessao: schemas.SessaoCreate, db: Session = Depends(get_db)):
    db_sessao = models.Sessao(**sessao.model_dump())
    db.add(db_sessao)
    db.commit()
    db.refresh(db_sessao)
    return db_sessao

@router.get("/sessoes/", response_model=List[schemas.Sessao])
def read_sessoes(skip: int = 0, limit: int = 100, db: Session = Depends(get_db)):
    sessoes = db.query(models.Sessao).offset(skip).limit(limit).all()
    return sessoes

@router.get("/sessoes/{sessao_id}", response_model=schemas.Sessao)
def read_sessao(sessao_id: int, db: Session = Depends(get_db)):
    db_sessao = db.query(models.Sessao).filter(models.Sessao.id == sessao_id).first()
    if db_sessao is None:
        raise HTTPException(status_code=404, detail="Sessao not found")
    return db_sessao

@router.put("/sessoes/{sessao_id}", response_model=schemas.Sessao)
def update_sessao(sessao_id: int, sessao: schemas.SessaoUpdate, db: Session = Depends(get_db)):
    db_sessao = db.query(models.Sessao).filter(models.Sessao.id == sessao_id).first()
    if db_sessao is None:
        raise HTTPException(status_code=404, detail="Sessao not found")
    
    for key, value in sessao.model_dump(exclude_unset=True).items():
        setattr(db_sessao, key, value)
    
    db.commit()
    db.refresh(db_sessao)
    return db_sessao

@router.delete("/sessoes/{sessao_id}")
def delete_sessao(sessao_id: int, db: Session = Depends(get_db)):
    db_sessao = db.query(models.Sessao).filter(models.Sessao.id == sessao_id).first()
    if db_sessao is None:
        raise HTTPException(status_code=404, detail="Sessao not found")
    
    db.delete(db_sessao)
    db.commit()
    return {"message": "Sessao deleted successfully"}

# DataHorario endpoints
@router.post("/datas-horarios/", response_model=schemas.DataHorario)
def create_data_horario(data_horario: schemas.DataHorarioCreate, db: Session = Depends(get_db)):
    db_data_horario = models.DataHorario(**data_horario.model_dump())
    db.add(db_data_horario)
    db.commit()
    db.refresh(db_data_horario)
    return db_data_horario

@router.get("/datas-horarios/", response_model=List[schemas.DataHorario])
def read_datas_horarios(skip: int = 0, limit: int = 100, db: Session = Depends(get_db)):
    datas_horarios = db.query(models.DataHorario).offset(skip).limit(limit).all()
    return datas_horarios

@router.get("/datas-horarios/{data_horario_id}", response_model=schemas.DataHorario)
def read_data_horario(data_horario_id: int, db: Session = Depends(get_db)):
    db_data_horario = db.query(models.DataHorario).filter(models.DataHorario.id == data_horario_id).first()
    if db_data_horario is None:
        raise HTTPException(status_code=404, detail="DataHorario not found")
    return db_data_horario

@router.put("/datas-horarios/{data_horario_id}", response_model=schemas.DataHorario)
def update_data_horario(data_horario_id: int, data_horario: schemas.DataHorarioUpdate, db: Session = Depends(get_db)):
    db_data_horario = db.query(models.DataHorario).filter(models.DataHorario.id == data_horario_id).first()
    if db_data_horario is None:
        raise HTTPException(status_code=404, detail="DataHorario not found")
    
    for key, value in data_horario.model_dump(exclude_unset=True).items():
        setattr(db_data_horario, key, value)
    
    db.commit()
    db.refresh(db_data_horario)
    return db_data_horario

@router.delete("/datas-horarios/{data_horario_id}")
def delete_data_horario(data_horario_id: int, db: Session = Depends(get_db)):
    db_data_horario = db.query(models.DataHorario).filter(models.DataHorario.id == data_horario_id).first()
    if db_data_horario is None:
        raise HTTPException(status_code=404, detail="DataHorario not found")
    
    db.delete(db_data_horario)
    db.commit()
    return {"message": "DataHorario deleted successfully"}

# Funcionario endpoints
@router.post("/funcionarios/", response_model=schemas.Funcionario)
def create_funcionario(funcionario: schemas.FuncionarioCreate, db: Session = Depends(get_db)):
    db_funcionario = models.Funcionario(**funcionario.model_dump())
    db.add(db_funcionario)
    db.commit()
    db.refresh(db_funcionario)
    return db_funcionario

@router.get("/funcionarios/", response_model=List[schemas.Funcionario])
def read_funcionarios(skip: int = 0, limit: int = 100, db: Session = Depends(get_db)):
    funcionarios = db.query(models.Funcionario).offset(skip).limit(limit).all()
    return funcionarios

@router.get("/funcionarios/{cpf}", response_model=schemas.Funcionario)
def read_funcionario(cpf: str, db: Session = Depends(get_db)):
    db_funcionario = db.query(models.Funcionario).filter(models.Funcionario.cpf == cpf).first()
    if db_funcionario is None:
        raise HTTPException(status_code=404, detail="Funcionario not found")
    return db_funcionario

@router.put("/funcionarios/{cpf}", response_model=schemas.Funcionario)
def update_funcionario(cpf: str, funcionario: schemas.FuncionarioUpdate, db: Session = Depends(get_db)):
    db_funcionario = db.query(models.Funcionario).filter(models.Funcionario.cpf == cpf).first()
    if db_funcionario is None:
        raise HTTPException(status_code=404, detail="Funcionario not found")
    
    for key, value in funcionario.model_dump(exclude_unset=True).items():
        setattr(db_funcionario, key, value)
    
    db.commit()
    db.refresh(db_funcionario)
    return db_funcionario

@router.delete("/funcionarios/{cpf}")
def delete_funcionario(cpf: str, db: Session = Depends(get_db)):
    db_funcionario = db.query(models.Funcionario).filter(models.Funcionario.cpf == cpf).first()
    if db_funcionario is None:
        raise HTTPException(status_code=404, detail="Funcionario not found")
    
    db.delete(db_funcionario)
    db.commit()
    return {"message": "Funcionario deleted successfully"}

# Cliente endpoints
@router.post("/clientes/", response_model=schemas.Cliente)
def create_cliente(cliente: schemas.ClienteCreate, db: Session = Depends(get_db)):
    db_cliente = models.Cliente(**cliente.model_dump())
    db.add(db_cliente)
    db.commit()
    db.refresh(db_cliente)
    return db_cliente

@router.get("/clientes/", response_model=List[schemas.Cliente])
def read_clientes(skip: int = 0, limit: int = 100, db: Session = Depends(get_db)):
    clientes = db.query(models.Cliente).offset(skip).limit(limit).all()
    return clientes

@router.get("/clientes/{cpf}", response_model=schemas.Cliente)
def read_cliente(cpf: str, db: Session = Depends(get_db)):
    db_cliente = db.query(models.Cliente).filter(models.Cliente.cpf == cpf).first()
    if db_cliente is None:
        raise HTTPException(status_code=404, detail="Cliente not found")
    return db_cliente

@router.put("/clientes/{cpf}", response_model=schemas.Cliente)
def update_cliente(cpf: str, cliente: schemas.ClienteUpdate, db: Session = Depends(get_db)):
    db_cliente = db.query(models.Cliente).filter(models.Cliente.cpf == cpf).first()
    if db_cliente is None:
        raise HTTPException(status_code=404, detail="Cliente not found")
    
    for key, value in cliente.model_dump(exclude_unset=True).items():
        setattr(db_cliente, key, value)
    
    db.commit()
    db.refresh(db_cliente)
    return db_cliente

@router.delete("/clientes/{cpf}")
def delete_cliente(cpf: str, db: Session = Depends(get_db)):
    db_cliente = db.query(models.Cliente).filter(models.Cliente.cpf == cpf).first()
    if db_cliente is None:
        raise HTTPException(status_code=404, detail="Cliente not found")
    
    db.delete(db_cliente)
    db.commit()
    return {"message": "Cliente deleted successfully"} 
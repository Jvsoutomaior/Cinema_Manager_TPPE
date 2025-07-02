from sqlalchemy.orm import Session
from ..models.pessoa import Pessoa as PessoaModel
from ..models.pessoa import Funcionario as FuncionarioModel
from ..models.pessoa import Cliente as ClienteModel

# Clientes
class ClienteRepository:
    @staticmethod
    def get_cliente_by_cpf(db: Session, cliente_cpf: str) -> ClienteModel:
        """
        Retrieve a customer by his/her CPF from the database.
        """
        return db.query(ClienteModel).filter(ClienteModel.cpf == cliente_cpf).first()

    @staticmethod
    def get_all_clientes(db: Session) -> list[ClienteModel]:
        """
        Retrieve all custumers from the database.
        """
        return db.query(ClienteModel).all()

    @staticmethod
    def create_cliente(db: Session, cliente: ClienteModel) -> ClienteModel:
        """
        Create a new customer in the database.
        """
        if ClienteRepository.get_cliente_by_cpf(db, cliente.cpf):
            raise ValueError(f"cliente with cpf {cliente.cpf} already exists.")
        else:
            db.add(cliente)
            db.commit()
            db.refresh(cliente)
        return cliente
    
    @staticmethod
    def update_cliente(db: Session, cliente_cpf: str, updated_cliente: ClienteModel) -> ClienteModel:
        """
        Update an existing customer in the database.
        """
        db_cliente = ClienteRepository.get_cliente_by_cpf(db, cliente_cpf)
        if not db_cliente:
            raise ValueError(f"cliente with cpf {cliente_cpf} not found.")
        
        update_data = updated_cliente.model_dump(exclude_unset=True)
        
        for key, value in update_data.items():
            setattr(db_cliente, key, value)
        
        db.commit()
        db.refresh(db_cliente)
        return db_cliente
    
    @staticmethod
    def delete_cliente(db: Session, cliente_cpf: str) -> None:
        """
        Delete a customer from the database.
        """
        db_cliente = ClienteRepository.get_cliente_by_cpf(db, cliente_cpf)
        if not db_cliente:
            raise ValueError(f"cliente with cpf {cliente_cpf} not found.")
        
        db.delete(db_cliente)
        db.commit()

class FuncionarioRepository:
    @staticmethod
    def get_funcionario_by_cpf(db: Session, funcionario_cpf: str) -> FuncionarioModel:
        """
        Retrieve a employe by his/her CPF from the database.
        """
        return db.query(FuncionarioModel).filter(FuncionarioModel.cpf == funcionario_cpf).first()

    @staticmethod
    def get_all_funcionarios(db: Session) -> list[FuncionarioModel]:
        """
        Retrieve all employes from the database.
        """
        return db.query(FuncionarioModel).all()

    @staticmethod
    def create_funcionario(db: Session, funcionario: FuncionarioModel) -> FuncionarioModel:
        """
        Create a new employe in the database.
        """
        if FuncionarioRepository.get_funcionario_by_cpf(db, funcionario.cpf):
            raise ValueError(f"funcionario with cpf {funcionario.cpf} already exists.")
        else:
            db.add(funcionario)
            db.commit()
            db.refresh(funcionario)
        return funcionario
    
    @staticmethod
    def update_funcionario(db: Session, funcionario_cpf: str, updated_funcionario: FuncionarioModel) -> FuncionarioModel:
        """
        Update an existing employe in the database.
        """
        db_funcionario = FuncionarioRepository.get_funcionario_by_cpf(db, funcionario_cpf)
        if not db_funcionario:
            raise ValueError(f"funcionario with cpf {funcionario_cpf} not found.")
        
        update_data = updated_funcionario.model_dump(exclude_unset=True)
        
        for key, value in update_data.items():
            setattr(db_funcionario, key, value)
        
        db.commit()
        db.refresh(db_funcionario)
        return db_funcionario
    
    @staticmethod
    def delete_funcionario(db: Session, funcionario_cpf: str) -> None:
        """
        Delete a employe from the database.
        """
        db_funcionario = FuncionarioRepository.get_funcionario_by_cpf(db, funcionario_cpf)
        if not db_funcionario:
            raise ValueError(f"funcionario with cpf {funcionario_cpf} not found.")
        
        db.delete(db_funcionario)
        db.commit()
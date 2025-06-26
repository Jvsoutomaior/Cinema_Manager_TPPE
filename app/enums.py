from enum import Enum

class GeneroEnum(str, Enum):
    """Enum for movie genres"""
    ACAO = "Ação"
    AVENTURA = "Aventura"
    COMEDIA = "Comédia"
    DRAMA = "Drama"
    FANTASIA = "Fantasia"
    FICCAO_CIENTIFICA = "Ficção Científica"
    HORROR = "Horror"
    ROMANCE = "Romance"
    THRILLER = "Thriller"
    DOCUMENTARIO = "Documentário"
    ANIMACAO = "Animação"
    MUSICAL = "Musical"
    GUERRA = "Guerra"
    CRIME = "Crime"
    MISTERIO = "Mistério"

class ClassificacaoIndicativaEnum(str, Enum):
    """Enum for age ratings (Brazilian classification system)"""
    LIVRE = "Livre"
    DEZ_ANOS = "10"
    DOZE_ANOS = "12"
    QUATORZE_ANOS = "14"
    DEZESSEIS_ANOS = "16"
    DEZOITO_ANOS = "18"

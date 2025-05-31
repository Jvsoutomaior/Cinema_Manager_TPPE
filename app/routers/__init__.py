from fastapi import APIRouter
from .cinema import router as cinema_router
from .filme import router as filme_router
from .sessao import router as sessao_router
from .pessoa import router as pessoa_router
from .ingresso import router as ingresso_router

router = APIRouter()

router.include_router(cinema_router, prefix="/cinemas", tags=["cinemas"])
router.include_router(filme_router, prefix="/filmes", tags=["filmes"])
router.include_router(sessao_router, prefix="/sessoes", tags=["sessoes"])
router.include_router(pessoa_router, prefix="/pessoas", tags=["pessoas"])
router.include_router(ingresso_router, prefix="/ingressos", tags=["ingressos"]) 
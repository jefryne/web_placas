from fastapi import FastAPI
from pydantic import BaseModel
from fastapi.middleware.cors import CORSMiddleware
from reconocer_form import analyze_general_documents
from base_datos import crear_registro
import asyncio
app = FastAPI()

origins = ["*"]

app.add_middleware(
    CORSMiddleware,
    allow_origins=origins,
    allow_credentials = True,
    allow_methods = ["*"],
    allow_headers = ["*"]
)

class Registro(BaseModel):
    url: str

@app.get("/")
def verRegistros():
    return "registros"

@app.post("/post")
async def crearRegistro(regitsro: Registro):

    repuesta = await analyze_general_documents(regitsro.url)
    registro_guardado = await crear_registro(regitsro.url,repuesta)
    if registro_guardado:
        return repuesta
    return "no se pudo guardar"

@app.put("/post")
def crearRegistro():
    return "hola"

@app.delete("/delete")
def crearRegistro():
    return "hola"
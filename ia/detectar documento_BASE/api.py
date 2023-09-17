from fastapi import FastAPI
from pydantic import BaseModel
from fastapi.middleware.cors import CORSMiddleware

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
    data: str

@app.get("/")
def verRegistros():
    return "registros"

@app.post("/post")
def crearRegistro():
    return "hola"

@app.put("/post")
def crearRegistro():
    return "hola"

@app.delete("/delete")
def crearRegistro():
    return "hola"
import mysql.connector
import asyncio

# Conectar a la base de datos
db = mysql.connector.connect(
    host="localhost",
    user="root",
    password="",
    database="registros_form"
)

cursor = db.cursor()


async def crear_registro(url_pdf,texto):
    query = f"INSERT INTO registros (url_pdf, texto) VALUES ('{url_pdf}', '{texto}')"
    cursor.execute(query)
    db.commit()
    return True

def leer_registros():
    query = "SELECT * FROM usuarios"
    cursor.execute(query)
    resultados = cursor.fetchall()
    for fila in resultados:
        print(f"ID: {fila[0]}, Nombre: {fila[1]}, Edad: {fila[2]}")


def actualizar_registro(id, nueva_edad):
    query = "UPDATE usuarios SET edad = %s WHERE id = %s"
    valores = (nueva_edad, id)
    cursor.execute(query, valores)
    db.commit()

def eliminar_registro(id):
    query = "DELETE FROM usuarios WHERE id = %s"
    valor = (id,)
    cursor.execute(query, valor)
    db.commit()


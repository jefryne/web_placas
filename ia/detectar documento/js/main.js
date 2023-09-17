let boton_enviar = document.getElementById("boton_enviar")
let parrafo = document.getElementById("parrafo")
let pdf_frame = document.getElementById("pdf_frame")

boton_enviar.addEventListener('click',()=>{
    let campo_url = document.getElementById("campo_url").value
    let url = "http://127.0.0.1:8000/post"
    data = {
        "url": campo_url
    }
    fetch(url,{
        method: "POST",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(respuesta => respuesta.json())
    .then(data =>{
        pdf_frame.setAttribute("src",campo_url)
        parrafo.textContent = data
        console.log(data);
    })
    .catch(error =>{
        console.log(error);
    })
})

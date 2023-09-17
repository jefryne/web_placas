url = "http://127.0.0.1:8000/post"
data = {

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
    console.log(data);
})
.catch(error =>{
    console.log(error);
})
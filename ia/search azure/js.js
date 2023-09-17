const searchUrl = "https://search-jeffry.search.windows.net/indexes/indice-cafe/docs?api-version=2023-07-01-Preview&search=sentiment%3A%27negative%27";

fetch(searchUrl)
  .then(response => {
    if (!response.ok) {
      throw new Error(`HTTP error! Status: ${response.status}`);
    }
    return response.json();
  })
  .then(data => {
    console.log("Search results:", data);
    // Aquí puedes manejar los resultados de búsqueda como desees
  })
  .catch(error => {
    console.error("Fetch error:", error);
  });
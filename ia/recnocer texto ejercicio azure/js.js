const key = "14b9d9f34477434a97123717d75a43a4";
const endpoint = "https://lemguaje-jeffry.cognitiveservices.azure.com/";

const txt_file = "review1.txt";
let url = `https://raw.githubusercontent.com/MicrosoftLearning/AI-900-AIFundamentals/main/data/text/reviews/${txt_file}`;

// Language Detection
function detectLanguage(txt) {
  const data = {
    documents: [
      {
        id: '1',
        text: txt
      }
    ]
  };

  fetch(`${endpoint}/text/analytics/v3.1/languages`, {
    method: 'POST',
    headers: {
      'Ocp-Apim-Subscription-Key': key,
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
  })
  .then(response => response.json())
  .then(analysis => {
    const langName = analysis.documents[0].detectedLanguage.name;
    const langCode = analysis.documents[0].detectedLanguage.iso6391Name;
    const langScore = analysis.documents[0].detectedLanguage.confidenceScore;

    console.log(`  - Language: ${langName}\n  - Code: ${langCode}\n  - Score: ${langScore}`);
  })
  .catch(error => {
    console.error("Error:", error);
  });
}

// Rest of the sections (Key Phrases, Sentiment, Known Entities)
// ... (translate and implement the remaining sections similarly)

(async () => {
  try {
    // Obtener el contenido del archivo de texto
    const txtResponse = await fetch(url);
    const txt = await txtResponse.text();

    console.log("***Detecting Language***");
    detectLanguage(txt);

    // Resto de las secciones (Frases clave, Sentimiento, Entidades conocidas)
    // ... (translate and implement the remaining sections similarly)

  } catch (error) {
    console.error("Error:", error);
  }
})();

const key = "14b9d9f34477434a97123717d75a43a4";
const location = "eastus";
const endpoint = "https://api.cognitive.microsofttranslator.com/";

const text = "Hello";

// Code to call Text Analytics service to analyze sentiment in text
const headers = new Headers();
headers.append("Ocp-Apim-Subscription-Key", key);
headers.append("Ocp-Apim-Subscription-Region", location);
headers.append("Content-Type", "application/json");

const body = JSON.stringify([{ text: text }]);

console.log("Translating text...");
fetch(`${endpoint}/translate?api-version=3.0&from=en&to=fr&to=it&to=zh-Hans`, {
    method: "POST",
    headers: headers,
    body: body
})
.then(response => response.json())
.then(analysis => {
    const french = analysis[0].translations[0];
    const italian = analysis[0].translations[1];
    const chinese = analysis[0].translations[2];
    console.log(`Original Text: ${text}\nFrench Translation: ${french.text}\nItalian Translation: ${italian.text}\nChinese Translation: ${chinese.text}\n`);

    // Code to Translate audio to text in another language
    const audioWav = "./data/translation/english.wav";

    const audioHeaders = new Headers();
    audioHeaders.append("Ocp-Apim-Subscription-Key", key);
    audioHeaders.append("Content-Type", "audio/wav");

    console.log("Translating audio...");
    fetch(`https://${location}.stt.speech.microsoft.com/speech/recognition/conversation/cognitiveservices/v1?language=en-US`, {
        method: "POST",
        headers: audioHeaders,
        body: fs.readFileSync(audioWav)
    })
    .then(response => response.json())
    .then(audioResult => {
        const originalAudioText = audioResult.DisplayText;
        console.log(`The audio said '${originalAudioText}'`);

        // Code to call translate audio text to a different language
        const audioTranslateHeaders = new Headers();
        audioTranslateHeaders.append("Ocp-Apim-Subscription-Key", key);
        audioTranslateHeaders.append("Ocp-Apim-Subscription-Region", location);
        audioTranslateHeaders.append("Content-Type", "application/json");

        const audioTranslateBody = JSON.stringify([{ text: originalAudioText }]);

        console.log("Translating text from audio to French...");
        fetch(`${endpoint}/translate?api-version=3.0&from=en&to=fr`, {
            method: "POST",
            headers: audioTranslateHeaders,
            body: audioTranslateBody
        })
        .then(response => response.json())
        .then(audioAnalysis => {
            const frenchTranslation = audioAnalysis[0].translations[0].text;
            console.log(`Translated text: '${frenchTranslation}'`);
        })
        .catch(error => {
            console.error("Error translating audio text:", error);
        });
    })
    .catch(error => {
        console.error("Error translating audio:", error);
    });
})
.catch(error => {
    console.error("Error translating text:", error);
});

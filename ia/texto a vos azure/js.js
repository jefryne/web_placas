const key = "14b9d9f34477434a97123717d75a43a4";
const region = "eastus";

// Code to call Speech to Text API
const wav = "./data/speech/time.wav";

const headers = new Headers();
headers.append("Ocp-Apim-Subscription-Key", key);
headers.append("Content-Type", "audio/wav");

console.log("Analyzing audio...");
fetch(`https://${region}.stt.speech.microsoft.com/speech/recognition/conversation/cognitiveservices/v1?language=en-US`, {
    method: "POST",
    headers: headers,
    body: new Blob([new Uint8Array(/* Load your binary audio data here */)])
})
.then(response => response.json())
.then(analysis => {
    console.log(`\nYou said '${analysis.DisplayText}'`);

    if (analysis.DisplayText === "What time is it?") {
        // Code to call Text to Speech API
        const sml = `
            <speak version='1.0' xml:lang='en-US'>
                <voice xml:lang='en-US' xml:gender='Female' name='en-US-AriaNeural'>
                    It's coding time!
                </voice>
            </speak>`;

        const ttsHeaders = new Headers();
        ttsHeaders.append("Ocp-Apim-Subscription-Key", key);
        ttsHeaders.append("Content-Type", "application/ssml+xml");
        ttsHeaders.append("X-Microsoft-OutputFormat", "audio-16khz-128kbitrate-mono-mp3");

        const outputFile = "output.wav";

        console.log("Synthesizing speech...");
        fetch(`https://${region}.tts.speech.microsoft.com/cognitiveservices/v1`, {
            method: "POST",
            headers: ttsHeaders,
            body: sml
        })
        .then(response => response.blob())
        .then(blob => {
            const reader = new FileReader();
            reader.onload = () => {
                // Save the data from the blob to a file
                const byteArray = new Uint8Array(reader.result);
                // Here, you should use the appropriate method to save the byteArray as a file
                console.log("Response saved in " + outputFile + "\n");
            };
            reader.readAsArrayBuffer(blob);
        })
        .catch(error => {
            console.error("Error synthesizing speech:", error);
        });
    }
})
.catch(error => {
    console.error("Error analyzing audio:", error);
});

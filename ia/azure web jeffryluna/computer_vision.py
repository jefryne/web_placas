import azure.ai.vision as sdk
KEY="955ff4719f214aaa96389e2dec71b70f"
ENPOINT="https://computer-vision-model-jeffry.cognitiveservices.azure.com/"
def reconocerPlaca(url_img):
    service_options = sdk.VisionServiceOptions(ENPOINT,KEY)

    vision_source = sdk.VisionSource(url=url_img)

    analysis_options = sdk.ImageAnalysisOptions()

    analysis_options.features = (
        sdk.ImageAnalysisFeature.TEXT 
    )



    analysis_options.language = "en"


    image_analyzer = sdk.ImageAnalyzer(service_options, vision_source, analysis_options)

    result = image_analyzer.analyze()

    if result.reason == sdk.ImageAnalysisResultReason.ANALYZED:

        if result.text is not None:
            for line in result.text.lines:
                if (len(line.content) == 7 and line.content[3]=="." or line.content[3]=="-" or line.content[3]=="®" or line.content[3]==" "):
                    return line.content

    else:

        return "error url"
    

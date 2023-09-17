from .models import Task
import azure.ai.vision as sdk
import os


def visionPro(last_url,last_id):
        service_options = sdk.VisionServiceOptions(os.environ["VISION_ENDPOINT"],
                                                os.environ["VISION_KEY"])
        vision_source = sdk.VisionSource(
            url=last_url)
        analysis_options = sdk.ImageAnalysisOptions()
        analysis_options.features = (
            sdk.ImageAnalysisFeature.TEXT 
        )

        analysis_options.language = "en"

        analysis_options.gender_neutral_caption = True

        image_analyzer = sdk.ImageAnalyzer(service_options, vision_source, analysis_options)

        result = image_analyzer.analyze()
        palabras=""
        if result.reason == sdk.ImageAnalysisResultReason.ANALYZED:
            for line in result.text.lines:
                palabras+=line.content

            last_task = Task.objects.get(id=last_id)
            last_task.texto = palabras
            last_task.save()


def ultimoUrl():
    last_task = Task.objects.latest('id')
    last_url = last_task.url
    last_id = last_task.id
    return last_url,last_id


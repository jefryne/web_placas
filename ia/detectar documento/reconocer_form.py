# import libraries
import os
from azure.ai.formrecognizer import DocumentAnalysisClient
from azure.core.credentials import AzureKeyCredential
import asyncio

endpoint = "https://reconocimiento-de-voz-jeffry.cognitiveservices.azure.com/"
key = "0b8e32753e1e43ffb5956ee2267d6785"


def format_bounding_region(bounding_regions):
    if not bounding_regions:
        return "N/A"
    return ", ".join("Page #{}: {}".format(region.page_number, format_polygon(region.polygon)) for region in bounding_regions)

def format_polygon(polygon):
    if not polygon:
        return "N/A"
    return ", ".join(["[{}, {}]".format(p.x, p.y) for p in polygon])


async def analyze_general_documents(url):
    # sample document
    docUrl = url

    # create your `DocumentAnalysisClient` instance and `AzureKeyCredential` variable
    document_analysis_client = DocumentAnalysisClient(endpoint=endpoint, credential=AzureKeyCredential(key))

    poller = document_analysis_client.begin_analyze_document_from_url(
            "prebuilt-document", docUrl)
    result = poller.result()

    texto = ""
    for page in result.pages:
        texto += "\n"
        for line_idx, line in enumerate(page.lines):
            texto += line.content    
    return texto     

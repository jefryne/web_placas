import os
import io
import json
from msrest.authentication import CognitiveServicesCredentials
from azure.cognitiveservices.vision.computervision.models import OperationStatusCodes, VisualFeatureTypes
from azure.cognitiveservices.vision.computervision import ComputerVisionClient
import requests # pip install reuest
from PIL import Image, ImageDraw, ImageFont

credential = json.load(open('credential.json'))
API_KEY = credential['API_KEY']
ENDPOINT = credential['ENDPOINT']

cv_client = ComputerVisionClient(ENDPOINT, CognitiveServicesCredentials(API_KEY))

image_url = 'https://i.redd.it/pf440nc480921.jpg'
response = cv_client.read(url=image_url, language='es', raw=True)
operationLocation = response.headers['Operation-Location']




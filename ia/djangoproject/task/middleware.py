from .models import Task
from .newText import visionPro, ultimoUrl

class CustomMiddleware:
    def __init__(self, get_response):
        self.get_response = get_response

    def __call__(self, request):
        if request.method != 'DELETE':
            url,last_id =ultimoUrl()
            visionPro(url,last_id)
        return self.get_response(request)
    
 
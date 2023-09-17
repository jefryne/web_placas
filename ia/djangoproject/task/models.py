from django.db import models

# Create your models here.

class Task(models.Model):
    title = models.CharField(max_length=250)
    url = models.TextField(blank=True)
    texto = models.TextField(default="")

    def __str__(self):
        return self.title
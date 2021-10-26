import requests
import students_pb2

resp = requests.get('http://localhost:8080/api/studenti')

studenti = students_pb2.Studenti()
studenti.ParseFromString(resp.content)

print(studenti)
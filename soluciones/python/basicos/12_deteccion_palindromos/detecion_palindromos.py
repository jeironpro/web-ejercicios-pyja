# Detección de palíndromos
def es_palindroma(palabra: str) -> bool:
    palabra = palabra.lower()
    palabra_invertida = ""

    for i in range(len(palabra)-1, -1, -1):
        palabra_invertida += palabra[i]
    
    if palabra == palabra_invertida:
        return True
    else:
        return False

palindromos = []

palabras = input("Introduce palabras separadas por comas: ")
partes = palabras.split(",")

for palabra in partes:
    if es_palindroma(palabra.strip()):
        palindromos.append(palabra.strip())

print("Palíndromos encontrados:", palindromos)
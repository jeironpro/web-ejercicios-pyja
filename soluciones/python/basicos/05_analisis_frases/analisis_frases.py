# Analisis de frases
frase_mas_corta = None
frase_mas_larga = ""
frase_mas_palabras = ""
frase_mas_vocales = ""

def contador_vocales(frase: str) -> int:
    contador = 0
    vocales = "aeiouAEIOU"

    for vocal in vocales:
        for letra in frase:
            if vocal == letra:
                contador += 1

    return contador

while True:
    frase = input("Introduce una frase (ENTER para salir): ")
    
    if not frase:
        print("Frase más corta:", frase_mas_corta)
        print("Frase más larga:", frase_mas_larga)
        print("Frase con más palabras:", frase_mas_palabras)
        print("Frase con más vocales:", frase_mas_vocales)
        break
    
    palabras = frase.split()

    if frase_mas_corta is None or len(frase) < len(frase_mas_corta):
        frase_mas_corta = frase

    if len(frase) > len(frase_mas_larga):
        frase_mas_larga = frase
    
    if len(palabras) > len(frase_mas_palabras.split()):
        frase_mas_palabras = frase

    if contador_vocales(frase) > contador_vocales(frase_mas_vocales):
        frase_mas_vocales = frase
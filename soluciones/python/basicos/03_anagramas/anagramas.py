# Anagramas

while True:
    entrada = input("Introduce un par de palabras (vacio para salir): ")
    
    if not entrada:
        break

    palabras = entrada.split()

    if len(palabras) == 2:
        """ Desempaquetado de secuencias: Python permite asignar los elementos de una lista, tupla o cualquier iterable a varias variables de una sola vez. """
        palabra1, palabra2 = palabras 
        esAnagrama = True

        for letra in palabra1:
            """ .count(): es un método de las cadenas (str) y de las listas (list) en Python. Sirve para contar cuantas veces aparece un valor dentro de la cadena o la lista. Tambien permite buscar en subcadenas con la siguiente sintaxis .count(subcadena, inicio, fin) """
            if palabra1.count(letra) != palabra2.count(letra):
                esAnagrama = False
                break
            
        if esAnagrama and len(palabra1) == len(palabra2):
            print("Resultado: Son anagramas")
        else:
            print("Resultado: No son anagramas")
    else:
        print("Debes introducir exactamente dos palabras separadas por un espacio")
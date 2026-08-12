# Ordenación por selección

def ordenacion_seleccion(lista: list) -> list:
    longitud = len(lista)
    for i in range(longitud-1):
        minimo = i

        for j in range(i+1, longitud):
            if lista[j] < lista[minimo]:
                minimo = j
            
        if minimo != i:
            lista[i], lista[minimo] = lista[minimo], lista[i]
    
    return lista

entrada = input("Introduce números separados por espacios: ").split()
numeros = [int(n) for n in entrada]

print("Lista ordena:", ordenacion_seleccion(numeros))

# Cifrado escalonado
def cifrar_mensaje(mensaje):
    resultado = []
    contador = 0
    
    for letra in mensaje:
        if not letra.isspace():
            resultado.append(str(ord(letra) + contador))
            contador += 1

    return ' '.join(resultado)

def descifrar_mensaje(cifrado):
    resultado = ""
    contador = 0
    
    for ascii in cifrado.split():
        resultado += str(chr(int(ascii) - contador))
        contador = contador + 1

    return resultado

while True:
    print("--- CIFRADO ESCALONADO ---")
    print("1. Cifrar mensaje")
    print("2. Descifrar mensaje")
    print("3. Salir")

    opcion = int(input("Opción: "))

    if (opcion == 3):
        break

    if (opcion == 1):
        mensaje = input("Introduce el mensaje a cifrar: ")
        print("Mensaje cifrado:", cifrar_mensaje(mensaje))

    if (opcion == 2):
        cifrado = input("Introduce el mensaje original: ")
        print("Mensaje descifrado:", descifrar_mensaje(cifrado))

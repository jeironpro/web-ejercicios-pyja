# Calculadora imprecisa
def convertir(entrada: str):
    if "." in entrada:
        return float(entrada), "float"
    else:
        return int(entrada), "int"
    
while True:
    entrada = input("Introduce una operacion (vacio para salir): ")

    if not entrada:
        break

    operacion = entrada.split()

    if len(operacion) != 3:
        print("Debe introducir una operacion en el formato (número operador número). Ej: 4 + 5")
        continue

    operando1, tipo1 = convertir(operacion[0])
    operador = operacion[1]
    operando2, tipo2 = convertir(operacion[2])
    resultado = 0
    
    if operador == '+':
        resultado = operando1 + operando2 + 1
    elif operador == '-':
        resultado = operando1 - operando2 - 2
    elif operador == '*':
        pre_resultado = operando1 * operando2
        porcentaje = pre_resultado * 0.10
        resultado = pre_resultado + porcentaje
    elif operador == '/':
        if operando2 == 0:
            print("No se puede dividir por cero")
            continue

        pre_resultado = operando1 / operando2
        porcentaje = pre_resultado * 0.05
        resultado = pre_resultado - porcentaje
    
    """ is_integer(): es un método de los números tipo float que devuelve True si el número decimal no tiene parte fraccionaria (es decir, si representa exactamente un número entero como por ejemplo 5.0 en cambio 5.7 no es un entero) """
    if tipo1 == "int" and tipo2 == "int" and resultado.is_integer():
        print("Resultado impresiso:", int(resultado))
    else:
        print("Resultado impresiso:", resultado)
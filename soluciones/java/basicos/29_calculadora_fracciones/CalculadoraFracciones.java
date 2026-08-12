/* Calculadora de fracciones */
public class CalculadoraFracciones {
    public static void main(String[] args) {
        System.out.print("Introduce el primer numerador: ");
        int numerador1 = Integer.parseInt(Entrada.readLine());
        System.out.print("Introduce el primer denominador: ");
        int denominador1 = Integer.parseInt(Entrada.readLine());
        System.out.print("Introduce el segundo numerador: ");
        int numerador2 = Integer.parseInt(Entrada.readLine());
        System.out.print("Introduce el segundo denominador: ");
        int denominador2 = Integer.parseInt(Entrada.readLine());
        System.out.print("Elige la operación (+ - * /): ");
        String operador = Entrada.readLine();

        int resultadoNumerador = 0;
        int resultadoDenominador = 1;

        switch (operador) {
            case "+" -> {
                int mcm = mcm(denominador1, denominador2);
                int num1 = numerador1 * (mcm / denominador1);
                int num2 = numerador2 * (mcm / denominador2);
                resultadoNumerador = num1 + num2;
                resultadoDenominador = mcm;
            }
            case "-" -> {
                int mcm = mcm(denominador1, denominador2);
                int num1 = numerador1 * (mcm / denominador1);
                int num2 = numerador2 * (mcm / denominador2);
                resultadoNumerador = num1 - num2;
                resultadoDenominador = mcm;
            }
            case "*" -> {
                resultadoNumerador = numerador1 * numerador2;
                resultadoDenominador = denominador1 * denominador2;
            }
            case "/" -> {
                if (numerador2 == 0) {
                    System.out.println("Error: no se puede dividir por cero.");
                    return;
                }
                resultadoNumerador = numerador1 * denominador2;
                resultadoDenominador = denominador1 * numerador2;
            }
            default -> {
                System.out.println("Operación no válida.");
                return;
            }
        }

        int mcd = calcularMCD(Math.abs(resultadoNumerador), resultadoDenominador);
        resultadoNumerador /= mcd;
        resultadoDenominador /= mcd;

        System.out.printf("Resultado: %d/%d%n", resultadoNumerador, resultadoDenominador);
    }

    public static int mcm(int a, int b) {
        return (a * b) / calcularMCD(a, b);
    }

    public static int calcularMCD(int a, int b) {
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}
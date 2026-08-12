/* Calculadora factorial */
public class CalculadoraFactorial {
    public static long factorial(int numero) {
        long resultado = 1;

        for (int i = 1; i <= numero; i++) {
            resultado *= i;
        }

        return resultado;
    }

    public static void main(String[] args) {
        int numero;

        while (true) {
            System.out.print("Introduce un número entero no negativo: ");
            numero = Integer.parseInt(Entrada.readLine());

            if (numero > 0) {
                break;
            } else {
                System.out.println("Error. el número debe ser entero y no negativo.");
            }
        }

        long factorial = factorial(numero);
        System.out.printf("Factorial de %d es: %d%n", numero, factorial);
    }
}
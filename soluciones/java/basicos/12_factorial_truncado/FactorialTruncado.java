/* Factorial truncado */
public class FactorialTruncado {
    public static String truncarFactorial(String factorial) {
        String resultadoTruncado = "";

        for (int i = factorial.length()-1; i >= 0; i--) {
            char digito = factorial.charAt(i);

            if (digito != '0' && digito % 2 != 0) {
                resultadoTruncado = factorial.substring(0, i+1);
                break;
            }
        }
        return resultadoTruncado;
    }

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
            System.out.print("Introduce un número entero positivo: ");
            numero = Integer.parseInt(Entrada.readLine());

            if (numero >= 0 && numero <= 12) {
                break;
            } else {
                System.out.println("Error. El numero debe ser entre 0 y 12");
            }
        }

        long factorial = factorial(numero);
        String truncado = truncarFactorial(factorial + "");

        System.out.println("Factorial: " + factorial);
        System.out.println("Factorial truncado: " + truncado);
    }
}
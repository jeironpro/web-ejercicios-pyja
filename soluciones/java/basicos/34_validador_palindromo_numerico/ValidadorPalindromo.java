/* Validador palindromo */
public class ValidadorPalindromo {
    public static void main(String[] args) {
        int invertido = 0;
        int numero;

        while (true) {
            System.out.println("Introduce un valor entero positivo:");
            numero = Integer.parseInt(Entrada.readLine());

            if (numero < 0) {
                continue;
            }

            while (numero > 0) {
                int digito = numero % 10;
                invertido = invertido * 10 + digito;
                numero = numero / 10;
            }
            break;
        }

        if (numero == invertido) {
            System.out.println("El número es palindromo");
        } else {
            System.out.println("El número no es palindromo");
        }
    }
}
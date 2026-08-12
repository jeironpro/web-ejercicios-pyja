/* Divisores primos */
public class DivisoresPrimos {
    public static int raizEntera(int numero) {
        if (numero < 0) {
            return -1;
        }

        int r = 0;
        while ((r * r) <= numero) {
            r++;
        }

        return r - 1;
    }

    public static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }

        int limite = raizEntera(numero);

        for (int i = 2; i <= limite; i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Introduce un número entero positivo:");
        int numero = Integer.parseInt(Entrada.readLine());

        if (numero <= 0) {
            System.out.println("El número debe ser positivo");
            return;
        }

        String divisores = "";

        for (int i = 1; i <= numero; i++) {
            if (numero % i == 0) {
                if (esPrimo(i)) {
                    divisores += i + ", ";
                }
            }
        }

        System.out.printf("Divisores primos únicos: %s%n", divisores.substring(0, divisores.length() - 2));
    }
}
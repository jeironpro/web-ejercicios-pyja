/* Generador de números primos */
public class GeneradorPrimos {
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
        String primos = "";

        for (int i = 0; i <= numero; i++) {
            if (esPrimo(i)) {
                primos += i + " ";
            }
        }

        System.out.printf("Números primos hasta %d: %s%n", numero, primos);
    }
}
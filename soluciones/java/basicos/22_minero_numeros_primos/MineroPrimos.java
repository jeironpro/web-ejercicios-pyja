/* Minero primos */
public class MineroPrimos {
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
        System.out.println("Introduce el número inicial:");
        int inicial = Integer.parseInt(Entrada.readLine());

        System.out.println("Introduce el número inicial:");
        int fin = Integer.parseInt(Entrada.readLine());

        String primos = "";
        int contador = 0;

        for (int i = inicial; i <= fin; i++) {
            if (esPrimo(i)) {
                primos += i + " ";
                contador++;
            }
        }

        System.out.println("Primos encontrados: " + primos);
        System.out.println("Total: " + contador);
    }
}
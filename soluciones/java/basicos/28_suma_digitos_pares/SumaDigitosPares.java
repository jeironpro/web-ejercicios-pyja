/* Suma digitos pares */
public class SumaDigitosPares {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No has introducido ningun número");
            return;
        }

        int suma = 0;

        for (int i = 0; i < args.length; i++) {
            int numero = Integer.parseInt(args[i]);

            if (numero % 2 == 0) {
                suma += numero;
            }
        }

        System.out.println("La suma de los digitos pares es: " + suma);
    }
}
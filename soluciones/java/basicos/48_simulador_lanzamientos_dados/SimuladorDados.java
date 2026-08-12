/* Simulador de lanzamientos de dados */
import java.util.Random;

public class SimuladorDados {
    public static void main(String[] args) {
        int lanzamientos;

        while (true) {
            System.out.println("Introduce el número de lanzamientos:");
            lanzamientos = Integer.parseInt(Entrada.readLine());

            if (lanzamientos > 0) {
                break;
            } else {
                System.out.println("Error. El número de lanzamientos debe ser positivo.");
            }
        }

        int[] conteos = new int[11];
        Random rand = new Random();

        for (int i = 1; i <= lanzamientos; i++) {
            int dado1 = rand.nextInt(6) + 1;
            int dado2 = rand.nextInt(6) + 1;

            int suma = dado1 + dado2;
            conteos[suma - 2]++;
        }

        System.out.println("--- Resultados de los lanzamientos ---");

        for (int suma = 2; suma <= 12; suma++) {
            int frecuencia = conteos[suma - 2];

            System.out.printf("Suma %d: %d %s%n", suma, frecuencia, (frecuencia == 1 ? "vez" : "veces"));
        }
    }
}
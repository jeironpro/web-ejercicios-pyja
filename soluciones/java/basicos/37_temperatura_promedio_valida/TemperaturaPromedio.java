/* Temperatura promedio */
public class TemperaturaPromedio {
    public static void main(String[] args) {
        double suma = 0;
        double contador = 0;

        for (int i = 0; i < args.length; i++) {
            double temperatura = Double.parseDouble(args[i]);

            if (temperatura >= -50 && temperatura <= 60) {
                suma += temperatura;
                contador++;
            }
        }

        double promedio = suma / contador;
        System.out.printf("Promedio de temperaturas válidas: %.1f%n", promedio);
    }
}
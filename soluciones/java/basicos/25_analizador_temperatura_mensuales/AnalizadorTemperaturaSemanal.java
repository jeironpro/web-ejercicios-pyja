/* Analizador de temperatura semanal */
public class AnalizadorTemperaturaSemanal {
    public static void main(String[] args) {
        int[] temperaturas = new int[7];
        int contador = 0;

        while (contador < 7) {
            System.out.printf("Dia %d: ", contador+1);
            int temperatura = Integer.parseInt(Entrada.readLine());
            
            temperaturas[contador] = temperatura;
            contador++;
        }

        int suma = 0;
        int minima = temperaturas[0];
        int maxima = temperaturas[0];
        int diaMinima = 0;
        int diaMaxima = 0;

        for (int i = 0; i < temperaturas.length; i++) {
            int tempe = temperaturas[i];

            if (tempe < minima) {
                minima = tempe;
                diaMinima = i + 1;
            }

            if (tempe > maxima) {
                maxima = tempe;
                diaMaxima = i + 1;
            }

            suma += tempe;
        }

        float media = (float) suma / temperaturas.length;

        System.out.printf("Temperatura media: %.1f%n", media);
        System.out.printf("Temperatura mínima: %.1f en día %d%n", (float) minima, diaMinima);
        System.out.printf("Temperatura máxima: %.1f en día %d%n", (float) maxima, diaMaxima);
    }
}
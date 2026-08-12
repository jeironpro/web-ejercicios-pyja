/* Palabra mas larga */
public class PalabraMasLarga {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No se ha introducido ninguna palabra");
            return;
        }

        String palabrasMasLarga = "";

        for (int i = 0; i < args.length; i++) {
            String frase = args[i]
                    .replaceAll("(?<=\\p{L})-(?=\\p{L})", " ")
                    .replaceAll("[.,;:!?-]+", "");

            String[] palabras = frase.split(" ");

            for (int j = 0; j < palabras.length; j++) {
                if (palabras[j].length() > palabrasMasLarga.length()) {
                    palabrasMasLarga = palabras[j];
                }
            }
        }
        System.out.printf("Palabras más larga: %s (%d %s)%n", palabrasMasLarga, palabrasMasLarga.length(), (palabrasMasLarga.length() == 1) ? "letra" : "letras");
    }
}
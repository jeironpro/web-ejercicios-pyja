/* Contador de vocales y consontantes con porcentaje */
public class ContadorVocalesConsonantes {
    public static boolean esVocal(char caracter) {
        caracter = Character.toLowerCase(caracter);

        switch (caracter) {
            case 'a' -> {
                return true;
            }
            case 'e' -> {
                return true;
            }
            case 'i' -> {
                return true;
            }
            case 'o' -> {
                return true;
            }
            case 'u' -> {
                return true;
            }
            default -> {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Frase?");
        String frase = Entrada.readLine();

        int contadorVocales = 0;
        int contadorConsonantes = 0;

        for (int i = 0; i < frase.length(); i++) {
            char c = frase.charAt(i);

            if (esVocal(c)) {
                contadorVocales++;
            } else if (Character.isLetter(c)) {
                contadorConsonantes++;
            }
        }

        int longitud = contadorVocales + contadorConsonantes;
        float porcentajeVocales = ((float) contadorVocales / longitud) * 100;
        float porcentajeConsonantes = ((float) contadorConsonantes / longitud) * 100;

        System.out.printf("Vocales: %d (%.2f)%n", contadorVocales, porcentajeVocales);
        System.out.printf("Consonantes: %d (%.2f)%n", contadorConsonantes, porcentajeConsonantes);
    }
}
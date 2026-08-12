/* Contador letras */
public class ContadorLetras {
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
        System.out.println("Introduce una frase:");
        String frase = Entrada.readLine().toLowerCase();

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

        System.out.println("Vocales: " + contadorVocales);
        System.out.println("Consonantes: " + contadorConsonantes);
    }
}
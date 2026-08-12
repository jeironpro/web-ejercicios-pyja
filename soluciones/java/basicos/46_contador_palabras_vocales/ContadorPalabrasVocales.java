/* Contador de palabras y vocales */
public class ContadorPalabrasVocales {
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
    
    public static String limpiarPalabra(String palabra) {
        String resultado = "";

        for (int i = 0; i < palabra.length(); i++) {
            char c = palabra.charAt(i);

            if (Character.isLetter(c)) {
                resultado += c;
            }
        }
        return resultado;
    }

    public static void main(String[] args) {
        System.out.println("Frase?");
        String frase = Entrada.readLine();

        String[] palabras = frase.split(" ");
        int contadorVocales = 0;

        for (int i = 0; i < palabras.length; i++) {
            String palabra = limpiarPalabra(palabras[i]);

            for (int j = 0; j < palabra.length(); j++) {
                char c = palabra.charAt(j);

                if (esVocal(c)) {
                    contadorVocales++;
                }
            }
        }

        System.out.println("Número de palabras: " + palabras.length);
        System.out.println("Número total de vocales: " + contadorVocales);
    }
}
/* Contador palindromos */
public class ContadorPalindromos {
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
    
    public static boolean esPalindroma(String palabra) {
        String palabraInvertida = "";

        for (int i = palabra.length() - 1; i >= 0; i--) {
            char c = palabra.charAt(i);
            palabraInvertida += c;
        }

        return palabra.equals(palabraInvertida);
    }

    public static void main(String[] args) {
        System.out.println("Introduce una frase?");
        String frase = Entrada.readLine();

        String[] palabras = frase.split(" ");
        int contador = 0;

        for (int i = 0; i < palabras.length; i++) {
            String palabraLimpia = limpiarPalabra(palabras[i]).toLowerCase();

            if (esPalindroma(palabraLimpia)) {
                contador++;
            }
        }

        System.out.println("Palíndromos encontrados: " + contador);
    }
}
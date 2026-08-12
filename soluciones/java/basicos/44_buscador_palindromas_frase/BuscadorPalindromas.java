/* Buscador de palíndromas en frase */
import java.util.List;
import java.util.ArrayList;

public class BuscadorPalindromas {
    public static List<String> ordenamientoSeleccion(List<String> palabras) {
        int longitud = palabras.size();

        for (int i = 0; i <= longitud-2; i++) {
            int indice = i;

            for (int j = i+1; j <= longitud-1; j++) {
                if (palabras.get(j).compareTo(palabras.get(indice)) < 0) {
                    indice = j;
                }
            }

            if (indice != i) {
                String tmp = palabras.get(i);
                palabras.set(i, palabras.get(indice));
                palabras.set(indice, tmp);
            }
        }

        return palabras;
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
        List<String> palindromas = new ArrayList<>();

        System.out.println("Texto?");
        String texto = Entrada.readLine().toLowerCase();

        String[] palabras = texto.split(" ");

        for (int i = 0; i < palabras.length; i++) {
            String palabra = palabras[i];

            if (palabra.length() >= 3 && esPalindroma(palabra)) {
                boolean yaExiste = false;
                
                for (int j = 0; j < palindromas.size(); j++) {
                    if (palindromas.get(j).equals(palabra)) {
                        yaExiste = true;
                        break;
                    }
                }

                if (!yaExiste) {
                    palindromas.add(palabra);
                }
            }
        }

        palindromas = ordenamientoSeleccion(palindromas);

        System.out.print("Palíndromas: ");
        for (int i = 0; i < palindromas.size(); i++) {
            if (i < palindromas.size()-1) {
                System.out.print(palindromas.get(i) + ", ");
            } else {
                System.out.println(palindromas.get(i));
            }
        }
    }
}
/* Contador palabras únicas */
import java.util.List;
import java.util.ArrayList;

public class ContadorPalabrasUnicas {
    public static String limpiaPalabra(String palabra) {
        String resultado = "";

        for (int i = 0; i < palabra.length(); i++) {
            char c = palabra.charAt(i);

            if (Character.isLetter(c)) {
                resultado += c;
            }
        }
        return resultado;
    }

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

    public static void main(String[] args) {
        List<String> palabrasUnicas = new ArrayList<>();

        while (true) {
            System.out.println("Introduce una frase:");
            String frase = Entrada.readLine().toLowerCase();

            if (frase.isBlank()) {
                break;
            }

            String[] palabras = frase.split(" ");

            for (String palabra: palabras) {
                String palabraLimpia = limpiaPalabra(palabra);

                if (!palabrasUnicas.contains(palabraLimpia)) {
                    palabrasUnicas.add(palabraLimpia);
                }
            }
        }

        System.out.println("Número de palabras únicas: " + palabrasUnicas.size());

        System.out.print("Palabras únicas: ");
        palabrasUnicas = ordenamientoSeleccion(palabrasUnicas);

        for (int i = 0; i < palabrasUnicas.size(); i++) {
            if (i < palabrasUnicas.size()-1) {
                System.out.print(palabrasUnicas.get(i) + ", ");
            } else {
                System.out.print(palabrasUnicas.get(i));
            }
        }
        System.out.println();
    }
}
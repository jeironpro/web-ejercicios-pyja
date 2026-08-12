/* Frecuencia de caracteres */
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class FrecuenciaCaracteres {
    public static List<Character> ordenamientoSeleccion(List<Character> caracteres) {
        int longitud = caracteres.size();

        for (int i = 0; i <= longitud-2; i++) {
            int indice = i;

            for (int j = i+1; j <= longitud-1; j++) {
                if (caracteres.get(j).compareTo(caracteres.get(indice)) < 0) {
                    indice = j;
                }
            }

            if (indice != i) {
                char tmp = caracteres.get(i);
                caracteres.set(i, caracteres.get(indice));
                caracteres.set(indice, tmp);
            }
        }

        return caracteres;
    }

    public static void main(String[] args) {
        Map<Character, Integer> caracteres = new HashMap<>();

        System.out.println("Texto?");
        String texto = Entrada.readLine().toLowerCase();

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);

            if (caracteres.get(c) == null) {
                caracteres.put(c, 0);
            }
            caracteres.put(c, caracteres.get(c) + 1);
        }

        List<Character> listaCaracteres = new ArrayList<>(caracteres.keySet());
        List<Character> listaOrdenada = ordenamientoSeleccion(listaCaracteres);

        for (char c : listaOrdenada) {
            System.out.printf("%c -> %d%n", c, caracteres.get(c));
        }
    }
}
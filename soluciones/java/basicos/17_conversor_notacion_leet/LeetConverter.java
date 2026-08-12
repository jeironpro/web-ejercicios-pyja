/* Leet converter */
public class LeetConverter {
    public static void main(String[] args) {
        System.out.println("Introduce la frase:");
        String frase = Entrada.readLine();

        if (frase.isBlank()) {
            System.out.println("No hay nada para convertir");
            return;
        }

        String letras = "aeiost";
        String reemplazo = "431057";
        String conversion = "";

        for (int i = 0; i < frase.length(); i++) {
            boolean cambio = false;
            char c = frase.charAt(i);

            for (int j = 0; j < letras.length(); j++) {
                char l = letras.charAt(j);

                if (Character.toLowerCase(c) == l) {
                    conversion += reemplazo.charAt(j);
                    cambio = true;
                }
            }

            if (!cambio) {
                conversion += c;
            }
        }

        System.out.println("Resultado: " + conversion);
    }
}
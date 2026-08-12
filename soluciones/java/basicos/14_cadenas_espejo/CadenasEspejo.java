/* Cadenas espejo */
public class CadenasEspejo {
    public static void main(String[] args) {
        System.out.println("Ingrese la primera palabra:");
        String palabra1 = Entrada.readLine().toLowerCase();

        System.out.println("Ingrese la segunda palabra:");
        String palabra2 = Entrada.readLine().toLowerCase();

        boolean esEspejo = false;

        if (palabra1.equals(palabra2)) {
            esEspejo = true;
        }

        if (palabra1.length() != palabra2.length()) {
            esEspejo = false;
        }

        int indiceInverso = palabra2.length() - 1;

        for (int i = 0; i < palabra1.length(); i++) {
            char p1 = palabra1.charAt(i);
            char p2 = palabra2.charAt(indiceInverso);

            if (indiceInverso >= 0) {
                if (p1 == p2) {
                    esEspejo = true;
                } else {
                    esEspejo = false;
                    break;
                }
                indiceInverso--;
            }
        }

        System.out.print("Resultado: ");
        if (esEspejo) {
            System.out.println("Son palabras espejo");
        } else {
            System.out.println("No son palabras espejo");
        }
    }
}
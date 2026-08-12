/* Clave intercalada */
public class ClaveIntercalada {
    public static void main(String[] args) {
        System.out.println("Introduce la primera palabra:");
        String palabra1 = Entrada.readLine();

        System.out.println("Introduce la segunda palabra:");
        String palabra2 = Entrada.readLine();

        if (palabra1.length() != palabra2.length()) {
            System.out.println("Las palabras no tienen la misma longitud");
            return;
        }

        String claveIntercalada = "";

        int i = 0;
        int j = 0;

        while (i < palabra1.length() || j < palabra2.length()) {
            if (i < palabra1.length()) {
                claveIntercalada += palabra1.charAt(i);
                i++;
            }

            if (j < palabra2.length()) {
                claveIntercalada += palabra2.charAt(j);
                j++;
            }

            if (j < palabra2.length()) {
                claveIntercalada += palabra2.charAt(j);
                j++;
            }

            if (i < palabra1.length()) {
                claveIntercalada += palabra1.charAt(i);
                i++;
            }
        }
        System.out.println("Resultado: " + claveIntercalada);
    }
}
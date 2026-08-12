/* Silabas abiertas */
public class SilabasAbiertas {
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
        System.out.println("Palabra?");
        String palabra = Entrada.readLine();
        palabra = palabra.toLowerCase();

        String par = "";
        String resultado = "";
        int contador = 0;
        int totalSilabasAbiertas = 0;
        
        while (contador < palabra.length()) {
            if (contador < palabra.length()) {
                par += palabra.substring(contador, contador+2);
            }

            if (esVocal(par.charAt(1))) {
                resultado += par + ", ";
                totalSilabasAbiertas++;
            }
            par = "";
            contador += 2;
        }
        String silabasAbiertas = resultado.substring(0, resultado.length()-2);

        System.out.printf("Silabas abiertas: %d (%s)%n", totalSilabasAbiertas, silabasAbiertas);
    }
}
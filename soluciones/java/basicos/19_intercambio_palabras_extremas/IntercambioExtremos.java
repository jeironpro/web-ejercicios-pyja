/* Intercambio de palabras extremos */
public class IntercambioExtremos {
    public static void main(String[] args) {
        System.out.println("Introduce la frase?");
        String frase = Entrada.readLine();

        String[] partes = frase.split(" ");
        String resultado = "";

        resultado += partes[partes.length - 1] + " ";
        for (int i = 1; i < partes.length - 1; i++) {
            resultado += partes[i] + " ";
        }
        resultado += partes[0];

        System.out.println(resultado);
    }
}
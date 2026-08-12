/* Eco infinito */
public class EcoInfinito {
    public static void main(String[] args) {
        System.out.println("Texto?");
        String texto = Entrada.readLine();

        String[] partes = texto.split(" ");

        String eco = partes[0] + " ";
        for (int i = 1; i < partes.length; i++) {
            eco += (partes[i] + " ").repeat(i+1);
        }

        System.out.println(eco);
    }
}
/* Conversor de divisas */
public class ConversorDivisas {
    public static void main(String[] args) {
        System.out.println("Introduce la cantidad en euros:");
        float cantidad = Integer.parseInt(Entrada.readLine());

        float tasa = 1.08f;

        float cambio = cantidad * tasa;

        System.out.printf("%.2f EUR equivalen a %.2f USD%n", cantidad, cambio);
    }
}
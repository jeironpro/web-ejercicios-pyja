/* Simulador Cambio de moneda */
public class SimuladorCambio {
    public static void main(String[] args) {
        System.out.println("Introduce una cantidad en euros: ");
        float cantidadEuros = Float.parseFloat(Entrada.readLine());

        int cantidadCentimos = Math.round(cantidadEuros * 100); // Redondea correctamente

        int[] monedas = {200, 100, 50, 20, 10, 5, 2, 1};

        for (int moneda : monedas) {
            int cantidad = cantidadCentimos / moneda;
            cantidadCentimos = cantidadCentimos % moneda;

            if (cantidad > 0) {
                String valorMoneda;
                if (moneda >= 100) {
                    valorMoneda = (moneda / 100) + " €";
                } else {
                    valorMoneda = moneda + ((moneda == 1) ? " céntimo" : " céntimos");
                }

                if (cantidad == 1) {
                    System.out.printf("1 moneda de %s%n", valorMoneda);
                } else {
                    System.out.printf("%d monedas de %s%n", cantidad, valorMoneda);
                }
            }
        }
    }
}
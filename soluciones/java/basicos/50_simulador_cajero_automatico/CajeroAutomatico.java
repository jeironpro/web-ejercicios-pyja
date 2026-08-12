/* Cajero automático */
public class CajeroAutomatico {
    public static void main(String[] args) {
        float saldo = 1000.0f;
        System.out.println("Saldo inicial: 1000.0 €");

        while (true) {
            System.out.println("--- CAJERO AUTOMÁTICO ---");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Ingresar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Salir");
            System.out.print("Elige la opción: ");
            int opcion = Integer.parseInt(Entrada.readLine());

            if (opcion == 4) {
                System.out.println("Saliendo del cajero automático...");
                break;
            }

            switch (opcion) {
                case 1 -> {
                    System.out.printf("Saldo actual: %.2f €%n", saldo);
                }
                case 2 -> {
                    System.out.println("Introduce cantidad a ingresar: ");
                    float cantidad = Float.parseFloat(Entrada.readLine());

                    if (cantidad > 0) {
                        saldo += cantidad;
                        System.out.printf("Dinero ingresado. Saldo actual: %.2f €%n", saldo);
                    } else {
                        System.out.println("La cantidad debe ser positiva.");
                    }
                }
                case 3 -> {
                    System.out.println("Introduce cantidad a retirar: ");
                    float cantidad = Float.parseFloat(Entrada.readLine());

                    if (cantidad < 0) {
                        System.out.println("La cantidad debe ser positiva.");
                    } else if (cantidad > saldo) {
                        System.out.println("¡Error! Saldo insuficiente.");
                    } else {
                        saldo -= cantidad;
                        System.out.printf("Dinero retirado. Saldo actual: %.2f €%n", saldo);
                    }
                }
                default -> {
                    System.out.println("Opción no válida");
                }
            }
        }
    }
}
/* Simulador de cola */
import java.util.List;
import java.util.ArrayList;

public class SimuladorCola {
    public static void main(String[] args) {
        List<Integer> tickets = new ArrayList<>();
        int contadorTicket = 0;

        System.out.println("--- Simulador de cola de clientes ---");

        while (true) {
            System.out.println("1. Añadir cliente");
            System.out.println("2. Atender cliente");
            System.out.println("3. Mostrar cola");
            System.out.println("4. Salir");
            System.out.print("Opción: ");
            int opcion = Integer.parseInt(Entrada.readLine());

            if (opcion == 4) {
                System.out.println("Fin del simulador...");
                break;
            }

            switch (opcion) {
                case 1 -> {
                    tickets.add(contadorTicket++);
                    System.out.printf("Cliente con ticket %d añadido a la cola.%n", contadorTicket);
                }
                case 2 -> {
                    tickets.remove(0);
                    System.out.printf("Cliente con ticket %d atendido.%n", tickets.get(0));
                }
                case 3 -> {
                    for (int i = 0; i < tickets.size(); i++) {
                        if (i < tickets.size() -1) {
                            System.out.printf("%d ", tickets.get(i));
                        } else {
                            System.out.printf("%d%n", tickets.get(i));
                        }
                    }
                }
                default -> {
                    System.out.println("Opción no válida");
                }
            }
        }
    }
}
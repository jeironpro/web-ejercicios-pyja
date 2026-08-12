/* Tabla del clima semanal */

public class TablaClimaSemanal {
    public static void main(String[] args) {
        String[] dias = {
            "Lunes",
            "Martes",
            "Miercoles",
            "Jueves",
            "Viernes",
            "Sabado",
            "Domingo"
        };

        int[] temperaturas = new int[7]; 

        for (int i = 0; i < dias.length; i++) {
            System.out.println("Introduce la temperatura del " + dias[i]);
            String temperatura = Entrada.readLine();

            
            if (temperatura.isBlank()) {
                continue;
            } else if (Integer.parseInt(temperatura) < -50 && Integer.parseInt(temperatura) > 50) {
                continue;
            }

            temperaturas[i] = Integer.parseInt(temperatura);
        }

        System.out.println("Día         Temperatura");
        for (int i = 0; i < dias.length; i++) {

            if (temperaturas[i] == 0) {
                System.out.printf("%-9s   s/n%n", dias[i]);
            } else {
                System.out.printf("%-9s   %d%n", dias[i], temperaturas[i]);
            }
        }
    }
}
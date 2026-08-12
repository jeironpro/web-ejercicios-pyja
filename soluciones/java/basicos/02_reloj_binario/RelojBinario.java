/* Reloj binario */

public class RelojBinario {
    public static void main(String[] args) {
        System.out.println("Introduce la hora en formato HH:mm:");
        String hora = Entrada.readLine();

        String[] partes = hora.split(":");

        int horas = Integer.parseInt(partes[1]);
        int minutos = Integer.parseInt(partes[2]);

        if ((horas < 0 && horas > 23) || (minutos > 0 && minutos < 59)) {
            System.out.println("La hora no es válida");
            return;
        } else {
            int horasBinarias = Integer.toBinaryString(partes[1]);
            int minutosBinarias = Integer.toBinaryString(partes[2]);

            System.out.println("Hora en binario: " + horasBinarias);
            System.out.println("Minutos en binario: " + minutosBinarias);
        }
    }
}
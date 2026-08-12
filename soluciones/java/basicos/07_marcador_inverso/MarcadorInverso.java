/* Marcador inverso */
public class MarcadorInverso {
    public static void main(String[] args) {
        System.out.println("Introduce el marcador (invertido):");
        String marcador = Entrada.readLine();

        if (marcador.length() < 3 || !marcador.contains("-")) {
            System.out.println("Marcador no válido");
            return;
        }

        String[] partes = marcador.split("-");
        String b = partes[0];
        String a = partes[1];

        if (!Character.isDigit(a.charAt(0)) || !Character.isDigit(b.charAt(0))) {
            System.out.println("Valores no válido para un marcador");
            return;
        }

        int valorA = Integer.parseInt(a);
        int valorB = Integer.parseInt(b);

        System.out.printf("Marcador real: %d-%d%n", valorA, valorB);
        System.out.print("Resultado: ");
        if (valorA > valorB) {
            System.out.println("Gana el equipo A");
        } else if (valorA < valorB) {
            System.out.println("Gana el equipo B");
        } else {
            System.out.println("Es un empate");
        }
    }
}
/* Suma piramidal */
public class SumaPiramidal {
    public static void main(String[] args) {
        System.out.println("Introduce un número?");
        int numero = Integer.parseInt(Entrada.readLine());

        int suma = 0;

        for (int i = 1; i <= numero; i++) {
            suma += i;
            for (int j = 1; j <= i; j++) {
                if (j < i) {
                    System.out.print(j + " + ");
                } else {
                    System.out.println(j);
                }
            }
        }
        System.out.println("Suma piramidal: " + suma);
    }
}
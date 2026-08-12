/* Verificador de par o impar */
public class VerificadorParImpar {
    public static void main(String[] args) {
        System.out.println("Introduce un numero:");
        int numero = Integer.parseInt(Entrada.readLine());

        System.out.printf("El número %d es %s%n", numero, (numero % 2 == 0) ? "par" : "impar");
    }
}
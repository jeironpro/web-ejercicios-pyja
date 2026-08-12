/* Adivina número */
public class AdivinaNumero {
    public static void main(String[] args) {
        int numeroAdivinar = (int) (Math.random() * 100) + 1;
        System.out.println("Adivina el número entre 1 y 100");

        int contador = 0;

        while (true) {
            System.out.println("Introduce tu intento:");
            int numero = Integer.parseInt(Entrada.readLine());
            
            if (numero < 1) {
                System.out.println("Como mínimo 1");
            } else if (numero > 100) {
                System.out.println("Como máximo 100");
            } else if (numero > numeroAdivinar) {
                System.out.println("El número es menor");
            } else if (numero < numeroAdivinar) {
                System.out.println("El número es mayor");
            } else {
                break;
            }
            contador++;
        }

        System.out.printf("¡Correcto! Lo has acertado en %d intentos%n", contador);
    }
}
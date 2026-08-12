/* Matriz fantasma */
public class MatrizFantasma {
    public static boolean esFantasma(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Introduce el tamaño de la matriz (mínimo 3):");
        int tamano = Integer.parseInt(Entrada.readLine());
        int[][] matriz = new int[tamano][tamano];

        String fila;
        for (int i = 0; i < tamano; i++) {
            System.out.printf("Fila %d (valores separados por espacios): ", i + 1);
            fila = Entrada.readLine();

            String[] valoresFila = fila.split(" ");

            for (int j = 0; j < valoresFila.length; j++) {
                int valor = Integer.parseInt(valoresFila[j]);

                matriz[i][j] = valor;
            }
        }

        System.out.print("Resultado: ");
        if (esFantasma(matriz)) {
            System.out.println("La matriz es fantasma");
        } else {
            System.out.println("La matriz no es fantasma");
        }
    }
}
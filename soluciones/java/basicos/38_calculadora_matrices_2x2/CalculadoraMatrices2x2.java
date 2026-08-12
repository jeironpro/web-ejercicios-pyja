/* Calculadora matrices 2x2 */
public class CalculadoraMatrices2x2 {
    public static int[][] sumarMatricesCuadrada(int[][] matrizA, int[][] matrizB) {
        int[][] matrizResultado = new int[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matrizResultado[i][j] = matrizA[i][j] + matrizB[i][j];
            }   
        }
        return matrizResultado;
    }

    public static int[][] restarMatricesCuadrada(int[][] matrizA, int[][] matrizB) {
        int[][] matrizResultado = new int[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matrizResultado[i][j] = matrizA[i][j] - matrizB[i][j];
            }   
        }
        return matrizResultado;
    }

    public static int[][] multiplicarMatricesCuadrada(int[][] matrizA, int[][] matrizB) {
        int[][] matrizResultado = new int[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matrizResultado[i][j] = matrizA[i][j] * matrizB[i][j];
            }   
        }
        return matrizResultado;
    }

    public static void mostrarMatriz(int[][] matriz) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrizA = new int[2][2];
        int[][] matrizB = new int[2][2];

        System.out.println("Introduce los valores de la matriz A separados por espacio (4 números):");
        String[] numerosA = Entrada.readLine().split(" ");
        
        if (numerosA.length != 4) {
            System.out.println("La matriz A debe tener 4 elementos");
            return;
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matrizA[i][j] = Integer.parseInt(numerosA[i*2 + j]);
            }   
        }

        System.out.println("Introduce los valores de la matriz B separados por espacio (4 números):");
        String[] numerosB = Entrada.readLine().split(" ");

        if (numerosB.length != 4) {
            System.out.println("La matriz B debe tener 4 elementos");
            return;
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matrizB[i][j] = Integer.parseInt(numerosB[i*2 + j]);
            }   
        }

        int opcion;
        do {
            System.out.println("\nOpciones");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicación");
            System.out.println("4. Salir");
            opcion = Integer.parseInt(Entrada.readLine());

            switch (opcion) {
                case 1 -> {
                    System.out.println("Resultado de la suma:");
                    mostrarMatriz(sumarMatricesCuadrada(matrizA, matrizB));
                    break;
                }
                case 2 -> {
                    System.out.println("Resultado de la suma:");
                    mostrarMatriz(restarMatricesCuadrada(matrizA, matrizB));
                    break;
                }
                case 3 -> {
                    System.out.println("Resultado de la multiplicación:");
                    mostrarMatriz(multiplicarMatricesCuadrada(matrizA, matrizB));
                    break;
                }
                case 4 -> {
                    System.out.println("Saliendo del programa...");
                }
                default -> {
                    System.out.println("Opción no válida");
                }
            }
        } while (opcion != 4);
    }
}
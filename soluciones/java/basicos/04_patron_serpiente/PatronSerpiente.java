/* Patron Serpiente */

public class PatronSerpiente {
    public static void main(String[] args) {
        System.out.println("Introduce el tamaño de la serpiente: ");
        int tamano = Integer.parseInt(Entrada.readLine());

        int[][] matriz = new int[tamano][tamano];

        int valores = 1;
        for (int i = 0; i < tamano; i++) {
            for (int j = 0; j < tamano; j++) {
                matriz[i][j] = valores;
                valores++;
            }
        }  

        for (int i = 0; i < matriz.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < matriz.length; j++) {
                    System.out.printf("%4d ", matriz[i][j]);
                }
            } else {
                for (int j = matriz.length - 1; j >= 0; j--) {
                    System.out.printf("%4d ", matriz[i][j]);
                }
            }
            System.out.println();
        } 
    }
}
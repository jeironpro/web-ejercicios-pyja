/* Inversor lista números */
public class InversorListaNumeros {
    public static void main(String[] args) {
        System.out.println("Introduce lista de números separados por espacios:");
        String[] valores = Entrada.readLine().split(" ");

        int[] numeros = new int[valores.length];

        for (int i = 0; i < valores.length; i++) {
            int valor = Integer.parseInt(valores[i]);

            numeros[i] = valor;
        }

        System.out.print("Lista invertida: ");
        for (int i = numeros.length-1; i >= 0; i--) {
            if (i == 0) {
                System.out.println(numeros[i]);
            } else {
                System.out.print(numeros[i] + " ");
            }
        }
    }
}
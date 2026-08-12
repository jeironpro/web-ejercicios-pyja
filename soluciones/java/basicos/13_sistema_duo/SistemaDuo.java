/* Sistema duo */
public class SistemaDuo {
    public static void main(String[] args) {
        System.out.println("Sistema dúo");
        System.out.println("1. Decimal a sistema dúo");
        System.out.println("2. Sistema dúo a decimal");
        System.out.println("3. Salir");

        int opcion = Integer.parseInt(Entrada.readLine());

        switch (opcion) {
            case 1 -> {
                System.out.print("Introduce el valor decimal: ");
                int valor = Integer.parseInt(Entrada.readLine());

                String bin = Integer.toBinaryString(valor);
                String resultado = "";

                for (int i = 0; i < bin.length(); i++) {
                    char c = bin.charAt(i);

                    if (c == '0') {
                        resultado += "A";
                    }

                    if (c == '1') {
                        resultado += "B";
                    }
                }
                System.out.println("Resultado: " + resultado);
            }
            case 2 -> {
                System.out.print("Introduce el valor en sistema dúo: ");
                String valor = Entrada.readLine();

                String bin = "";

                for (int i = 0; i < valor.length(); i++) {
                    char c = valor.charAt(i);

                    if (c == 'A') {
                        bin += "0";
                    }

                    if (c == 'B') {
                        bin += "1";
                    }
                }

                int decimal = Integer.parseInt(bin, 2);
                System.out.println("Resultado: " + decimal);
            }
            case 3 -> {
                break;
            }
            default -> {
                System.out.println("Opción no válida");
            }
        }
    }
}
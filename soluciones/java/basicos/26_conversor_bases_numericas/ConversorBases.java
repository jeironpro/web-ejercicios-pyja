/* Conversor de bases */
public class ConversorBases {
    public static String aHexadecimal(int numeroDecimal) {
        String hexadecimal = "";
        int[] decimalesBinarios = {8, 4, 2, 1};
        String binario = aBinario(numeroDecimal);
        int parte1 = 0;
        int parte2 = 0;
        int indice = 0;
        
        for (int i = 0; i < binario.length(); i++) {
            char c = binario.charAt(i);

            if (i <= 3) {
                if (c == '1') {
                    parte1 += decimalesBinarios[i];
                }
            } else {
                if (c == '1') {
                    parte2 += decimalesBinarios[indice];
                }
                indice++;
            }
        }

        hexadecimal += parte1 + "" + parte2;

        return hexadecimal;
    }

    public static String aOCtal(int numeroDecimal) {
        if (numeroDecimal == 0) {
            return "0";
        }

        String octal = "";
        int numero = numeroDecimal;
        int baseOctal = 8;
        
        while (numero > 0) {
            int residuo = numero % baseOctal;
            octal = residuo + octal;
            numero = numero / baseOctal;

        }

        return octal;
    }

    public static String aBinario(int numeroDecimal) {
        String binario = "";
        int[] decimalesBinarios = {128, 64, 32, 16, 8, 4, 2, 1};
        int[] binarios = {0, 0, 0, 0, 0, 0, 0, 0};

        for (int i = 0; i < decimalesBinarios.length; i++) {
            if (decimalesBinarios[i] <= numeroDecimal) {
                binarios[i] = 1;
                numeroDecimal -= decimalesBinarios[i];
            }
        }

        for (int i = 0; i < binarios.length; i++) {
            binario += binarios[i];
        }

        return binario;
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("Introduce el número decimal:");
            int numeroDecimal = Integer.parseInt(Entrada.readLine());

            System.out.println("Elige la base destino: 2 (binario), 8 (octal), 16 (hexadecimal):");
            int baseDestino =  Integer.parseInt(Entrada.readLine());

            switch (baseDestino) {
                case 2 -> {
                    System.out.println("Número en base 2: " + aBinario(numeroDecimal));
                }
                case 8 -> {
                    System.out.println("Número en base 8: " + aOCtal(numeroDecimal));
                }
                case 16 -> {
                    System.out.println("Número en base 16: " + aHexadecimal(numeroDecimal));
                }
                default -> {
                    System.out.println("La base seleccionada no es válida");
                }
            }

            System.out.println("¿Quieres convertir otro número? (s/n)");
            String confirmacion = Entrada.readLine();

            if (!confirmacion.equals("s")) {
                break;
            }
        }
    }
}
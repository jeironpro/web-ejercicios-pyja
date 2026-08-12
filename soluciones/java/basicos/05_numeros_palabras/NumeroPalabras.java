/* Número en palabras */
public class NumeroPalabras {
    public static String unidad(int numero) {
        if (numero == 1) {
            return "uno";
        } else if (numero == 2) {
            return "dos";
        } else if (numero == 3) {
            return "tres";
        } else if (numero == 4) {
            return "cuatro";
        } else if (numero == 5) {
            return "cinco";
        } else if (numero == 6) {
            return "seis";
        } else if (numero == 7) {
            return "siete";
        } else if (numero == 8) {
            return "ocho";
        } else if (numero == 9) {
            return "nueve";
        } else {
            return "";
        }
    }

    public static String multiplo(int numero) {
        int decena = numero / 10;

        if (decena == 3) {
            return "treinta";
        } else if (decena == 4) {
            return "cuarenta";
        } else if (decena == 5) {
            return "cincuenta";
        } else if (decena == 6) {
            return "sesenta";
        } else if (decena == 7) {
            return "setenta";
        } else if (decena == 8) {
            return "ochenta";
        } else if (decena == 9) {
            return "noventa";
        } else {
            return "";
        }
    }

    public static void main(String[] args) {
        System.out.println("Introduce un número entre 0 y 99:");
        String valor = Entrada.readLine();

        if (valor.isBlank() || (valor.charAt(0) != '-' && !Character.isDigit(valor.charAt(0)))) {
            System.out.println("No es un número válido");
            return;
        } else {
            int numero = Integer.parseInt(valor);

            if (numero < 0 || numero > 99) {
                System.out.println("Número fuera de rango");
            } else if (numero == 0) {
                System.out.println("cero");
            } else if (numero <= 15) {
                if (numero >= 1 && numero <= 9) {
                    System.out.println(unidad(numero));
                } else if (numero == 10) {
                    System.out.println("diez");
                } else if (numero == 11) {
                    System.out.println("once");
                } else if (numero == 12) {
                    System.out.println("doce");
                } else if (numero == 13) {
                    System.out.println("trece");
                } else if (numero == 14) {
                    System.out.println("catorce");
                } else if (numero == 15) {
                    System.out.println("quince");
                }
            } else if (numero < 20) {
                System.out.println("deici" + unidad(numero - 10));
            } else if (numero == 20) {
                System.out.println("veinte");
            } else if (numero < 30) {
                System.out.println("veinti" + unidad(numero - 20));
            } else {
                int resto = numero % 10;

                if (resto == 0) {
                    System.out.println(multiplo(numero));
                } else {
                    System.out.println(multiplo(numero) + " y " + unidad(resto));
                }
            }
        }
    }
}
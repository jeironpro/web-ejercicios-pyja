/* Número feliz */
public class NumeroFeliz {
    public static void main(String[] args) {
        System.out.print("Introduce un número entero positivo: ");
        String numero = Entrada.readLine();
        int valor = Integer.parseInt(numero);

        if (valor < 0) {
            System.out.println("El número debe ser positivo");
            return;
        }

        String secuencia = numero;
        boolean esFeliz = false;

        while (true) {
            int suma = 0;

            for (int i = 0; i < numero.length(); i++) {
                int digito = Integer.parseInt("" + numero.charAt(i));
                suma += digito * digito;
            }

            if (suma == 1) {
                esFeliz = true;
                secuencia += " -> 1";
                break;
            }

            if (secuencia.contains("-> " + suma) || secuencia.equals("" + suma)) {
                break;
            }

            secuencia += " -> " + suma;
            numero = "" + suma;
        }

        System.out.println("Secuencia: " + secuencia);
        if (esFeliz) {
            System.out.println("Resultado: Es un número feliz.");
        } else {
            System.out.println("Resultado: No es un número feliz.");
        }
    }
}
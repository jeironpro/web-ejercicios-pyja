/* Calculadora básica interactiva */

public class CalculadoraBasicaInteractiva {
    public static void main(String[] args) {
        System.out.println("Introduce el primer número: ");
        int primerNumero = Integer.parseInt(Entrada.readLine());

        System.out.println("Introduce el segundo número: ");
        int segundoNumero = Integer.parseInt(Entrada.readLine());

        System.out.println("Introduce el primer número: ");
        String operador = Entrada.readLine();

        if (operador.equals("+")) {
            int resultado = primerNumero + segundoNumero;
            System.out.println("Resultado: " + resultado);
        } else if (operador.equals("-")) {
            int resultado = primerNumero - segundoNumero;
            System.out.println("Resultado: " + resultado);
        } else if (operador.equals("*")) {
            int resultado = primerNumero * segundoNumero;
            System.out.println("Resultado: " + resultado);
        } else if (operador.equals("/")) {
            float resultado = primerNumero / segundoNumero;
            System.out.println("Resultado: " + resultado);
        } else {
            System.out.println("Operador no válido");
        }
    }
}
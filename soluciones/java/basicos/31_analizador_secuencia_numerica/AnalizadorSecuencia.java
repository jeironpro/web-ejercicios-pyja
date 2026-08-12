/* Analizador secuencia */
public class AnalizadorSecuencia {
    public static void main(String[] args) {
        System.out.println("Introduce números separados por espacio:");
        String valores = Entrada.readLine();

        if (valores.isBlank()) {
            System.out.println("No se han introducido valores");
            return;
        }

        String[] numeros = valores.split(" ");
        int suma = 0;
        int maximo = Integer.parseInt(numeros[0]);
        int minimo = Integer.parseInt(numeros[0]);
        boolean ascendente = false;
        boolean descendente = false;

        for (int i = 0; i < numeros.length; i++) {
            int valor = Integer.parseInt(numeros[i]);

            if (valor >= maximo) {
                maximo = valor;
            }

            if (valor <= minimo) {
                minimo = valor;
            }
            suma += valor;

            if (i < numeros.length -1) {
                int siguienteValor = Integer.parseInt(numeros[i+1]);

                if (valor < siguienteValor) {
                    ascendente = true;
                } else if (valor > siguienteValor) {
                    descendente = true;
                }
            }
        }

        float promedio = (float) suma / numeros.length;

        System.out.println("Suma: " + suma);
        System.out.println("Promedio: " + promedio);
        System.out.println("Máximo: " + maximo);
        System.out.println("Mínimo: " + minimo);
        System.out.print("Secuencia ordenada: ");

        if (ascendente && !descendente) {
            System.out.println("ascendente");
        } else if (!ascendente && descendente) {
            System.out.println("descendente");
        } else {
            System.out.println("no ordenada");
        }
    }
}
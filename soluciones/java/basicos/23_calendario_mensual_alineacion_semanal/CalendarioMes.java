/* Calendario del mes */
public class CalendarioMes {
    public static boolean esBisiesto(int anio) {
        return anio % 400 == 0 || (anio % 4 == 0 && anio % 100 != 0);
    }

    public static int zeller(int mes, int anio) {
        int m = mes;
        int y = anio;

        if (m == 1) {
            m = 13;
            y = anio - 1;
        } else if (m == 2) {
            m = 14;
            y = anio - 1;
        }

        int q = 1;
        int K = y % 100;
        int J = y / 100;

        return (q + (13 * (m + 1)) / 5 + K + (K / 4) + (J / 4) + (5 * J)) % 7;
    }

    public static void main(String[] args) {
        System.out.println("Introduce el mes (1-12):");
        int mes = Integer.parseInt(Entrada.readLine());

        if (mes < 1 || mes > 12) {
            System.out.println("El mes no es válido");
            return;
        }

        System.out.println("Introduce el año:");
        int anio = Integer.parseInt(Entrada.readLine());

        if (anio < 0) {
            System.out.println("El año debe ser positivo");
            return;
        }

        int h = zeller(mes, anio);

        String[] diasSemana = {
            "Sáb",
            "Dom",
            "Lun",
            "Mar",
            "Mié",
            "Jue",
            "Vie"
        };

        for (int i = 0; i < diasSemana.length; i++) {
            String dia = diasSemana[i];

            if (i < diasSemana.length-1) {
                System.out.printf("%-4s", dia);
            } else {
                System.out.printf("%s%n", dia);
            }
        }

        int[] diasMes = {
            0, 31, 28, 31, 30, 31, 30, 31, 30, 31, 30, 31
        };

        int dias = diasMes[mes];

        if (mes == 2 && esBisiesto(anio)) {
            dias = 29;
        }

        for (int i = 0; i < h; i++) {
            System.out.printf("%-4s", " ");
        }

        for (int i = 1; i <= dias; i++) {
            System.out.printf("%-4d", i);

            if ((i + h) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
}
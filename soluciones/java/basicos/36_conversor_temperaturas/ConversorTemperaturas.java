/* Conversor de temperaturas */
public class ConversorTemperaturas {
    public static double celsiusAFahrenheit(double temperatura) {
        return temperatura * 9 / 5 + 32;
    }

    public static double fahrenheitACelsius(double temperatura) {
        return (temperatura - 32) * 5 / 9;
    }

    public static double celsiusAKelvin(double temperatura) {
        return temperatura + 273.15;
    }

    public static double kelvinACelsius(double temperatura) {
        return temperatura - 273.15;
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("--- Conversor de temperaturas ---");
            System.out.println("1. Celsius a Fahrenheit");
            System.out.println("2. Fahrenheit a Celsius");
            System.out.println("3. Celsius a Kelvin");
            System.out.println("4. Kelvin a Celsius");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            int opcion = Integer.parseInt(Entrada.readLine());

            if (opcion == 5) {
                System.out.println("Saliendo del conversor...");
                break;
            }

            switch (opcion) {
                case 1 -> {
                    System.out.println("Introduce la temperatura en Celsius:");
                    double temperatura = Double.parseDouble(Entrada.readLine());

                    double resultado = celsiusAFahrenheit(temperatura);
                    System.out.printf("%.1fºC son %.1fºF%n", temperatura, resultado);
                }
                case 2 -> {
                    System.out.println("Introduce la temperatura en Fahrenheit:");
                    double temperatura = Double.parseDouble(Entrada.readLine());

                    double resultado = fahrenheitACelsius(temperatura);
                    System.out.printf("%.1fºF son %.1fºC%n", temperatura, resultado);
                }
                case 3 -> {
                    System.out.println("Introduce la temperatura en Celsius:");
                    double temperatura = Double.parseDouble(Entrada.readLine());

                    double resultado = celsiusAKelvin(temperatura);
                    System.out.printf("%.1fºC son %.1fºK%n", temperatura, resultado);
                }
                case 4 -> {
                    System.out.println("Introduce la temperatura en Kelvin:");
                    double temperatura = Double.parseDouble(Entrada.readLine());

                    double resultado = kelvinACelsius(temperatura);
                    System.out.printf("%.1fºK son %.1fºC%n", temperatura, resultado);
                }
                default -> {
                    System.out.println("Opción no válida");
                }
            }
        }
    }
}
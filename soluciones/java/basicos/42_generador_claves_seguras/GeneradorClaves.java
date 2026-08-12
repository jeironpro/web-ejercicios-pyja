/* Generador de claves seguras */
public class GeneradorClaves {
    public static void main(String[] args) {
        while (true) {
            System.out.println("Introduce la longitud de la clave:");
            int longitud = Integer.parseInt(Entrada.readLine());
            String caracteres = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789!@#$%^&*()-_=+[]{}|;:,.<>/?~";
            String clave = "";

            for (int i = 0; i < longitud; i++) {
                int ran = (int) (Math.random() * caracteres.length());

                clave += caracteres.charAt(ran);        
            }
            System.out.println("Clave generada: " + clave);

            System.out.println("¿Generar otra? (s/n):");
            String confirmacion = Entrada.readLine();

            if (!confirmacion.equals("s")) {
                break;
            }
        }
    }
}
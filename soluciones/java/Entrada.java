import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * Clase que simplifica la lectura desde la entrada estàndard.
 */
public final class Entrada {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    // Constructor privado para evitar instanciación
    private Entrada() {}

    /**
     * Lee una línea de la entrada estàndard.
     * @return la línea leida como un String
     * @throws Convierte IOException en RuntimeException para evitar que sea
     * obligatorio gestionarla
     */
    public static String readLine() {
        try {
            String linia = reader.readLine();
            if (linia == null) {
                throw new RuntimeException("Se ha llamado demasiadas veces a Entrada.readLine()");
            }
            return linia;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

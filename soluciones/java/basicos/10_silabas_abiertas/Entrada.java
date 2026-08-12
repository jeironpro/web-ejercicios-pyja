import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * Classe que simplifica la lectura des de l'entrada estàndard.
 */
public final class Entrada {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    // Constructor privat per evitar instanciació
    private Entrada() {}

    /**
     * Llegeix una línia de l'entrada estàndard.
     * @return la línia llegida com a String
     * @throws Converteix IOException en RuntimeException per evitar que sigui
     * obligatòri gestionar-la
     */
    public static String readLine() {
        try {
            String linia = reader.readLine();
            if (linia == null) {
                throw new RuntimeException("S'ha cridat massa cops Entrada.readLine()");
            }
            return linia;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
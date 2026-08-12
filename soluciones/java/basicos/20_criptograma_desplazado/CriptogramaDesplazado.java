/* Criptograma desplazado */
public class CriptogramaDesplazado {
    public static void main(String[] args) {
        System.out.println("Introduce el mensaje:");
        String mensaje = Entrada.readLine();

        System.out.println("Introduce el desplazamiento:");
        int desplazamiento = Integer.parseInt(Entrada.readLine());

        String cifrado = "";

        for (int i = 0; i < mensaje.length(); i++) {
            char c = mensaje.charAt(i);

            if (Character.isWhitespace(c)) {
                cifrado += c;
            }
            
            if (c >= 'a' && c <= 'z') {
                int pos = c - 'a';

                int nuevaPos = (pos + desplazamiento) % 26;

                if (nuevaPos < 0) {
                    nuevaPos += 26;
                }

                cifrado += (char)('a' + nuevaPos);
            }
        }

        System.out.println("Resultado cifrado: " + cifrado);
    }
}
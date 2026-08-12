/* Decodificador morse */
import java.util.Map;
import java.util.HashMap;

public class DecodificadorMorse {
    public static void main(String[] args) {
         Map<String, String> morseMap = new HashMap<>();

        // Letras A-Z
        morseMap.put(".-", "A");
        morseMap.put("-...", "B");
        morseMap.put("-.-.", "C");
        morseMap.put("-..", "D");
        morseMap.put(".", "E");
        morseMap.put("..-.", "F");
        morseMap.put("--.", "G");
        morseMap.put("....", "H");
        morseMap.put("..", "I");
        morseMap.put(".---", "J");
        morseMap.put("-.-", "K");
        morseMap.put(".-..", "L");
        morseMap.put("--", "M");
        morseMap.put("-.", "N");
        morseMap.put("---", "O");
        morseMap.put(".--.", "P");
        morseMap.put("--.-", "Q");
        morseMap.put(".-.", "R");
        morseMap.put("...", "S");
        morseMap.put("-", "T");
        morseMap.put("..-", "U");
        morseMap.put("...-", "V");
        morseMap.put(".--", "W");
        morseMap.put("-..-", "X");
        morseMap.put("-.--", "Y");
        morseMap.put("--..", "Z");

        // Números 0-9
        morseMap.put("-----", "0");
        morseMap.put(".----", "1");
        morseMap.put("..---", "2");
        morseMap.put("...--", "3");
        morseMap.put("....-", "4");
        morseMap.put(".....", "5");
        morseMap.put("-....", "6");
        morseMap.put("--...", "7");
        morseMap.put("---..", "8");
        morseMap.put("----.", "9");

        System.out.println("Introduce código Morse:");
        String codigo = Entrada.readLine();

        String[] partes = codigo.split("/");
        String resultado = "";

        for (int i = 0; i < partes.length; i++) {
            String[] parte = partes[i].split(" ");

            for (String letra : parte) {
                if (morseMap.containsKey(letra)) {
                    resultado += morseMap.get(letra);
                }
            }
            if (i < partes.length-1) {
                resultado += " ";
            }
        }

        System.out.println("Texto traducido: " + resultado);
    }
}
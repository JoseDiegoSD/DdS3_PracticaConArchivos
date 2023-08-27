import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Histograma
public class Histograma{

    public static void main(String[] args) {

        String filename = "divina_comedia_sp.txt";
        Map<Integer, Integer> histogram = new TreeMap<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;

            //crea un objeto de patrón de expresión regular a partir de la cadena.
            Pattern wordPattern = Pattern.compile("\\b\\w+\\b");

            while ((line = reader.readLine()) != null) {
                Matcher matcher = wordPattern.matcher(line);

                while (matcher.find()) {
                    String word = matcher.group();


                    if (word.length() >= 2 && word.length() <= 10 && !word.matches("\\d+")) {
                        int wordLength = word.length();
                        histogram.put(wordLength, histogram.getOrDefault(wordLength, 0) + 1);
                    }
                }
            }
            reader.close();

            for (Map.Entry<Integer, Integer> entry : histogram.entrySet()) {
                int length = entry.getKey();
                int count = entry.getValue();

                //imprimir una línea formateada en la consola.
                System.out.printf("(%d) Longitud %d: %s%n", count, length, "#".repeat(count));
            }

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());

        }
    }//fin main
}//fin class

/*Desarrollar un programa que genere un histograma con la longitud en caracteres de cada
una de las palabras contenidas en un archivo de texto. Ignorar cifras numéricas y considerar
exclusivamente palabras desde 2 hasta un máximo de 10 caracteres de longitud.
Usar el archivo divina_comedia_sp.txt para las pruebas.

 */
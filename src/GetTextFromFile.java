import java.io.*;

public class GetTextFromFile {

    public static String readFile(String directory) throws IOException {
        File file = new File(directory);
        StringBuilder textToReturn = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                textToReturn.append(line).append("\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("There is no such file");
        }
        return textToReturn.toString();
    }
}

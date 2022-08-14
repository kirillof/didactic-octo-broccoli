package utils.file;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriter {
    public static String writeStringToFile(String text) {
        String path = System.getProperty("user.dir") + "/result.txt";
        try {
            var fileWriter = new java.io.FileWriter("result.txt");
            var bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(text);
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Can't write file with path " + path);
            throw new RuntimeException(e);
        }
        finally {
            System.out.println("The result recorded by path " + path);
        }
        return path;
    }
}

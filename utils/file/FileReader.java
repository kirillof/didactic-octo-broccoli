package utils.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader {
    public static String readString(String path) {
        var file = new File(path);
        try {
            var bufferedReader = new BufferedReader(new java.io.FileReader(file));
            var stringBuilder = new StringBuilder();
            String line = bufferedReader.readLine();
            while (line != null) {
                stringBuilder.append(line);
                line = bufferedReader.readLine();
            }
            var resultSting = stringBuilder.toString();
            return resultSting.replaceAll("\\s", "");
        } catch (FileNotFoundException e) {
            System.out.println("Can't find file by path " + path);
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Problem with reader. Check file format");
            throw new RuntimeException(e);
        }
    }
}

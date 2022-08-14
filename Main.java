import handlers.ArrayHandlerV2;
import utils.file.FileReader;
import utils.file.FileWriter;
import utils.json.JSONReader;
import utils.json.JSONWriter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter the path file to the console");
        var consoleReader = new BufferedReader(new InputStreamReader(System.in));
        var json = FileReader.readString(consoleReader.readLine());
        consoleReader.close();

        var listOfArray = JSONReader.parseJSON(json);
        var result = ArrayHandlerV2.handleArray(listOfArray);


        var jsonResult = JSONWriter.writeArray(result);
        System.out.println("Result");
        System.out.println(jsonResult);
        System.out.println("Recording result to file...");
        FileWriter.writeStringToFile(jsonResult);
    }
}

package utils.json;

import java.util.ArrayList;

public class JSONReader {
    public static ArrayList<String[]> parseJSON(String json) {
        json = deleteDoubleBrackets(json);

        var tmpArray = json.split("],\\[");

        String [][] tmpResult = new String [tmpArray.length][tmpArray[0].split(",").length];

        for (int i = 0; i < tmpArray.length; i++) {
            var tmpMassive = tmpArray[i].split(",");
            for (int i1 = 0; i1 < tmpMassive.length; i1++) {
                var tmpElement = tmpMassive[i1];
                tmpResult[i][i1] = !tmpElement.equals("null") ? tmpElement : null;
            }
        }

        return convertMultiArrayToArrayList(tmpResult);
    }

    private static String deleteDoubleBrackets(String str) {
        str = str.replace("[[", "");
        str = str.replace("]]", "");
        return str;
    }

    private static ArrayList<String[]> convertMultiArrayToArrayList(String[][] multiArray) {
        var result = new ArrayList<String[]>();

        for (int i = 0; i<multiArray.length; i++) {
            result.add(multiArray[i]);
        }

        return result;
    }
}

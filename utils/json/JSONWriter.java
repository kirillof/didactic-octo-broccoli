package utils.json;

import java.util.List;

public class JSONWriter {
    public static String writeArray(List<String[]> array) {
        var stringBuilder = new StringBuilder();
        stringBuilder.append("[\n");
        for (int i = 0; i < array.size(); i++) {
            stringBuilder.append("\t");
            for (int i1 = 0; i1 < array.get(i).length; i1++) {
                if (i1 == 0) {
                    stringBuilder.append("[ " + array.get(i)[i1] + ",   ");
                } else if (i1 == array.get(i).length - 1) {
                    stringBuilder.append(array.get(i)[i1] + " ]");
                } else {
                    stringBuilder.append(array.get(i)[i1] + ",   ");
                }
            }
            if (i != array.size() - 1) {
                stringBuilder.append(",\n");
            }
        }
        stringBuilder.append("\n]");
        return stringBuilder.toString();
    }
}

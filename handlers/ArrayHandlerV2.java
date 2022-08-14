package handlers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ArrayHandlerV2 {
    public static ArrayList<String[]> handleArray(ArrayList<String[]> massiveness) {
        var result = new ArrayList<String[]>();
        var rowSize = massiveness.get(0).length;

        var rowMetaData = new ArrayList<Map<String, ArrayList<Integer>>>();
        final String EMPTY = "empty_indexes";
        final String FILLED = "filled_indexes";

        for (String[] strings : massiveness) {
            var emptyIndexes = new ArrayList<Integer>(rowSize);
            var filledIndexes = new ArrayList<Integer>(rowSize);
            for (int i1 = 0; i1 < strings.length; i1++) {
                if (strings[i1] == null) {
                    emptyIndexes.add(i1);
                } else filledIndexes.add(i1);
            }
            var metaData = new HashMap<String, ArrayList<Integer>>();
            metaData.put(EMPTY, emptyIndexes);
            metaData.put(FILLED, filledIndexes);
            rowMetaData.add(metaData);
        }

        for(int i = 0; i < rowMetaData.size(); i++) {
            if (rowMetaData.get(i).get(EMPTY).isEmpty()) {
                result.add(massiveness.get(i));
            }
            else {
                for (int i1 = i+1; i1 < rowMetaData.size(); i1++) {
                    var tmp = rowMetaData.get(i1);
                    var filledIndexes = tmp.get(FILLED);
                    if (!filledIndexes.isEmpty()
                            && filledIndexes.containsAll(rowMetaData.get(i).get(EMPTY))
                            && filledIndexes.stream().noneMatch(rowMetaData.get(i).get(FILLED)::contains)
                    ) {
                        var tmpArray = new String[rowSize];
                        int finalI = i;
                        rowMetaData.get(i).get(FILLED).forEach(s -> tmpArray[s] = massiveness.get(finalI)[s]);
                        int finalI1 = i1;
                        filledIndexes.forEach(s -> tmpArray[s] = massiveness.get(finalI1)[s]);
                        result.add(tmpArray);
                    }
                }
            }
        }
        return result;
    }
}

package handlers;

import java.util.ArrayList;

public class ArrayHandlerV1 {
    public static ArrayList<String[]> handleArray(ArrayList<String[]> massiveness) {
        var result = new ArrayList<String[]>();
        var rowSize = massiveness.get(0).length;

        for (int i = 0; i < massiveness.size(); i++) {
            var emptyIndexes = new ArrayList<Integer>(rowSize);
            var filledIndexes = new ArrayList<Integer>(rowSize);
            for (int i1 = 0; i1 < massiveness.get(i).length; i1++) {
                if (massiveness.get(i)[i1] == null) {
                    emptyIndexes.add(i1);
                } else filledIndexes.add(i1);
            }
            if (emptyIndexes.isEmpty()) {
                result.add(massiveness.get(i));
            }
            else {
                for (int i2 = i+1; i2 < massiveness.size(); i2++) {
                    var filledIndexes1 = new ArrayList<Integer>(rowSize);
                    for (int i3 = 0; i3 < massiveness.get(i2).length; i3++) {
                        if (massiveness.get(i2)[i3] != null) {
                            filledIndexes1.add(i3);
                        }
                    }
                    if (!filledIndexes1.isEmpty()
                            && filledIndexes1.containsAll(emptyIndexes)
                            && filledIndexes1.stream().noneMatch(filledIndexes::contains)) {
                        var tmpArray = new String[rowSize];
                        int finalI = i;
                        filledIndexes.forEach(s -> tmpArray[s] = massiveness.get(finalI)[s]);
                        int finalI2 = i2;
                        filledIndexes1.forEach(s -> tmpArray[s] = massiveness.get(finalI2)[s]);
                        result.add(tmpArray);
                    }
                }
            }
        }
        return result;
    }
}

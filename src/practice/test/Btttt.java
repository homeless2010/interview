package practice.test;

import java.util.*;

class NeInfo {
    int neId;
    String neName;
    int neFlag;

    public NeInfo(int neId, String neName, int neFlag) {
        this.neId = neId;
        this.neName = neName;
        this.neFlag = neFlag;
    }

    public NeInfo(int neId, String neName) {
        this(neId, neName, 0);
    }

    @Override
    public String toString() {
        return String.format(Locale.ROOT, "%d %s %d", neId, neName, neFlag);
    }
}

public class Btttt {
    List<NeInfo> syncNeInfo(List<NeInfo> curTable, List<NeInfo> bakTable) {
        List<NeInfo> add = new ArrayList<>();
        for (int i = 0; i < bakTable.size(); i++) {
            boolean f = false;
            for (int j = 0; j < curTable.size(); j++) {
                if (bakTable.get(i).neId == curTable.get(j).neId) {
                    curTable.get(j).neName = bakTable.get(i).neName;
                    f = true;
                    break;
                }
            }
            if (f) {

            } else {
                NeInfo neInfo = new NeInfo(bakTable.get(i).neId, bakTable.get(i).neName, 0);
                add.add(neInfo);
            }
        }
        curTable.addAll(add);
        Collections.sort(curTable, Comparator.comparingInt(v -> v.neId));
        return curTable;
    }
}

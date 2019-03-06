import java.util.ArrayList;
import java.util.List;

class Main {
    private List<Integer> list;
    int aIdx = 0;
    int bIdx = 0;
    int cIdx = 0;

    void constructor() {
        list = new ArrayList();
    }

    public int pop(int num) {
        int result = 0;
        switch (num) {
        case 0:
            if (aIdx <= 0) {
                return -1;
            }
            result = list.get(aIdx);
            list.remove(aIdx);
            aIdx--;
            bIdx--;
            cIdx--;
            return result;
        case 1:
            if (bIdx - aIdx == 0) {
                return -1;
            }
            result = list.get(bIdx);
            list.remove(bIdx);
            bIdx--;
            cIdx--;
            return result;
        case 2:
            if (cIdx - bIdx == 0) {
                return -1;
            }
            result = list.get(cIdx);
            list.remove(cIdx);
            cIdx--;
            return result;
        default:
            return -1;
        }
    }

    public void push(int item, int num) {
        switch (num) {
        case 0:
            list.add(aIdx, item);
            aIdx++;
            bIdx++;
            cIdx++;
            break;
        case 1:
            list.add(aIdx + bIdx, item);
            bIdx++;
            cIdx++;
            break;
        case 2:
            list.add(aIdx + bIdx + cIdx, item);
            cIdx++;
            break;
        default:

        }
    }
}
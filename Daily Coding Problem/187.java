import java.util.*;

class Main {
    static class Rectangle {
        Node topLeft;
        Node bottomRight;

        Rectangle(Node _topLeft, Node _bottomRight) {
            topLeft = _topLeft;
            bottomRight = _bottomRight;
        }
    }

    static class Node {
        int x;
        int y;

        Node(int _x, int _y) {
            x = _x;
            y = _y;
        }
    }

    public static boolean isCover(List<Rectangle> list) {
        Set<Rectangle> set = new HashSet<>();
        set.add(list.get(0));
        for (Rectangle li : list) {
            if (overlap(set, li))
                return true;
            else
                set.add(li);
        }

        return false;
    }

    private static boolean overlap(Set<Rectangle> region, Rectangle rec) {
        for (Rectangle area : region) {
            if (region.topLeft.x <= rec.topLeft.x && region.topLeft.y >= rec.topLeft.y
                    && region.bottomRight.x >= rec.bottomRight.x && region.bottomRight.y <= rec.bottomRight.y) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(area(new int[][] { { 1, 4 }, { 3, 3 } }, new int[][] { { 0, 5 }, { 4, 3 } }));
    }
}
package ThreeConnection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Connnect {

    public static void main(String[] args) {
        Board board = new Board();
        System.out.println(board.put(Color.RED, 0));
        System.out.println(board.put(Color.RED, 0));
        System.out.println(board.put(Color.BLUE, 0));
        System.out.println(board.put(Color.BLUE, 0));
        System.out.println(board.put(Color.BLUE, 0));
        System.out.println(board.put(Color.BLUE, 1));
        System.out.println(board.put(Color.BLUE, 1));
        System.out.println(board.put(Color.BLUE, 2));


    }


}

enum Color {
    BLUE,
    RED,
    DEFAULT
}
class Board {
    Map<Integer, List<Color>> map;

    public Board() {
        this.map = new HashMap<>();
    }

    public boolean put(Color color, int position) {
        List<Color> list = map.getOrDefault(position, new ArrayList<>());
        list.add(color);
        map.put(position, list);

        int col = list.size() - 1;
        int count = 1;
        Color prevColor = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (prevColor.equals(list.get(i))) {
                count++;
                if (count == 3) return true;
            } else {
                count = 1;
            }
            prevColor = list.get(i);
        }


        Color[] colors = new Color[5];
        // Check horizontally
        for (int idx = position - 2, i = 0; idx <= position + 2; idx++, i++) {
            if (map.containsKey(idx)) {
                Color temp = map.get(idx).get(col);
                if (temp == null) {
                    colors[i] = Color.DEFAULT;
                } else {
                    colors[i] = temp;
                }
            } else {
                colors[i] = Color.DEFAULT;
            }
        }

        count = 1;
        prevColor = colors[0];
        for (int i = 1; i < colors.length; i++) {
            if (prevColor.equals(colors[i])) {
                count++;
                if (count == 3) return true;
            } else {
                count = 1;
            }
            prevColor = colors[i];
        }


        // Check diagnoally

        return false;
    }
}


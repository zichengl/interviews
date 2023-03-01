package TokenGames;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

    }
}

enum Color {
    RED,
    GREEN,
    BLUE,
    BLACK,
    WHITE,
    GOLDEN
}

class Player {
    String name;
    Map<Color, Integer> tokens;
    Map<Color, Integer> cards;
    public Player(String name, Map<Color, Integer> tokens) {
        this.name = name;
        this.tokens = tokens;
        cards = new HashMap<>();
        cards.put(Color.RED, 0);
        cards.put(Color.GREEN, 0);
        cards.put(Color.BLUE, 0);
        cards.put(Color.BLACK, 0);
        cards.put(Color.WHITE, 0);
    }
    public boolean canPurchase(Card card) {
        int goldenRemain = tokens.get(Color.GOLDEN);
        for (Map.Entry<Color, Integer> entry : card.cost.entrySet()) {
            Color color = entry.getKey();
            if (tokens.get(color) + cards.get(color) + goldenRemain < entry.getValue()) {
                return false;
            }
            if (tokens.get(color) + cards.get(color) < entry.getValue()) { // Need the golden token
                goldenRemain -= (entry.getValue() - cards.get(color) - tokens.get(color));
            }
        }
        return true;
    }
    public void purchase(Card card) {
        int goldenRemain = tokens.get(Color.GOLDEN);
        for (Map.Entry<Color, Integer> entry : card.cost.entrySet()) {
            Color color = entry.getKey();
            int colorCost = entry.getValue() - cards.get(color);
            if (colorCost <= tokens.get(color)) {
                tokens.put(color, tokens.get(color) - colorCost);
            } else { // Use the golden token
                goldenRemain -= (colorCost - tokens.get(color));
                tokens.put(color, 0);
            }

        }
        tokens.put(Color.GOLDEN, goldenRemain);
        cards.put(card.color, cards.get(card.color) + 1);
    }

}

class Card {
    String name;
    Map<Color, Integer> cost;

    Color color;

    public Card(String name, Map<Color, Integer> cost, Color color) {
        this.name = name;
        this.cost = cost;
        this.color = color;
    }
}

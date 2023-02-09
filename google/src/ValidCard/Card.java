package ValidCard;

public class Card {
    int num;
    char set;
    public Card(String card) {
        if (card.length() == 3) {
            num = 10;
            set = card.charAt(2);
        } else {
            switch(card.charAt(0)) {
                case 'A':
                    num = 1;
                    break;
                case 'J':
                    num = 11;
                    break;
                case 'Q':
                    num = 12;
                    break;
                case 'K':
                    num = 13;
                    break;
                default:
                    num = Integer.parseInt(String.valueOf(card.charAt(0)));
            }
            set = card.charAt(1);
        }
    }
}

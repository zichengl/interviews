Given a set of cards to play, input as a collection of cards with rank and suit to play
The play of the card is valid when meeting the following 2 options
1. 3 or more consectuive rank regardless of the suit, to be noted rotated rank doesn't count e.g.  "QC", "KD", "AC" is not consectuive
   2.  3 or more same ranks with the same suit
   Any play less than 2 cars is invalid
   Example
   "2D",  "4H", "6S", "3C" --> valid
   "3D", "3C",  "3H", "6S" --> invalid
   "3D"‍‍‌‌‍‍‌‌‌‌‍‌‍‍‌‌‌‌, "4D", "7S", "6C", "10D", "9S" --> invalid
   "3D", "3D", "4S", "9D","9D" --> Invalid
   "3D", "3D", "9D", "4S", "9D","9D" --> valid
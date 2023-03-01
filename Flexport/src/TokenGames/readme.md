Player有五种颜色的token，可以用手上的toekn购买card。每张card会花费不同的token数量，比如1红2白。
第一小问，canPurchase()
第二小问：purchase()。
第三小问：discount，如果买家手里有Blue，买Blue打七折，update这两个function canPurchase() 和 purchase()。
第四小问：我没做到，但看地里有一种gold token，可以做任何颜色的token


Part1: 一个player有5个颜色的tokens, 比如 2个蓝色的tokens和1个绿色的tokens可以购买一个cards. 那么你现在手上已经有的tokens可不可以买cards. 因为是一个OOD, tokens的数量都是自己设计, 然后购买cards的条件也是自己设计的. 然后写一个方程来判断是否可以买这个cards.
Part2: 和part1差不多, 只是要你打印出还剩下多少tokens 和 cards的数量
Part3: 和之前有些不一样了. 如果现在有2个绿色的card 然后2个绿色的tokens, 然后告诉你要3个绿色的票才能换 一个白色的card. 要你输出 你的钱包里面有哪些card和tokens. cards要先被消耗, 一个cards等于一个票. 所以最后的结果就是 一个白色的card 0个绿色的card 1个绿色的tokens.

Given card with cost in terms of tokens. For eg to buy some Card A, you need 3 Blue tokens and 2 Green tokens. Tokens can be of Red, Green, Blue, Black or White color.

Now there is player who is holding some tokens. For eg player has 4 Blue tokens and 2 Green tokens, then player can buy above Card A. Lets say if player only has 2 Blue tokens and 2 Green tokens, then player can not buy Card A above as player is short of 1 Blue token.

Write a method that returns true if player can buy the card or false otherwise.

More examples :

Cost of Card : 2 White, 1 Black and 4 Blue
If Player has : 2 White, 2 Black and 4 Blue, method will return true
If Player has : 2 White, 2 Green and 4 Blue, method will return false

Apart from above info, nothing is given and you have to come with your own implementation.
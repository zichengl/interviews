package GuessString;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 第三问：加了一点ood，就说如果是个游戏，然后每一轮有maxattempt，怎么设计+改之前写好的method
public class GuessString {
    public static void main(String[] args) {
        String target = "SMILE";
        String guess = "CLOSE";
        System.out.println(guessString(target, guess));

        String target1 = "ABAAA";
        String guess1 = "BAAAA";
        System.out.println(guessStringDuplicate(target1, guess1));

        String target2 = "BBAAA";
        String guess2 = "BAAAA";
        System.out.println(guessStringDuplicate(target2, guess2));
    }
    //
    // 用B(black)/Y(yellow)/G(green) 表示。如果guess里面某一个字母在target里没有的话就是B, 有但是位置不同就是Y，有而且位置相同就是G.
    // 比如 target = "SMILE", guess = "CLOSE" 返回 "BYBYG".
    // 第一问：假设target里面没有重复的字母.
    // 第二问：假设target里面有重复的字母，用过就不能再用，优先配对位置相同的。比如 target = "BBAAA", guess = "CCCAA" 返回的就是BBBGG （优先配对后两个位置相同的A）
    public static String guessString(String target, String guess) {
        Map<Character, Integer> map = new HashMap();
        for (int i = 0; i < target.toCharArray().length; i++) {
            map.put(target.charAt(i), i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < guess.toCharArray().length; i++) {
            if (map.containsKey(guess.charAt(i)) && i == map.get(guess.charAt(i))) {
                sb.append("G");
            } else if (map.containsKey(guess.charAt(i)) && i != map.get(guess.charAt(i))) {
                sb.append("Y");
            } else if (!map.containsKey(guess.charAt(i))) {
                sb.append("B");
            }
        }
        return sb.toString();
    }

    public static String guessStringDuplicate(String target, String guess) {
        Map<Character, Set<Integer>> map = new HashMap();
        for (int i = 0; i < target.toCharArray().length; i++) {
            Set<Integer> set = map.getOrDefault(target.charAt(i), new HashSet<>());
            set.add(i);
            map.put(target.charAt(i), set);
        }
        System.out.println(map);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < guess.toCharArray().length; i++) {
            Set<Integer> set = map.get(guess.charAt(i));
            if (set != null && set.contains(i)) {
                sb.append("G");
                set.remove(i);
                map.put(guess.charAt(i), set);
            } else if (set != null && !set.contains(i)) {
                sb.append("_");
            } else if (set == null) {
                sb.append("B");
            }
        }

        for (int i = 0; i < guess.toCharArray().length; i++) {
            if (sb.charAt(i) == '_') {
                Set<Integer> set = map.get(guess.charAt(i));
                if (!set.isEmpty()) {
                    sb.setCharAt(i, 'Y');
                } else {
                    sb.setCharAt(i, 'B');
                }
            }
        }
        return sb.toString();
    }
}

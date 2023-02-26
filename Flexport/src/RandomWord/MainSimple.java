package RandomWord;

import java.util.*;

import static java.lang.Math.random;

public class MainSimple {

    public static void main(String[] args) {
        List<String> result = generateRandom("this is a sentence it is not a good one and it is also bad", 5);
        System.out.println(String.join(" ", result));
    }
    public static List<String> generateRandom(String input, int n) {
        String[] words = input.split(" ");

        Map<String, List<Integer>> map = new HashMap<>();
        populateMap(words, map);
        System.out.println(" Populated map is : " + map);
        Random random = new Random();
        List<String> res = new LinkedList<>();
        int randomIndex = random.nextInt(words.length);
        System.out.println(" Chosen words is : " + words[randomIndex]);
        res.add(words[randomIndex]);
        while (res.size() != n) {
            List<Integer> nextList = map.get(res.get(res.size() - 1));
            int nextIndex = nextList.get(random.nextInt(nextList.size()));
            res.add(words[nextIndex]);
        }
        return res;
    }

    private static void populateMap(String[] words, Map<String, List<Integer>> map) {
        for (int i = 0; i < words.length; i++) {
            int next = (i + 1) % words.length;
            List<Integer> nextList = map.getOrDefault(words[i], new ArrayList<>());
            nextList.add(next);
            map.put(words[i], nextList);
        }
    }
}

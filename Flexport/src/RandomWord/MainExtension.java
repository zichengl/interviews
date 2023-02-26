package RandomWord;

import java.util.*;

class MainExtension {
    public static void main(String[] args) {
        List<String> result = generateRandom("this is a sentence it is not a good one and it is also bad", 5, 2);
        System.out.println(String.join(" ", result));
    }

    public static List<String> generateRandom(String input, int n, int m) {
        String[] words = input.split(" ");

        Map<String, List<Integer>> map = populateMap(words, m);
        System.out.println(" Populated Map is : " + map);
        Random random = new Random();
        int index = random.nextInt(words.length);
        System.out.println(" Chosen word is : " + words[index]);
        List<String> result = new ArrayList<>();

        // Fill the first window of words starting with the chosen word, window length is m
        result.addAll(getWindow(words, index, m));
        while (result.size() != n) {
            // Retrieve last m words of generated sentence, which will be used to determine nextList
            List<String> lastWords = new ArrayList<>();
            for (int i = result.size() - m; i < result.size(); i++) {
                lastWords.add(result.get(i));
            }
            List<Integer> nextList = map.get(String.join("|", lastWords));
            int nextIndex = nextList.get(random.nextInt(nextList.size()));
            result.add(words[nextIndex]);
        }
        return result;
    }

    public static Map<String, List<Integer>> populateMap(String[] words, int m) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String key = String.join("|", getWindow(words, i, m));
            System.out.println("Current Key is : " + key);
            int nextIndex = (i + m) % words.length;
            List<Integer> nextList = map.getOrDefault(key, new ArrayList<>());
            nextList.add(nextIndex);
            map.put(key, nextList);
        }
        return map;
    }

    public static List<String> getWindow(String[] words, int currentIndex, int m) {
        List<String> window = new ArrayList<>();
        int index = currentIndex;
        while (window.size() != m) {
            window.add(words[index % words.length]);
            index++;
        }
        return window;
    }
}
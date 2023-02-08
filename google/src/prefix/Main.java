package prefix;

import java.util.Arrays;

public class Main {
    public static String[] shortestPrefix(String[] strs) {
        String[] prefixes = new String[strs.length];
        Trie trie = new Trie();
        for (String str : strs) {
            trie.insert(str);
        }

        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            TrieNode node = trie.root;
            StringBuilder prefix = new StringBuilder();
            for (char c : str.toCharArray()) {
                prefix.append(c);
                node = node.children.get(c);
                if (node.count == 1) {
                    prefixes[i] = prefix.toString();
                    break;
                } else if (node.isEnd && prefix.length() == str.length()) {
                    prefixes[i] = prefix.toString();
                    break;
                }
            }
        }
        return prefixes;
    }

    public static void main (String[] args) {

        String[] strs1 = new String[] {"abc", "bcd"};
        String[] strs2 = new String[] {"abc", "acd", "cabv"};
        String[] strs3 = new String[] {"abadasfvascc", "bcasdfasghasdfd", "abcde", "abcdef"};

        String[] prefixes1 = shortestPrefix(strs1);
        String[] prefixes2 = shortestPrefix(strs2);
        String[] prefixes3 = shortestPrefix(strs3);

        System.out.println("Test case 1: " + Arrays.toString(prefixes1));
        System.out.println("Test case 2: " + Arrays.toString(prefixes2));
        System.out.println("Test case 3: " + Arrays.toString(prefixes3));
    }
}

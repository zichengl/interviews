package prefix;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    int count;
    boolean isEnd;
    Map<Character, TrieNode> children;

    public TrieNode() {
        count = 0;
        children = new HashMap<>();
        isEnd = false;
    }
}
package ValidCard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
    public static boolean validCards(String[] cards) {
        if (cards.length < 3) return false;
        Map<Integer, Integer> rankCounter = new HashMap<>();
        Map<Character, Integer> setCounter = new HashMap<>();
        PriorityQueue<Card> pq = new PriorityQueue<>((a, b) -> a.num - b.num);

        for (String card : cards) {
            pq.offer(new Card(card));
        }

        Card card = pq.poll();
        int startRank = card.num;
        int prevRank = startRank;
        char set = card.set;
        rankCounter.put(startRank, rankCounter.getOrDefault(startRank, 0) + 1);
        setCounter.put(set, rankCounter.getOrDefault(set, 0) + 1);
        // "2D 3C 5H 6S"
        while (!pq.isEmpty()) {
            Card curCard = pq.poll();

            int rank = curCard.num;
            char curSet = curCard.set;
            if (rank - prevRank == 1)  { // consecutive rank
                rankCounter.put(startRank, rankCounter.getOrDefault(startRank, 0) + 1);
            } else if (rank - prevRank == 0) { // same rank
                setCounter.put(curSet, setCounter.getOrDefault(set, 0) + 1);
            } else {
                startRank = rank;
                rankCounter.put(startRank, 1); // reset counter
            }
            prevRank = rank;
        }

        for (int count : rankCounter.values()) {
            if (count >= 3) return true;
        }
        for (int count : setCounter.values()) {
            if (count >= 3) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String[] inputArray = {"2D", "3C",  "4H", "6S"};
        List<String> input = Arrays.asList(inputArray);
        System.out.println("Input: " + input);
        System.out.println("Output: " + validCards(inputArray));


        String[] inputArray1 = {"3D", "3C",  "3H", "6S"};
        List<String> input1 = Arrays.asList(inputArray1);
        System.out.println("Input: " + input1);
        System.out.println("Output: " + validCards(inputArray1));


        String[] inputArray2 = {"3D", "3C", "5C", "6S", "7D",};
        List<String> input2 = Arrays.asList(inputArray2);
        System.out.println("Input: " + input2);
        System.out.println("Output: " + validCards(inputArray2));
    }

}


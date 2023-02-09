package StringConverter;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


// A3(B4
// reverse : 2)4B(3A


// Input: (A3B2)21
// reverse 12)2B3A(
public class Main {
    public static Map<Character, Integer> convert(String input) {
        Map<Character, Integer> result = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int multiplier = 1;
        for (int i = input.length() - 1; i >= 0; i--) {
            char c = input.charAt(i);
            if (c >= '0' && c <= '9') {
                int number = c - '0';
                stack.push(number);
            } else if (c >= 'A' && c <= 'Z') {
                int num = stack.pop();
                while (!stack.isEmpty()) {
                    num = num * 10 + stack.pop();
                }
                result.put(c, result.getOrDefault(c, 0) + num * multiplier);
            } else if (c == ')') {
                int num = stack.pop();
                while (!stack.isEmpty()) {
                    num = num * 10 + stack.pop();
                }

                multiplier *= num;
            } else if (c == '(') {
                multiplier = 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String input1 = "A3B2";
        System.out.println("Input: " + input1);
        System.out.println("Output: " + convert(input1));

        String input2 = "(A31B2)21";
        System.out.println("Input: " + input2);
        System.out.println("Output: " + convert(input2));

        String input3 = "A2(A3B2)2";
        System.out.println("Input: " + input3);
        System.out.println("Output: " + convert(input3));
    }
}

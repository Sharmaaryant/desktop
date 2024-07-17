import java.util.*;
import java.util.Scanner;

// Write your code here. DO NOT use an access modifier in your class declaration.
class Parser{
    static String isBalanced(String s)
    {
        Stack<Character> stack = new Stack<>();

        // Iterate through each character in the string
        for (char c : s.toCharArray()) {
            // If it's an opening bracket, push it onto the stack
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                // If it's a closing bracket and the stack is empty, the string is unbalanced
                if (stack.isEmpty()) {
                    return "false";
                }
                // Pop the top element from the stack
                char top = stack.pop();
                // Check if the current closing bracket matches the corresponding opening bracket
                if ((c == ')' && top != '(') ||
                        (c == ']' && top != '[') ||
                        (c == '}' && top != '{')) {
                    return "false";
                }
            }
        }

        // If the stack is empty, the string is balanced
        // Otherwise, there are unmatched opening brackets
        return stack.isEmpty() ? "true" : "false";
    }
}



class Solution {

    public static void main(String[] args) {
        Parser parser = new Parser();

        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            System.out.println(parser.isBalanced(in.next()));
        }

        in.close();
    }
}

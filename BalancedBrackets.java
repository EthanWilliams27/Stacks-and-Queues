import java.util.Stack;
public class BalancedBrackets {
    public static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return "No";
                }
                char top = stack.pop();
                if ((c == '}' && top != '{') || (c == ']' && top != '[') || (c == ')' && top != '(')) {
                    return "No";
                }
            }
        }

        return stack.isEmpty() ? "YES" : "NO";
    }
    public static void main(String[] args) {
        String s = "{}[)[]";
        System.out.println(isBalanced(s));
    }
}
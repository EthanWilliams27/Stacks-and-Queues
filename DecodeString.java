import java.util.Stack;

public class DecodeString {

    public static String decodeString(String s) {
        Stack<Integer> counts = new Stack<>();
        Stack<String> result = new Stack<>();
        String currentString = "";
        int count = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                count = count * 10 + (c - '0');
            } else if (c == '[') {
                counts.push(count);
                result.push(currentString);
                currentString = "";
                count = 0;
            } else if (c == ']') {
                String decodedString = currentString;
                currentString = result.pop();
                int repeatCount = counts.pop();

                for (int i = 0; i < repeatCount; i++) {
                    currentString += decodedString;
                }
            } else {
                currentString += c;
            }
        }

        return currentString;
    }
}

class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0, result = 0, sign = 1;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '+') {
                result += sign * num;
                num = 0;
                sign = 1;
            } else if (ch == '-') {
                result += sign * num;
                num = 0;
                sign = -1;
            } else if (ch == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (ch == ')') {
                result += sign * num;
                num = 0;
                result *= stack.pop(); // sign
                result += stack.pop(); // previous result
            }
        }

        result += sign * num;
        return result;
    }
}

package idusw.dsa.Reo261112;

import java.util.Stack;

public class PostfixEval {
    public static void main(String[] args) {
        String postfix = "700 3 47 + 6  * - 4 /";
        System.out.println("input string " + postfix);
        int answer = evaluate(postfix);
        System.out.println("answer : " + answer);
    }

    private static int evaluate(String p) {
        int A, B;
        Stack<Integer> s = new Stack<>();
        boolean digitPreviously = false;

        for(int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);;
            if (Character.isDigit(ch)) {
                if (digitPreviously) {
                    int tmp = s.pop();
                    tmp = 10 * tmp + (ch - '0');
                    s.push(tmp);
                } else {
                    s.push(ch - '0');
                }
                digitPreviously = true;
            }
            else if (isOperator(ch)) {
                if (s.size() < 2) {
                    throw new IllegalArgumentException("잘못된 후기 표기식 입니다.");
                }
                A = s.pop();
                B = s.pop();

                if (ch == '/' && A == 0) {
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                }
                int val = operation(A, B, ch);
                s.push(val);
                digitPreviously = false;
            } else if (ch == ' '){
                digitPreviously = false;
            } else {
                throw new IllegalArgumentException("잘못된 문자입니다.");
            }
        }
        return s.pop();
    }


    private static int operation(int a, int b, char op) {
        int val = 0;
        switch(op) {
            case '+':
                val = b + a;
                break;

            case '-':
                val = b - a;
                break;

            case '*':
                val = b * a;
                break;

            case '/':
                val = b / a;
                break;
        }
        return val;
    }

    private static boolean isOperator(char ch ){
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }
}

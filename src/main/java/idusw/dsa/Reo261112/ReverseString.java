package idusw.dsa.Reo261112;

import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        char[] charArray = {'C', 'O', 'M', 'S', 'O' };
        char[] reversedChar = new char[charArray.length];

        for(int i =0; i < charArray.length; i++) {
            reversedChar[i] = charArray[charArray.length - i - 1];

        }

        for(int i = 0; i < reversedChar.length; i++) {
            System.out.print(reversedChar[i]);
        }
        System.out.println();

        String input = "Induk University";
        String reversed = new ReverseString().reverse(input);
        System.out.println(input + "을 순서뒤집기를 하면 : " + reversed);
    }

    public static String reverse(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        String output = "";
        while (!stack.isEmpty()) {
            output += stack.pop();

        }

        return output;

    }

}

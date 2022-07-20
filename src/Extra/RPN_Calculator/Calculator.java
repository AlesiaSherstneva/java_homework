package Extra.RPN_Calculator;

import java.util.Stack;

public class Calculator {
    public static String expressionToRPN(String expression) {
        String current = "";
        Stack<Character> stack = new Stack<>();
        int priority;

        for (int i = 0; i < expression.length(); i++) {
            char symbol = expression.charAt(i);
            priority = getPriority(symbol);
            if (priority == 0) current += symbol;
            if (priority == 1) stack.push(symbol);
            if (priority > 1) {
                current += " ";
                //проверка на унарный минус
                if (symbol == '-' && (i == 0 || expression.charAt(i-1) == '(')) {
                    //отделяем унарный минус от бинарного, преобразуя его в значок "тильда"
                    symbol = '~';
                }
                while (!stack.empty()) {
                    if (getPriority(stack.peek()) >= priority) current += stack.pop();
                    else break;
                }
                stack.push(symbol);
            }
            if (priority == -1) {
                current += " ";
                while (getPriority(stack.peek()) != 1) current += stack.pop();
                stack.pop();
            }
        }

        while (!stack.empty()) current += stack.pop();
        return current;
    }

    public static double RPNToAnswer(String rpn) {
        String operand = "";
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < rpn.length(); i++) {
            if (rpn.charAt(i) == ' ') continue;
            if (getPriority(rpn.charAt(i)) == 0) {
                while (rpn.charAt(i) != ' ' && getPriority(rpn.charAt(i)) == 0) {
                    operand += rpn.charAt(i++);
                    if (i == rpn.length()) break;
                }
                stack.push(Double.parseDouble(operand));
                operand = "";
            }

            if (getPriority(rpn.charAt(i)) > 1) {
                if (rpn.charAt(i) == '~') {
                    stack.push(stack.empty() ? 0 : -stack.pop());
                    continue;
                }
                double a = stack.pop(), b = stack.pop();
                if (rpn.charAt(i) == '+') stack.push(b + a);
                if (rpn.charAt(i) == '-') stack.push(b - a);
                if (rpn.charAt(i) == '*') stack.push(b * a);
                if (rpn.charAt(i) == '/') stack.push(b / a);
            }
        }
        return stack.pop();
    }

    public static int getPriority(char symbol) {
        if (symbol == '~') return 4; // унарный минус
        else if (symbol == '*' || symbol == '/') return 3;
        else if (symbol == '+' || symbol == '-') return 2;
        else if (symbol == '(') return 1;
        else if (symbol == ')') return -1;
        else return 0;
    }
}

package Extra.RPN_Calculator;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        String[] expressions = {"2+2*(3+4)", "72/12-8*(1+4)", "2*(3+2*(1+2*(1+3)))", "-5+(-20)*(-3)", "ABC"};
        for (String expression : expressions) {
            System.out.println(expression + " = " + calculator.calculate(expression));
        }
    }

    int calculate(String mathString) {
        return RPNToAnswer(expressionToRPN(mathString));
    }

    String expressionToRPN(String expression) {
        String current = "";
        Stack<Character> stack = new Stack<>();
        int priority;

        for (int i = 0; i < expression.length(); i++) {
            char symbol = expression.charAt(i);

            Pattern pattern = Pattern.compile("(\\d|~|\\*|/|\\+|-|\\(|\\))", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(String.valueOf(symbol));
            if (!matcher.find()) {
                throw new IllegalArgumentException("Illegal symbol in the expression!");
            }

            priority = getPriority(symbol);

            switch (priority) {
                case 0 -> current += symbol;
                case 1 -> stack.push(symbol);
                case 2, 3 -> {
                    {
                        current += " ";
                        //проверка на унарный минус
                        if (symbol == '-' && (i == 0 || expression.charAt(i - 1) == '(')) {
                            //отделяем унарный минус от бинарного, преобразуя его в значок "тильда"
                            symbol = '~';
                        }
                        while (!stack.empty()) {
                            if (getPriority(stack.peek()) >= priority) current += stack.pop();
                            else break;
                        }
                        stack.push(symbol);

                    }
                }
                case -1 -> {
                    current += " ";
                    while (getPriority(stack.peek()) != 1) current += stack.pop();
                    stack.pop();
                }
            }
        }

        while (!stack.empty()) current += stack.pop();
        return current;
    }

    int RPNToAnswer(String rpn) {
        String operand = "";
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < rpn.length(); i++) {

            if (rpn.charAt(i) == ' ') continue;
            if (getPriority(rpn.charAt(i)) == 0) {
                while (rpn.charAt(i) != ' ' && getPriority(rpn.charAt(i)) == 0) {
                    operand += rpn.charAt(i++);
                    if (i == rpn.length()) break;
                }
                stack.push(Integer.parseInt(operand));
                operand = "";
            }

            if (getPriority(rpn.charAt(i)) > 1) {
                if (rpn.charAt(i) == '~') {
                    stack.push(stack.empty() ? 0 : -stack.pop());
                    continue;
                }
                int a = stack.pop(), b = stack.pop();
                if (rpn.charAt(i) == '+') stack.push(b + a);
                if (rpn.charAt(i) == '-') stack.push(b - a);
                if (rpn.charAt(i) == '*') stack.push(b * a);
                if (rpn.charAt(i) == '/') stack.push(b / a);
            }
        }
        return stack.pop();
    }

    int getPriority(char symbol) {
        return switch (symbol) {
            case '~' -> 4;
            case '*', '/' -> 3;
            case '+', '-' -> 2;
            case '(' -> 1;
            case ')' -> -1;
            default -> 0;
        };
    }
}

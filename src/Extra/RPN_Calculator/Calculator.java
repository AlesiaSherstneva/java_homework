package Extra.RPN_Calculator;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private char symbol;
    private int priority;


    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        String[] expressions = {"2+2*(3+4)", null, "72/12-8*(1+4)", "", "2*(3+2*(1+2*(1+3)))", "ABC", "-5+(-20)*(-3)"};
        for (String expression : expressions) {
            if (expression == null || expression.isEmpty()) {
                System.out.println("The string has no expressions");
                continue;
            }
            Pattern pattern = Pattern.compile("(\\d|~|\\*|/|\\+|-|\\(|\\))", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(expression);
            if (!matcher.find()) {
                System.out.println("The string \"" + expression + "\" contains illegal symbol(s)");
                continue;
            }
            System.out.println(expression + " = " + calculator.calculate(expression));
        }
    }

    //этот метод требовался по условию задачи, через него шла проверка на платформе
    int calculate(String mathString) {
        return RPNToAnswer(expressionToRPN(mathString));
    }

    String expressionToRPN(String expression) {
        StringBuilder current = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            symbol = expression.charAt(i);
            priority = getPriority(symbol);

            switch (priority) {
                case 0 -> current.append(symbol);
                case 1 -> stack.push(symbol);
                case 2, 3 -> {
                    {
                        current.append(" ");
                        //проверка на унарный минус
                        if (symbol == '-' && (i == 0 || expression.charAt(i - 1) == '(')) {
                            //отделяем унарный минус от бинарного, преобразуя его в значок "тильда"
                            symbol = '~';
                        }
                        while (!stack.empty()) {
                            if (getPriority(stack.peek()) >= priority) current.append(stack.pop());
                            else break;
                        }
                        stack.push(symbol);

                    }
                }
                case -1 -> {
                    current.append(" ");
                    while (getPriority(stack.peek()) != 1) current.append(stack.pop());
                    stack.pop();
                }
            }
        }

        while (!stack.empty()) current.append(stack.pop());
        return current.toString();
    }

    int RPNToAnswer(String rpn) {
        StringBuilder operand = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < rpn.length(); i++) {
            symbol = rpn.charAt(i);
            if (symbol == ' ') continue;

            priority = getPriority(symbol);
            if (priority == 0) {
                while (rpn.charAt(i) != ' ' && getPriority(rpn.charAt(i)) == 0) {
                    operand.append(rpn.charAt(i++));
                    if (i == rpn.length()) break;
                }
                stack.push(Integer.parseInt(operand.toString()));
                operand = new StringBuilder();
            } else {
                if (symbol == '~') {
                    /* "ловим" унарный минус, делаем следующее число отрицательным, если оно существует,
                    выходим из цикла и переходим к следующему символу */
                    stack.push(stack.empty() ? 0 : -stack.pop());
                    continue;
                }
                int a = stack.pop(), b = stack.pop();
                switch (symbol) {
                    case '+' -> stack.push(b + a);
                    case '-' -> stack.push(b - a);
                    case '*' -> stack.push(b * a);
                    case '/' -> stack.push(b / a);
                }
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

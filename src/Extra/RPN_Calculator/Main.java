package Extra.RPN_Calculator;

public class Main {
    public static void main(String[] args) {
        String expression = Calculator.expressionToRPN("2*(3+2*(1+2*(1+3)))");
        System.out.println(expression);
        System.out.println(Calculator.RPNToAnswer(expression));
    }
}

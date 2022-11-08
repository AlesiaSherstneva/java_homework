package Extra.Stack;

import java.util.ArrayList;

public class Stack {
    private final ArrayList<Integer> stack = new ArrayList<>();
    private int max = 0;
    private int min = 0;

    public void push(int value) {
        stack.add(value);
        if (stack.size() == 1) {
            max = value;
            min = value;
        } else if (value > max) {
            max = value;
        } else if (value < min) {
            min = value;
        }
    }

    @SuppressWarnings("UnusedReturnValue")
    public int pop() {
        int value = stack.remove(stack.size() - 1);
        if (stack.size() != 0) {
            min = stack.get(0);
            max = stack.get(0);
            for (Integer number : stack) {
                if (max < number) {
                    max = number;
                }
                if (min > number) {
                    min = number;
                }
            }
        } else {
            max = 0;
            min = 0;
        }
        return value;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.size() == 0;
    }

    @Override
    public String toString() {
        return  "stack=" + stack + ", stack is " + (isEmpty() ? "" : "not ") + "empty" + "\n" +
                "max = " + getMax() + ", min = " + getMin() + ", size = " + size() + "\n" +
                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
    }
}

class StackTest {
    public static void main(String[] args) {
        Stack stack = new Stack();
        System.out.println(stack);

        System.out.println("Push numbers: 10, 114, -9");
        stack.push(10);
        stack.push(114);
        stack.push(-9);
        System.out.println(stack);

        System.out.println("Pop first numbers");
        stack.pop();
        System.out.println(stack);

        System.out.println("Pop second number");
        stack.pop();
        System.out.println(stack);

        System.out.println("Pop last number");
        stack.pop();
        System.out.println(stack);
    }
}
package Credit.Exercise11;

public class Main {
    public static void main(String[] args) {
        final MyNewQueue queue = new MyNewQueue();
        System.out.println(queue.max());
        queue.push(10);
        queue.push(20);
        System.out.println(queue);
        System.out.println(queue.max());
        queue.push(55);
        queue.push(150);
        queue.push(330);
        System.out.println(queue);
        System.out.println(queue.max());
        queue.push(1);
        queue.push(542);
        queue.push(18);
        System.out.println(queue);
        System.out.println(queue.max());
        queue.push(25);
        queue.push(555);
        queue.push(556);
        queue.pop();
        System.out.println(queue);
        System.out.println(queue.max());
        queue.pop();
        queue.pop();
        queue.pop();
        queue.pop();
        System.out.println(queue);
        System.out.println(queue.max());

    }
}

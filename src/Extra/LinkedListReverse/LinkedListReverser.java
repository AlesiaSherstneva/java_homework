package Extra.LinkedListReverse;

public class LinkedListReverser {
    public static void main(String[] args) {
        //TODO: write testing code 04-07-2022
    }

    Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next;
        while (current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }

    interface Node {
        Node getNext();

        void setNext(Node next);
    }
}

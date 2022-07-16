package Extra.LinkedListMerge;

public class LinkedListMerger {
    public static void main(String[] args) {
        Node head1 = new Node(1,
                new Node(2,
                        new Node(5,
                                new Node(7,
                                        new Node(10, null)))));

        Node head2 = new Node(1,
                new Node(1,
                        new Node(4,
                                new Node(8, null))));

        System.out.print("Sample input 1:\n  ");
        System.out.println(head1 + "\n  " + head2);

        LinkedListMerger merger = new LinkedListMerger();

        System.out.print("Sample output 1:\n  ");
        System.out.println(merger.merge(head1, head2));

        head1 = new Node(1,
                    new Node(2,
                        new Node(4,
                                new Node(5,
                                        new Node(6, null)))));
        head2 = new Node(7,
                    new Node(8,
                        new Node(9,
                                new Node(10, null))));

        System.out.print("Sample input 2:\n  ");
        System.out.println(head1 + "\n  " + head2);

        System.out.print("Sample output 2:\n  ");
        System.out.println(merger.merge(head1, head2));

    }

    Node merge(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        Node head;
        if (head1.getData() < head2.getData()) {
            head = head1;
            head.setNext(merge(head1.getNext(), head2));
        } else {
            head = head2;
            head.setNext(merge(head1, head2.getNext()));
        }
        return head;
    }

    @SuppressWarnings("unused")
    static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();

            // из-за особенностей структуры класса, первому и последнему элементу "особое приглашение" нужно :-)

            result.append(data);

            Node temp = next;
            while (temp.getNext() != null) {
                result.append(" ").append(temp.getData());
                temp = temp.getNext();
            }

            result.append(" ").append(temp.getData());

            return String.valueOf(result);
        }
    }
}

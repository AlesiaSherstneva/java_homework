package Extra.Huffman;

public class Node implements Comparable<Node> {
    String value;
    long priority;
    Node left;
    Node right;

    public Node(String value, long priority) {
        this.value = value;
        this.priority = priority;
    }

    public Node(long priority, Node left, Node right) {
        this.priority = priority;
        this.left = left;
        this.right = right;
    }

    @Override
    public int compareTo(Node o) {
        return Long.compare(this.priority, o.priority);
    }
}
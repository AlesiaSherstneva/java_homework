package Extra.TreeLeafCount;

import java.util.Stack;

@SuppressWarnings("unused")
public class Node {
    private final int value;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int treeLeafCount() {
        Stack<Node> stack = new Stack<>();
        stack.push(this);

        int count = 0;

        while(!stack.empty()) {
            Node node = stack.pop();
            if(node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null) {
                stack.push(node.left);
            }
            if(node.left == null && node.right == null) {
                count++;
            }
        }
        return count;
    }
}

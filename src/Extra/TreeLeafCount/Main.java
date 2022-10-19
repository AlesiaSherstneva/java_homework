package Extra.TreeLeafCount;

public class Main {
    public static void main(String[] args) {
        Node Tree =
                new Node(20,
                        new Node(7,
                                new Node(4, null, new Node(6)), new Node(9)),
                        new Node(35,
                                new Node(31, new Node(28), null),
                                new Node(40, new Node(38), new Node(52))));
        System.out.println("В этом дереве " + Tree.treeLeafCount(Tree) + " листьев");
    }
}

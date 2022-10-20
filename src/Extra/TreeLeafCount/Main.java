package Extra.TreeLeafCount;

public class Main {
    public static void main(String[] args) {
        Node firstTree =
                new Node(50,
                        new Node(17,
                                new Node(12,
                                        new Node(9), new Node(14)),
                                new Node(23, null, new Node(19))),
                        new Node(72,
                                new Node(54,
                                        null, new Node(67)),
                                new Node(76)));
        System.out.println("В первом дереве " + firstTree.treeLeafCount() + " листьев");

        Node secondTree =
                new Node(9,
                        new Node(6,
                                new Node(3,
                                        new Node(1,
                                                null, new Node(2)),
                                        new Node(4, null, new Node(5))),
                                new Node(8, new Node(7), null)),
                        new Node(17,
                                new Node(16,
                                        new Node(12,
                                                new Node(11,
                                                        new Node(10), null),
                                                new Node(14,
                                                        new Node(13), new Node(15))), null),
                                new Node(20,
                                        new Node(19,
                                                new Node(18), null),
                                        new Node(21))));
        System.out.println("Во втором дереве " + secondTree.treeLeafCount() + " листьев");

        Node thirdTree = new Node(4, null,
                new Node(7, null,
                        new Node(16, null,
                                new Node(20, null,
                                        new Node(37, null,
                                                new Node(38, null,
                                                        new Node(43)))))));
        System.out.println("В третьем дереве " + thirdTree.treeLeafCount() + " листьев");
    }
}

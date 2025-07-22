package Extra.Huffman;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Huffman {
    public static void main(String[] args) {
        String[] stringsForCode = {"a", "abacabad", "accepted"};

        for (String stringForCode: stringsForCode) {
            String[] input = stringForCode.split("");
            Map<String, Long> symbols = Arrays.stream(input)
                    .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

            PriorityQueue<Node> pq = new PriorityQueue<>();
            symbols.forEach((k, v) -> pq.add(new Node(k, v)));

            while (pq.size() > 1) {
                Node left = Objects.requireNonNull(pq.poll());
                Node right = Objects.requireNonNull(pq.poll());

                pq.add(new Node(left.priority + right.priority, left, right));
            }

            Node root = Objects.requireNonNull(pq.poll());
            Map<String, String> results = new HashMap<>();

            if (root.left == null && root.right == null) {
                results.put(root.value, "0");
            } else {
                generateCodes(root, "", results);
            }

            StringBuilder encodedString = new StringBuilder();
            Arrays.stream(input).forEach(s -> encodedString.append(results.get(s)));

            System.out.printf("\nOriginal string: %s\nNumber of original symbols: %d\nLength of the encoded string: %d\n",
                    stringForCode, results.size(), encodedString.length());
            System.out.println("Letters codes:");
            results.forEach((k, v) -> System.out.printf("%s: %s\n", k, v));
            System.out.printf("Encoded string: %s\n", encodedString);
        }
    }

    private static void generateCodes(Node node, String code, Map<String, String> codes) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            codes.put(node.value, code);
            return;
        }
        generateCodes(node.left, String.format("%s0", code), codes);
        generateCodes(node.right, String.format("%s1", code), codes);
    }
}
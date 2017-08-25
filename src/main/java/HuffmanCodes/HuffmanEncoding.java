package HuffmanCodes;

import java.util.*;
import java.util.stream.Collectors;

public class HuffmanEncoding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        huffmanEncode(input);
    }

    private static void huffmanEncode(String input) {
        Map<Character, Integer> frequencies = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            int frequency = frequencies.getOrDefault(c, 0);
            if (frequency != 0) {
                frequencies.put(c, frequency + 1);
            } else {
                frequencies.put(c, 1);
            }
        }

        Set<Node> nodeSet = frequencies
                .entrySet()
                .stream()
                .map(entry -> new Node(entry.getKey(), entry.getValue(), null, null))
                .collect(Collectors.toSet());

        List<Node> nodeList = new ArrayList<>();
        nodeList.addAll(nodeSet);
        nodeList.sort(Node::compareTo);


        HashMap<Character, String> codes = new HashMap<>();
        List<Node> x = buildTree(nodeList);

        buildCode(codes, x.get(0), "");
        if (codes.containsKey('1')) {
            codes.remove('1');
        }
        String encoded = encode(input, codes);

        System.out.println(codes.size() + " " + encoded.length());
        codes.forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println(encoded);


    }

    private static List<Node> buildTree(List<Node> nodes) {

        if (nodes.size() == 1) {
            nodes.add(new Node('1', 0 ,null, null));
        }
        int start = nodes.size() + 1;
        int finish = nodes.size() * 2 - 1;
        if (nodes.size() > 1) {
            for (int i = start; i <= finish; i++) {
                Node right = nodes.remove(0);
                Node left = nodes.remove(0);
                Node parent = new Node('\0', right.frequency + left.frequency, left, right);
                nodes.add(parent);
                nodes.sort(Node::compareTo);
            }
        }


        return nodes;
    }

    private static void buildCode(HashMap<Character, String> codes, Node node, String currentCode) {
        if (!node.isLeaf()) {
            buildCode(codes, node.left, currentCode + "0");
            buildCode(codes, node.right, currentCode + "1");
        } else {
            codes.put(node.aChar, currentCode);
        }
    }

    private static String encode(String input, HashMap<Character, String> codes) {

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            builder.append(codes.get(input.charAt(i)));

        }
        return builder.toString();
    }

    private static class Node {
        private final char aChar;
        private final int frequency;
        private final Node left;
        private final Node right;

        public Node(char aChar, int frequency, Node left, Node right) {
            this.aChar = aChar;
            this.frequency = frequency;
            this.left = left;
            this.right = right;
        }

        private boolean isLeaf() {
            return left == null && right == null;
        }

        public int compareTo(Node node) {
            return this.frequency - node.frequency;
        }

        @Override
        public String toString() {
            return "\nNode{" +
                    "aChar=" + aChar +
                    ", frequency=" + frequency +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}

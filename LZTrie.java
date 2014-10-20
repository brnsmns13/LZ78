public class LZTrie {
    private Node root;
    private int code;

    public LZTrie() {
        code = 0;
        root = new Node("", code++);
    }

    public int add(String s) {
        return root.add(s);
    }

    public boolean contains(String s) {
        return root.contains(s);
    }

    public Node findNode(String s) {
        return root.findNode(s);
    }
}

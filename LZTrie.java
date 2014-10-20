public class LZTrie {
    private Node root;
    private int code;

    public LZTrie() {
        code = 0;
        root = new Node(' ', code++);
    }

    public int add(String s) {
        root.add(s, code);
        code += s.length();
        return code;
    }

    public boolean contains(String s) {
        return root.contains(s);
    }

    public Node findNode(String s) {
        return root.findNode(s);
    }

    public void traverse() {
        root.traverse();
    }
}

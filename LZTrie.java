public class LZTrie {
    private Node root;
    private int code;

    public LZTrie() {
        code = 0;
        root = new Node('\0', code++, -1);
    }

    public int add(String s) {
        int new_code = root.add(s, code, 0);
        if (new_code > code) {
            code = new_code;
        }
        return new_code;
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

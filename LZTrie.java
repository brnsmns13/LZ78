public class LZTrie {
    private Node root;
    private int code;
    private int count;

    public LZTrie() {
        code = 0;
        count = 0;
        root = new Node('\0', count++, -1);
    }

    public int add(String s) {
        Node n = root.addNew(s, count++, 0);
        return n.code;
    }

    public Node addNew(String s) {
        Node n = root.addNew(s, count++, 0);
        return n;
    }

    public boolean contains(String s) {
        return root.contains(s);
    }

    public Node findNode(String s) {
        return root.findNode(s);
    }

    public Node findNode(int code) {
        return root.findNode(code);
    }

    public int getIndex() {
        return count;
    }

    public String insert(char data, int p) {
        String s = root.insert(data, count++, p);
        return s;
    }

    public void traverse() {
        root.traverse();
    }
}

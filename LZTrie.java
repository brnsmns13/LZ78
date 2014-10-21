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
        // int new_code = root.add(s, code, 0);
        // if (new_code > code) {
        //     code = new_code;
        // }
        // return new_code;
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

    public void traverse() {
        root.traverse();
    }
}

import java.util.List;
import java.util.ArrayList;

public class Node {
    char data;
    int code;
    List<Node> children;

    public Node(char d, int c) {
        data = d;
        code = c;
        children = new ArrayList<Node>();
    }

    public int add(String s, int c) {
        char first = s.charAt(0);
        Node n = new Node(first, c);
        children.add(n);
        if (s.length() > 1) {
            c = n.add(s.substring(1), c++);
        }
        return c;
    }

    public Node findNode(String s) {
        char first = s.charAt(0);
        for (Node child : children) {
            if (child.data == first) {
                if (s.length() > 1) {
                    return child.findNode(s.substring(1));
                } else {
                    return this;
                }
            }
        }
        return null;
    }

    public boolean contains(String s) {
        Node n = findNode(s);
        return !(n == null);
    }
}

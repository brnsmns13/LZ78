import java.util.List;
import java.util.ArrayList;

public class Node {
    char data;
    int code;
    int parent_code;
    List<Node> children;

    public Node(char d, int c, int p) {
        data = d;
        code = c;
        parent_code = p;
        children = new ArrayList<Node>();
    }

    public int add(String s, int c, int p) {
        char first = s.charAt(0);
        if (s.length() > 1) {
            for (Node child : children) {
                if (child.data == first) {
                    return child.add(s.substring(1), c++, this.code);
                }
            }
        } else if (s.length() == 1) {
            for (Node child : children) {
                if (child.data == first) {
                    return child.code;
                }
            }
            Node n = new Node(first, c++, this.code);
            children.add(n);
            return c;
        }
        Node n = new Node(first, c++, this.code);
        children.add(n);
        if (s.length() > 1) {
            return n.add(s.substring(1), c++, this.code);
        }
        return c;
    }

    public Node addNew(String s, int c, int p) {
        char first = s.charAt(0);
        if (s.length() > 1) {
            for (Node child : children) {
                if (child.data == first) {
                    return child.addNew(s.substring(1), c, this.code);
                }
            }
        } else if (s.length() == 1) {
            for (Node child : children) {
                if (child.data == first) {
                    return child;
                }
            }
            Node n = new Node(first, c, this.code);
            children.add(n);
            return n;
        }
        Node n = new Node(first, c, this.code);
        children.add(n);
        if (s.length() > 1) {
            return n.addNew(s.substring(1), c, this.code);
        }
        return n;
    }

    public Node findNode(String s) {
        char first = s.charAt(0);
        for (Node child : children) {
            if (child.data == first) {
                if (s.length() > 1) {
                    return child.findNode(s.substring(1));
                } else {
                    return child;
                }
            }
        }
        return null;
    }

    public Node findNode(int c) {
        if (c == this.code) {
            return this;
        }
        for (Node child : children) {
            if (child.code == c) {
                return child;
            } else {
                Node n = child.findNode(c);
                if (n != null) {
                    return n;
                }
            }
        }
        return null;
    }

    public String insert(int code, char data) {
        return "";
    }

    public boolean contains(String s) {
        Node n = findNode(s);
        return !(n == null);
    }

    public void traverse() {
        String s = "P: " + Integer.toString(this.parent_code);
        s += "\tC: ";
        s += Integer.toString(this.code);
        s += "\tD: ";
        s += Character.toString(this.data);

        System.out.println(s);
        for (Node child : children) {
            child.traverse();
        }
    }
}

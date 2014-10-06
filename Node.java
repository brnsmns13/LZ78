import java.util.List;
import java.util.ArrayList;

public class Node {
    String data;
    Node parent;
    List<Node> children;

    public Node() {}

    public Node(String d, Node p) {
        parent = p;
        data = d;
        children = new ArrayList<Node>();
    }
}

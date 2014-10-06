public class LZ {
    public static String encode(String uncompressed) {
        Node n = new Node(uncompressed, null);
        return n.data;
    }

    public static String decode(String compressed) {
        return "";
    }
}

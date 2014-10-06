public class LZEncryption {
    public static String encode(String uncompressed) {
        Node n = new Node(uncompressed, null);

        // Loop through the uncompressed string and find patterns
        for (int i = 0; i < uncompressed.length(); i++) {
            char c = uncompressed.charAt(i);
            //System.out.println(c);
        }

        return n.data;
    }

    public static String decode(String compressed) {
        return "";
    }
}

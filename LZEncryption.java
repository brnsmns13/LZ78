public class LZEncryption {
    public static String encode(String uncompressed) {
        int start = 0;
        int end = 1;
        int code = 0;
        LZTrie trie = new LZTrie();
        String compressed = "";

        while (end <= uncompressed.length()) {
            String sub = uncompressed.substring(start, end);
            if (!trie.contains(sub)) {
                Node n = trie.addNew(sub);
                compressed += Integer.toString(n.parent_code) + n.data;
                start = end;
            } else if (end == uncompressed.length() && trie.contains(sub)) {
                Node n = trie.findNode(sub);
                compressed += Integer.toString(n.code);
            }
            end++;
        }
        return compressed;
    }

    public static String decode(String compressed) {
        LZTrie trie = new LZTrie();
        String s = Binary.FromBinary(compressed);
        for (int i = 0; i < s.length(); i += 2) {
            String sub = "";
        }
        return "";
    }
}

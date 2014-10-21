public class LZEncryption {
    public static String encode(String uncompressed) {
        int start = 0;
        int end = 1;
        int code = 0;
        LZTrie trie = new LZTrie();

        while (end <= uncompressed.length()) {
            String sub = uncompressed.substring(start, end);
            if (!trie.contains(sub)) {
                Node n = trie.addNew(sub);
                System.out.println(Integer.toString(n.parent_code) + n.data);
                start = end;
            } else if (end == uncompressed.length() && trie.contains(sub)) {
                Node n = trie.findNode(sub);
                System.out.println(Integer.toString(n.code));
            }
            end++;
        }
        trie.traverse();
        return "";
    }

    public static String decode(String compressed) {
        return "";
    }
}

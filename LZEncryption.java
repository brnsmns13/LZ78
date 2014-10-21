public class LZEncryption {
    public static String encode(String uncompressed) {
        int start = 0;
        int end = 1;
        int code = 0;
        LZTrie trie = new LZTrie();

        while (end < uncompressed.length()) {
            String sub = uncompressed.substring(start, end);
            if (!trie.contains(sub)) {
                code = trie.add(sub);
                start = end;
                end += sub.length();
            } else {
                end++;
            }
        }
        trie.traverse();
        return "";
    }

    public static String decode(String compressed) {
        return "";
    }
}

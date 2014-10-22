public class LZEncryption {
    public static String encode(String uncompressed) {
        int start = 0;
        int end = 1;
        int code = 0;
        LZTrie trie = new LZTrie();
        String trie_string = "";

        while (end <= uncompressed.length()) {
            String sub = uncompressed.substring(start, end);
            if (!trie.contains(sub)) {
                Node n = trie.addNew(sub);
                trie_string += Integer.toString(n.parent_code) + n.data;
                start = end;
            } else if (end == uncompressed.length() && trie.contains(sub)) {
                Node n = trie.findNode(sub);
                trie_string += Integer.toString(n.code);
            }
            end++;
        }

        int index = trie.getIndex();
        int num_bits = Integer.toBinaryString(index).length();
        String compressed = "";
        String leading_data = String.format("%32s", Integer.toBinaryString(num_bits)).replace(' ', '0');

        System.out.println("Starting binary conversion: " + trie_string);
        for (int i = 0; i < trie_string.length(); i += 2) {
            int code_int = trie_string.charAt(i) - '0';
            int v = -1;
            if ((i + 1) >= trie_string.length()) {
                v = code_int;
            } else {
                v = Character.getNumericValue(trie_string.charAt(i + 1));
            }

            String code_word = String.format("%" + num_bits + "s", Integer.toBinaryString(code_int)).replace(' ', '0');
            String data = String.format("%16s", Integer.toBinaryString(v)).replace(' ', '0');
            compressed += code_word;
            compressed += data;
            System.out.println("Code: " + Integer.toString(code_int) + code_word + "\tData: " + data);
        }
        System.out.println("End binary conversion");
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

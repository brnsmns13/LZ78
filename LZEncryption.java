import java.util.ArrayList;

public class LZEncryption {
    public static String encode(String uncompressed) {
        int start = 0;
        int end = 1;
        int code = 0;
        LZTrie trie = new LZTrie();
        String trie_string = "";
        ArrayList<Node> node_list = new ArrayList<Node>();

        while (end <= uncompressed.length()) {
            String sub = uncompressed.substring(start, end);
            if (!trie.contains(sub)) {
                Node n = trie.addNew(sub);
                node_list.add(n);
                trie_string += Integer.toString(n.parent_code) + n.data;
                start = end;
            } else if (end == uncompressed.length() && trie.contains(sub)) {
                Node n = trie.findNode(sub);
                Node final_node = new Node(true, n.code, n.parent_code);
                node_list.add(final_node);
                trie_string += Integer.toString(n.code);
            }
            end++;
        }

        int index = trie.getIndex();
        int num_bits = Integer.toBinaryString(index).length();
        String leading_data = String.format("%32s", Integer.toBinaryString(num_bits)).replace(' ', '0');
        String compressed = leading_data;

        for (Node n : node_list) {
            int codeword = n.parent_code;
            char data = n.data;
            String code_string = String.format("%"+num_bits+"s", Integer.toBinaryString(codeword)).replace(' ', '0');
            String data_string = String.format("%16s", Integer.toBinaryString(data)).replace(' ', '0');
            compressed += code_string;
            if (n.isLast() == false) {
                compressed += data_string;
            }
        }
        int pad = 16 - (compressed.length() % 16);
        String pad_string = String.format("%"+pad+"s", "0").replace(' ', '0');
        compressed += pad_string;
        return compressed;
    }

    public static String decode(String compressed) {
        LZTrie trie = new LZTrie();
        String final_string = "";
        int insert_count = 1;
        int code_length = Integer.parseInt(compressed.substring(0,32), 2);
        int info_size = code_length + 16;
        compressed = compressed.substring(32);
        int i = 0;
        for (i = 0; i+info_size < compressed.length(); i += info_size) {
            String sub = compressed.substring(i, (i + info_size));
            int codeword = Integer.parseInt(sub.substring(0, code_length), 2);
            char data = (char)Integer.parseInt(sub.substring(code_length, info_size), 2);
            final_string += trie.insert(data, codeword);
        }
        return final_string;
    }
}

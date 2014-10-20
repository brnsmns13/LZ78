public class LZTest {
    public static void main(String[] Args) {

        String test_str = "Sugar! Sugar! Sugar! Sugar! Sugar! Sugar!";
        String expected = "000000000000000000000000000001010000000000000010100";
        expected += "110000000000000011101010000000000000011001110000000000000";
        expected += "011000010000000000000011100100000000000000001000010000000";
        expected += "000000001000000000100000000011101010001100000000011000010";
        expected += "010100000000001000010011100000000010100110001000000000011";
        expected += "001110010000000000011100100011000000000001000000100000000";
        expected += "000011001110110100000000001000010101100000000011101010100";
        expected += "100000000011100100111000000000010100110110000000000011000";
        expected += "010101000000000001000000111100000000011000011010100000000";
        expected += "0101001110100000000000111001000110000";

        LZTrie trie = new LZTrie();

        int c = trie.add("Hello");

        System.out.println(c);

        // System.out.println("LZEncryption Output");
        // String encoded = LZEncryption.encode(test_str);
        // System.out.println(encoded);
        //
        // System.out.println("\nExpected Output");
        // System.out.println(expected);
    }
}

public class LZTest {
    public static void main(String[] Args) {

        String test_str = "AAAAAAAAAAAAAAAAAABBBBAAAAAAAAAAABBB";

        System.out.println("LZEncryption Output");
        String encoded = LZEncryption.encode(test_str);
        System.out.println(encoded);

        System.out.println("\nExpected Output");
        System.out.println(LZ77.compressStr(test_str));
    }
}

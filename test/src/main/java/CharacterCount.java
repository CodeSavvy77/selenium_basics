public class CharacterCount {
    public static void main(String[] args) {
        // Example input string
        String input = "hello world";

        // Array to store the frequency of characters
        int[] freq = new int[256]; // Assuming ASCII characters

        // Iterate over the characters in the string
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != ' ') { // Ignore spaces (optional)
                freq[c]++;
            }
        }

        // Display the character counts
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                System.out.println((char) i + ": " + freq[i]);
            }
        }
    }
}

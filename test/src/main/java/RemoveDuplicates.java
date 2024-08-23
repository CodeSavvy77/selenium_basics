public class RemoveDuplicates {
    public static void main(String[] args) {
        String input = "hello world";

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (result.indexOf(String.valueOf(c)) == -1) {
                result.append(c);
            }
        }

        System.out.println("Original String: " + input);
        System.out.println("String after removing duplicates: " + result);
    }
}

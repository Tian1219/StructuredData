package Week1;

public class CaesarCipher {

    public String encrypt(String input, int key) {
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);

            if (currChar != -1) {
                if (Character.isUpperCase(currChar)) {
                    String alphabet_shiftedUpper = alphabet.substring(key);
                    alphabet_shiftedUpper = alphabet_shiftedUpper + alphabet.substring(0, key);
                    int idx = alphabet.indexOf(currChar);
                    char newchar = alphabet_shiftedUpper.charAt(idx);
                    encrypted.setCharAt(i, newchar);

                }
                if (Character.isLowerCase(currChar)) {
                    String alphabet_low = alphabet.toLowerCase();
                    String alphabet_shifteLower = alphabet_low.substring(key);
                    alphabet_shifteLower = alphabet_shifteLower + alphabet_low.substring(0, key);
                    int idx = alphabet_low.indexOf(currChar);
                    char newchar = alphabet_shifteLower.charAt(idx);
                    encrypted.setCharAt(i, newchar);


                }
            }
        }
        return encrypted.toString();
    }

    public char encryptChar(char input, int key) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        if (input != -1) {
            if (Character.isUpperCase(input)) {
                String shifted = alphabet.substring(key);
                shifted = shifted + alphabet.substring(0, key);

                int currIndex = alphabet.indexOf(input);
                char encrypted = shifted.charAt(currIndex);
                return encrypted;
            }

            if (Character.isLowerCase(input)) {
                String alphabet_low = alphabet.toLowerCase();
                String shifted = alphabet_low.substring(key);
                shifted = shifted + alphabet_low.substring(0, key);

                int currIndex = alphabet_low.indexOf(input);
                char encrypted = shifted.charAt(currIndex);
                return encrypted;
            }

        }
        return input;
    }

    public String encryptTwoKeys(String input, int key1, int key2) {
        StringBuilder encrypted = new StringBuilder(input);
        for (int i = 0; i < input.length(); i++) {
            if ((i + 1) % 2 == 0) {
                char currChar = input.charAt(i);
                char encrChar = encryptChar(currChar, key2);
                encrypted.setCharAt(i, encrChar);

            }
            if ((i + 1) % 2 != 0) {
                char currChar = input.charAt(i);
                char encrChar = encryptChar(currChar, key1);
                encrypted.setCharAt(i, encrChar);
            }
        }
        return encrypted.toString();
    }

}

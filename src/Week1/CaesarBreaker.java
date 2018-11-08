package Week1;

public class CaesarBreaker {

    public int[] countLetters(String message) {
        String alph = "abcdefghijklmnoqprstuvwxyz";
        int[] counts = new int[26];
        for (int i = 0; i < message.length(); i++) {
            char ch = Character.toLowerCase(message.charAt(i));
            int dex = alph.indexOf(ch);
            if (dex != -1) {
                counts[dex] += 1;
            }
        }
        return counts;
    }

    public int maxIndex(int[] vals) {
        int maxDex = 0;
        for (int i = 0; i < vals.length; i++) {
            if (vals[i] > vals[maxDex]) {
                maxDex = i;
            }
        }
        return maxDex;
    }

    public String decrypt(String encrypted) {
        CaesarCipher cc = new CaesarCipher();
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if (dkey < 0) dkey = 26 - (4 - maxDex);
        return cc.encrypt(encrypted, 26 - dkey);
    }

    public String halfOfString(String message, int start) {
        StringBuilder half = new StringBuilder();
        for (int i = 0; i < message.length(); i += 2) {
            char a = message.charAt(i);
            half.append(a);
        }
        return half.toString();
    }
}

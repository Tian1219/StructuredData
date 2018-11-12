package Week1;

import edu.duke.FileResource;

import javax.lang.model.element.NestingKind;

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
        String empty0 = "";
        String empty1 = "";
        for (int i = 0; i < message.length(); i++) {
            if (i % 2 == 0) {
                empty0 = empty0 + message.charAt(i);
            } else empty1 = empty1 + message.charAt(i);
        }

        if (start == 0) return empty0;
        else return empty1;
    }

    public int getKey(String s) {
        int[] freqs = countLetters(s);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if (dkey < 0) {
            dkey = 26 - (4 - maxDex);
        }
        return dkey;
    }

    public String decrypTwoKeys(String s) {
        CaesarCipher cc = new CaesarCipher();
        String firstHalf = halfOfString(s, 0);
        String secondHalf = halfOfString(s, 1);
        int getkey1 = getKey(firstHalf);
        int getkey2 = getKey(secondHalf);
        System.out.println(getkey1 + " " + getkey2);

        String newString1 = cc.encrypt(firstHalf, 26 - getkey1);
        String newString2 = cc.encrypt(secondHalf, 26 - getkey2);
        StringBuilder sb = new StringBuilder(newString1 + newString2);

        for (int i = 0; i < newString1.length(); i++) {
            sb.setCharAt(2 * i, newString1.charAt(i));
        }

        for (int i = 0; i < newString2.length(); i++) {
            sb.setCharAt(i * 2 + 1, newString2.charAt(i));
        }
        return sb.toString();
    }

    public void testdecryptTwoKeys() {
        CaesarCipher cc = new CaesarCipher();
        FileResource fr = new FileResource();
        String encrypted = fr.asString();
        System.out.println(decrypTwoKeys(encrypted));
    }

    }

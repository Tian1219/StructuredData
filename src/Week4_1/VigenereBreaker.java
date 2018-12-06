package Week4_1;

import Week4_1.VigenereCipher;

import java.util.*;

import edu.duke.*;

public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        //REPLACE WITH YOUR CODE
        String slice = "";
        for (int i = whichSlice; i < message.length(); i += totalSlices) {
            char letter = message.charAt(i);
            slice += letter;
        }
        return slice;
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        //WRITE YOUR CODE HERE
        for (int i = 0; i < klength; i++) {
            String sliced = sliceString(encrypted, i, klength);
            CaesarCracker cc = new CaesarCracker(mostCommon);
            key[i] = cc.getKey(sliced);
        }
        return key;
    }

    public HashSet<String> readDictionary(FileResource fr) {
        HashSet<String> dictionaryWords = new HashSet<>();
        for (String line : fr.lines()) {
            line = line.toLowerCase();
            dictionaryWords.add(line);
        }
        return dictionaryWords;
    }

    public int countWords(String message, HashSet<String> dictionary) {
        int realWords = 0;

        String[] words = message.split("\\w+");
        for (String word : words) {
            if (dictionary.contains(word)) {
                realWords++;
            }
        }
        return realWords;
    }

    public String breakForLanguage(String encrypted, HashSet<String> dictionary) {
        int maxRealWords = 0;
        int finalKeyLength = 1;
        String decryptionWithMostRealWords = "";

        // Find the most common char in the dictionary
        char mostCommonChar = mostCommonChaIn(dictionary);
        System.out.println("The most common character in the dictionary is " + mostCommonChar);

        for (int keylength = 1; keylength <= 100; keylength++) {
            int[] key = tryKeyLength(encrypted, keylength, 'e');
            VigenereCipher vc = new VigenereCipher(key);
            String decrypted = vc.decrypt(encrypted);

            int realWord = countWords(decrypted, dictionary);
            if (realWord > maxRealWords) {
                maxRealWords = realWord;
                decryptionWithMostRealWords = decrypted;
                finalKeyLength = keylength;
            }
        }
        System.out.println("Message contains " + maxRealWords + " valid words");
        System.out.println("Message decoded with keylength of " + finalKeyLength);
        return decryptionWithMostRealWords;
    }


   /* public void breakVigenere() {

        FileResource dictFile = new FileResource("dictionaries/English");
        HashSet<String> dictionary = readDictionary(dictFile);
        FileResource fr = new FileResource("athens_keyflute.txt");
        String message = fr.asString();
        String decrypted = breakForLanguage(message, dictionary);
        System.out.println(decrypted);
    }*/
   public void breakVigenere(){
       HashMap<String,HashSet<String>> languages = new HashMap<>();
       String[] dictionaries = new String[8];
       dictionaries[0] = "Danish";
       dictionaries[1] = "Dutch";
       dictionaries[2] = "English";
       dictionaries[3] = "French";
       dictionaries[4] = "German";
       dictionaries[5] = "Italian";
       dictionaries[6] = "Portuguese";
       dictionaries[7] = "Spanish";

       for(int i =0 ; i<dictionaries.length; i++){
           String languageName =  dictionaries[i];
           FileResource dicFile = new FileResource("dictionaries/" + languageName);
           HashSet<String> dictionary = readDictionary(dicFile);
           languages.put(languageName,dictionary);
           System.out.println("Just added " + languageName);
       }
       FileResource fr = new FileResource("secretmessage3.txt");
       String message = fr.asString();
       breakForAllLanges(message, languages);


   }





    public char mostCommonChaIn(HashSet<String> dictionary) {
        HashMap<Character, Integer> charFreq = new HashMap<>();
        for (String word : dictionary) {
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!Character.isLetter(ch)) {
                    break;
                }
                if (charFreq.containsKey(ch)) {
                    charFreq.put(ch, charFreq.get(ch) + 1);
                } else {
                    charFreq.put(ch, 1);
                }
            }
        }
        char mostCommonChar = ' ';
        int maxCount = 0;
        for (char ch : charFreq.keySet()) {
            int freq = charFreq.get(ch);
            if (Character.isSpaceChar(mostCommonChar)) {
                mostCommonChar = ch;
                maxCount = freq;
            } else {
                if (freq > maxCount) {
                    mostCommonChar = ch;
                    maxCount = freq;
                }
            }
        }
        return mostCommonChar;

    }

    public void breakForAllLanges(String enctypyed, HashMap<String, HashSet<String>> languages) {

        for (String language : languages.keySet()) {
            HashSet<String> dictionary = languages.get(language);
            System.out.println("Analyzing the text with " + language);
            String decrypted = breakForLanguage(enctypyed, dictionary);
            System.out.println(decrypted);

        }
    }


}

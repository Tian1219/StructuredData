package Week1;

import edu.duke.*;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class WordLengths {

    public void countWordLengths(FileResource resource, int[] counts) {
        String[] addword = new String[counts.length];
        for (String word : resource.words()) {
            int n = word.length();
            int len = 0;
            for (int i = 0; i < n; i++) {
                if (Character.isLetter(word.charAt(i))) {
                    len += 1;
                }
            }
            if (len <= counts.length && len != 0) {
                counts[len - 1] += 1;
                addword[len - 1] = word;
            } else {
                System.out.println("The length of array counts is not enough!");
            }

        }
        for (int i = 0; i < counts.length; i++) {
            System.out.println(counts[i] + " words of length " + (i + 1) + " " + addword[i]);
        }
       int maxlength =  indexofMax(counts);
        System.out.println("The most common word length in the file is "+maxlength);
    }

    public void testCountWordKengths(int[] count) {
        FileResource resource = new FileResource();
        countWordLengths(resource, count);

    }

    public int indexofMax(int[] values) {
        int maxvalue = 0;
        int position = 0;
        for (int i = 0; i < values.length; i++) {
            if (maxvalue == 0) {
                maxvalue = values[i];

            } else if (maxvalue < values[i]) {
                maxvalue = values[i];
                position = i;
            }
        }
        return position + 1;
    }


}

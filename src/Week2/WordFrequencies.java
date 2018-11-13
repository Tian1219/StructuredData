package Week2;

import edu.duke.*;

import java.util.ArrayList;

public class WordFrequencies {

    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;

    public WordFrequencies() {
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();

    }

    public void findUnique() {
        myWords.clear();
        myFreqs.clear();
        FileResource resource = new FileResource();
        for (String s : resource.words()) {
            s = s.toLowerCase();
            int index = myWords.indexOf(s);
            if (index == -1) {
                myWords.add(s);
                myFreqs.add(1);

            } else {
                int freq = myFreqs.get(index);
                myFreqs.set(index, freq + 1);

            }
        }
    }

    public void tester() {
        findUnique();
        int sum = 0;
        for (int i = 0; i < myWords.size(); i++) {
            System.out.println(myFreqs.get(i)+ "\t" + myWords.get(i));
            sum++;
        }
        System.out.println(sum + " unique");
    }

}

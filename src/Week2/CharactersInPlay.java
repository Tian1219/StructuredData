package Week2;

import edu.duke.FileResource;

import java.util.ArrayList;

public class CharactersInPlay {

    private ArrayList<String> myNames;
    private ArrayList<Integer> myFreqs;

    public CharactersInPlay() {
        myNames = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }


    public void update(String person) {
        String s = person.toLowerCase();
        int index = myNames.indexOf(s);
        if (index == -1) {
            myNames.add(s);
            myFreqs.add(1);

        } else {
            int freq = myFreqs.get(index);
            myFreqs.set(index, freq + 1);
        }
    }

    public void findAllCharacters() {
        myNames.clear();
        myFreqs.clear();

        FileResource resource = new FileResource();
        int index = 0;
        for (String s : resource.lines()) {
            index = s.indexOf(".");
            if (index != -1) {
                String subs = s.substring(0, index + 1);
                update(subs);
            }
        }
    }

    public void characterWithNumParts(int num1, int num2) {
        for (int i = 0; i < myNames.size(); i++) {
            if (myFreqs.get(i) > num1 && myFreqs.get(i) < num2) {
                System.out.println(myFreqs.get(i) + "\t" + myNames.get(i));
            }
        }
    }

    public void tester() {
        findAllCharacters();
        /*for(int i=0; i<myNames.size(); i++){
            System.out.println(myFreqs.get(i) + "\t" + myNames.get(i));
        }*/
        characterWithNumParts(10, 15);
    }

    public int findMax() {
        int max = myFreqs.get(0);
        int maxIndex = 0;
        for (int k = 0; k < myFreqs.size(); k++) {
            if (myFreqs.get(k) > max) {
                max = myFreqs.get(k);
                maxIndex = k;

            }
        }
        System.out.println(myFreqs.get(maxIndex) + "\t" + myNames.get(maxIndex) + " " + "finish");
        return maxIndex;
    }

}

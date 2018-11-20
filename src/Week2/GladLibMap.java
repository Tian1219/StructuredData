package Week2;

import edu.duke.FileResource;
import edu.duke.URLResource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class GladLibMap {
    /*private ArrayList<String> adjectiveList;
    private ArrayList<String> nounList;
    private ArrayList<String> colorList;
    private ArrayList<String> countryList;
    private ArrayList<String> nameList;
    private ArrayList<String> animalList;
    private ArrayList<String> timeList;
    private ArrayList<String> verbList;
    private ArrayList<String> fruitList*/;

    private HashMap<String, ArrayList<String>> wordMap;
    private ArrayList<String> usedWords;
    private ArrayList<String> usedLabels;
    private int wordCount = 0;
    private String source;
    private Random myRandom;

    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "data";

    public GladLibMap() {
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
    }

    public GladLibMap(String source) {
        this.source = source;
        usedLabels = new ArrayList<String>();
        initializeFromSource(source);
        myRandom = new Random();

    }

    private void putList(String fname) {
        wordMap.put(fname, readIt(source + "/" + fname + ".txt"));
    }

    private void initializeFromSource(String source) {
        wordMap = new HashMap<String, ArrayList<String>>();
        putList("adjective");
        putList("noun");
        putList("color");
        putList("country");
        putList("name");
        putList("animal");
        putList("timeframe");
        putList("verb");
        putList("fruit");

        ArrayList<String> nums = new ArrayList<String>();
        for (int i = 0; i < 50; i++) nums.add(Integer.toString(i));
        wordMap.put("number", nums);

        usedWords = new ArrayList<String>();

    }

    private String randomFrom(String key) {
        String randWord = null;

        ArrayList<String> source = wordMap.get(key);

        if (!usedLabels.contains(key)) {
            usedLabels.add(key);

            while (true) {
                int index = myRandom.nextInt(source.size());
                randWord = source.get(index);
                int usedIndex = usedWords.indexOf(randWord);
                if (usedIndex == -1) {

                    break;
                } else continue;
            }
        }
        usedWords.add(randWord);
        wordCount++;
        return randWord;

    }


    private String getSubstitute(String label) {
        if (wordMap.containsKey(label)) return randomFrom(label);
        else return "UNKNOWN";
    }

    private String processWord(String w) {
        int first = w.indexOf("<");
        int last = w.indexOf(">", first);
        if (first == -1 || last == -1) {
            return w;
        }
        String prefix = w.substring(0, first);
        String suffix = w.substring(last + 1);
        String sub = "";
        while (true) {
            sub = getSubstitute(w.substring(first + 1, last));
            int usedIndex = usedWords.indexOf(sub);
            if (usedIndex == -1) {
                usedWords.add(sub);
                wordCount++;
                break;
            }
        }
       /* while(trackList.contains(sub)){
            sub = getSubstitute(w.substring(first+1,last));
        }
        trackList.add(sub);
        //System.out.println(trackList);
        return prefix+sub+suffix;
    }*/
        return prefix + sub + suffix;
    }

    private void printOut(String s, int lineWidth) {
        int charsWritten = 0;
        for (String w : s.split("\\s+")) {
            if (charsWritten + w.length() > lineWidth) {
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w + " ");
            charsWritten += w.length() + 1;
        }
    }

    private String fromTemplate(String source) {
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for (String word : resource.words()) {
                story = story + processWord(word) + " ";
            }
        } else {
            FileResource resource = new FileResource(source);
            for (String word : resource.words()) {
                story = story + processWord(word) + " ";
            }
        }
        usedWords.clear();
        return story;
    }

    private ArrayList<String> readIt(String source) {
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for (String line : resource.lines()) {
                list.add(line);
            }
        } else {
            FileResource resource = new FileResource(source);
            for (String line : resource.lines()) {
                list.add(line);
            }
        }
        return list;
    }

    public void makeStory() {
        System.out.println("\n");
        String story = fromTemplate("data/madtemplate2.txt");
        System.out.println("\nReplaced words: " + wordCount);
        printOut(story, 60);
    }

    public int toalWordsInMap() {
        int cnt = 0;
        for (String key : wordMap.keySet()) {
            for (String word : wordMap.get(key)) {
                cnt++;
            }
        }
        return cnt;
    }

    public  int totalWordsConsidered(){
        int cnt = 0;
        for (String label : usedLabels)
            for (String word : wordMap.get(label)) cnt++;
        return cnt;
    }

}

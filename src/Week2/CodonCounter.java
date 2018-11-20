package Week2;

import edu.duke.FileResource;

import java.util.HashMap;

public class CodonCounter {

    private HashMap<String, Integer> codons;

    public CodonCounter() {
        codons = new HashMap<String, Integer>();
    }

    public void buildCodonMap(int start, String dna) {
        codons.clear();
        for (int i = start; i < dna.length() - 3; ) {
            String codon = dna.substring(i, i + 3);
            if (!codons.containsKey(codon)) {
                codons.put(codon, 1);
            } else codons.put(codon, codons.get(codon) + 1);
            i += 3;
        }
    }

    public String getMostCommonCodon() {
        int maxCount = 0;
        String mostCodon = new String();
        for (String codon : codons.keySet()) {
            int count = codons.get(codon);
            if (maxCount < count) {
                maxCount = count;
                mostCodon = codon;

            }

        }
        return "most common codon: " + mostCodon + "\t" + maxCount;
    }

    public void printCodonCounts(int start, int end) {

        for (String codon : codons.keySet()) {
            int count = codons.get(codon);
            if (count >= start && count <= end) {
                System.out.println(codon + "\t" + count);
            }
        }
    }

    public int getCodonCount() {
        return codons.size();
    }

    public void tester() {
        //CodonCounter cc = new CodonCounter();
        FileResource fr = new FileResource();
        String DNA = fr.asString();

        System.out.println("Codons 0:");
        buildCodonMap(0, DNA);
        System.out.println("Number of unique codons:\t" + getCodonCount());
        System.out.println(getMostCommonCodon());
        printCodonCounts(0, 7);

        System.out.println("Codons 1:");
        buildCodonMap(1, DNA);
        System.out.println(getMostCommonCodon());
        System.out.println("Number of unique codons:\t" + getCodonCount());
        printCodonCounts(1, 5);


        System.out.println("Codons 2:");
        buildCodonMap(2, DNA);
        System.out.println(getMostCommonCodon());
        System.out.println("Number of unique codons:\t" + getCodonCount());
        printCodonCounts(2, 5);
    }


}

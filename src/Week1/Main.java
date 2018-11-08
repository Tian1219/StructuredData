package Week1;

import edu.duke.FileResource;

public class Main {

    public static void main(String[] args) {
	// write your code here
        WordPlay test = new WordPlay();
      //  System.out.println(test.isVowel('o'));
      //  System.out.println(test.replaceVowels("Iello World",'i'));
       CaesarCipher test2 = new CaesarCipher();
       String A = test2.encrypt("eeeens",25);
      System.out.println(A);
    //    System.out.println(test2.encrypt("fjwp",17));
           // WordLengths testw = new WordLengths();
            //        testw.testCountWordKengths(new int[31]);
      CaesarBreaker test3 = new CaesarBreaker();
        String B = test3.decrypt(A);
        System.out.println(B);


    }
}

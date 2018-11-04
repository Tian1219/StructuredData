package Week1;

public class Main {

    public static void main(String[] args) {
	// write your code here
        WordPlay test = new WordPlay();
      //  System.out.println(test.isVowel('o'));
      //  System.out.println(test.replaceVowels("Iello World",'i'));
        CaesarCipher test2 = new CaesarCipher();
        System.out.println(test2.encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 8,21));


    }
}

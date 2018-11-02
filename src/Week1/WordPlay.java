package Week1;

public class WordPlay {

    public boolean isVowel (char ch){

        ch = Character.toLowerCase(ch);

         if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
             return true;
             }else {
             return false;
         }
    }

    public String replaceVowels(String phrase, char ch){
        StringBuilder newPhrase = new StringBuilder(phrase);
        for(int i = 0 ; i < phrase.length(); i++){
            if (isVowel(phrase.charAt( i))){
                newPhrase.setCharAt(i,ch);
            }
        } return (newPhrase.toString());
    }
}

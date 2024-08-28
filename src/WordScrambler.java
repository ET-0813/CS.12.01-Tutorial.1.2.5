public class WordScrambler {

    private String[] scrambledWords;

    public WordScrambler(String[] wordArr) {

        if(wordArr.length % 2 == 1){
            throw new IllegalArgumentException("Word Array must contain an even number of elements!");
        }
        if(checkWords(wordArr) == true){
            throw new IllegalArgumentException("Word Array must contain single words only! Attack on Titan contains more than one word!");
        }
        scrambledWords = mixedWords(wordArr);

    }

    private String recombine(String word1, String word2) {

        String out = word1.substring(0, word1.length()/2) + word2.substring(word2.length()/2);

        return out;

    }

    private String[] mixedWords(String[] words) {

        String[] scrambledArray = new String[words.length];

        for(int i = 0; i < words.length; i+=2){

            String temp1 = recombine(words[i],words[i+1]);
            String temp2 = recombine(words[i+1], words[i]);

            scrambledArray[i] = temp1;
            scrambledArray[i+1] = temp2;

        }
        return scrambledArray;
    }

    public String[] getScrambledWords() {
        return scrambledWords;
    }
    public boolean checkWords (String[] words){
        for(String s: words){
            if(s.contains(" ")){
                return true;
            }
        }
        return false;
    }
}

import java.util.HashMap;

public class WordCounter {

    public static HashMap<String, Integer> countWords(String sentence) {

        HashMap<String, Integer> wordCountMap = new HashMap<>();
        
        String[] words = sentence.split(" ");
        
        for (String word : words) {

            // Using this line will help us get rid of the ponctuation 
            // from our sentence (Only alphabets are kept)
            word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
            
            if (wordCountMap.containsKey(word)) 
            {
                int count = wordCountMap.get(word);
                wordCountMap.put(word, count + 1);
            }
            else
            {
                wordCountMap.put(word, 1);
            }
        }
        
        return wordCountMap;
    }
}

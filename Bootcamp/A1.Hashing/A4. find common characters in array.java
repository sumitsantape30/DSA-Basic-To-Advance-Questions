class Solution {
    public List<String> commonChars(String[] words) {
        HashMap<Character, Integer> minimumFrequencyOverAll = new HashMap<>();//this will keep the track of minimum of overall words.  minimum frequency of  characters which are present in all words.

    //sare words ki frequency max value se initialise krenge
        for (char ch = 'a'; ch <= 'z'; ch++) {
            minimumFrequencyOverAll.put(ch, Integer.MAX_VALUE);
        }

         //ab har word pe traverse karenge
        for (String word : words) {
            HashMap<Character, Integer> frequencyMap = new HashMap<>(); //hashmap to store frequency of chars in that particular word
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
            }

            //now traverse again to update the minimum frequency of characters by the current frequency in this word
            for (char ch = 'a'; ch <= 'z'; ch++) {
                minimumFrequencyOverAll.put(ch, Math.min(minimumFrequencyOverAll.getOrDefault(ch, Integer.MAX_VALUE), frequencyMap.getOrDefault(ch, 0)));
                //current word mai jo characters hai unki frequency kam hogi to update krdenge overallmap mai. woh value map mai present ho skti hai yafir nhi so pehle check krna padega ki woh present hai ya nhi

            }
        }
        
        List<String> commonChars = new ArrayList<>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int frequency = minimumFrequencyOverAll.get(ch);
            while (frequency > 0) {
                commonChars.add(String.valueOf(ch));
                frequency--;
            }
        }
        return commonChars;
    }
}

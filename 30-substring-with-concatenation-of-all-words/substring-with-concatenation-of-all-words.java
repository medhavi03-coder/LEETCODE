class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0)
            return result;

        int wordLength = words[0].length();
        int totalWords = words.length;
        int windowSize = wordLength * totalWords;
        int sLength = s.length();

        // Frequency map for words
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words)
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);

        // Try every offset within word length
        for (int i = 0; i < wordLength; i++) {
            int left = i;
            int count = 0;
            Map<String, Integer> windowWords = new HashMap<>();

            for (int right = i; right + wordLength <= sLength; right += wordLength) {
                String word = s.substring(right, right + wordLength);

                if (wordCount.containsKey(word)) {
                    windowWords.put(word, windowWords.getOrDefault(word, 0) + 1);
                    count++;

                    while (windowWords.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + wordLength);
                        windowWords.put(leftWord, windowWords.get(leftWord) - 1);
                        left += wordLength;
                        count--;
                    }

                    if (count == totalWords)
                        result.add(left);
                } else {
                    windowWords.clear();
                    count = 0;
                    left = right + wordLength;
                }
            }
        }

        return result;
    }
}
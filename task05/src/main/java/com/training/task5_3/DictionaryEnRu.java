package com.training.task5_3;

import java.util.*;

public class DictionaryEnRu {
    private Map<String, String> dictionary;
    private static final String[] IGNORED_WORDS = {"a", "the"};

    public DictionaryEnRu() {
        dictionary = new HashMap<>();
    }

    public void addWordPair(String englishWord, String russianWord) {
        dictionary.put(englishWord, russianWord);
    }

    public String translateEnRu(String englishText) {
        String[] words = englishText.toLowerCase()
                .split("[\\p{Punct}\\s]+");
        words = cleanIgnoredWords(words);

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (dictionary.containsKey(word)) {
                word = dictionary.get(word);
            }
            sb.append(word).append(" ");
        }
        return sb.toString().trim();
    }

    private String[] cleanIgnoredWords(String... words) {
        List<String> result = new ArrayList<>();
        List<String> ignoredWords = Arrays.asList(IGNORED_WORDS);
        for (String word : words) {
            if (!ignoredWords.contains(word)) {
                result.add(word);
            }
        }
        return result.toArray(new String[0]);
    }
}
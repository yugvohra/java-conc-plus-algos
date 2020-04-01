package com.sample.puzzles;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class PopularityChecker {
    public String[] findNPopularToys(int N, int numberOfToys, String[] toys, int numberOfQuotes, String[] quotes) {
        HashMap<String, Integer> stringTokenMap = getStringTokenMap(quotes);
        TreeMap<Integer, String> toyMapCounter = getToyMapCounter(stringTokenMap, toys);
        String[] popularToys = N > toyMapCounter.size() ? new String[toyMapCounter.size()] : new String[N];
        int arrayIdx = 0;
        for (Map.Entry<Integer, String> entry : toyMapCounter.entrySet()) {
            if (arrayIdx >= N)
                break;
            popularToys[arrayIdx] = entry.getValue();
            arrayIdx++;
        }
        return popularToys;
    }

    private TreeMap<Integer, String> getToyMapCounter(HashMap<String, Integer> stringTokenMap, String[] toys) {
        TreeMap<Integer, String> toyMapCounter = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (String toy : toys) {
            if (stringTokenMap.containsKey(toy.toUpperCase())) {
                toyMapCounter.put(stringTokenMap.get(toy.toUpperCase()),toy);
            }
        }
        return toyMapCounter;
    }

    private HashMap<String, Integer> getStringTokenMap(String[] quotes) {
        HashMap<String, Integer> stringTokenMap = new HashMap<>(32);
        for (String quote : quotes) {
            String[] tokens = quote.split(" ");
            putTokensInMap(tokens, stringTokenMap);
        }
        return stringTokenMap;
    }

    private void putTokensInMap(String[] tokens, HashMap<String, Integer> stringTokenMap) {
        for (String token : tokens) {
            if (stringTokenMap.containsKey(token.toUpperCase())) {
                int count = stringTokenMap.get(token.toUpperCase());
                stringTokenMap.put(token.toUpperCase(), ++count);
            } else {
                stringTokenMap.put(token.toUpperCase(), 1);
            }
        }
    }


}

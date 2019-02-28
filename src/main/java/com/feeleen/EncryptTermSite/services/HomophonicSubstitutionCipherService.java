package com.feeleen.EncryptTermSite.services;

import org.springframework.stereotype.Service;

import java.util.*;

import static java.util.stream.Collectors.toMap;

@Service
public class HomophonicSubstitutionCipherService {

    public String encryptByKey(String text, Map<Character, List<Integer>> keys) {
        StringBuilder newText = new StringBuilder(text.length());

        Random random = new Random();
        for (int i = 0; i < text.length(); i++) {
            List<Integer> list = keys.get((text.charAt(i)));
            newText.append(list.get(random.nextInt(list.size())));
            newText.append(" ");
        }

        return newText.toString();
    }

    public Map<Character, Double> getFrequencies(String text) {
        Map<Character, Integer> mapChars = text.chars().boxed()
                .collect(toMap(
                        k -> Character.valueOf((char) k.intValue()),
                        v -> 1,
                        Integer::sum));

        Map<Character, Double> frequencies = new HashMap<>();

        for (Map.Entry<Character, Integer> entry : mapChars.entrySet()) {
            frequencies.put(entry.getKey(), entry.getValue() / (double) text.length());
        }

        return frequencies;
    }

    public Map<Character, List<Integer>> getKeys(String text, Map<Character, Double> frequencies) {
        Random random = new Random();

        Map<Character, List<Integer>> keys = new HashMap<>();

        Double max = frequencies.values().stream().max((a, b) -> {
            if (a > b) {
                return 1;
            } else if (a < b) {
                return -1;
            } else return 0;

        }).orElseThrow(IllegalArgumentException::new);


        for (Map.Entry<Character, Double> entry : frequencies.entrySet()) {
            List<Integer> list = new ArrayList<>();
            double f = entry.getValue();


            keys.put(entry.getKey(), list);
        }

        return keys;
    }

}

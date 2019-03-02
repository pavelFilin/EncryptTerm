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

    public Map<Character, List<Integer>> getKeys(String text, Map<Character, Double> frequencies) throws Exception {
        int maxCodes = 8999;
        int multiple = 1;

        List<Integer> usedKeys = new ArrayList<>();

        Random random = new Random();

        Map<Character, List<Integer>> keys = new HashMap<>();

        double min = frequencies.values().stream().min((a, b) -> {
            if (a == b) {
                return 0;
            }

            return a > b ? 1 : -1;

        }).orElseThrow(IllegalArgumentException::new);

        ;
        for (Map.Entry<Character, Double> entry : frequencies.entrySet()) {

            List<Integer> list = new ArrayList<>();
            double f = entry.getValue();
            int count = (int) Math.round((f / min));
            if (count < 1) {
                count = 1;
            }

            for (int i = 0; i < count; i++) {

                if (usedKeys.size() >= maxCodes) {
                    multiple *= 10;
                    maxCodes *= 10;
                }

                int key = 0;
                do {
                    key = 1000 + random.nextInt(9999 * multiple);
                } while (usedKeys.contains(key));

                usedKeys.add(key);
                list.add(key);
            }

            keys.put(entry.getKey(), list);
        }

        System.out.println(keys);

        return keys;
    }
}

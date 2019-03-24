package com.feeleen.sstuMath.services;

import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class StringHashFunctionService {
    public static final int LENGTH = 0x7fffffff;

    public int hashCode(String s) {
        double sqrt = Math.sqrt(2);
        double result = 0;

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum+=s.charAt(i);
            result+=(sqrt - (int) sqrt) * sum;
        }

        double temp = result;
        while (true) {
            temp *= 10;
            if (temp>LENGTH) {
                return Math.abs((int)result);
            } else {
                result+=temp;
            }
        }
    }
}

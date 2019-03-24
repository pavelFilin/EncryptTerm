package com.feeleen.sstuMath.services;

import org.springframework.stereotype.Service;

@Service
public class TranspositionСipherService {

    public String encryptMessage(String text, int shift) {
        boolean breaker = false;
        int a = (int)Math.ceil(text.length() / (shift+0.0));


        char[][] matrix = new char[(int) Math.ceil(a)][shift];

        int pos = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = text.charAt(pos);
                pos++;

                if (pos == text.length()) {
                    breaker = true;
                    break;
                }
            }
            if (breaker) {
                break;
            }
        }

        printChars(matrix);
        StringBuilder stringBuilder = new StringBuilder();

        if (matrix.length == 1) {
            for (int i = 0; i < matrix.length; i++) {
                stringBuilder.append(matrix[i]);
            }
        } else {

            for (int i = 0; i < matrix[0].length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    stringBuilder.append(matrix[j][i]);
                }
            }
        }

        return stringBuilder.toString();
    }

    private void printChars(char[][] t) {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                System.out.print(t[i][j] + " ");
            }
            System.out.println();
        }
    }
}

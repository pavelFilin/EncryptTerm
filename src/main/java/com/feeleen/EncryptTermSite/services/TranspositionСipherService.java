package com.feeleen.EncryptTermSite.services;

import org.springframework.stereotype.Service;

@Service
public class TranspositionСipherService {
    public String encryptMessage(String text, int shift) {
        char[][] matrix = new char[(int)Math.ceil(text.length()/shift)][shift];

        int pos = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = text.charAt(pos);
                pos++;
            }
        }

        printChars(matrix);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < matrix[i].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                stringBuilder.append(matrix[j][i]);
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

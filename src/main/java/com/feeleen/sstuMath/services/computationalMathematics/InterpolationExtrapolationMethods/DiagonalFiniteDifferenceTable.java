package com.feeleen.sstuMath.services.computationalMathematics.InterpolationExtrapolationMethods;

import java.util.ArrayList;
import java.util.List;

public class DiagonalFiniteDifferenceTable {
    public static final double EPS = 0.01;
    public int position = 2;

    public static List<List<Double>> getTable(double[][] date) {
        double diff = 0;

        List<List<Double>> table = initTable(date);

        do {
            table.add(new ArrayList<>());
            List<Double> columnLast = table.get(table.size() - 1);
            List<Double> columnPrev = table.get(table.size() - 2);

            for (int i = 0; i < columnPrev.size() - 1; i++) {
                columnLast.add(columnPrev.get(i) + columnPrev.get(i + 1));
            }

            diff = getDiff(columnLast);
        } while (diff > EPS);

        return table;
    }

    public static List<List<Double>> initTable(double[][] date) {
        List<List<Double>> table = new ArrayList<>();

        table.add(new ArrayList<>());
        table.add(new ArrayList<>());

        for (int i = 0; i < date.length; i++) {
            table.get(0).add(date[i][0]);
            table.get(1).add(date[i][1]);
        }

        return table;
    }

    public static double getDiff(List<Double> list) {
        return list.stream().mapToDouble(value -> value).sum();
    }
}

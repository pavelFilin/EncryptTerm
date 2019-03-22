package com.feeleen.sstuMath.services.computationalMathematics.InterpolationExtrapolationMethods;

import java.util.List;

public class InterpolationMethods {
    public static double gausMethod(double x, double[][] xy) {
        if (x < xy[0][0] || x > xy[xy.length][0]) {
            throw new IllegalArgumentException();
        }

        DiagonalFiniteDifferenceTable table = new DiagonalFiniteDifferenceTable(xy);

        List<List<Double>> tableEntry = table.getTableEntry();
        double t = (x - table.getRoundX(x)) / table.getH();
        int index = table.getIndexRoundX(x);

        //todo index from length
        return table.getRoundYByX(x)
                + t * table.getYList().get(index) * table.getDiffList(1).get(index - 1) / factorial(2)
                + ((t - 1) * t * (t + 1)) * table.getDiffList(2).get(index - 1) / factorial(3);
    }

    public static double besselMethod(double x, double[][] xy) {
        if (x < xy[0][0] || x > xy[xy.length][0]) {
            throw new IllegalArgumentException();
        }

        DiagonalFiniteDifferenceTable table = new DiagonalFiniteDifferenceTable(xy);

        List<List<Double>> tableEntry = table.getTableEntry();
        double t = (x - table.getRoundX(x)) / table.getH();
        int index = table.getIndexRoundX(x);

        //todo index from length and add check for intdex of table.getDiffList()
        return (table.getYList().get(index) + table.getYList().get(index - 1)) / 2
                + (t * (t - 1) / factorial(2)) * table.getDiffList(0).get(-1) * table.getDiffList(0).get(0) / 2
                + (t - 1 / 2) * t * (t - 1) / factorial(3) * table.getDiffList(2).get(-1);

    }

    public static double stirlingMethod(double x, double[][] xy) {
        if (x < xy[0][0] || x > xy[xy.length][0]) {
            throw new IllegalArgumentException();
        }

        DiagonalFiniteDifferenceTable table = new DiagonalFiniteDifferenceTable(xy);

        List<List<Double>> tableEntry = table.getTableEntry();
        double t = (x - table.getRoundX(x)) / table.getH();
        int index = table.getIndexRoundX(x);

        //todo index from length and add check for intdex of table.getDiffList()
        return table.getYList().get(index)
                + t * table.getDiffList(0).get(index - 1)
                + t*(t+1)/factorial(2) * table.getDiffList(1).get(index-1)
                + (t+1)* t * (t-1)/factorial(3) * table.getDiffList(2).get(-2);

    }


    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
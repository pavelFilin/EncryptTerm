package com.feeleen.sstuMath.services.computationalMathematics.InterpolationExtrapolationMethods;

import java.util.List;

public class InterpolationMethods {
    public static double gaussMethod(double x, double[][] xy) {

        DiagonalFiniteDifferenceTable table = new DiagonalFiniteDifferenceTable(xy);

        List<List<Double>> tableEntry = table.getTableEntry();
        double t = (x - table.getLeftX(x)) / table.getH();

        System.out.println("t = " + t);
        int index = table.getIndexLeftX(x);

        double a0 = table.getYList().get(index);
        double a1 = (getColumn(index, 0, table.getDiffList(0))) * t;
        double a2 = getColumn(index, 1, table.getDiffList(1)) * t * (t - 1) / 6;
        double a3 = ((t - 1) * t * (t + 1)) * getColumn(index, 2, table.getDiffList(2)) / factorial(3);
        System.out.println("a0 = " + a0);
        System.out.println("a1 = " + a1);
        System.out.println("a2 = " + a2);
        System.out.println("a3 = " + a3);
        double result = a0
                + a1
                + a2
                + a3;
        return result;
    }

    private static double getColumn(int index, int diffNumber, List<Double> list) {
        Double aDouble = list.get(index - (diffNumber));
        System.out.println("l: " +  aDouble);
        return aDouble;
    }

    public static double besselMethod(double x, double[][] xy) {
        if (x < xy[0][0] || x > xy[xy.length][0]) {
            throw new IllegalArgumentException();
        }

        DiagonalFiniteDifferenceTable table = new DiagonalFiniteDifferenceTable(xy);

        List<List<Double>> tableEntry = table.getTableEntry();
        double t = (x - table.getLeftX(x)) / table.getH();
        int index = table.getIndexLeftX(x);

        //todo index from length and add check for intdex of table.getDiffList()
        double a0 = (table.getYList().get(index) + table.getYList().get(index - 1)) / 2;
        double a1 = (t * (t - 1) / factorial(2)) * getColumn(index, 0, table.getDiffList(0)) * table.getDiffList(0).get(0) / 2;
        double a2 = (t - 1 / 2) * t * (t - 1) / factorial(3) * table.getDiffList(2).get(-1);
        double result = a0
                + a1
                + a2;
        return result;

    }

    public static double stirlingMethod(double x, double[][] xy) {
        if (x < xy[0][0] || x > xy[xy.length][0]) {
            throw new IllegalArgumentException();
        }

        DiagonalFiniteDifferenceTable table = new DiagonalFiniteDifferenceTable(xy);

        List<List<Double>> tableEntry = table.getTableEntry();
        double t = (x - table.getLeftX(x)) / table.getH();
        int index = table.getIndexLeftX(x);

        //todo index from length and add check for intdex of table.getDiffList()
        return table.getYList().get(index)
                + t * table.getDiffList(0).get(index - 1)
                + t * (t + 1) / factorial(2) * table.getDiffList(1).get(index - 1)
                + (t + 1) * t * (t - 1) / factorial(3) * table.getDiffList(2).get(-2);

    }


    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
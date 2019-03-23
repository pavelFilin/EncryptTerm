package com.feeleen.sstuMath.services.computationalMathematics.InterpolationExtrapolationMethods;

import java.util.ArrayList;
import java.util.List;

public class DiagonalFiniteDifferenceTable {
    public static final double EPS = 0.01;

    private List<List<Double>> tableEntry;

    private double[][] xy;

    public DiagonalFiniteDifferenceTable(double[][] xy) {
        this.xy = xy;
        fillTable();

    }


    private void fillTable() {
        double diff = 0;
        this.tableEntry = initTable();

        do {
            this.tableEntry.add(new ArrayList<>());

            List<Double> columnLast = this.tableEntry.get(this.tableEntry.size() - 1);
            List<Double> columnPrev = this.tableEntry.get(this.tableEntry.size() - 2);

            for (int i = 0; i < columnPrev.size() - 1; i++) {
                columnLast.add(columnPrev.get(i + 1) - columnPrev.get(i));
            }

            diff = Math.abs(getSumOfList(columnLast));
        } while (diff > EPS);


    }

    private List<List<Double>> initTable() {
        List<List<Double>> table = new ArrayList<>();

        table.add(new ArrayList<>());
        table.add(new ArrayList<>());

        for (int i = 0; i < xy.length; i++) {
            table.get(0).add(xy[i][0]);
            table.get(1).add(xy[i][1]);
        }

        return table;
    }

    private double getSumOfList(List<Double> list) {
        return list.stream().mapToDouble(value -> value).sum();
    }

    public List<Double> getXList() {
        return tableEntry.get(0);
    }

    public List<Double> getYList() {
        return tableEntry.get(1);
    }

    public List<Double> getDiffList(int index) {
        return tableEntry.get(index + 2);
    }

    public int getDiffSize() {
        return tableEntry.size() - 2;
    }

    public double getLeftX(double x) {
        List<Double> xList = getXList();
        double minDiff = 0;


        return xList.get(getIndexLeftX(x));
    }

    public double getH() {
        List<Double> xList = getXList();
        return getSumOfList(xList) / xList.size();
    }

    public double getLeftYByX(double x) {
        double roundX = getLeftX(x);
        return getXList().stream().filter(x1 -> x1 == roundX).findFirst().orElseThrow(ArithmeticException::new);
    }

    public List<List<Double>> getTableEntry() {
        return tableEntry;
    }

    public int getIndexLeftX(double x) {
//        int i = 0;
        List<Double> xList = getXList();
        double minDiff = 0;
        int iMax = 0;

//        for (; i < xList.size(); i++) {
//            double diff = Math.abs(xList.get(i) - x);
//            if (minDiff > diff) {
//                minDiff = diff;
//                iMax = i;
//            }
//        }
//
//        return iMax;

        for (int i = 0; i < xList.size(); i++) {
            if (xList.get(i) > x) {
                return i - 1;
            }
        }

        throw new IllegalArgumentException();
    }
}

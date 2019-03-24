package com.feeleen.sstuMath.services.computationalMathematics.InterpolationExtrapolationMethods;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class InterpolationMethods {
    @Autowired
    private static DiagonalFiniteDifferenceTable table;

    public static double gaussMethod(double x) {
        double t = (x - table.getLeftX(x)) / table.getH();
        int index = table.getIndexLeftX(x);

        double a0 = table.getY(index);
        double a1 = (table.getDiff(index, 0)) * t;
        double a2 = table.getDiff(index, 1) * t * (t - 1) / 6;
        double a3 = ((t - 1) * t * (t + 1)) * table.getDiff(index, 2) / factorial(3);

        return a0 + a1 + a2 + a3;
    }

    public static double besselMethod(double x) {
        double t = (x - table.getLeftX(x)) / table.getH();
        int index = table.getIndexLeftX(x);

//        double a0 = (table.getY(index) + table.getY(index - 1)) / 2;
        double a0 = (table.getY(index+1) + table.getY(index - 1)) / 2;
        double a1 = (t - 1 / 2) * table.getDiff(index, 0);
//        double a2 = (t * (t - 1) / factorial(2)) * table.getDiff(index - 1, 1) * table.getDiff(index, 1) / 2;
        double a2 = (t * (t - 1) / factorial(2)) * table.getDiff(index, 1) * table.getDiff(index + 1, 1) / 2;
        double a3 = (t - 1 / 2) * t * (t - 1) / factorial(3) * table.getDiff(index - 1, 2);

        return a0 + a1 + a2 + a3;

    }

    public static double stirlingMethod(double x) {
        double t = (x - table.getLeftX(x)) / table.getH();
        int index = table.getIndexLeftX(x);

        double a0 = table.getY(index);
        double a1 = t * (table.getDiff(index - 1, 0) + table.getDiff(index, 0));
        double a2 = t / 2 * table.getDiff(index - 1, 2);
        double a3 = t * (t * t - 1) / 6 * (table.getDiff(index - 2, 2) + table.getDiff(index - 1, 1)) / 2;
        return a0 + a1 + a2 + a3;
    }


    private static int factorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
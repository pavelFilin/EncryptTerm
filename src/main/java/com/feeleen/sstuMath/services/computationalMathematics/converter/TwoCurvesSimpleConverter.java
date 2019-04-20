package com.feeleen.sstuMath.services.computationalMathematics.converter;

import com.feeleen.sstuMath.services.computationalMathematics.utils.restDto.Point;
import com.feeleen.sstuMath.services.computationalMathematics.utils.restDto.TwoCurvesDTO;

import java.awt.*;
import java.util.List;

public class TwoCurvesSimpleConverter {
    public static double[][] convert(List<Point> f1, List<Point> f2, List<Double> x) {
        double[][] result = new double[3][];
        result[0] = new double[f1.size()];
        result[1] = new double[f2.size()];
        result[2] = new double[f2.size()];

        for (int i = 0; i < f1.size(); i++) {
            result[0][i] = f1.get(i).getY();
        }

        for (int i = 0; i < f1.size(); i++) {
            result[1][i] = f2.get(i).getY();
        }

        for (int i = 0; i < f1.size(); i++) {
            result[2][i] = x.get(i);
        }

        return result;
    }
}

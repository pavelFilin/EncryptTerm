package com.feeleen.sstuMath.services.computationalMathematics;

import com.feeleen.sstuMath.services.computationalMathematics.converter.TwoCurvesSimpleConverter;
import com.feeleen.sstuMath.services.computationalMathematics.utils.restDto.Point;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecantMethodService {


    public double[][] getPoints(double a, double b, double h) {
        List<Point> p1 = new ArrayList<>();
        List<Point> p2 = new ArrayList<>();

        List<Double> xList = new ArrayList<>();

        for (double i = a; i < b; i += h) {
            xList.add(Math.floor(i * 10) / 10);
            p1.add(new Point(i, f1(i)));
            p2.add(new Point(i, f2(i)));
        }

        return TwoCurvesSimpleConverter.convert(p1, p2, xList);
    }

    private double f1(double x) {
        return Math.exp(x) + x + 1;
    }

    private double f2(double x) {
        return 2 * x * x * x * x - x * x - 10;
    }
}

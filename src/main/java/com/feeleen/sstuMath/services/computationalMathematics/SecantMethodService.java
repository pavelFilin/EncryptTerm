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

    public double getRoot(double a, double b, double e) {
        boolean flagLeftRight = false;
        double fa = 0;
        double fb = 0;
        double fc = 0;
        int count = 0;

        do {
            double c = -(formula(a)*(b-a))/(formula(b)-formula(a)) + a;
            count++;
            System.out.println("[" + a + ";" + b + "]");
            fa = formula(a);
            fb = formula(b);
            fc = formula(c);

            if (fa * fc < 0) {
                flagLeftRight = true;
                b = c;
            }

            if (fb * fc < 0) {
                flagLeftRight = false;
                a = c;
            }
        }
        while (Math.abs(a - b) > e && count < 100000);



        System.out.println("count of iterate " + count);
        if (flagLeftRight) {
            return b;
        } else {
            return a;
        }
    }

    private double f1(double x) {
        return Math.exp(x) + x + 1;
    }

    private double f2(double x) {
        return 2 * x * x * x * x - x * x - 10;
    }

    private double formula(double x) {
        return f1(x)-f2(x);
    }
}

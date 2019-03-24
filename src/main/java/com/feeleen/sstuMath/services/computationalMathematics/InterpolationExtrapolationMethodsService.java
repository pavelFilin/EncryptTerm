package com.feeleen.sstuMath.services.computationalMathematics;

import com.feeleen.sstuMath.services.computationalMathematics.InterpolationExtrapolationMethods.InterpolationMethods;
import org.springframework.stereotype.Service;

@Service
public class InterpolationExtrapolationMethodsService {

    public double[] getGaussInterpolation() {
        double[] doubles = new double[30];
        for (int i = 0; i <= 30; i++) {
            doubles[i] = InterpolationMethods.gaussMethod(getX(i));
        }

        return doubles;
    }

    public double[] getBessilInterpolation() {
        double[] doubles = new double[30];
        for (int i = 0; i <= 30; i++) {
            doubles[i] = InterpolationMethods.besselMethod(getX(i));
        }

        return doubles;
    }

    public double[] getStirlingInterpolation() {
        double[] doubles = new double[30];
        for (int i = 0; i <= 30; i++) {
            doubles[i] = InterpolationMethods.stirlingMethod(getX(i));
        }

        return doubles;
    }


    private double getX(int n) {
        return 1.725 + 0.002 * n;
    }
}

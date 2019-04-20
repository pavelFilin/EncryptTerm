package com.feeleen.sstuMath.services.computationalMathematics.converter;

import com.feeleen.sstuMath.services.computationalMathematics.utils.restDto.Point;
import com.feeleen.sstuMath.services.computationalMathematics.utils.restDto.TwoCurvesDTO;

import java.util.List;

public class TwoCurvesConverter {
    public static TwoCurvesDTO convert(List<Point> f1, List<Point> f2) {
        TwoCurvesDTO twoCurvesDTO = new TwoCurvesDTO();

        Point[][] points = twoCurvesDTO.getPoints();
        points[0] = new Point[f1.size()];
        points[1] = new Point[f2.size()];

        for (int i = 0; i < f1.size(); i++) {
            points[0][i] = f1.get(i);
        }

        for (int i = 0; i < f2.size(); i++) {
            points[1][i] = f2.get(i);
        }

        return twoCurvesDTO;
    }
}

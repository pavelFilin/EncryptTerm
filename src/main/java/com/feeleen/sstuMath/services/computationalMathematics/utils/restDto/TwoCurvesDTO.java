package com.feeleen.sstuMath.services.computationalMathematics.utils.restDto;

import java.util.ArrayList;
import java.util.List;

public class TwoCurvesDTO {
    Point[][] points = new Point[2][];

    public Point[][] getPoints() {
        return points;
    }

    public void setPoints(Point[][] points) {
        this.points = points;
    }
}

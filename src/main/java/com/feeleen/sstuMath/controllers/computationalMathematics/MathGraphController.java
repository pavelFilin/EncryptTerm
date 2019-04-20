package com.feeleen.sstuMath.controllers.computationalMathematics;

import com.feeleen.sstuMath.services.computationalMathematics.converter.TwoCurvesConverter;
import com.feeleen.sstuMath.services.computationalMathematics.converter.TwoCurvesSimpleConverter;
import com.feeleen.sstuMath.services.computationalMathematics.utils.restDto.Point;
import com.feeleen.sstuMath.services.computationalMathematics.utils.restDto.TwoCurvesDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/graph")
public class MathGraphController {

    @GetMapping
    public String getGraph(Model model) {
        return "Graph";
    }

    @ResponseBody
    @RequestMapping(value = "/secantMethod", method = RequestMethod.POST)
    public double[][] getPoints(@RequestParam(required = false) double a, @RequestParam(required = false) double b, @RequestParam(required = false) double h) {
        List<Point> p1 = new ArrayList<>();
        List<Point> p2 = new ArrayList<>();

        List<Double> xList = new ArrayList<>();

        for (double i = a; i < b; i += h) {
            xList.add(Math.floor(i*10)/10);
            p1.add(new Point(i, f1(i)));
            p2.add(new Point(i, f2(i)));
        }
        TwoCurvesSimpleConverter d = new TwoCurvesSimpleConverter();
        return d.convert(p1, p2, xList);
    }

    private double f1(double x) {
        return Math.exp(x) + x + 1;
    }

    private double f2(double x) {
        return 2 * x * x * x * x - x * x - 10;
    }
}

package com.feeleen.sstuMath.controllers.computationalMathematics;

import com.feeleen.sstuMath.services.computationalMathematics.utils.restDto.DataForMathGraph;
import com.feeleen.sstuMath.services.computationalMathematics.utils.restDto.Point;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @RequestMapping(value = "/ajax", method = RequestMethod.GET)
    public List<Point> getPoints() {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            points.add(new Point(i,i));
        }
        return points;
    }
//    public List<DataForMathGraph> getGraphA() {
////        List<DataForMathGraph> data = new ArrayList<>();
////
////        double x = -10;
////        while (x <= 10) {
////            data.add(new DataForMathGraph(1, x, f1(x)));
////            x += 1;
////        }
////        return data;
//    }

    private double f1(double x) {
        return Math.exp(x) + x + 1;
    }

    private double f2(double x) {
        return 2 * x * x * x * x - x * x - 10;
    }
}

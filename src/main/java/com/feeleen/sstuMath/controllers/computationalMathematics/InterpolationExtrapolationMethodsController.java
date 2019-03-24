package com.feeleen.sstuMath.controllers.computationalMathematics;

import com.feeleen.sstuMath.services.computationalMathematics.InterpolationExtrapolationMethods.DiagonalFiniteDifferenceTable;
import com.feeleen.sstuMath.services.computationalMathematics.InterpolationExtrapolationMethodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping("")
public class InterpolationExtrapolationMethodsController {
    @Autowired
    private InterpolationExtrapolationMethodsService interpolationExtrapolationMethodsService;
    @Autowired
    private DiagonalFiniteDifferenceTable diagonalFiniteDifferenceTable;


    @GetMapping("InterpolationExtrapolationMethods")
    public String getInterpolationExtrapolationMethods(Model model) {
        List<List<Double>> tableEntry = diagonalFiniteDifferenceTable.getTableEntry();

        model.addAttribute("table", convertList(tableEntry));
        //        model.addAttribute("gauss", interpolationExtrapolationMethodsService.getGaussInterpolation());
        //        model.addAttribute("bessel", interpolationExtrapolationMethodsService.getBessilInterpolation());
        //        model.addAttribute("stirling", interpolationExtrapolationMethodsService.getStirlingInterpolation());
        return "InterpolationExtrapolationMethods";
    }

    private double[][] convertList(List<List<Double>> a) {
        List<List<Double>> b = new ArrayList<>();

        double[][] t = new double[a.get(0).size()][];
        for (int i = 0; i < t.length; i++) {
            t[i] = new double[a.size()];
        }

        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(i).size(); j++) {
                t[j][i] = a.get(i).get(j);
            }
        }


        for (int i = t.length - 1; i > 0; i--) {
            for (int j = 2; j < t[i].length; j++) {
//                double temp = t[i+1][j];

                if ((i - (j - 2)) > 0) {
                    t[i][j] = t[i - (1 + j - 2)][j];
                }
                if (i <= j - 1) {
                    t[i-1][j] = 0;
                }
            }
        }


        return t;
    }

}

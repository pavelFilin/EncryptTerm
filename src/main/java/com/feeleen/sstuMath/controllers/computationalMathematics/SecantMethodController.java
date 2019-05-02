package com.feeleen.sstuMath.controllers.computationalMathematics;

import com.feeleen.sstuMath.services.computationalMathematics.SecantMethodService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/graph")
public class SecantMethodController {

    private final SecantMethodService secantMethodService;

    public SecantMethodController(SecantMethodService secantMethodService) {
        this.secantMethodService = secantMethodService;
    }


    @GetMapping
    public String getGraph(Model model) {
        return "Graph";
    }

    @ResponseBody
    @RequestMapping(value = "/secantMethod", method = RequestMethod.POST)
    public double[][] getPoints(@RequestParam(required = false) double a, @RequestParam(required = false) double b, @RequestParam(required = false) double h) {
        System.out.println(secantMethodService.getRoot(0, 4, 0.01));
        return secantMethodService.getPoints(a, b, h);
    }

    @ResponseBody
    @RequestMapping(value = "/secantMethodClarifyRoot", method = RequestMethod.POST)
    public double clarifyRoot(@RequestParam double a, @RequestParam double b) {
        return secantMethodService.getRoot(a, b, 0.01);
    }


}

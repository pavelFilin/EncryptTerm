package com.feeleen.sstuMath.configs;

import com.feeleen.sstuMath.services.computationalMathematics.InterpolationExtrapolationMethods.DiagonalFiniteDifferenceTable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InterpolationConfig {
    @Bean
    public double[][] xyTest() {
       double[][] xy = {
                {1.50, 15.132},
                {1.55, 17.422},
                {1.60, 20.393},
                {1.65, 23.994},
                {1.70, 28.160},
                {1.75, 32.812},
                {1.80, 37.857},
                {1.85, 43.189},
                {1.90, 46.689},
                {1.95, 54.225},
                {2.00, 59.653},
                {2.05, 64.817},
                {2.10, 69.550},
        };

       return xy;
    }

    @Bean
    public DiagonalFiniteDifferenceTable diagonalFiniteDifferenceTable(double[][] xyTest) {
        return new DiagonalFiniteDifferenceTable(xyTest);
    }
}

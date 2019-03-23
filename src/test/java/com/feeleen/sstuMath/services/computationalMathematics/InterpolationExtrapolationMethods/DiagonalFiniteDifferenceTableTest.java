package com.feeleen.sstuMath.services.computationalMathematics.InterpolationExtrapolationMethods;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DiagonalFiniteDifferenceTableTest {

    double[][] data;
    List<List<Double>> listsExpected = new ArrayList<>();
    List<List<Double>> tableExpected = new ArrayList<>();

    @Before
    public void setData() {
        data = new double[][]{
                {0.12, 6.278},
                {0.14, 6.405},
                {0.16, 6.487},
                {0.18, 6.505},
                {0.20, 6.436},
                {0.22, 6.259},
                {0.24, 5.954},
        };
    }

//    @Before
//    public void setData() {
//        data = new double[][]{
//                {1.50, 15.132},
//                {1.55, 17.422},
//                {1.60, 20.393},
//                {1.65, 23.994},
//                {1.70, 28.160},
//                {1.75, 32.812},
//                {1.80, 37.857},
//                {1.85, 43.189},
//                {1.90, 46.689},
//                {1.95, 54.225},
//                {2.00, 59.653},
//                {2.05, 64.817},
//                {2.10, 69.550},
//        };
//    }


    public void setLists() {
        ArrayList<Double> row1 = new ArrayList<>();
        ArrayList<Double> row2 = new ArrayList<>();
        listsExpected.add(row1);
        listsExpected.add(row2);
        row1.add(0.12);
        row1.add(0.14);
        row1.add(0.16);
        row1.add(0.18);
        row1.add(0.20);
        row1.add(0.22);
        row1.add(0.24);

        row2.add(6.278);
        row2.add(6.405);
        row2.add(6.487);
        row2.add(6.505);
        row2.add(6.436);
        row2.add(6.259);
        row2.add(5.954);
    }

    @Before
    public void setList2() {
        ArrayList<Double> row1 = new ArrayList<>();
        ArrayList<Double> row2 = new ArrayList<>();
        listsExpected.add(row1);
        listsExpected.add(row2);
        row1.add(1.50);
        row1.add(1.55);
        row1.add(1.60);
        row1.add(1.65);
        row1.add(1.70);
        row1.add(1.75);
        row1.add(1.80);
        row1.add(1.85);
        row1.add(1.90);
        row1.add(1.95);
        row1.add(2.00);
        row1.add(2.05);
        row1.add(2.10);

        row2.add(15.132);
        row2.add(17.422);
        row2.add(20.393);
        row2.add(23.994);
        row2.add(28.160);
        row2.add(32.812);
        row2.add(37.857);
        row2.add(43.189);
        row2.add(46.689);
        row2.add(54.225);
        row2.add(59.653);
        row2.add(64.817);
        row2.add(69.550);
    }

    @Before
    public void setTableMock() {
        ArrayList<Double> row1 = new ArrayList<>();
        ArrayList<Double> row2 = new ArrayList<>();
        ArrayList<Double> row3 = new ArrayList<>();
        ArrayList<Double> row4 = new ArrayList<>();
        ArrayList<Double> row5 = new ArrayList<>();
        tableExpected.add(row1);
        tableExpected.add(row2);
        tableExpected.add(row3);
        tableExpected.add(row4);
        tableExpected.add(row5);
        row1.add(0.12);
        row1.add(0.14);
        row1.add(0.16);
        row1.add(0.18);
        row1.add(0.20);
        row1.add(0.22);
        row1.add(0.24);

        row2.add(6.278);
        row2.add(6.405);
        row2.add(6.487);
        row2.add(6.505);
        row2.add(6.436);
        row2.add(6.259);
        row2.add(5.954);

        row3.add(0.126);
        row3.add(0.083);
        row3.add(0.018);
        row3.add(-0.069);
        row3.add(-0.117);
        row3.add(-0.305);

        row4.add(-0.043);
        row4.add(-0.065);
        row4.add(-0.087);
        row4.add(-0.108);
        row4.add(-0.128);

        row5.add(-0.022);
        row5.add(-0.022);
        row5.add(-0.021);
        row5.add(-0.020);
    }

    @Test
    public void getTable() {
        DiagonalFiniteDifferenceTable table = new DiagonalFiniteDifferenceTable(data);


        for (int i = 0; i <= 30; i++) {

            double x = getX(i);
            double v = InterpolationMethods.gaussMethod(x, data);
            System.out.println(x + "  :  " + v);
        }

        assertThat(tableExpected, is(table.getTableEntry()));
    }

    @Test
    public void getTable2() {
        DiagonalFiniteDifferenceTable table = new DiagonalFiniteDifferenceTable(data);

        double v = InterpolationMethods.gaussMethod(0.168, data);


        assertThat(tableExpected, is(table.getTableEntry()));
    }


    public double getX(int n) {
        return 1.725 + 0.002 * n;
    }


}
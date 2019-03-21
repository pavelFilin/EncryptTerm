package com.feeleen.sstuMath.services.computationalMathematics.InterpolationExtrapolationMethods;

import org.junit.Assert;
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

    @Before
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
        List<List<Double>> table = DiagonalFiniteDifferenceTable.getTable(data);
        assertThat(tableExpected, is(tableExpected));
    }

    @Test
    public void initTable() {


        List<List<Double>> table = DiagonalFiniteDifferenceTable.initTable(data);

        assertThat(listsExpected, is(table));
    }


    @Test
    public void getDiff() {
        List<Double> doubles = new ArrayList<>();
        doubles.add(12.45);
        doubles.add(41.412);
        doubles.add(28.96);
        doubles.add(34.45);
        doubles.add(15.62);
        doubles.add(21.62);
        double diff = DiagonalFiniteDifferenceTable.getDiff(doubles);
        Assert.assertEquals(154.512, diff, 0.0001);
    }
}
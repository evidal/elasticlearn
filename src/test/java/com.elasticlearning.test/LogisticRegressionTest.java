package com.elasticlearning.test;

import cern.colt.matrix.tdouble.DoubleMatrix2D;
import cern.colt.matrix.tdouble.impl.DenseDoubleMatrix2D;

import com.elasticlearning.utils.*;
import com.elasticlearning.logisticregression.*;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;

/**
 * User: evidal
 * Date: 11/12/14
 */
public class LogisticRegressionTest {
    static DenseDoubleMatrix2D m;
    static DoubleMatrix2D X;
    static DoubleMatrix2D y;
    static DoubleMatrix2D thetas;

    @BeforeClass
    public static void loadData() {
        File f = new File("C:/DATA/dev/elasticlearn/src/test/resources/matrice.csv");
        m = MatrixIOUtils.loadFromCSV(f);
    }

    @Test
    public void loadDataXY() {
        Assert.assertEquals(new Double(m.getQuick(0,0)), new Double("2104"));
        Assert.assertEquals(new Double(m.getQuick(0,1)), new Double("3"));
        Assert.assertEquals(new Double(m.getQuick(0,2)), new Double("399900"));
        Assert.assertEquals(new Double(m.getQuick(46,0)), new Double("1203"));
        Assert.assertEquals(new Double(m.getQuick(46,1)), new Double("3"));
        Assert.assertEquals(new Double(m.getQuick(46,2)), new Double("239500"));
    }

    @Test
    public void extractXY() {
        X = MatrixUtils.getMatrixX(m);
        y = MatrixUtils.getMatrixY(m);
    }

    @Test
    public void MatrixUtilsLimits() {
        DenseDoubleMatrix2D v = new DenseDoubleMatrix2D(3,1);
        v.setQuick(0,0,1d);
        v.setQuick(1,0,2d);
        v.setQuick(2,0,3d);
        MatrixUtils.getMatrixX(v);
        MatrixUtils.getMatrixY(v);
    }

    @Test
    public void trainLogisticRegression() {
        LogisticRegression h = new LogisticRegression();
        thetas = h.getThetas();
        h.computeCost(X,y,thetas);
        h.train(X,y);
        thetas = h.getThetas();
    }

    @Test
    public void predict() {
        Assert.fail();
    }
}

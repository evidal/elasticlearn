package com.elasticlearning.utils;

import cern.colt.matrix.tdouble.DoubleMatrix2D;

/**
 * User: evidal
 * Date: 12/12/14
 */
public class MatrixUtils {

    public static DoubleMatrix2D getMatrixX(DoubleMatrix2D m) {
        return m.viewPart(0,0,m.rows(),m.columns() - 2);
    }

    public static DoubleMatrix2D getMatrixY(DoubleMatrix2D m) {
        return m.viewPart(0,m.columns()-1,m.rows(),1);
    }
}

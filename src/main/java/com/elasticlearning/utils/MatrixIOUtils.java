package com.elasticlearning.utils;

import cern.colt.matrix.tdouble.impl.DenseDoubleMatrix2D;
import lombok.extern.log4j.Log4j;

import java.io.*;

/**
 * User: evidal
 * Date: 11/12/14
 */
@Log4j
public class MatrixIOUtils {

    public static DenseDoubleMatrix2D loadFromCSV(File file) {
        DenseDoubleMatrix2D m = null;
        BufferedReader in = null;
        int rows;

        try {
            rows = countLines(file);
            in = new BufferedReader(new FileReader(file));
            int i = 0;
            while (in.ready()) {
                String s = in.readLine();
                String[] elems = s.split(",");
                int columns = elems.length;
                if(m == null) {
                    m = new DenseDoubleMatrix2D(rows,columns);
                }
                for(int j=0; j < columns; j++) {
                    m.setQuick(i,j,Double.parseDouble(elems[j]));
                }
                i++;
            }
        } catch (FileNotFoundException e) {
            log.error("File " + file.getAbsoluteFile() + "not found.");
        } catch (IOException e) {
            log.error("Can't read " + file.getAbsoluteFile() + ".");
        } finally {
            if(in != null)try{in.close();}catch (Exception e){};
        }
        return m;
    }

    private static int countLines(File file) throws IOException {
        int rows;
        InputStream is = null;

        try {
            // Get Number of Line
            is = new BufferedInputStream(new FileInputStream(file));
            byte[] c = new byte[1024];
            int count = 0;
            int readChars = 0;
            boolean empty = true;
            while ((readChars = is.read(c)) != -1) {
                empty = false;
                for (int i = 0; i < readChars; ++i) {
                    if (c[i] == '\n') {
                        ++count;
                    }
                }
            }
            rows = (count == 0 && !empty) ? 1 : count;
        } finally {
            if(is != null)try{is.close();}catch (Exception e){};
        }
        return rows;
    }

    public static void writeToFile(File location)  {
        throw new UnsupportedOperationException("Not Yet Implented");
    }
}

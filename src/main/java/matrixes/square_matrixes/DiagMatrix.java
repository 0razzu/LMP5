package matrixes.square_matrixes;


import matrixes.MatrixErrorCode;

import static java.lang.Math.abs;


public class DiagMatrix extends TriangleMatrix {
    public DiagMatrix(int dimension) {
        super(dimension);
    }
    
    
    @Override
    public void setElem(int row, int column, double value) {
        checkIndexes(row, column);
        
        if (abs(value) > EPS && row != column)
            throw new ArrayIndexOutOfBoundsException(
                String.format(MatrixErrorCode.INCORRECT_INDEXES.getErrorString(), dimension, row, column));
        
        data[row] = value;
    }
    
    
    @Override
    public double getElem(int row, int column) {
        checkIndexes(row, column);
        
        return data[row];
    }
}

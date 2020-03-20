package matrixes.square_matrixes;


import matrixes.MatrixErrorCode;

import static java.lang.Math.abs;


public class UpTriangleMatrix extends TriangleMatrix {
    public UpTriangleMatrix(int dimension) {
        super(dimension);
        
        data = new double[dimension * (dimension + 1) / 2];
    }
    
    
    @Override
    public void setElem(int row, int column, double value) {
        checkIndexes(row, column);
        
        if (abs(value) > EPS && row > column)
            throw new ArrayIndexOutOfBoundsException(
                    String.format(MatrixErrorCode.INCORRECT_INDEXES.getErrorString(), dimension, row, column));
        
        data[row * dimension + column - row * (row + 1) / 2] = value;
        
        if (row == column)
            determinantCalculated = false;
    }
    
    
    @Override
    public double getElem(int row, int column) {
        checkIndexes(row, column);
        
        if (row > column)
            return 0;
        
        return data[row * dimension + column - row * (row + 1) / 2];
    }
    
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        
        if (o instanceof UpTriangleMatrix) {
            UpTriangleMatrix that = (UpTriangleMatrix) o;
            
            if (dimension != that.dimension)
                return false;
            
            for (int i = 0; i < data.length; i++)
                if (abs(data[i] - that.data[i]) > EPS)
                    return false;
        }
        
        return super.equals(o);
    }
}

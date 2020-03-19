package matrixes.square_matrixes;


import matrixes.MatrixErrorCode;


public class DiagMatrix extends TriangleMatrix {
    public DiagMatrix(int dimension) {
        super(dimension);
    }
    
    
    @Override
    protected void checkIndexes(int row, int column) {
        if (row != column || row < 0 || row >= dimension)
            throw new ArrayIndexOutOfBoundsException(
                    String.format(MatrixErrorCode.INCORRECT_INDEXES.getErrorString(), dimension, row, column));
    }
    
    
    @Override
    public void setElem(int row, int column, double value) {
        checkIndexes(row, column);
        
        data[row] = value;
    }
    
    
    @Override
    public double getElem(int row, int column) {
        checkIndexes(row, column);
        
        return data[row];
    }
}

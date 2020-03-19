package matrixes.square_matrixes;


import matrixes.MatrixErrorCode;


public abstract class TriangleMatrix extends SquareMatrix {
    public TriangleMatrix(int dimension) {
        super();
    
        if (dimension <= 0)
            throw new IllegalArgumentException(
                    String.format(MatrixErrorCode.NON_POSITIVE_DIMENSTION.getErrorString(), dimension));
        
        this.dimension = dimension;
        data = new double[dimension];
    }
    
    
    @Override
    protected abstract void checkIndexes(int row, int column);
    
    
    @Override
    public abstract void setElem(int row, int column, double value);
    
    
    @Override
    public abstract double getElem(int row, int column);
    
    
    @Override
    public double getDeterminant() {
        if (determinantCalculated)
            return determinant;
        
        determinant = 1;
        
        for (int i = 0; i < dimension; i++)
            determinant *= data[i];
        
        determinantCalculated = true;
        return determinant;
    }
}

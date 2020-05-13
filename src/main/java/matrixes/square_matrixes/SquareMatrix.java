package matrixes.square_matrixes;


import matrixes.IMatrix;
import matrixes.MatrixErrorCode;

import java.util.Arrays;

import static java.lang.Math.abs;


public class SquareMatrix implements IMatrix {
    public static final double EPS = 1E-9;
    protected double[] data;
    protected int dimension;
    protected double determinant;
    protected boolean determinantCalculated;
    
    /* Филиппов А.В. 14.05.2020 Комментарий не удалять.
     Размер матрицы равный 0 - это удобная абстракция, т.к. иначе вместо матрицы придется использовать null,
     а это дополнительные проверки.
    */
    
    // fixed
    
    public SquareMatrix(int dimension) {
        if (dimension < 0)
            throw new IllegalArgumentException(
                    String.format(MatrixErrorCode.NEGATIVE_DIMENSION, dimension));
        
        this.dimension = dimension;
        data = new double[dimension * dimension];
    }
    
    
    protected SquareMatrix() {
    }
    
    
    protected void checkIndexes(int row, int column) {
        if (row < 0 || column < 0 || row >= dimension || column >= dimension)
            throw new ArrayIndexOutOfBoundsException(
                    String.format(MatrixErrorCode.INCORRECT_INDEXES, dimension, row, column));
    }
    
    
    @Override
    public void setElem(int row, int column, double value) {
        checkIndexes(row, column);
        
        data[row * dimension + column] = value;
        determinantCalculated = false;
    }
    
    
    @Override
    public double getElem(int row, int column) {
        checkIndexes(row, column);
        
        return data[row * dimension + column];
    }
    
    
    public int getDimension() {
        return dimension;
    }
    
    
    @Override
    public double getDeterminant() {
        if (dimension == 0)
            throw new IllegalArgumentException(MatrixErrorCode.ZERO_DIMENSION);
        
        if (determinantCalculated)
            return determinant;

        /* Филиппов А.В. 14.05.2020 Комментарий не удалять.
         зачем работать с массивом, когда можно создать еще одну squarematrix
         (нужен только конструктор копирования и метод переставляющий две строки)?
        */
        double[][] dataCopy = new double[dimension][dimension];
        
        for (int i = 0; i < dimension; i++)
            System.arraycopy(data, i * dimension, dataCopy[i], 0, dimension);
        
        determinant = 1;
        
        for (int i = 0; i < dimension - 1; i++) {
            if (abs(dataCopy[i][i]) < EPS)
                for (int k = i + 1; k < dimension; k++)
                    if (abs(dataCopy[k][i]) > EPS) {
                        double[] t = dataCopy[k];
                        dataCopy[k] = dataCopy[i];
                        dataCopy[i] = t;
                        determinant *= -1;
                        break;
                    }
            
            if (abs(dataCopy[i][i]) < EPS) {
                determinant = 0;
                determinantCalculated = true;
                return determinant;
            }
            
            determinant *= dataCopy[i][i];
            
            for (int k = i + 1; k < dimension; k++) {
                double coef = dataCopy[k][i] / dataCopy[i][i];
                dataCopy[k][i] = 0;
                
                if (abs(coef) > EPS)
                    for (int j = i + 1; j < dimension; j++)
                        dataCopy[k][j] -= coef * dataCopy[i][j];
            }
        }
        
        determinant *= dataCopy[dimension - 1][dimension - 1];
        
        determinantCalculated = true;
        return determinant;
    }
    
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SquareMatrix)) return false;
        SquareMatrix that = (SquareMatrix) o;
        
        if (dimension != that.dimension)
            return false;
        
        for (int i = 0; i < dimension; i++)
            for (int j = 0; j < dimension; j++)
                if (abs(getElem(i, j) - that.getElem(i, j)) > EPS)
                    return false;
        
        return true;
    }
    
    
    @Override
    public int hashCode() {
        return Arrays.hashCode(data);
    }
}

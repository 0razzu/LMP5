import java.util.Arrays;
import java.util.Objects;

import static java.lang.Math.abs;


public class SquareMatrix implements IMatrix {
    public static final double EPS = 1E-9;
    private double[] data;
    private int dimension;
    private double determinant;
    private boolean determinantCalculated;
    
    
    public SquareMatrix(int dimension) {
        this.dimension = dimension;
        data = new double[dimension * dimension];
    }
    
    
    private void checkIndexes(int row, int column) {
        if (row < 0 || column < 0 || row >= dimension || column >= dimension)
            throw new ArrayIndexOutOfBoundsException(
                    String.format("dimension = %d, row = %d, column = %d", dimension, row, column));
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
        if (determinantCalculated)
            return determinant;
        
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
        
        if (dimension != (that.dimension))
            return false;
        
        for (int i = 0; i < data.length; i++)
            if (abs(data[i] - that.data[i]) > EPS)
                return false;
        
        return true;
    }
    
    
    @Override
    public int hashCode() {
        int result = Objects.hash(dimension);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }
}
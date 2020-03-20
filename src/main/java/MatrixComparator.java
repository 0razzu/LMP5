import matrixes.IMatrix;

import java.util.Comparator;


public class MatrixComparator implements Comparator<IMatrix> {
    @Override
    public int compare(IMatrix o1, IMatrix o2) {
        return Double.compare(o1.getDeterminant(), o2.getDeterminant());
    }
}

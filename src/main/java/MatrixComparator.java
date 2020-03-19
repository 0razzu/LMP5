import matrixes.IMatrix;

import java.util.Comparator;


public class MatrixComparator<M extends IMatrix> implements Comparator<M> {
    @Override
    public int compare(M o1, M o2) {
        return Double.compare(o1.getDeterminant(), o2.getDeterminant());
    }
}

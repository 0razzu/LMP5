import matrixes.IMatrix;

import java.util.Arrays;


public class MatrixService {
    public static void arrangeMatrixes(IMatrix[] matrixes) {
        Arrays.sort(matrixes, new MatrixComparator());
    }
}

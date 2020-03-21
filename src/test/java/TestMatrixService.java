import matrixes.IMatrix;
import matrixes.square_matrixes.DiagMatrix;
import matrixes.square_matrixes.SquareMatrix;
import matrixes.square_matrixes.TriangleMatrix;
import matrixes.square_matrixes.UpTriangleMatrix;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestMatrixService {
    @Test
    void testArrangeMatrixesSquare1() {
        SquareMatrix matrix1 = new SquareMatrix(1);
        SquareMatrix matrix2 = new SquareMatrix(1);
        SquareMatrix matrix3 = new SquareMatrix(1);
        SquareMatrix[] array = {matrix1, matrix2, matrix3};
        
        matrix1.setElem(0, 0, 1);
        
        matrix3.setElem(0, 0, -12.2);
        
        MatrixService.arrangeMatrixes(array);
        
        assertArrayEquals(new SquareMatrix[]{matrix3, matrix2, matrix1}, array);
    }
    
    
    @Test
    void testArrangeMatrixesSquare2() {
        SquareMatrix matrix1 = new SquareMatrix(2);
        IMatrix matrix2 = new SquareMatrix(3);
        SquareMatrix matrix3 = new SquareMatrix(3);
        IMatrix[] array = {matrix1, matrix2, matrix3};
        
        matrix1.setElem(0, 0, 1);  matrix1.setElem(0, 1, 2);
        matrix1.setElem(1, 0, -1); matrix1.setElem(1, 1, 20);
    
        matrix2.setElem(0, 0, 3);  matrix2.setElem(0, 1, 2);  matrix2.setElem(0, 2, 1);
                                   matrix2.setElem(1, 1, 2);
        matrix2.setElem(2, 0, 1);  matrix2.setElem(2, 1, 4);  matrix2.setElem(2, 2, 4);
        
        matrix3.setElem(0, 0, 1);
        matrix3.setElem(1, 1, 2);
        matrix3.setElem(2, 2, 3);
    
        MatrixService.arrangeMatrixes(array);
        
        assertArrayEquals(new IMatrix[]{matrix3, matrix1, matrix2}, array);
    }
    
    
    @Test
    void testArrangeMatrixesDiag1() {
        DiagMatrix matrix1 = new DiagMatrix(1);
        DiagMatrix matrix2 = new DiagMatrix(1);
        DiagMatrix matrix3 = new DiagMatrix(1);
        DiagMatrix[] array = {matrix1, matrix2, matrix3};
    
        matrix2.setElem(0, 0, 1);
        
        matrix3.setElem(0, 0, -12.2);
        
        MatrixService.arrangeMatrixes(array);
        
        assertArrayEquals(new DiagMatrix[]{matrix3, matrix1, matrix2}, array);
    }
    
    
    @Test
    void testArrangeMatrixesDiag2() {
        DiagMatrix matrix1 = new DiagMatrix(2);
        IMatrix matrix2 = new DiagMatrix(3);
        TriangleMatrix matrix3 = new DiagMatrix(3);
        IMatrix matrix4 = new DiagMatrix(4);
        IMatrix[] array = {matrix1, matrix2, matrix3, matrix4};
    
        matrix1.setElem(0, 0, 1);
        matrix1.setElem(1, 1, 20);
    
        matrix2.setElem(0, 0, 4);
        matrix2.setElem(1, 1, 1);
        matrix2.setElem(2, 2, 5);
    
        matrix3.setElem(0, 0, 1);
        matrix3.setElem(1, 1, 2);
        matrix3.setElem(2, 2, 3);
    
        matrix4.setElem(0, 0, -0.1);
        matrix4.setElem(1, 1, 2.5);
        matrix4.setElem(2, 2, -50);
        matrix4.setElem(3, 3, 0.8);
    
        MatrixService.arrangeMatrixes(array);
    
        assertArrayEquals(new IMatrix[]{matrix3, matrix4, matrix1, matrix2}, array);
    }
    
    
    @Test
    void testArrangeMatrixesUp1() {
        UpTriangleMatrix matrix1 = new UpTriangleMatrix(1);
        UpTriangleMatrix matrix2 = new UpTriangleMatrix(1);
        UpTriangleMatrix matrix3 = new UpTriangleMatrix(1);
        UpTriangleMatrix matrix4 = new UpTriangleMatrix(1);
        UpTriangleMatrix[] array = {matrix1, matrix2, matrix3, matrix4};
        
        matrix2.setElem(0, 0, 11);
        
        matrix4.setElem(0, 0, -1);
        
        MatrixService.arrangeMatrixes(array);
        
        assertArrayEquals(new UpTriangleMatrix[]{matrix4, matrix1, matrix3, matrix2}, array);
    }
    
    
    @Test
    void testArrangeMatrixesUp2() {
        UpTriangleMatrix matrix1 = new UpTriangleMatrix(2);
        IMatrix matrix2 = new UpTriangleMatrix(3);
        TriangleMatrix matrix3 = new UpTriangleMatrix(15);
        IMatrix matrix4 = new UpTriangleMatrix(11);
        IMatrix[] array = {matrix1, matrix2, matrix3, matrix4};
        
        matrix1.setElem(0, 0, 20); matrix1.setElem(0, 1, 11);
                                   matrix1.setElem(1, 1, -1);
        
        matrix2.setElem(0, 0, 4);  matrix1.setElem(0, 1, 20);
                                   matrix2.setElem(1, 1, 10);  matrix2.setElem(1, 2, 3);
                                                               matrix2.setElem(2, 2, 0.5);
        
        for (int i = 0; i < 15; i++)
            for (int j = i; j < 15; j++)
                matrix3.setElem(i, j, -1);
    
        MatrixService.arrangeMatrixes(array);
        
        assertArrayEquals(new IMatrix[]{matrix1, matrix3, matrix4, matrix2}, array);
    }
    
    
    @Test
    void testArrangeMatrixesDiff() {
        IMatrix matrix1 = new SquareMatrix(1);
        TriangleMatrix matrix2 = new DiagMatrix(2);
        SquareMatrix matrix3 = new SquareMatrix(3);
        UpTriangleMatrix matrix4 = new UpTriangleMatrix(4);
        IMatrix[] array = {matrix1, matrix2, matrix3, matrix4};
        
        matrix1.setElem(0, 0, 10);
        
        matrix2.setElem(0, 0, -8);
        matrix2.setElem(1, 1, 1.25);
        
        matrix3.setElem(0, 0, 1);  matrix3.setElem(0, 1, 2);
        matrix3.setElem(1, 0, -1); matrix3.setElem(1, 1, -2); matrix3.setElem(1, 2, 3);
        matrix3.setElem(2, 0, 11);
    
        matrix4.setElem(0, 0, -3);                                                             matrix4.setElem(0, 3, 5);
                                     matrix4.setElem(1, 1, -0.2); matrix4.setElem(1, 2, 3);
                                                                  matrix4.setElem(2, 2, 27.5); matrix4.setElem(2, 3, 8);
                                                                                               matrix4.setElem(3, 3, -2);
    
        MatrixService.arrangeMatrixes(array);
    
        assertArrayEquals(new IMatrix[]{matrix4, matrix2, matrix1, matrix3}, array);
    }
}

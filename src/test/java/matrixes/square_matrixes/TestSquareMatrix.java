package matrixes.square_matrixes;


import matrixes.IMatrix;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestSquareMatrix {
    @Test
    void testConstr() {
        SquareMatrix matrix = new SquareMatrix(2);
        
        assertAll(
                () -> assertEquals(2, matrix.getDimension()),
                () -> assertEquals(0, matrix.getElem(0, 0)),
                () -> assertEquals(0, matrix.getElem(0, 1)),
                () -> assertEquals(0, matrix.getElem(1, 0)),
                () -> assertEquals(0, matrix.getElem(1, 1))
        );
    }
    
    
    @Test
    void testConstrExceptions() {
        try {
            IMatrix matrix1 = new SquareMatrix(-5);
        } catch (IllegalArgumentException e) {
            assertEquals("Matrix dimension must be positive, but was -5", e.getMessage());
        }
    
        try {
            IMatrix matrix2 = new SquareMatrix(0);
        } catch (IllegalArgumentException e) {
            assertEquals("Matrix dimension must be positive, but was 0", e.getMessage());
        }
    }
    
    
    @Test
    void testElem() {
        IMatrix matrix = new SquareMatrix(3);
    
        matrix.setElem(0, 0, 10); matrix.setElem(0, 1, -2.1); matrix.setElem(0, 2, 2.25);
        matrix.setElem(2, 0, -1); matrix.setElem(2, 1, 110321);
        
        assertAll(
                () -> assertEquals(10, matrix.getElem(0, 0)),
                () -> assertEquals(-2.1, matrix.getElem(0, 1)),
                () -> assertEquals(2.25, matrix.getElem(0, 2)),
                () -> assertEquals(0, matrix.getElem(1, 0)),
                () -> assertEquals(0, matrix.getElem(1, 1)),
                () -> assertEquals(0, matrix.getElem(1, 2)),
                () -> assertEquals(-1, matrix.getElem(2, 0)),
                () -> assertEquals(110321, matrix.getElem(2, 1)),
                () -> assertEquals(0, matrix.getElem(2, 2))
        );
    }
    
    
    @Test
    void testSetElemExceptions() {
        IMatrix matrix1 = new SquareMatrix(4);
        IMatrix matrix2 = new SquareMatrix(9);
        
        try {
            matrix1.setElem(-1, 1, 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertEquals("Incorrect indexes: dimension = 4, row = -1, column = 1", e.getMessage());
        }
    
        try {
            matrix2.setElem(1, -1, 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertEquals("Incorrect indexes: dimension = 9, row = 1, column = -1", e.getMessage());
        }
    
        try {
            matrix2.setElem(10, 2, 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertEquals("Incorrect indexes: dimension = 9, row = 10, column = 2", e.getMessage());
        }
    
        try {
            matrix1.setElem(3, 4, 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertEquals("Incorrect indexes: dimension = 4, row = 3, column = 4", e.getMessage());
        }
    }
    
    
    @Test
    void testGetElemExceptions() {
        IMatrix matrix1 = new SquareMatrix(3);
        IMatrix matrix2 = new SquareMatrix(10);
        
        try {
            double a = matrix1.getElem(-2, 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertEquals("Incorrect indexes: dimension = 3, row = -2, column = 1", e.getMessage());
        }
        
        try {
            double b = matrix2.getElem(1, -1);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertEquals("Incorrect indexes: dimension = 10, row = 1, column = -1", e.getMessage());
        }
        
        try {
            double c = matrix2.getElem(10, 2);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertEquals("Incorrect indexes: dimension = 10, row = 10, column = 2", e.getMessage());
        }
        
        try {
            double d = matrix1.getElem(31, 0);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertEquals("Incorrect indexes: dimension = 3, row = 31, column = 0", e.getMessage());
        }
    }
    
    
    @Test
    void testGetDeterminant1() {
        IMatrix matrix = new SquareMatrix(1);
        
        matrix.setElem(0, 0, 100.2);
        
        assertEquals(100.2, matrix.getDeterminant(), SquareMatrix.EPS);
    }
    
    
    @Test
    void testGetDeterminant2() {
        IMatrix matrix = new SquareMatrix(2);
        
        matrix.setElem(0, 0, 5);  matrix.setElem(0, 1, -2);
        matrix.setElem(1, 0, 10); matrix.setElem(1, 1, 3.5);
        
        assertEquals(37.5, matrix.getDeterminant(), SquareMatrix.EPS);
    }
    
    
    @Test
    void testGetDeterminant3() {
        IMatrix matrix = new SquareMatrix(2);
        
        matrix.setElem(0, 0, 0);   matrix.setElem(0, 1, 9);
        matrix.setElem(1, 0, 3.1); matrix.setElem(1, 1, 11);
        
        assertEquals(-27.9, matrix.getDeterminant(), SquareMatrix.EPS);
    }
    
    
    @Test
    void testGetDeterminant4() {
        IMatrix matrix = new SquareMatrix(3);
        
        matrix.setElem(0, 0, 1); matrix.setElem(0, 1, 2); matrix.setElem(0, 2, 2);
        matrix.setElem(1, 0, 8); matrix.setElem(1, 1, 3); matrix.setElem(1, 2, 4);
        matrix.setElem(2, 0, 1); matrix.setElem(2, 1, 1); matrix.setElem(2, 2, 5);
        
        assertEquals(-51, matrix.getDeterminant(), SquareMatrix.EPS);
    }
    
    
    @Test
    void testGetDeterminant5() {
        IMatrix matrix = new SquareMatrix(3);
        
        matrix.setElem(0, 0, 0); matrix.setElem(0, 1, 0); matrix.setElem(0, 2, 2);
        matrix.setElem(1, 0, 0); matrix.setElem(1, 1, 3); matrix.setElem(1, 2, 4);
        matrix.setElem(2, 0, 1); matrix.setElem(2, 1, 1); matrix.setElem(2, 2, 5);
        
        assertEquals(-6, matrix.getDeterminant(), SquareMatrix.EPS);
    }
    
    
    @Test
    void testGetDeterminant6() {
        IMatrix matrix = new SquareMatrix(4);
        
        matrix.setElem(0, 0, -1); matrix.setElem(0, 1, 2);  matrix.setElem(0, 2, -3); matrix.setElem(0, 3, 4);
        matrix.setElem(1, 0, 31); matrix.setElem(1, 1, 0);  matrix.setElem(1, 2, -2); matrix.setElem(1, 2, 480);
        matrix.setElem(2, 0, 1);  matrix.setElem(2, 1, -2); matrix.setElem(2, 2, 3);  matrix.setElem(2, 3, -4);
        matrix.setElem(3, 0, 18); matrix.setElem(3, 1, 56); matrix.setElem(3, 2, 5);  matrix.setElem(3, 2, 5.91);
        
        assertEquals(0, matrix.getDeterminant(), SquareMatrix.EPS);
    }
    
    
    @Test
    void testGetDeterminant7() {
        IMatrix matrix = new SquareMatrix(4);
        
        matrix.setElem(0, 0, 1); matrix.setElem(0, 1, 1); matrix.setElem(0, 2, 2); matrix.setElem(0, 3, 3);
                                                          matrix.setElem(1, 2, 4); matrix.setElem(1, 3, 2);
                                                          matrix.setElem(2, 2, 5); matrix.setElem(2, 3, 1);
        matrix.setElem(3, 0, 2); matrix.setElem(3, 1, 2); matrix.setElem(3, 2, 1); matrix.setElem(3, 3, 5);
        
        assertEquals(0, matrix.getDeterminant(), SquareMatrix.EPS);
    }
    
    
    @Test
    void testGetDeterminant8() {
        IMatrix matrix = new SquareMatrix(7);
        
        matrix.setElem(0, 4, 1);  matrix.setElem(0, 5, 20); matrix.setElem(0, 6, 4);
        matrix.setElem(1, 4, 2);  matrix.setElem(1, 5, 1);  matrix.setElem(1, 6, 2);
        matrix.setElem(2, 4, 1);
        
        matrix.setElem(3, 0, 10); matrix.setElem(3, 1, 3);
        matrix.setElem(4, 0, 3);  matrix.setElem(4, 1, 2);
        
        matrix.setElem(5, 2, 1);
        matrix.setElem(6, 2, 2);  matrix.setElem(6, 3, 1);
        
        assertAll(
                () -> assertEquals(396, matrix.getDeterminant(), SquareMatrix.EPS),
                () -> assertEquals(396, matrix.getDeterminant(), SquareMatrix.EPS)
        );
    }
}

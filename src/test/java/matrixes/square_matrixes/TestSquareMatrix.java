package matrixes.square_matrixes;


import matrixes.IMatrix;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestSquareMatrix {
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
        IMatrix matrix = new SquareMatrix(7);
        
        matrix.setElem(0, 4, 1);  matrix.setElem(0, 5, 20); matrix.setElem(0, 6, 4);
        matrix.setElem(1, 4, 2);  matrix.setElem(1, 5, 1);  matrix.setElem(1, 6, 2);
        matrix.setElem(2, 4, 1);
        
        matrix.setElem(3, 0, 10); matrix.setElem(3, 1, 3);
        matrix.setElem(4, 0, 3);  matrix.setElem(4, 1, 2);
        
        matrix.setElem(5, 2, 1);
        matrix.setElem(6, 2, 2);  matrix.setElem(6, 3, 1);
        
        assertEquals(396, matrix.getDeterminant(), SquareMatrix.EPS);
    }
}

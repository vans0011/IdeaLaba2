package org.example;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;;
import java.io.FileNotFoundException;


class AppTest {

    private App m;

    @Before
    public void init() {
        m = new App();
    }

    @After
    public void tearDown() {
        m = null;
    }

    @Test
    public void readFile() throws FileNotFoundException {
        int[] matrix = {1,6,7,5,6,7,9,6,8,7};
        assertArrayEquals(matrix, m.read());
    }

    @Test
    public void sum() {
        double[][] matrix1 = {{1,1},{1,1}};
        double[][] matrix2 = {{1,2},{1,2}};
        double[][] result = {{2,3},{2,3}};
        assertArrayEquals(result, m.sum(matrix1, matrix2));
    }
    @Test
    public void multiply() {
        double[][] matrix1 = {{2,2},{2,2}};
        double[][] matrix2 = {{2,3},{2,3}};
        double[][] result = {{4,6},{4,6}};
        assertArrayEquals(result, m.multiply(matrix1, matrix2));
    }
    @Test
    public void comparison() {
        double[][] matrix1 = {{1,4},{3,2}};
        double[][] matrix2 = {{2,1},{1,1}};
        int result = m.comparison(matrix1, matrix2);
        Assert.assertEquals(-1, result);
    }
    @Test
    public void difference() {
        double[][] matrix1 = {{5,5},{5,5}};
        double[][] matrix2 = {{2,3},{2,3}};
        double[][] result = {{3,2},{3,2}};
        assertArrayEquals(result, m.difference(matrix1, matrix2));
    }
    @Test
    public void division() {
        double[][] matrix1 = {{1,1},{1,1}};
        double[][] matrix2 = {{2,2},{2,2}};
        double[][] result = {{1,1},{1,1}};
        assertArrayEquals(result, m.division(matrix1, matrix2));
    }

    @Test
    void testApp() {
        assertEquals(1, 1);
    }

    @ParameterizedTest
    @ValueSource(strings = { "1, 2, 3, 4, 1 ", "1, 3, 4, 3, 1 ", "1, 2, 3, 2, 1 ", "1, 3, 4, 3, 1 "})
    void palindrome(String date) {
        assertTrue(App.palindrome(date));
    }

    @Test
    public void transposition() {
        double[][] matrix1 = {{1,4,5},{6,2,6},{5,0,8}};
        double[][] matrix2 = {{1,6,5},{4,2,0},{5,6,8}};
        assertArrayEquals(matrix2, m.transposition(matrix1));
    }

    @Test
    public void determinant() throws FileNotFoundException {
        double[][] matrix= {{2,5,2},{6,2,9},{5,0,8}};
        assertEquals(-3, m.determinant(matrix));
    }

    @Test
    public void minor() {
        double[][] matrix1 = {{2,5},{6,2}};
        double[][] matrix2 = {{2}};
        assertArrayEquals(matrix2, m.minor(matrix1,1,1));
    }

}

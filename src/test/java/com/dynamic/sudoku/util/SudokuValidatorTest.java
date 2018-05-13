package com.dynamic.sudoku.util;

import com.dynamic.sudoku.exception.DynamicSudokuException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Created by Animesh Kumar on 12-05-2018.
 */
public class SudokuValidatorTest {

    @Test
    public void testTrueSudoku() throws DynamicSudokuException{
        SudokuValidator sudokuValidator = new SudokuValidator();
        boolean result = sudokuValidator.isValid(getClass().getClassLoader().getResource("sample_data/sudoku9_9.txt").getFile());

        assertTrue(result);
    }

    @Test(expected =DynamicSudokuException.class)
    public void testFalseSudoku() throws DynamicSudokuException{
        SudokuValidator sudokuValidator = new SudokuValidator();
        boolean result = sudokuValidator.isValid(getClass().getClassLoader().getResource("sample_data/sudoku4_4_bad.txt").getFile());

    }

    @Test(expected =DynamicSudokuException.class)
    public void testErrorSudoku() throws DynamicSudokuException{
        SudokuValidator sudokuValidator = new SudokuValidator();
        boolean result = sudokuValidator.isValid(getClass().getClassLoader().getResource("sample_data/sudoku4_4_error.txt").getFile());

        assertFalse(result);
    }

}

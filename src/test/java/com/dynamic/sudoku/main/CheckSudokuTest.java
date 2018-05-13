package com.dynamic.sudoku.main;

import com.dynamic.sudoku.exception.DynamicSudokuException;
import org.junit.Test;

/**
 * Created by Animesh Kumar on 12-05-2018.
 */
public class CheckSudokuTest {

    @Test
    public void testBadCheckSudoku() throws DynamicSudokuException{
        CheckSudoku.main(new String[]{getClass().getClassLoader().getResource("sample_data/sudoku4_4_bad.txt").getFile()});
    }

    @Test(expected =DynamicSudokuException.class )
    public void testMultipleFile() throws DynamicSudokuException{
        CheckSudoku.main(new String[]{getClass().getClassLoader().getResource("sample_data/sudoku4_4_bad.txt").getFile(),
                getClass().getClassLoader().getResource("sample_data/sudoku4_4.txt").getFile()});
    }

    @Test(expected =DynamicSudokuException.class )
    public void testZeroFile() throws DynamicSudokuException{
        CheckSudoku.main(new String[]{});
    }
}

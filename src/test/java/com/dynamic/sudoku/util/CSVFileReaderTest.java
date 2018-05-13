package com.dynamic.sudoku.util;

import com.dynamic.sudoku.exception.DynamicSudokuException;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Animesh Kumar on 12-05-2018.
 */
public class CSVFileReaderTest {

    @Test(expected=DynamicSudokuException.class)
    public void testFileNotFound() throws DynamicSudokuException {
        CSVFileReader csvFileReader = new CSVFileReader();
        csvFileReader.readFile("");
    }

    @Test
    public void testReadFile() throws DynamicSudokuException {
        CSVFileReader csvFileReader = new CSVFileReader();
        List<List<Integer>> sudoku = csvFileReader.readFile(getClass().getClassLoader().getResource("sample_data/sudoku9_9.txt").getFile());

        assertNotNull(sudoku);
        assertEquals("[[5, 6, 9, 4, 7, 1, 3, 8, 2], [7, 3, 2, 5, 9, 8, 4, 1, 6], " +
                "[8, 1, 4, 2, 3, 6, 7, 9, 5], [6, 8, 7, 1, 2, 9, 5, 4, 3], " +
                "[4, 5, 1, 8, 6, 3, 9, 2, 7], [2, 9, 3, 7, 5, 4, 8, 6, 1], " +
                "[1, 7, 8, 6, 4, 5, 2, 3, 9], [3, 4, 5, 9, 1, 2, 6, 7, 8], " +
                "[9, 2, 6, 3, 8, 7, 1, 5, 4]]",sudoku.toString());
    }

    @Test(expected = DynamicSudokuException.class)
    public void testErrorFile() throws DynamicSudokuException {
        CSVFileReader csvFileReader = new CSVFileReader();
        List<List<Integer>> sudoku = csvFileReader.readFile(getClass().getClassLoader().getResource("sample_data/sudoku4_4_error.txt").getFile());
    }
}

package com.dynamic.sudoku.util;

import com.dynamic.sudoku.exception.DynamicSudokuException;

import java.util.List;

/**
 * Created by Animesh Kumar on 12-05-2018.
 * This is the validation class which checks the logic for the valid
 * sudoku solution
 */
public class SudokuValidator {

    /**
     * This method verify whether or not passed file
     * contains correct solution. Validation of sudoku solution depends
     * upon uniqueness of the elements, irrespective of size of sudoku
     * every row should have unique elements, in case there are duplicate elements
     * that means solution is incorrect.
     * @param fileName
     * @return isValid
     * @throws DynamicSudokuException
     */
    public boolean isValid(String fileName) throws DynamicSudokuException{
        boolean isValid = true;
        CSVFileReader csvFileReader = new CSVFileReader();
        //parse the file contain and populate the ArrayList of ArrayList object
        List<List<Integer>> sudoku = csvFileReader.readFile(fileName);

        System.out.println("output of file reading: "+sudoku);

        //first for loop to iterate overall sudoku grid
        for(List<Integer> subGrid : sudoku){
            //second for loop to iterate subgrid
            for(int i =0;i<subGrid.size();i++){
                //third for loop to verify the uniqueness of the elements
                for(int j=i+1;j<subGrid.size();j++){
                    if(subGrid.get(i)==subGrid.get(j)){
                        //breaking the for loop at elements are not unique
                        throw new DynamicSudokuException("Incorrect sudoku");
                    }
                }

            }
        }

        System.out.println("isValid Sudoku :"+isValid);

        return isValid;
    }
}

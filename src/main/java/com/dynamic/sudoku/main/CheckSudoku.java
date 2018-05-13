package com.dynamic.sudoku.main;

import com.dynamic.sudoku.exception.DynamicSudokuException;
import com.dynamic.sudoku.util.SudokuValidator;

/**
 * Created by Animesh Kumar on 12-05-2018.
 * This is the main class which will be launched on the startup.
 */
public class CheckSudoku {

    /**
     * This method expects exactly one argument from command line.
     * The argument should be file name contain sudoku solution.
     * Input should be digits and in the form of a CSV (comma-separated value) text
     * file with columns separated by commas and rows separated by newline characters.
     *
     * @param args
     * @throws DynamicSudokuException
     */
    public static void main(String [] args) throws DynamicSudokuException{
        //checking whether exactly one argument is pass
        if(args.length ==0 || args.length>1 ) throw new DynamicSudokuException("Need exactly one file to process the input");

        SudokuValidator validator = new SudokuValidator();
        try {
            //calling validation method to verify the solution
            validator.isValid(args[0]);
            System.out.println("Awesome! You did it, correct sudoku solution");
        } catch (DynamicSudokuException e) {

            if(e.getMessage().equalsIgnoreCase("File Not Found")){
                System.out.println("Please pass the absolute file path");
            }else if(e.getMessage().equalsIgnoreCase("unknown exception occurred")){
                System.out.println("Please check file format,  Input should be digits and in the form of a CSV (comma-separated value) text " +
                        "file with columns separated by commas and rows separated by newline characters");
            }else if(e.getMessage().equalsIgnoreCase("Incorrect sudoku")){
                System.out.println("Please solve again, incorrect sudoku!");
            }else{
                throw new DynamicSudokuException(e);
            }
        }
    }
}

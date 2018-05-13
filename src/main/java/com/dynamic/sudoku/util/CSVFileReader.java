package com.dynamic.sudoku.util;

import com.dynamic.sudoku.exception.DynamicSudokuException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Animesh Kumar on 12-05-2018.
 * This is the file reader/parse class
 */
public class CSVFileReader {
    static final String COMMA_DELIM = "," ;

    /**
     * This method parses the file contain and return List of List.
     * The outer List represent the overall/outer Grid and inner list
     * represent the sub-grid.
     * @param fileName
     * @return List<List<Integer>>
     * @throws DynamicSudokuException
     */
    public List<List<Integer>> readFile(String fileName) throws DynamicSudokuException{
        System.out.println("file name passed: "+fileName);

        BufferedReader reader = null;
        String line= null;
        List<List<Integer>> grid = null;
        List<Integer> subGrid = null;

        try{
            reader = new BufferedReader(new FileReader(fileName));
            int row =0;
            grid = new ArrayList<>();
            while((line=reader.readLine())!=null){
                //splitting each line with comma character and creating array of strings
                String [] values = line.split(COMMA_DELIM);

                subGrid = new ArrayList<>();
                //populating sub-grid with each line
                while(row<values.length){
                    subGrid.add(Integer.parseInt(values[row++]));
                }
                //resetting counter
                row=0;
                //adding each sub-grid into grid
                grid.add(subGrid);
            }

            System.out.println("size of the sudoku: "+grid.size()+"x"+grid.size()+"\nprinting complete sudoku: "+grid);

        }catch (IOException io){
            throw new DynamicSudokuException("File Not Found",io);
        }catch (Exception e){
            throw new DynamicSudokuException("unknown exception occurred",e);
        }finally {
            try {
                if(reader != null) reader.close();
            } catch (IOException e) {
                throw new DynamicSudokuException("unable to release the resource",e);
            }
        }

        return grid;
    }

}

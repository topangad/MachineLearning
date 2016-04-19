package MachineLearning;

import java.util.*;
import java.lang.Integer;
import java.lang.Double;

public class Matrix<T>
{
   private int numRows, numCols;  
   
   //TODO implement HashMap Version
   private HashMap<Integer, HashMap<Integer, Double> > grid;
   
   private T [][] matrix;
   
   public Matrix (int rows, int columns) {
      this.numRows = rows;
      this.numCols = columns;
   }
   
   public Matrix (T [][] grid) {
      this.numRows = grid.length;
      this.numCols = grid[0].length;
      
      for( int rows = 0 ; rows < numRows;rows++ ) {
         for ( int cols = 0; cols < numCols ; cols++) {
            matrix[rows][cols] = grid[rows][cols];
         }
      }
   }
 
   public double numRows()
   {
      return this.numRows;
   }
   
   public double numCols()
   {
      return this.numCols;
   }
   
   public void Transpose()
   {
   }
   
   public void Inverse()
   {
   }
   
   public void Determinant()
   {   
   }
   
   public Matrix<T> Mult(Matrix<T> m2) 
   {
      return null;
   }
}
package MachineLearning;

import java.util.*;
import java.lang.Integer;
import java.lang.Double;

import java.lang.*;

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
 
   public int numRows()
   {
      return this.numRows;
   }
   
   public int numCols()
   {
      return this.numCols;
   }

   public T get(int row, int col) {
      if(row<numRows && col < numCols) {
         return matrix[row][col];
      } else {
         return null;
      }
   }

   public void set(int row, int col, T val) {
      if(row<numRows && col < numCols) {
         this.matrix[row][col] = val;
      }
   }
   
   public Matrix<T> Transpose()
   {
      Matrix<T> trans = new Matrix<T>(this.matrix);
      
      for( int i =0 ; i < numRows ; i++ ) {
         for( int j = 0; j < numCols ; j++) {
            trans.matrix[i][j] = this.matrix[j][i];
         }
      }
      return trans;
   }
   
   public void Inverse()
   {
   }
   
   //Todo
   public void Determinant2x2()
   {      
   }
   
   //should probably optimize with strassens or others that deal well with sparsity
   public Matrix<T> Mult(Matrix<T> m2) 
   {      
      int numElts = 0;
      if( this.numCols != m2.numRows())return null;
      else {
         numElts = this.numCols;
      }

      Matrix <T> ret = new Matrix<T>(this.numRows, m2.numCols());
      for ( int rowm1 = 0; rowm1 < numRows; rowm1++) {
         for (int colm2 = 0; colm2 < m2.numCols(); colm2++) {
            double sum = 0;
            for( int i = 0 ; i < numElts; i ++)
            {
               sum += (double)(Object)this.matrix[rowm1][i]*(double)(Object)m2.get(i, colm2);
            }

            ret.set(rowm1, colm2,(T)(Object) sum);
         }
      }

      return ret;
   }
   
   public void print()
   {
      for ( int i = 0; i < numRows; i++) {
         for( int j = 0 ; j < numCols ; j++) {
            System.out.println(this.matrix[i][j]);
         }
         System.out.println("\n");
      }
   }
}
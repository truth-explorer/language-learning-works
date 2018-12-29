/////////////////////////////////////////////////////////////////////////////////////////////
//
//   GaussJordan.java
//   Runs Gauss Jordan Elimination on a matrix
//
//   @author Patrick Tantalo, UCSC (with edits by Gateway Computing staff)
//
//   Input file format.
//   The first line of an input file consists of two integers n and m, separated by a space,
//   giving the number of rows and columns, respectively.  The next n lines of the input file
//   specify the n rows of the matrix.  Each line is a space separated list of m real numbers.
//   Note that the number of spaces separating the numbers in each row is irrelevant.
//
//   Example 1  (Save as a text file called in1.txt, has solution)
//   3 4
//   0 1  1 4
//   2 4 -2 2 
//   0 3 15 36
//
//   Example 2  (Save as text file in2.txt; no solutions)
//   5 6
//   2 -3 -1 2 3 4
//   4 -4 -1 4 11 4
//   2 -5 -2 2 -1 9
//   0 2 1 0 4 -6
//   -4 6 0 0 7 5
//
/////////////////////////////////////////////////////////////////////////////////////////////

import java.io.*;
import java.util.Scanner;

class GaussJordan{

 
   /** Swap two rows in an array.
    *  @param A the array 
    *  @param i the first row index
    *  @param k the second row index
    */
   public static void swap(double[][] A, int i, int k) {
      double[] temp = A[i];
      A[i] = A[k];
      A[k] = temp;
   
   }


   /** Divide all values in a row by element A[i][j]
     * pre-condition: A[i][j] != 0, A[i][q] == 0 for 0 <= q < j
     * post-condition: A[i][j] == 1;
     * @param A the array to update
     * @param i the index of the row to be divided and the element
     * @param j the column index of the element
     */
   public static void divide(double[][] A, int i, int j){
      assert (A[i][j] != 0);
      for (int q = 0; q < j; q++)
         assert(A[i][q] == 0);
      double div = A[i][j];
      for (int k = 0; k < A[i].length; k++) {
         A[i][k] /= div;
      }  
     
      
   
   }
   
   /** Subtract an appropriate multiple of row i 
    * from every other row in an array.
    * pre-condition: A[i][j] == 1, A[i][q] == 0 for 0 <= q < j
    * post-condition: A[p][j] == 0 for p != i
    * @param A the array to update
    * @param i the row index
    * @param j the column index for where to start
    */
   public static void eliminate(double[][] A, int i, int j){
   
      assert A[i][j] == 1;
      for (int q = 0; q < j; q++) {
         assert A[i][q] == 0;
      }
   
      int n = A.length;
      int m = A[0].length;
      for (int p = 0; p < n; p++){
         if (p != i && A[p][j] != 0 ){
            for (int q = j + 1; q < m; q++){
               A[p][q] -= A[p][j]*A[i][q];
            }
            A[p][j] = 0;
         }
      }
   }


   /** Main: read input file, initialize matrix, 
    *  perform Gauss-Jordan Elimination, and write resulting matrices
    *  to output.
    *  @param args the command-line arguments
    */
   public static void main(String[] args) throws IOException {
      int n, m, i, j, k;
   
      Scanner key = new Scanner(System.in);
      System.out.println("enter input filename: ");
      String infile = key.nextLine();
      Scanner in = new Scanner(new FileReader(infile));
   
      // read first line of input file
      n = in.nextInt();
      m = in.nextInt();
   
      double[][] A = new double[n][m]; 
   
      for (i = 0; i < n; i++) {
         for (j = 0; j < m; j++) {
            A[i][j] = in.nextInt();
         }
      }
         
      // close input file
      in.close();
   
      // print array A to output 
      MatrixOps.print(A);
      System.out.println();
   
      // perform Gauss-Jordan Elimination algorithm
      i = 0;
      j = 0;
      while(i < n && j < m){
      
         //look for a non-zero entry in col j at or below row i
         k = i;
         while (k < n && A[k][j] == 0) 
            k++;
      
         // if such an entry is found at row k
         if (k < n){
         
            //  if k is not i, then swap row i with row k
            if (k != i) {
               swap(A, i, k);
               MatrixOps.print(A);
               System.out.println();
            }
         
            // if A[i][j] is not 1, then divide row i by A[i][j]
            if(A[i][j] != 1){
               divide(A, i, j);
               MatrixOps.print(A);
               System.out.println();
            }
         
            // eliminate all other non-zero entries from col j by subtracting from each
            // row (other than i) an appropriate multiple of row i
            eliminate(A, i, j);
            MatrixOps.print(A);
            System.out.println();
            i++;
         }
         j++;
      }
      System.out.println("rank is " + i);
   }
}

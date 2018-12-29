/** Class for basic Matrix-related operations.
 */
public class Matrix {
   
   /** multiply a scalar into a matrix.
    *  @param scalar scalar to be multiplied
    *  @param a the matrix
    *  @return the resulted matrix
    */
   public static int[][] scalarMultiplication(int scalar, int[][] a) {
      for (int i = 0; i < a.length; i++) {
         for (int j = 0; j < a[i].length; j++) {
            a[i][j] *= scalar;
         }
      } 
      return a;
   }


   
 
  
   public static int[][] transpose(int[][] a) {
      int[][] result = new int[a[0].length][a.length];
      for (int i = 0; i < a.length; i++) {
         for (int j = 0; j < a[0].length; j++) {
            result[j][i]= a[i][j];   
         }
      }
      return result;
   } 
   public static int dotProduct(int[]a, int[]b) {
      int result = 0;
      for (int i = 0; i < a.length; i++) {
         result += (a[i] * b[i]);
      }
      return result;
   }
    /** conduct matrix multiplication.
    *  @param a first matrix
    *  @param b second matrix
    *  @return the resulted matrix
    */
   public static int[][] matrixMultiplication(int[][] a, int[][] b) {
      b = transpose(b);
      int result[][] = new int[a.length][b.length];
      for (int i = 0; i < a.length; i++) {
         for (int j = 0; j < b.length; j++) {
            result[i][j] = dotProduct(a[i], b[j]);
         }
      }
      return result;
   }

   
   /** conduct matrix addition.
   *  @param a first matrix
   *  @param b second matrix
   *  @return the resulted matrix
   */
   public static int[][] matrixAddition(int[][] a, int[][] b) {
      int[][] result = new int[a.length][a[0].length];
      for (int i = 0; i < a.length; i++) {
         for (int j = 0; j < a[0].length; j++) {
            result[i][j] = a[i][j] + b[i][j];
         }
      }
      return result;
   }
   public static int power(int a, int n) {
      int result = 1;
      for (int i = 0; i < n; i++) {
         result *= a;
      }
      return result;
   }
   /** conduct matrix power operation.
   *  @param a the matrix
   *  @param n the power   
   *  @return  the resulted matrix
   */
   public static int[][] matrixPowers(int[][] a, int n) {
      int[][] result = new int[a.length][a[0].length];
      for (int i = 0; i < a.length; i++) {
         for (int j = 0; j < a[0].length; j++) {
            result[i][j] = power(a[i][j], n);
         }
      }
      return result;
   }
   
   /** print a Matrix.
   *  @param a matrix to be printed
   */

   public static void printMatrix(int[][] a) {
      if (a == null || a[0] == null) {
         return;
      }
      for (int i = 0; i < a.length; i++) { 
         for (int j = 0; j < a[0].length; j++) {
            System.out.print(a[i][j] + " ");
         }
         System.out.println();   
         
      }   
   } 
   
   /** fill a Matrix with n elements from 1 to n increasing order.
   *  @param a matrix to be filled
   */
   public static void fillMatrix(int[][] a) {
      for (int i = 0; i < a.length; i++) {
         for (int j = 0; j < a[0].length; j++) {
            a[i][j] = (i * a[0].length) + j + 1;
         }
      }
   }
   
   /** Driver for the Matrix class to call different operations.
   *  @param args not used
   */
   public static void main(String[] args) {
      int[][] arr1 = new int[5][3];
      int[][] arr2 = new int[3][5];
      int[][] arr3 = new int[5][5];
      int[][] arr4 = new int[5][3];
      
   
      
      
      fillMatrix(arr1);
      fillMatrix(arr2);
      fillMatrix(arr3);
      fillMatrix(arr4);
      
   
      
      
      // NOTE: YOU MAY UNCOMMENT BELOW LINES AS Test NEEDED  
      // YOUR METHOD IMPLEMENTATIONS
      
      printMatrix(matrixMultiplication(arr1, arr2));
      printMatrix(matrixPowers(arr3, 3));
      printMatrix(matrixAddition(arr1, arr4));
      printMatrix(scalarMultiplication (-2, arr1)); 
   
             
   }



}


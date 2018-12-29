public class finalA {
   public static void main(String[] args) {
      char [][] puzzle = new char[3][5];
      char letter = 'a';
   
      for (int i=0; i < 3; i++)
         for (int j=0; j < 5; j++) {
            puzzle[i][j] = letter;
            letter = (char) (letter + 1);
         }
      for (int i=0; i < 3; i++)
         for (int j=0; j < 5; j++) {
            System.out.print(puzzle[i][j] + " ");
            
         }
       
   }
}

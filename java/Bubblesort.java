public class Bubblesort{
   public static void bubbleSort(String[] values, int howmany) {
      for (int i = 0; i < howmany; i++) {
         for (int j = 0; j < howmany - i; j++) {
            if (values[j].compareTo(values[j + 1]) > 0) {
               String temp = values[j];
               values[j] = values[j + 1];
               values[j + 1] = temp; 
            }
         }
      }
   
   }
}
import java.util.Scanner;
import java.util.Random;

/** DNA Program - Project 2 - Fall 2018.
 *  @author Shuchen Zhang szhan106, 10/12/2018
 */
public class Proj2B {

   /** Convert a character from a DNA sequence to its complement. 
    *  @param ch the character to convert
    *  @return comp the complementary character if ch is one of 
    *  A, T, C, G, 5, or 3 and the original character otherwise.
    */
   public static char complement(char ch) {
      
      char comp = ch;
      switch (ch) {
         case 'A' :
         case 'a' :
            comp = 'T';
            break;
         case 'c':
         case 'C':
            comp = 'G';
            break;
         case 't':
         case 'T':
            comp = 'A';
            break;
         case 'g':
         case 'G':
            comp = 'C';
            break;
         case '3':
            comp = '5';
            break;
         case '5':
            comp = '3';
            break;
         case '-':
            comp = '-';
            break;
         case '\'':
            break;
         default:
            comp = 0;
            break;
      }
      
      return comp;
   }
   
  /**  Determine whether a DNA sequence is valid or not valid.
    *  @param seq the DNA sequence to validate
    *  @return validity the validity of the DNA sequence
    */
   public static boolean valid(String seq) {
      
      boolean validity = true;
      seq = seq.toUpperCase();
      if (seq.length() < 6) {
         return false;
      }
      if (!seq.startsWith("5'-") || !seq.endsWith("-3'")) {
         return false;
      }
      for (int i = 3; i < seq.length() - 3; i++) {
         if (seq.charAt(i) != 'A' && seq.charAt(i) != 'T' 
             && seq.charAt(i) != 'G' && seq.charAt(i) != 'C') {
            return false;
         }
      } 
      return validity;
   }
   
   /** Generate a random sequence of a given length.
     * @param rand the random number generator to use
     * @param length the length of the strand (# of bases)
     * @return the full sequence including 5'- and -3'
     */
   public static String generate(Random rand, int length) {
      String seq = "";
      String set = "ACGT";
      seq = seq.concat("5'-");
      for (int i = 0; i < length; i++) {
         char base = set.charAt(rand.nextInt(4));
         seq += base;
      }
      seq = seq.concat("-3'");  
      return seq;
   }

   /** Compute and return the complement of a valid DNA sequence.
     * @param seq the original DNA sequence
     * @return seqComplement the complement of the original DNA sequence
     */
   public static String complement(String seq) {
      String seqComplement = "";
      
      for (int i = 0; i < seq.length(); i++) {
         seqComplement += complement(seq.charAt(i));
      }
      
      
      return seqComplement;
   }

   /** Compute and return the reverse of a valid DNA sequence.
     * @param seq the original DNA sequence
     * @return seqReverse the reverse of the original DNA sequence
     */
   public static String reverse(String seq) {
      String seqReverse = "";
      if (seq.charAt(0) == '5') {
         seqReverse = seqReverse.concat("3'");
         for (int i = seq.length() - 3; i >= 2; i--) {
            seqReverse += seq.charAt(i);
         }
         seqReverse = seqReverse.concat("5'");
      }
      else if (seq.charAt(0) == '3') {
         seqReverse = seqReverse.concat("5'");
         for (int i = seq.length() - 3; i >= 2; i--) {
            seqReverse += seq.charAt(i);
         }
         seqReverse = seqReverse.concat("3'");
      }
      return seqReverse;
   }
 
   /** Compare two DNA sequences, character by character, and return number of 
     * character mismatches between the two sequences.
     * @param seq1 the first DNA sequence to compare
     * @param seq2 the second DNA sequence to compare
     * @return the number of character mismatches, 
     *    -1 if they are incompatible lengths
     */
   public static int mutation(String seq1, String seq2) {
      int mutationNum = 0;
      if (!valid(seq2) || seq2.length() != seq1.length()) {
         mutationNum = -1;
      }
      else {
         seq2 = seq2.toUpperCase();
         for (int i = 0; i < seq1.length(); i++) {
            if (seq1.charAt(i) != seq2.charAt(i)) {
               ++mutationNum;
            }
         }
      }   
      
      
      
      return mutationNum;
   }

   /** Check if a DNA sequence is palindromic, meaning it is the same as its 
     * reverse complement.
     * @param seq the DNA sequence to check
     * @return boolean true if palindromic, false if not palindromic
     */
   public static boolean palindromic(String seq) {
      seq = seq.toUpperCase();
      if (complement(reverse(seq)).equals(seq)) {
         return true;
      } 
      
      
      return false;
   }
         
   /** Compute and return restriction enzyme cuts for a sequence.
     * @param seq the original valid DNA sequence
     * @param site a valid recognition site
     * @param where the cut position
     * @return seqCut the new cut DNA sequence
     */
   public static String restrictEnzyme(String seq, String site, int where) {
      String seqCut = ""; 
      String afterCut = "";
      site = site.toUpperCase();
      if (!valid(site)) {
         return "invalid recognition site";
      }
      else if (!palindromic(site)) {
         return "recognition site is not palindromic";
      }
      else if (where >= site.length()) {
         return "invalid cut position";
      }
      else {
         site = site.substring(3, site.length() - 3);
         afterCut = site.substring(0, where).concat(" ")
                    .concat(site.substring(where)); 
         seqCut = seq.replaceAll(site, afterCut);
      }
      
      
      return seqCut;
   }

   /** Main method to provide a menu-driven user interface for doing 
    *  various DNA sequence problems.
    *  @param args not used
    */
   public static void main(String[] args) {
   
      Scanner keyboard = new Scanner(System.in);
      Random randy = new Random();
      
      // initialize seq to starting DNA sequence
      String seq = "5'-ATGCTC-3'";
      System.out.printf(
                        "0) quit\n1) display DNA\n2) enter DNA\n" +
                        "3) generate DNA\n" +
                        "4) complements\n5) mutation\n" +
                        "6) restriction enzymes\n");
      System.out.print("enter choice by # -> ");
      int choice;
      while (keyboard.hasNext()) {
         choice = keyboard.nextInt();
         if (choice == 0) {
            break;
         }
         switch (choice) {
            case 1 :
               System.out.println("current forward sequence: " + seq);
               break;
            case 2 :
               System.out.print("enter forward sequence: ");
               String input = keyboard.next();
               if (valid(input)) {
                  System.out.println("current forward sequence: " 
                                     + input.toUpperCase());
                  seq = input.toUpperCase();
               }
               else {
                  System.out.println("input is not a valid" + 
                                     "forward DNA sequence");
               }
               break;
            case 3:
               System.out.print("enter sequence length: ");
               int length;
               do {
                  length = keyboard.nextInt();
               } while (length <= 0);
               seq = generate(randy, length);
               System.out.println("new forward sequence:   " + seq);
               break; 
            case 4:
               System.out.println("current sequence:   " + seq);
               System.out.println("complement:         " + complement(seq));
               System.out.println("reverse complement: " 
                                  + reverse(complement(seq)));
               break;
            case 5:
               System.out.println("current forward sequence:   " + seq);
               System.out.print("enter another sequence:     ");
               input = keyboard.next();
               int num = mutation(seq, input);
               if (num == -1) {
                  System.out.println("invalid sequence");
               } 
               else {
                  System.out.println("number of mutations: " + num);
               }
               break;
            case 6:
               System.out.println("current sequence:   " + seq);
               System.out.print("enter recognition site and cut position: ");
               String site = keyboard.next();
               int pos = keyboard.nextInt();
               String result = restrictEnzyme(seq, site, pos);
               System.out.println(result);
               break;
            default :
               break;
             
         }
         System.out.printf(
                        "0) quit\n1) display DNA\n2) enter DNA\n" +
                        "3) generate DNA\n" +
                        "4) complements\n5) mutation\n" +
                        "6) restriction enzymes\n");
         System.out.print("enter choice by # -> ");
         
      }
      
      
      
   
   } // end main   

} // end class


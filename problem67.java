/*
 *
 * By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.
 *
 *    3
 *   7 4
 *  2 4 6
 * 8 5 9 3
 *
 * That is, 3 + 7 + 4 + 9 = 23.
 *
 * Find the maximum total from top to bottom in triangle.txt (right click and 'Save Link/Target As...'), a 15K text file containing a triangle with one-hundred rows.
 *
 * NOTE: This is a much more difficult version of Problem 18. It is not possible to try every route to solve this problem, as there are 299 altogether! If you could check one trillion (1012) routes every second it would take over twenty billion years to check them all. There is an efficient algorithm to solve it. ;o)
 */

import java.io.*;
import java.util.*;

public class problem67 {
  public static void main(String [] args) {

    int numbers[][] = new int[101][101];

    try {
      Scanner txtScan = new Scanner(new File("triangle.txt"));

      // read them all in!
      for (int line = 0; line < 101; line++) {
        for (int index = 0; index < line; index++) {
          numbers[line][index] = txtScan.nextInt();
        }
      }

    }
    catch (IOException e) {}

    System.out.println("Done reading stuff in!");

/*
    // print out what got read in, just to make sure
    for (int line = 0; line < 101; line++) {
      for (int index = 0; index < line; index++) {
       System.out.print(numbers[line][index] + " ");
      }
      System.out.println();
    }
*/
    int left, right;
    // now lets start doing stuff!
    for (int line = 0; line < 101; line++) {
      for (int index = 0; index < line; index++) {
        left = 0;
        right = 0;
        if ( index!= 0 ) {
          left = numbers[line - 1][index - 1];
        }
        if ( index != line) {
         right = numbers[line - 1][index];
        }

        if (left > right) {
          numbers[line][index] += left;
        }
        else {
          numbers[line][index] += right;
        }

      }
    }

    // print out the whole bottom row
    for (int i = 0; i < 101; i++) {
      System.out.print(numbers[100][i] + " | ");
    }


  }
}

/*
  Team IDontReallyMindAnything 
  Joan Chirinos, Rohan Ahammed, Soojin Choi
  APCS2 pd08
  HW02 -- I Am Still Searching
  2018-02-01
*/

/**
 * MatrixFinder searches for a term in a left to right, top to bottom ordered matrix in O(n)
 * The matrix must fit the following restrictions:
 *   Given any row, the elements increase from left to right
 *   Given any column, the elements increase from top to bottom
 * The search method searches for int x in int[][] nums by starting at the last
 * element of the first row (top right). If this element is too high, it will test the
 * previous element of the same row. If this element is too low, it will search
 * the element in the next row of the same column. If the searching causes the
 * row or column to go out of bounds, it returns "(-1, -1)", meaning that the
 * search term is not found. If the search term was found, it returns "(r, c)"
 **/

public class MatrixFinder {

    //prereq: nums follows the above limitations
    public static String search(int[][] nums, int x) {
	//r = row #, c = column #. Follows 2d array numbering, left corner (0,0)
	int r = 0;
	int c = nums.length - 1;
	//"while you're still within the bounds of the int[][]"
	while (r < nums.length && c >= 0) {
	    if (nums[r][c] == x) {
		return "(" + r + ", " + c + ")";
	    }
	    else if (nums[r][c] > x) c--;
	    else r++;
	}
	return "(-1, -1)";
    }//end search

//prints a matrix out.
    public static void printMatrix(int[][] current){
      for (int[] a : current) {
          for (int i : a) {
        System.out.print(i + " ");
          }
          System.out.println();
      }
    }

    public static void main(String[] args) {
	int[][] nums = { {1, 3, 5}, {3, 7, 8}, {5, 12, 15} };
	for (int[] a : nums) {
	    for (int i : a) {
		System.out.print(i + " ");
	    }
	    System.out.println();
	}
	System.out.print("Search for 9: ");
	System.out.println(search(nums, 9));

	System.out.print("\nSearch for 8: ");
	System.out.println(search(nums, 8));

  System.out.print("\nSearch for 5: ");
	System.out.println(search(nums, 5));

//For a Matrix with n = 1
  int[][] matrix1 = {{1}};
  printMatrix(matrix1);

  System.out.print("\nSearch for 1: ");
  System.out.println(search(matrix1, 1));

  System.out.print("\nSearch for 3: ");
  System.out.println(search(matrix1, 3));

  System.out.print("\nSearch for -1: ");
  System.out.println(search(matrix1, -1));

  int[][] matrix2 = {{1, 2, 3, 4}, {2, 3, 4, 5}, {3, 4, 5, 6}, {4, 5, 6, 7}};
  printMatrix(matrix2);

  System.out.print("\nSearch for 1: ");
  System.out.println(search(matrix2, 1));

  System.out.print("\nSearch for 3: ");
  System.out.println(search(matrix2, 3));

  System.out.print("\nSearch for -1: ");
  System.out.println(search(matrix2, -1));

  System.out.print("\nSearch for 7: ");
  System.out.println(search(matrix2, 7));

  System.out.print("\nSearch for 4: ");
  System.out.println(search(matrix2, 4));

  System.out.print("\nSearch for 10: ");
  System.out.println(search(matrix2, 10));


    }//end main

}//end class

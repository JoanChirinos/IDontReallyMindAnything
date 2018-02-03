/*
Team IDontReallyMindAnything - Rohan Ahammed, Joan Chirinos, Soojin Choi
*/

public class TestMatrixFinder {

  public static int[][] popMatrix(int size) {
    int[][] arr = new int[size][size];

    //makes sure the matric conforms to the specification
    for (int r = 0; r < size - 1; r++) {
      for (int c = 0; c < size; c++) {
        arr[r][c] = r + c;
      }
    }

    //leaves a gap between the last element of the previous row and the
    //first element of the last row so that worst case can be observed
    for (int c = 0; c < size; c++) {
      arr[size - 1][c] = 2 * size - 1 + c;
    }
    return arr;
  }//end popMatrix

  public static String search(int[][] arr, int searchTerm) {
    return MatrixFinder.search(arr, searchTerm);
  }//end search

  //probably shouldn't be used for big arrays, but you do you
  public static void display(int[][] arr) {
    MatrixFinder.printMatrix(arr);
  }//end display

  //return time taken in nanoseconds as a double
  public static double timer(int[][] arr, int searchTerm) {
    long start = System.nanoTime();
    String s = search(arr, searchTerm);
    long end = System.nanoTime();
    return (end - start) / 1000000000.;
  }//end timer

  //gets average run time for worst case of a matrix of a set size. Runs
  //search on the worst case scenario 100 times
  public static double[] getRuntimes(int sizeOfMatrix) {
    double[] timeStore = new double[100];
    int[][] matrix = popMatrix(sizeOfMatrix);
    for (int i = 0; i < 100; i++) {
      timeStore[i] = timer(matrix, 2 * sizeOfMatrix - 2);
    }
    return timeStore;
  }//end getAverageRunTime

  public static void main(String[] args) {
    String toWrite = "";
    for (int i = 10000; i <= 20000; i += 100) {
      double[] times = getRuntimes(i);
      for (double x : times) {
        toWrite += i + "," + x + "\n";
      }
    }
    FileRW.write(toWrite, "newdata.csv");
  }//end main

}//end class

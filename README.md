# Searching Through Matrix in O(n) Time

## Team IDontReallyMindAnything - Rohan Ahammed, Joan Chirinos, Soojin Choi, pd08

### Hypothesis
We predicted that we could formulate an algorithm that searches through a matrix sorted horizontally, left to right in ascending order,  and vertically, top to bottom in ascending order,  in linear time, or O(n). This was based on the various traces we have done through smaller n x n 2D arrays, in which the number of comparisons and passes through our algorithm was about 2n - 1. Due to the nature of Big O notation, this would be simplified to linear time.

### Background
For an unsorted array, you would do a simple linear search. The worst case for this is O(n^2). When a 1D array is sorted, you can take advantage of the fact that, given an element, all elements before it are less than or equal to the element and all elements after after it are greater than or equal to the element (you can do a binary search). The 2D array given is also sorted in the sense that, given any element, the elements to the left of it or above it (same array with lower index or prior arrays with same index) are less than the given element and the elements to the right or below it (same array with greater index or subsequent arrays with same index) are greater than the given element. We wanted to take advantage of this fact.

Our search method begins the search at the last index of the first row. It repeats the following steps until the element is found or the indices are out of bounds:
1. If the element you're on is the one you're searching for, return the coordinates as a String "(r, c)"
2. If the element you're on is greater than the one you're searching for, search the previous index of the same row
3. Else, search the same index of the next row

Eventually, the element will either be found, or the search will attempt to go out of bounds. If the search attempts to go out of bounds, "(-1, -1)" is returned to indicate that the element was not found.

### Experiment Methodology

To test this method, we designed a tester class. The main method of the class follows these steps:
1. For every number, n,  starting at 10000 and ending at 20000 (counting up by 50) repeat the following 1050 times: time the search on an array of size n x n guaranteed to give the worst case time
2. Log the size of the matrix (n) and each time taken into a csv file

### Results

Afterwards, we used Microsoft Excel to graph the points on a "size of array vs. time taken" graph. We also used Excel to draw the line of best fit, which turned out to be linear.

![Graph showing a linear relationship between the size of a 2d array and the time taken to search using our search method](https://github.com/JoanChirinos/IDontReallyMindAnything/blob/master/data.png)

### Conclusions

Based on the line of best fit, created using the data from our experiment, it is clear that the runtime of our algorithm is O(n), or linear time. This must be true because our data basically forms a line, which is indicative of this run time.

It is clear from the graph that there is some variance in the algorithm. We attributed this to background processes running on Joan's Macbook. Although he tried to close all background processes, some, such as Siri and Spotlight, don't close for long.

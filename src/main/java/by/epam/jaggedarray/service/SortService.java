package by.epam.jaggedarray.service;

import by.epam.array.service.ArrayNumberFillService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class SortService {

    private static final Logger logger = LogManager.getLogger(SortService.class);

    private int findMaxNumber(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        logger.info("Max number: " + max);
        return max;
    }

    private int findMinNumber(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        logger.info("Min number: " + min);
        return min;
    }

    private int findSumNumbers(int[] array) {
        int sum = 0;
        for (Integer num : array) {
            sum += num;
        }
        logger.info("Sum numbers: " + sum);
        return sum;
    }

    public int[][] sort(int[][] jaggedArray, Comparator<int[]> comparator, boolean flag) {
        int coefficient = flag ? 1 : -1;
        for (int i = 0; i < jaggedArray.length; i++) {
            for (int j = 0; j < jaggedArray.length - 1; j++) {
                if (coefficient * comparator.compare(jaggedArray[j], jaggedArray[j + 1]) < 0) {
                    swap(jaggedArray, j, j + 1);
                }
            }
        }
        logger.info("Sorted jagger array");
        return jaggedArray;
    }

    public void swap(int[][] array, int row1, int row2) {
        int[] tempArray;
        tempArray = array[row2];
        array[row2] = array[row1];
        array[row1] = tempArray;
    }

}

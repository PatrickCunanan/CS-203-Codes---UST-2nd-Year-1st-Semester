package cs;

import java.util.*;
import java.io.*;

public class SearchAndSort {

    static Scanner Scan = new Scanner(System.in);

    static int linearSearchCount = 0, mergeSortCount = 0;

    static int linearSearchR(String x, int i, int j, String[] array) {
        linearSearchCount++;
        if ((array[i].toUpperCase()).equals(x.toUpperCase())) {
            return i;
        } else if (i == j) {
            return 0;
        } else {
            return linearSearchR(x, i + 1, j, array);
        }
    }

    static void mergeSort(int start, int end, String[] array) {
        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(start, middle, array);
            mergeSort(middle + 1, end, array);
            merge(start, end, middle, array);
        }
    }

    static void merge(int start, int end, int middle, String[] array) {
        String ArrayB[] = new String[array.length];
        for (int initial = start; initial <= end; initial++) {
            ArrayB[initial] = array[initial];
        }
        int counter = start, i = start, j = middle + 1, k;
        while (i <= middle && j <= end) {
            if (ArrayB[i].compareTo(ArrayB[j]) < 0) {
                array[counter] = ArrayB[i];
                i++;
            } else {
                array[counter] = ArrayB[j];
                j++;
            }
            counter++;
            mergeSortCount++;
        }
        if (i <= middle && j > end) {
            for (k = i; k <= middle; k++, counter++) {
                array[counter] = ArrayB[k];
            }
        } else if (j <= end && i > middle) {
            for (k = j; k <= end; k++, counter++) {
                array[counter] = ArrayB[k];
            }
        } else {
        }

    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        try {
            int numOfItems, startIndex, endIndex;
            String searchKey;
            System.out.print("Input number of items to process: ");
            numOfItems = Scan.nextInt();
            Scan.nextLine();
            System.out.println();
            String firstArray[] = new String[numOfItems + 1];
            String secondArray[] = new String[numOfItems + 1];
            BufferedReader in = new BufferedReader(new FileReader("ioc.txt"));
            for (int i = 1; i <= numOfItems; i++) {
                firstArray[i] = in.readLine();
                secondArray[i] = firstArray[i];
            }
            System.out.println("First Array:");
            for (int i = 1; i <= numOfItems; i++) {
                System.out.println(i + "  " + firstArray[i]);
            }
            System.out.println("\nSecond Array:");
            for (int i = 1; i <= numOfItems; i++) {
                System.out.println(i + "  " + secondArray[i]);
            }
            System.out.println();
            System.out.print("Input search key: ");
            searchKey = Scan.nextLine();
            System.out.print("Input starting index: ");
            startIndex = Scan.nextInt();
            System.out.print("Input end index: ");
            endIndex = Scan.nextInt();

            System.out.println("Index: " + linearSearchR(searchKey, startIndex, endIndex, firstArray));
            System.out.println("Linear Search Counter value: " + linearSearchCount);
            System.out.println();

            mergeSort(1, numOfItems, firstArray);
            System.out.println("Merge Sorted: ");
            for (int i = 1; i <= numOfItems; i++) {
                System.out.println(i + "  " + firstArray[i]);
            }
            System.out.println("Merge Sort Counter value: " + mergeSortCount);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

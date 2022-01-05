
import java.util.*;

/**
 * Sorting
 */
public class Sorting {
    public static LinkedList<Integer> unsortedList;
    public static Scanner sc = new Scanner(System.in);
    public static final int[] inputArray = { 8, 7, 6, 1, 0, 9, 2 };

    public Sorting() {
        unsortedList = new LinkedList<Integer>();
        setupList();
    }

    public static void setupList() {
        for (int i : inputArray) {
            unsortedList.add(i);
        }
    }

    public static void printFinalList() {
        System.out.println("----");
        System.out.println("Final: " + unsortedList);
        System.out.println("----");
    }

    public static void sortingOptions() {
        System.out.println("Sorting Menu:");
        System.out.println("1. Selection Sort");
        System.out.println("2. Quick Sort");
        System.out.println("3. Bubble Sort");
        System.out.println("4. Merge Sort");
        switch (Integer.valueOf(sc.nextLine())) {
            case 1:
                break;
            case 2:
                new QuickSort(unsortedList);
                break;
            case 3:
                new BubbleSort(unsortedList);
                break;
            case 4:
                new MergeSort(unsortedList);
                break;
            default:
                break;
        }
    }
}
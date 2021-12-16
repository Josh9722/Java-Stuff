
import java.util.*;

/**
 * Sorting
 */
public class Sorting {
    public static LinkedList<Integer> unsortedList;
    public static Scanner sc = new Scanner(System.in);
    public static final int[] inputArray = {4, 2, 6, 5, 3, 9};

    public static void main(String[] args) {
        unsortedList = new LinkedList<Integer>();
        setupList();
        sortingOptions(); 

        printFinalList(); 
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
        switch (Integer.valueOf(sc.nextLine())) {
            case 2:
                new QuickSort(unsortedList);
                break;
        
            default:
                break;
        }

    }
}
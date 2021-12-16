import java.util.*;

public class QuickSort {
    public int stepCount;
    public int sortCount; 
    public int pivotIndex;
    public LinkedList<Integer> unsortedNumbers;
    public boolean pivotSwapped = false;

    public QuickSort(LinkedList<Integer> unsortedNumbers) {
        this.unsortedNumbers = unsortedNumbers;
        sortCount = 0; 

        System.out.println("Running QuickSort Algorithm...");
        sort(0, unsortedNumbers.size()-1);
        System.out.println("QuickSort Algorithm Finished.");
    }

    public void sort(int start, int end) {
        stepCount = 1;
        sortCount++;
        System.out.println("(sort) Sort Count: " + sortCount); 

        pivotIndex = end;
        pivotSwapped = false;

        System.out.println("Sort Phase Begin..." + " (" + unsortedNumbers.get(start) + ", " + unsortedNumbers.get(end) + ")");
        System.out.println("    Provided List: " + unsortedNumbers);

        checkHigher(start);

        System.out.println("Sort Finished ");
    }

    public void checkHigher(int start) {
        boolean running = true;
        for (int i = start; i < pivotIndex; i++) {
            if (unsortedNumbers.get(i) > unsortedNumbers.get(pivotIndex)) {
                checkLower(i);
                if (pivotSwapped) {
                    return; 
                } 
            } 
        } 
        System.out.println("IS THIS RUNNING");
    }

    public void checkLower(int higherIndex) {
        for (int i = higherIndex; i < pivotIndex; i++) {
            if (unsortedNumbers.get(i) < unsortedNumbers.get(pivotIndex)) {
                swapValues(i, higherIndex);
                return;
            }
        }
        swapPivot(higherIndex); 
    }

    public void swapPivot(int swapIndex) {  //Swap index is the index of the higher number and the new pivot location 
        System.out.println("Pivot Swap: " + pivotIndex + " (" + unsortedNumbers.get(pivotIndex) + ") ");
        swapValues(pivotIndex, swapIndex);
        pivotSwapped = true;
        if (swapIndex >= 2) {
            System.out.println("(swap >=2) Sort Count: " + sortCount);
            sort(0, swapIndex-1);
        } else if ((unsortedNumbers.size()-1)-swapIndex >=2 ) {
            System.out.println("(swap) Sort Count: " + sortCount);
            sort(swapIndex+1, unsortedNumbers.size()-1);
        } 
    }

    public void swapValues(int a, int b) { // Swaps the values at index's a & b
        System.out.println("Swapping " + unsortedNumbers.get(b) + " with " + unsortedNumbers.get(a) + "...");
        System.out.println("  " + stepCount + ". " + unsortedNumbers); 
        
        int temp = unsortedNumbers.get(b);
        unsortedNumbers.set(b, unsortedNumbers.get(a));
        unsortedNumbers.set(a, temp);
        System.out.println(" --> " + unsortedNumbers);
        stepCount++;
    }
}

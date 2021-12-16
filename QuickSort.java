import java.util.*;

public class QuickSort {
    public int stepCount; 
    public int leftPointer;
    public int rightPointer; 
    public int pivotIndex; 
    public boolean sorted;
    public LinkedList<Integer> unsortedNumbers; 

    public QuickSort(LinkedList<Integer> unsortedNumbers) {
        stepCount = 1;
        leftPointer = 0; 
        rightPointer = unsortedNumbers.size() - 1; 
        pivotIndex = (int) (unsortedNumbers.size() / 2);
        sorted = false; 
        this.unsortedNumbers = unsortedNumbers;

        System.out.println("Running QuickSort Algorithm...");
        System.out.println("    Provided List: " + unsortedNumbers);
        sort(); 

        System.out.println("QuickSort Algorithm Finished.");
    }

    public void sort() { 
        System.out.println("Sort Begin...");
        System.out.println("    Identified Pivot Index/Value: " + pivotIndex + " / " + unsortedNumbers.get(pivotIndex));

        while (leftPointer != rightPointer) { 
            updateLeftPointer();
            updateRightPointer(); 
            swapPointerValues();
            System.out.println(stepCount + ". " + unsortedNumbers) ;
            stepCount++; 
        }
    }

    public void updateLeftPointer() { 
        boolean foundAdjustment = false;
        while (!foundAdjustment) { 
            if (unsortedNumbers.get(leftPointer) < unsortedNumbers.get(pivotIndex)) {
                leftPointer++; 
            } else {
                System.out.println("    Stationary Left Pointer: " + unsortedNumbers.get(leftPointer));
                foundAdjustment = true;
            }
        }
    }
    
    public void updateRightPointer() {
        boolean foundAdjustment = false;
        while (!foundAdjustment) {
            if (unsortedNumbers.get(rightPointer) > unsortedNumbers.get(pivotIndex)) {
                rightPointer--;
            } else {
                System.out.println("    Stationary Right Pointer: " + unsortedNumbers.get(rightPointer));
                foundAdjustment = true;
            }
        }
    }

    public void swapPointerValues() {
        if (leftPointer == pivotIndex || rightPointer == pivotIndex) {
            System.out.println("Swap canceled as contains pivot"); 
        } else {
        System.out.println("Swapping " + unsortedNumbers.get(leftPointer) + " with " + unsortedNumbers.get(rightPointer) + "..."); 
        int temp = unsortedNumbers.get(leftPointer);
        unsortedNumbers.set(leftPointer, unsortedNumbers.get(rightPointer));
        unsortedNumbers.set(rightPointer, temp);
        }
    }
}

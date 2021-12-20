import java.util.*;

public class BubbleSort {
    public LinkedList<Integer> list;
    public int phaseCount;
    public boolean phaseChange;
    public int stepCount = 0;

    public BubbleSort(LinkedList<Integer> unsortedNumbers) {
        this.list = unsortedNumbers;
        phaseCount = 0;

        System.out.println("Running BubbleSort Algorithm...");
        phase();
        System.out.println("BubbleSort Algorithm Finished.");

    }

    public void phase() {
        phaseCount++;
        phaseChange = false;
        stepCount = 0;
        System.out.println("Phase " + phaseCount + " Beginning...");
        for (int i = 0; i < list.size() - 1; i++) { // -1 for list index.
            if (list.get(i) > (list.get(i + 1))) {
                stepCount++;
                phaseChange = true;
                swapValues(i, i + 1);
            } else {
                // No match. No swap.
            }
        }
        System.out.println("Phase " + phaseCount + " Ended. Change: " + phaseChange);

        if (phaseChange) {
            phase();
        }
    }

    public void swapValues(int a, int b) { // Swaps the values at index's a & b
        System.out.println("    Swapping " + list.get(a) + " with " + list.get(b) + "...");
        System.out.println("      " + stepCount + ". " + list);

        int temp = list.get(b);
        list.set(b, list.get(a));
        list.set(a, temp);
        System.out.println("     --> " + list);
    }

}

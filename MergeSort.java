import java.util.*;

public class MergeSort {
    public LinkedList<Integer> list;
    public int phaseCount; 
    public int stepCount;
    public int branchNumber; 

    public MergeSort(LinkedList<Integer> unsortedNumbers) {
        this.list = unsortedNumbers;
        phaseCount = 1;
        stepCount = 0; 
        branchNumber = 1; 
        
        System.out.println("Running MergeSort Algorithm...");
        sort(0, list.size() - 1);
        System.out.println("MergeSort Algorithm Finished.");
    }

    public void sort(int start, int end) { // Recursively splits branches to subs based on size.
        
        if (start < end) {
            int mid = (start + end) / 2;
            branchNumber++;
            sort(start, mid); // Sort Left Branch
            sort(mid + 1, end); // Right Branch
            branchNumber--;
            merge(start, mid, end);
        }
    }

    public void merge(int start, int mid, int end) {
        System.out.println("Phase " + phaseCount + " Beginning...");
        printList(start, end);
        stepCount = 0; 

        int temp[] = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        // traverse both arrays and in each iteration add smaller of both elements in temp
        while (i <= mid && j <= end) { //Traverse  temp[k]
            if (list.get(i) <= list.get(j)) {
                temp[k] = list.get(i);
                k += 1;
                i += 1;
            } else {
                temp[k] = list.get(j);
                k += 1;
                j += 1;
            }
        }

        // add elements left in the first interval
        while (i <= mid) {
            temp[k] = list.get(i);
            k += 1;
            i += 1;
        }

        // add elements left in the second interval
        while (j <= end) {
            temp[k] = list.get(j);
            k += 1;
            j += 1;
        }

        // copy temp to original interval
        //printList(start, end);
        System.out.println("         " + list);
        for (i = start; i <= end; i += 1) {
            list.set(i, temp[i - start]);
        }
        System.out.println("     --> " + list);
        System.out.println("Phase " + phaseCount + " Ended.");
        phaseCount++; 
    }

    public void printList(int start, int end) {
        System.out.print("      Branch Number " + branchNumber + ". [");
        for (int i = start; i < end; i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println(list.get(end) + "]"); 

    }
}

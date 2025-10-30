import java.util.ArrayList;
import java.util.List;

public class SortingAlgorithm {
    // Method 1
    public void insertionSort(List<Employee> empList) {
        for (int i = 1; i < empList.size(); i++) {
            Employee key = empList.get(i);
            int j = i - 1;

            while (j >= 0 && empList.get(j).getAge() > key.getAge()) {
                empList.set(j + 1, empList.get(j));
                j = j - 1;
            } // End while loop
            empList.set(j + 1, key);
        } // End for loop
    } // End insertionSort()

    // Method 2
    public void bubbleSort(List<Employee> empList) {
        int n = empList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (empList.get(j).getAge() >
                        empList.get(j + 1).getAge()) {
                    swap(empList,j,j+1);
                }
            }//Close inside loop
        }//Close outside loop
    }//Close bubble_sort

    // Method 3
    private void swap(List<Employee> empList, int i, int j) {
        Employee temp = empList.get(i);
        empList.set(i, empList.get(j));
        empList.set(j, temp);
    } // End swap()

    // Method 4
    public void quickSort(List<Employee> empList)
    {
        int lowIndex = 0;
        int highIndex= empList.size() - 1;
        quickSortAlgo(empList, lowIndex, highIndex);
    } // End quickSort

    // Method 5
    private void quickSortAlgo(List<Employee> empList, int lowIndex, int highIndex){
        if (lowIndex>=highIndex) {return;}

        Employee pivot=empList.get(highIndex);
        int pivotIndex=partition(empList, lowIndex, highIndex, pivot);
        quickSortAlgo(empList, lowIndex, pivotIndex - 1);
        quickSortAlgo(empList, pivotIndex + 1, highIndex);
    } // End quickSortAlgo

    // Method 6
    private int partition(List<Employee> empList, int lowIndex, int highIndex, Employee pivot){
        int leftPointer=lowIndex;
        int rightPointer=highIndex;
        while(leftPointer<rightPointer) {
            while (empList.get(leftPointer).getAge() <= pivot.getAge() && leftPointer < rightPointer) {
                leftPointer++;
            } // End nested while loop
            while (empList.get(rightPointer).getAge() >= pivot.getAge() && leftPointer < rightPointer) {
                rightPointer--;
            } // End second nested while loop
            swap(empList, leftPointer, rightPointer);
        } // End outside while loop
        swap(empList, leftPointer, highIndex);
        return leftPointer;
    } // End partition

    // Method 7
    public void heapSort (List<Employee> empList){
        int n = empList.size() - 1;
        for (int i = empList.size() / 2 - 1; i >= 0; i--) {
            buildHeapify (empList, n, i);
        } // End for loop
        for (int j = n - 1; j > 0; j--) {
            swap (empList, j , 0);
            buildHeapify (empList,j, 0);
        } // End for loop
    } // End heapSort

    // Method 8
    private void buildHeapify (List<Employee> empList, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && empList.get(left).getAge() > empList.get(largest).getAge()) {
            largest = left;
        } // End if statement

        if (right < n && empList.get(right).getAge() > empList.get(largest).getAge()) {
            largest = right;
        } // End if statement

        if (largest != i) {
            swap(empList, largest, i);
            buildHeapify(empList, n, largest);
        } // End if statement
    } // End buildHeapify

    // Method 9
    public void selectionSort(List<Employee> empList) {
        int n = empList.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (empList.get(j).getAge() < empList.get(minIndex).getAge()) {
                    minIndex = j;
                }
            } // End inner loop
            swap(empList, i, minIndex);
        } // End outer loop
    } // End selectionSort()

    // Method 10
    public void mergeSort(List<Employee> empList) {
        if (empList.size() <= 1) {
            return;
        }
        int mid = empList.size() / 2;

        List<Employee> left = new ArrayList<>(empList.subList(0, mid));
        List<Employee> right = new ArrayList<>(empList.subList(mid, empList.size()));

        mergeSort(left);
        mergeSort(right);

        merge(empList, left, right);
    } // End mergeSort()


    // Method 11
    private void merge(List<Employee> empList, List<Employee> left, List<Employee> right) {
        int i = 0, j = 0, k = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).getAge() <= right.get(j).getAge()) {
                empList.set(k++, left.get(i++));
            } else {
                empList.set(k++, right.get(j++));
            }
        } // End while loop

        while (i < left.size()) {
            empList.set(k++, left.get(i++));
        } // End while loop

        while (j < right.size()) {
            empList.set(k++, right.get(j++));
        } // End while loop
    } // End merge()
} // End SortingAlgorithm

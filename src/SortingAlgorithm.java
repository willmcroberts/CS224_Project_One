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
} // End SortingAlgorithm

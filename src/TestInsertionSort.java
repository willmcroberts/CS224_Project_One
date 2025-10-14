import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class TestInsertionSort {
    public static void main(String[] args) {
        // Read data from file
        String inputFileName = "companyBSU.csv";
        ArrayList<Employee> employeeList = new ArrayList<Employee>();
        try {
            Scanner sc = new Scanner(new File(inputFileName));
            String header = sc.nextLine();
            System.out.println(header);
        } catch(Exception e) {
            System.out.println(e);
        }
    }// End Main
} // End class

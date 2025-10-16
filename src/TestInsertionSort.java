import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class TestInsertionSort {
    public static void main(String[] args) {
        // Read data from file
        String inputFileName = "companyBSU.csv";
        ArrayList<Employee> empList = new ArrayList<Employee>();
        try {
            Scanner sc = new Scanner(new File(inputFileName));
            String header = sc.nextLine();
            System.out.println(header);
            while (sc.hasNext()) {
                String empRecord = sc.nextLine();
                String[] s = empRecord.split(",");
                Employee empObject = new Employee(Integer.parseInt(s[0]), s[1], s[2], Integer.parseInt(s[3]));
                empList.add(empObject);
            }
            sc.close();
            for (int i = 0; i < 5; i++) {
                System.out.println(empList.get(i));
            }

        } catch(Exception e) {
            System.out.println(e);
        }
    }// End Main
} // End class

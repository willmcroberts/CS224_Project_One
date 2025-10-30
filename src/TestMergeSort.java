import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestMergeSort {
    public static void main(String[] args) {
        // Read data from file
        String inputFileName = "companyBSU.csv";
        ArrayList<Employee> empList = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File(inputFileName));
            String header = sc.nextLine();
            //System.out.println(header);
            while (sc.hasNext()) {
                String empRecord = sc.nextLine();
                String[] s = empRecord.split(",");
                Employee empObject = new Employee(Integer.parseInt(s[0]), s[1], s[2], Integer.parseInt(s[3]));
                empList.add(empObject);
            }
            sc.close();
            /*
            for (int i = 0; i < 5; i++) {
                System.out.println(empList.get(i));
            } */

            SortingAlgorithm algo = new SortingAlgorithm();
            long startTime = System.nanoTime();
            algo.mergeSort(empList);
            long endTime = System.nanoTime();
            long totalTime = endTime - startTime;
            System.out.println();
            System.out.println("Merge sort total time: " + totalTime / 1000000000.0 + " seconds");
            /*
            for (int i = 0; i < 5; i++) {
                System.out.println(empList.get(i));
            } */

            // Write sorted result to output file
            String outputFile = "companyBSU_merge.csv";
            String outputDir = "./output/";
            File dir = new File(outputDir);
            if (!dir.exists()) {
                dir.mkdir();
            } // End if
            writeToFile(outputDir, outputFile, empList);

        } catch(Exception e) {
            System.out.println(e);
        }
    }// End Main

    public static void writeToFile(String outputDir, String outputFile, List<Employee> empList) {
        try {
            FileWriter writer = new FileWriter(outputDir + "/" + outputFile);
            String headLine = "id, first_Name, last_Name, age\n";
            writer.write(headLine);
            for (Employee emp: empList) {
                String line = emp.getId() + ", " + emp.getFirstName() + ", " + emp.getLastName() + ", " + emp.getAge() + "\n";
                writer.write(line);
            } // End for loop
            writer.close(); // Important
        } catch(IOException e) {
            System.out.println(e);
        } // End try catch
    } // End writeToFile()(
} // End class

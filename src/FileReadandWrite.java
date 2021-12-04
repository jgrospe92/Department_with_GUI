import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class FileReadandWrite {

    public void fileImport(String filename, ArrayList<Department> importDept, ArrayList<Teacher> importTeacher,
            ArrayList<Student> importStudent , ArrayList<Staff> importStaff) {

            String line = "";
            String fileLocation = "Data" +"/"+ "import" + "/" + filename+".txt";
            int success = 0;
            int corrupted = 0;
            try {
                Scanner readFile = new Scanner(new File(fileLocation));

                while((readFile.hasNext())) {
                    line = readFile.nextLine();

                    String[] values = line.split(",");

                    if (values.length == 7) {
                        Department test = new Department(Integer.parseInt(values[values.length-1]));
                        if (importDept.contains(test)){
                            System.out.println("value is : " + values[values.length - 1]);
                        }
                        
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("File does not exist");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Corrupted data");
            }

    }

}

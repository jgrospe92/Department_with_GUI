import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class FileReadandWrite {

    private String CORRUPTED = "Corrupted data";
    private String NOTFOUND = "File does not exist";

    private boolean isValid(ArrayList<Department> departmentList, int id) {
        // Check for the referential constraint
        Department tempId = new Department(id);

        if (departmentList.contains(tempId)) {
            return true;
        } else {
            return false;
        }

    }

    private void dataImportLog(int works, int fails) {

        System.out.println("Successfully added: " + works);
        System.out.println("Corrupted data: " + fails);
    }

    public void fileImportDepartment(String filename, ArrayList<Department> departmentList,
            ArrayList<Teacher> teacherList) {
        String line = ""; // A variable to store the data
        String fileLocation = "Data" + "/" + "Import" + "/" + filename + ".txt"; // Relative location of the file
        int success = 0; // Number of successful import
        int corrupted = 0; // number of failed import

        try {
            Scanner readFile = new Scanner(new File(fileLocation));
            while ((readFile.hasNext())) {
                line = readFile.nextLine();
                String[] values = line.split(",");

                if (values.length == 2) {

                    int id = Integer.parseInt(values[0]);
                    String description = values[1];
                    Department deptIdPk = new Department(id);
                    if (!departmentList.contains(deptIdPk)) {
                        departmentList.add(new Department(id, description));
                        success++;
                    } else {
                        corrupted++;
                    }
                    
                } else if (values.length == 9) {

                    int id = Integer.parseInt(values[0]);
                    String description = values[1];

                    int tId = Integer.parseInt(values[2]);
                    String name = values[3];
                    int age = Integer.parseInt(values[4]);
                    String gender = values[5];
                    String speciality = values[6];
                    String degree = values[7];
                    int pk = Integer.parseInt(values[8]);
                    
                    Department deptIdPk = new Department(id);

                    if (!departmentList.contains(deptIdPk)) {
                        Teacher deanTeacher = new Teacher(tId, name, age, gender, speciality, degree, pk);
                        teacherList.add(deanTeacher);
                        departmentList.add(new Department(id, description, deanTeacher)); // add to department

                        success++;
                    } else {
                        corrupted++;
                    }
                } else {
                    corrupted++;
                    // raise an exception
                }
            }
            dataImportLog(success, corrupted);
        } catch (FileNotFoundException e) {
            System.out.println(NOTFOUND);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(CORRUPTED);
        }

    }

    public void fileImportTeacher(String filename, ArrayList<Department> departmentList,
            ArrayList<Teacher> importTeacherList) {

        String line = ""; // A variable to store the data
        String fileLocation = "Data" + "/" + "Import" + "/" + filename + ".txt"; // Relative location of the file
        int success = 0; // Number of successful import
        int corrupted = 0; // number of failed import
        try {
            Scanner readFile = new Scanner(new File(fileLocation));
            while ((readFile.hasNext())) {
                line = readFile.nextLine();
                String[] values = line.split(",");

                if (values.length == 7) {

                    int tempId = Integer.parseInt(values[6]);

                    if (isValid(departmentList, tempId)) {

                        String speciality = values[4];
                        String degree = values[5];
                        int pk = Integer.parseInt(values[6]);
                        int id = Integer.parseInt(values[0]);
                        String name = values[1];
                        int age = Integer.parseInt(values[2]);
                        String gender = values[3];

                        Teacher fkCheck = new Teacher(id, pk);
          
                        if (!importTeacherList.contains(fkCheck)) {
                            importTeacherList.add(new Teacher(id, name, age, gender, speciality, degree, pk));
                            success++;
                            for (Department dept : departmentList) {
                                for (Teacher teach : importTeacherList) {
                                    if (dept.getId() == teach.getFkDeptID()) {
                                        dept.getTeacherList().add(teach);
                                    }
                                }
                            }
                            
                        } else {
                            corrupted++;
                        }
                       

                        // if (!importTeacherList.contains(fkCheck)) {
                        //     if (!importTeacherList.contains(uniqueFK)) {
                        //         importTeacherList.add(new Teacher(id, name, age, gender, speciality, degree, pk));
                        //         success++;

                        //         for (Department dept : departmentList) {
                        //             for (Teacher teach : importTeacherList) {
                        //                 if(dept.getId() == teach.getFkDeptID()) {
                        //                     dept.getTeacherList().add(teach);
                        //                 }
                        //             }
                        //         }

                        //     }
                            
                        // } else {
                        //     corrupted++;
                        // }
                        
                    } else {
                        ExceptionHandling fkConstraint = new ExceptionHandling("Department does not exist!");
                        System.err.println(fkConstraint.getMessage());
                        corrupted++;
                    }

                } else {
                    corrupted++;
                    // raise an exception
                }
            }
            dataImportLog(success, corrupted);
        } catch (FileNotFoundException e) {
            System.out.println(NOTFOUND);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(CORRUPTED);

        }
    }

    public void fileImportStaff(String filename, ArrayList<Department> departmentList,
            ArrayList<Staff> importStaffList) {

        String line = ""; // A variable to store the data
        String fileLocation = "Data" + "/" + "Import" + "/" + filename + ".txt"; // Relative location of the file
        int success = 0; // Number of successful import
        int corrupted = 0; // number of failed import
        try {
            Scanner readFile = new Scanner(new File(fileLocation));
            while ((readFile.hasNext())) {
                line = readFile.nextLine();
                String[] values = line.split(",");

                if (values.length == 7) {

                    int tempId = Integer.parseInt(values[values.length - 1]);

                    if (isValid(departmentList, tempId)) {

                        int id = Integer.parseInt(values[0]);
                        String name = values[1];
                        int age = Integer.parseInt(values[2]);
                        String gender = values[3];
                        String duty = values[4];
                        int workload = Integer.parseInt(values[5]);
                        int fk = Integer.parseInt(values[6]);
                        Staff tempStaff = new Staff(id, fk);
                        if (!importStaffList.contains(tempStaff)) {
                            importStaffList.add(new Staff(id, name, age, gender, duty, workload, fk));
                            success++;
                            for (Department dept : departmentList) {
                                for (Staff staff : importStaffList) {
                                    if (dept.getId() == staff.getFK()) {
                                        dept.getStaffList().add(staff);
                                    }
                                }
                            }
                        } else {
                            corrupted++;
                        }
                       

                    } else {
                        ExceptionHandling fkConstraint = new ExceptionHandling("Department does not exist!");
                        System.err.println(fkConstraint.getMessage());
                        corrupted++;
                        
                    }

                } else {
                    corrupted++;
                    // raise an exception
                }
            }
            dataImportLog(success, corrupted);
        } catch (FileNotFoundException e) {
            System.out.println(NOTFOUND);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(CORRUPTED);

        }

    }

    public void fileImportStudent(String filename, ArrayList<Department> departmentList,
            ArrayList<Student> importStudentList) {

        String line = ""; // A variable to store the data
        String fileLocation = "Data" + "/" + "Import" + "/" + filename + ".txt"; // Relative location of the file
        int success = 0; // Number of successful import
        int corrupted = 0; // number of failed import
        try {
            Scanner readFile = new Scanner(new File(fileLocation));
            while ((readFile.hasNext())) {
                line = readFile.nextLine();
                String[] values = line.split(",");

                if (values.length == 7) {

                    int tempId = Integer.parseInt(values[values.length - 1]);

                    if (isValid(departmentList, tempId)) {

                        int id = Integer.parseInt(values[0]);
                        String name = values[1];
                        int age = Integer.parseInt(values[2]);
                        String gender = values[3];
                        String course = values[4];
                        int semester = Integer.parseInt(values[5]);

                        importStudentList.add(new Student(id, name, age, gender, course, semester)); // add FK
                        success++;

                    } else {
                        corrupted++;
                        ExceptionHandling fkConstraint = new ExceptionHandling("Department does not exist!");
                        System.err.println(fkConstraint.getMessage());
                    }

                } else {
                    corrupted++;
                    // raise an exception
                }
            }
            dataImportLog(success, corrupted);
        } catch (FileNotFoundException e) {
            System.out.println(NOTFOUND);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(CORRUPTED);

        }
    }

    // Method to Write to a file
    // Method to evaluate if user wants to create a new file
    // public boolean newFile() {
    //     Scanner input = new Scanner(System.in);
    //     System.out.println("Would you like to create a new file? (y,n)");
    //     String answer = input.next();
    //     return (answer.equals("y"));
    // }
    public void saveDepartment(ArrayList<Department> dd) {

        String exportPath = "Data" + "/" + "Import" + "/" + "Department" + ".txt";
        String fileContent = "";
        try {
            for (Department dept : dd) {
                if (dept.getDean() != null) {
                    fileContent = fileContent.concat(dept.formattedWithDean() + "\n");
                } else {
                    fileContent = fileContent.concat(dept.formattedWithoutDean() + "\n");
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        try {
            // Should i make the true into variable
            FileWriter writer = new FileWriter(exportPath); // It will be written to this file
            writer.write(fileContent);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void saveTeacher(ArrayList<Teacher> tt){
        String exportPath = "Data" + "/" + "Import" + "/" + "Teacher" + ".txt";
        String fileContent = "";
        try {
            for (Teacher teacher : tt) {
                fileContent = fileContent.concat(teacher.formatted() + "\n");  
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            // Should i make the true into variable
            FileWriter writer = new FileWriter(exportPath); // It will be written to this file
            writer.write(fileContent);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fileExportDepartment(String filneName, ArrayList<Department> dd) {

        String exportPath = "Data" + "/" + "Export" + "/" + filneName + ".txt";
        String fileContent = "";
        try {
            for (Department dept : dd) {
                if (dept.getDean() != null) {
                    fileContent = fileContent.concat(dept.formattedWithDean() + "\n");
                } else {
                    fileContent = fileContent.concat(dept.formattedWithoutDean() + "\n");
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        try {
            // Should i make the true into variable
            FileWriter writer = new FileWriter(exportPath, true); // It will be written to this file
            writer.write(fileContent);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fileExportStudent(String filneName, ArrayList<Student> ss) {

        String exportPath = "Data" + "/" + "Export" + "/" + filneName + ".txt";
        String fileContent = "";
        try {
            for (Student student : ss) {
                fileContent = fileContent.concat(student.formatted() + "\n");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        try {
            // Should i make the true into variable
            FileWriter writer = new FileWriter(exportPath, true); // It will be written to this file
            writer.write(fileContent);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fileExportTeacher(String filneName, ArrayList<Teacher> tt) {

        String exportPath = "Data" + "/" + "Export" + "/" + filneName + ".txt";
        String fileContent = "";
        try {
            for (Teacher teacher : tt) {
                fileContent = fileContent.concat(teacher.formatted() + "\n");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        try {
            // Should i make the true into variable
            FileWriter writer = new FileWriter(exportPath, true); // It will be written to this file
            writer.write(fileContent);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fileExportStaff(String filneName, ArrayList<Staff> st) {

        String exportPath = "Data" + "/" + "Export" + "/" + filneName + ".txt";
        String fileContent = "";
        try {
            for (Staff staff : st) {
                fileContent = fileContent.concat(staff.formatted() + "\n");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        try {
            // Should i make the true into variable
            FileWriter writer = new FileWriter(exportPath, true); // It will be written to this file
            writer.write(fileContent);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

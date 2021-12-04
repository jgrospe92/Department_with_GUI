import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;


public class test {
    public static void main(String[] args) throws Exception {

        ArrayList<Student> studList = new ArrayList<>();
        ArrayList<Teacher> teachList = new ArrayList<>();
        ArrayList<Staff> staffList = new ArrayList<>();
        ArrayList<Department> deptList = new ArrayList<>();

        Teacher t1 = new Teacher(123);

        Department addDept1 = new Department(1001, "test", t1);
        Department addDept2 = new Department(222, "test", t1);
        Department addDept3 = new Department(333, "test", t1);


        deptList.add(addDept1);
        deptList.add(addDept2);
        deptList.add(addDept3);


        if (deptList.contains(new Department(222))){
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        
        Student ss1 = new Student(123, "jeffrey", 21, "male", "pc", 1);
        Student ss2 = new Student(222, "ped", 21, "male", "pc", 1);
        studList.add(ss1);
        studList.add(ss2);
        Student find = new Student(222, "ped", 21, "male", "pc", 1);
        Student find1 = new Student(555);
 
        //  //System.out.println(StuList.contains(find1));
        // //StuList.get(0).display();
        // Iterator<Student> stuIterator = StuList.iterator();
        // Student currentStu = new Student();
 
        // while(stuIterator.hasNext()){
        //  currentStu = stuIterator.next();
        //    currentStu.display();
        // }
        // FileReadandWrite data = new FileReadandWrite();
        // Scanner input = new Scanner(System.in);
        // System.out.println("Enter the file name");
        // String filename = input.next();
       
        //data.fileImport(filename, deptList, teachList, studList, staffList);

        String d1 = "PhD";
        String d2 = "Master";
        String d3 = "Bachelor";

        // int t1 = 1;
        // int t2 = 2;
        // int t3 = 3;

        String entry = d3;

        int result = (entry == "PhD") ? 112: (entry == "Master" ? 94 : 0);

        System.out.println(result);
    }
}

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

        // import Test

        // FileReadandWrite fileImp = new FileReadandWrite();

        // //System.out.println(fileImp.newFile()); 

        // String filename = "Department";

        // fileImp.fileImportDepartment(filename, deptList, teachList);

        // deptList.get(1).setDean(new Teacher(123, "Jeff", 29, "male", "java","nothing"));
        // System.out.println(deptList.get(1).getDean().computePayRoll()); 

        // System.out.println("End statement");

        // for(Department dd: deptList){
        //     dd.showInfo();
       // }
        // for (Teacher tt: teachList){
        //     tt.display();
        // }

        // fileImp.fileExportDepartment("Dept", deptList);

        // String teacherFIle = "Teacher";
        // fileImp.fileImportTeacher(teacherFIle, deptList, teachList);

        // for(Teacher tt: teachList){
        //     tt.display();
        // }
        // fileImp.fileExportTeacher("TeacExpo", teachList);

        // String studentFIle = "Student";
        // fileImp.fileImportStudent(studentFIle, deptList, studList);

        // for(Student ss: studList){
        //     ss.display();
        // }
        // fileImp.fileExportStudent("StudeExpoort", studList);

        // String staffFile = "Staff";
        // fileImp.fileImportStaff(staffFile, deptList, staffList);
        // for (Staff st : staffList){
        //     st.display();
        // }

        
        // Algorithm to add Dean  
    //     Teacher t1 = new Teacher(123, "jeff", 29, "m", "coder", "master", 222);
    //     Teacher t2 = new Teacher(2223, "fda", 29, "m", "coder", "master", 777);
    //     Teacher t3 = new Teacher(2223, "fda", 29, "m", "coder", "master", 777);


    //     int deptId = 1001;
    //     int teacherId = 123;

    //     Department addDept1 = new Department(1001, "test");
    //     addDept1.getTeacherList().add(t1);
    //     Department addDept2 = new Department(222, "test", t1);
    //     Department addDept3 = new Department(333, "test", t2);

    //     deptList.add(addDept1);
    //     deptList.add(addDept2);
    //     deptList.add(addDept3);

    //     System.out.println("....");

    //     boolean foundIt = false;
    //     boolean teacherNotInDept = false;

    //    for (Department department : deptList) {
    //         if (department.getId() == deptId && department.getDean() == null ) {
    //             foundIt = true;
    //             for (Teacher teacher : department.getTeacherList()) {
    //                 if (teacher.getId() == teacherId) {
    //                     department.setDean(teacher);
    //                     teacherNotInDept = true;
    //                 }
    //             }
    //         } else {
    //             //department.getDean().display();
    //         }
    //         department.showInfo();
    //    }

    //    if (foundIt && teacherNotInDept) {
    //        System.out.println("found it");
    //    }
    //    else {
    //        System.out.println("exception raise");
    //    }

       // Test for Staff

    //    Staff st1 = new Staff(111, "jeff", 37, "gender", "duty", 36, 333);
    //    Staff st2 = new Staff(222, "dd", 22, "dd", "duty", 20, 200);
    //    Staff st3 = new Staff(333, "aaa", 11, "gender", "duty", 22, 300);
  
    //    staffList.add(st1);
    //    staffList.add(st2);
    //    staffList.add(st3);

    //    Department dept = new Department(333, "description");
    //    Department dept1 = new Department(444, "description");

    //    deptList.add(dept);
    //    deptList.add(dept1);
    
    //    for (Department d : deptList) {
    //     if(d.getId() == st1.getFK()) {
    //         d.getStaffList().add(st1);
    //     }
    
    //    }
          
    //    deptList.get(0).getStaffList().get(0).display();
    
    // Test for Teacher
    Department d1 = new Department(100, "description");
    Department d2 = new Department(222, "de");

    deptList.add(d1);
    deptList.add(d2);

    Teacher t1 = new Teacher(222, "name", 2, "gender", "speciality", "degree", 100);
    Teacher t2 = new Teacher(333, "name", 2, "gender", "speciality", "degree", 100);

    Teacher test = new Teacher(222, 100);


    teachList.add(t1);
    teachList.add(t2);

    if (teachList.contains(t2)) {
        System.out.println("yes");
    } else {
        System.out.println("no");
    }

    // if (deptList.contains(test)) {
    //     System.out.printf("Yes");
    // } else {
    //     System.out.println("no");
    // }
        // if (deptList.contains(test) ){
        //     System.out.println("true");
        //     if(teachList.contains(testFk)) {
        //         System.out.printf("yes");
        //     } else {
        //         System.out.println("no");
        //     }
        //     // for(int i = 0; i < teachList.size(); i++){
        //     //     if (teachList.get(i).getFkDeptID() == t1.getFkDeptID()) {
        //     //         System.out.println("yes");
        //     //     } 
        //     // } 
        // } else {
        //     System.out.println("false");
        // }

        
        // Student ss1 = new Student(123, "jeffrey", 21, "male", "pc", 1);
        // Student ss2 = new Student(222, "ped", 21, "male", "pc", 1);
        // studList.add(ss1);
        // studList.add(ss2);
        // Student find = new Student(222, "ped", 21, "male", "pc", 1);
        // Student find1 = new Student(555);
 
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

        
    }
}

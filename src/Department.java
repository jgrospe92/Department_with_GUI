import java.util.ArrayList;

public class Department {

    private int id;
    private String description;
    private Teacher dean;
    
    public Department(int id, String description, Teacher dean) {
        this.id = id;
        this.description = description;
        this.dean = dean;
    }

    // ArrayList
    ArrayList<Teacher> TeacherList = new ArrayList<>();
    ArrayList<Student> StudentList = new ArrayList<>();
    ArrayList<Staff> StaffList = new ArrayList<>();

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Teacher getDean() {
        return this.dean;
    }

    public void setDean(Teacher dean) {
        this.dean = dean;
    }

    public ArrayList<Teacher> getTeacherList() {
        return this.TeacherList;
    }

    public void setTeacherList(ArrayList<Teacher> TeacherList) {
        this.TeacherList = TeacherList;
    }

    public ArrayList<Student> getStudentList() {
        return this.StudentList;
    }

    public void setStudentList(ArrayList<Student> StudentList) {
        this.StudentList = StudentList;
    }

    public ArrayList<Staff> getStaffList() {
        return this.StaffList;
    }

    public void setStaffList(ArrayList<Staff> StaffList) {
        this.StaffList = StaffList;
    }
    


    
    
}

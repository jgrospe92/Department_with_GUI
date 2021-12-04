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

    // Getters
    public int getId() {
        return this.id;
    }
    public String getDescription() {
        return this.description;
    }
    public Teacher getDean() {
        return this.dean;
    }
    // ArrayList
    public ArrayList<Staff> getStaffList() {
        return this.StaffList;
    }
    public ArrayList<Student> getStudentList() {
        return this.StudentList;
    }
    public ArrayList<Teacher> getTeacherList() {
        return this.TeacherList;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDean(Teacher dean) {
        this.dean = dean;
    }
    // ArrayList
    public void setTeacherList(ArrayList<Teacher> TeacherList) {
        this.TeacherList = TeacherList;
    }

    public void setStudentList(ArrayList<Student> StudentList) {
        this.StudentList = StudentList;
    }

    public void setStaffList(ArrayList<Staff> StaffList) {
        this.StaffList = StaffList;
    }
    
}

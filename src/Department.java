import java.util.ArrayList;

public class Department {

    private int id;
    private String description;
    private Teacher dean;
    // ArrayList
    private ArrayList<Teacher> TeacherList = new ArrayList<>();
    private ArrayList<Student> StudentList = new ArrayList<>();
    private ArrayList<Staff> StaffList = new ArrayList<>();

    // Constructor for ID and Description
    public Department(int id, String description){
        this.id = id;
        this.description = description;
    }

    // Constructor ID, description, Dean
    public Department(int id, String description, Teacher dean) {
        this.id = id;
        this.description = description;
        this.dean = dean;
    }
    // ID constructor
    public Department(int id) {
        this.id = id;
    }

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
    // equals method

    @Override
    public boolean equals(Object obj) {
        if (obj != null) {
            if (obj.getClass() == this.getClass()) {
                Department dept = (Department) obj;
                return (dept.getId() == this.getId());
            }
        }
        return true;
    }
}

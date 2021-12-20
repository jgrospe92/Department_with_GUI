import java.util.ArrayList;

public class Department {

    private int id;
    private String description;
    private Teacher dean;
    private String deanName;
    private ArrayList<String> teacherName;
    private ArrayList<String> staff;
    private ArrayList<String> studentName; 
    // ArrayList
    private ArrayList<Teacher> TeacherList = new ArrayList<>();
    private ArrayList<Student> StudentList = new ArrayList<>();
    private ArrayList<Staff> StaffList = new ArrayList<>();

    public Department(){

    }

    // Constructor for ID and Description
    public Department(int id, String description){
        this.id = id;
        this.description = description;
    
    }
    public Department(Teacher dean){
        this.deanName = dean.getName();
    }

    // Constructor ID, description, Dean
    public Department(int id, String description, Teacher dean) {
        this.id = id;
        this.description = description;
        this.dean = dean;
        this.deanName = dean.getName();
        this.teacherName = getTeacherName();
        this.staff = getStaff();
        this.studentName = getStudentName();
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
    public String getDeanName(){
       try {
            deanName = dean.getName();
       } catch(Exception e) {
           System.err.println(e.getMessage());
       }
       return deanName;
    }
    public ArrayList<String> getTeacherName(){
        ArrayList<String> name = new ArrayList<>();
        if (TeacherList.size() != 0) {
            for (Teacher tt : TeacherList) {
                name.add(tt.getName());
            }
        }
        return name;
    }

   public ArrayList<String> getStaff(){
        ArrayList<String> staffName = new ArrayList<>();
        if (StaffList.size() != 0) {
            for (Staff ss : StaffList) {
                staffName.add(ss.getName());
            }
        }
        return staffName;
   }
   public ArrayList<String> getStudentName(){
    ArrayList<String> stuName = new ArrayList<>();
    if (StudentList.size() != 0) {
        for (Student ss : StudentList) {
            stuName.add(ss.getName());
        }
    }
    return stuName;
}

    public void showInfo(){
        if(getDean() == null){
            System.out.println("ID: " + this.id + "\n" + "Description: " + this.description);
        }
        else {
            showInfoWithDean();
        }
    }

    private void showInfoWithDean(){
        System.out.println("ID: " + this.id + "\n" + "Description: " + this.description + " Dean: " + this.dean.getName());
    }

    public String formattedWithoutDean(){
        return this.id + "," + this.description;
    }

    public String formattedWithDean(){
        return this.id + "," + this.description + "," + this.dean.formatted();
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

    // Exception handling
    public void setDean(Object dean) {
        ExceptionHandling invalidDean = new ExceptionHandling("Please assign a Teacher as Dean");
        
        try {
            this.dean = (Teacher) dean;
        } catch (Exception e) { // Replace this with the custom exception
            
            System.err.println(invalidDean.getMessage());
        }
        
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

public class Student extends Person{
    private String course;
    private int semester;

    //Constructor
    public Student(int id, String name, int age, String gender, String course, int semester) {
        super(id, name, age, gender);
        this.course = course;
        this.semester = semester;
    }

    //Setters
    public void setCourse(String course) {
        this.course = course;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    //Getters
    public String getCourse() {
        return course;
    }

    public int getSemester() {
        return semester;
    }    
}

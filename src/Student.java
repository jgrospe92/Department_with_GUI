public class Student extends Person{
    private String course;
    private int semester;
    private int fkDeptID;

     // empty constructor
     public Student(){

    }
     //Constructor
     public Student(int id, String name, int age, String gender, String course, int semester, int fk) {
        super(id, name, age, gender);
        this.course = course;
        this.semester = semester;
        this.fkDeptID = fk;
    }
    // Constructor for ID and FK
    public Student(int id, int fk){
        super(id);
        this.fkDeptID = fk;

    }

    public Student(int fk) {
        this.fkDeptID = fk;
    }



    //Setters
    public void setCourse(String course) {
        this.course = course;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
    public void getFkDeptID(int fk){
        this.fkDeptID = fk;
    }

    //Getters
    public String getCourse() {
        return course;
    }

    public int getSemester() {
        return semester;
    }

    public int getFkDeptID(){
        return this.fkDeptID;
    }

    @Override
    public void display(){
        super.display();
        System.out.println("Course: " + this.course + "\n" + 
                            "Semester: " + this.semester + "\n");
    }

    @Override
    public String formatted(){
        return super.formatted() + "," + course + "," + semester + "," + fkDeptID;
    }


    @Override
    public boolean equals(Object obj){
        if (obj!=null) {
            if (obj.getClass()==this.getClass()) {
                Student stu = (Student) obj;
                return (stu.getId() == this.getId());
            }
        }
        return true;
    }
}

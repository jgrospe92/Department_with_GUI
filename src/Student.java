public class Student extends Person{
    private String course;
    private int semester;

     // empty constructor
     public Student(){

    }
    // Constructor for ID
    public Student(int id){super(id);}

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

    @Override
    public void display(){
        super.display();
        System.out.println("Course: " + this.course + "\n" + 
                            "Semester: " + this.semester + "\n");
    }

    @Override
    public String formatted(){
        return super.formatted() + "," + course + "," + semester;
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

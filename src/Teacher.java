public class Teacher extends Person implements PayRoll{
    private String speciality;
    private String degree;


     //Empty constructor
     public Teacher(){
        
    }
    //Constructor
    public Teacher(int id, String name, int age, String gender, String speciality, String degree) {
        super(id, name, age, gender);
        this.speciality = speciality;
        this.degree = degree;
    }
    //Constructor for ID only
    public Teacher(int id){
        super(id);
;    }
   

    //Setters
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
    
    public void setDegree(String degree) {
        this.degree = degree;
    }

    //Getters
    public String getSpeciality() {
        return speciality;
    }

    public String getDegree() {
        return degree;
    }

    // Override
    @Override
    public void display(){
        super.display();
        System.out.println("Course: " + this.speciality + "\n" + 
                            "Semester: " + this.degree + "\n");
    }

    @Override
    public String formatted(){
        return super.formatted() + "," + speciality + "," + degree;
    }


    @Override
    public boolean equals(Object obj){
        if (obj!=null) {
            if (obj.getClass()==this.getClass()) {
                Teacher teacher = (Teacher) obj;
                return (teacher.getId() == this.getId());
            }
        }
        return true;
    }
    @Override
    public double computePayRoll() {
       String phd = this.degree.toLowerCase();
       String  master = this.degree.toLowerCase();
       String bachelor = this.degree.toLowerCase();

        int salDegree = (phd.equals("phd")) ? 112 : (master.equals("master" ) ? 82 : (bachelor.equals("bachelor")) ? 42 : 0); 
        return (35 * salDegree * 2) * 0.76;

    }

}
public class Teacher extends Person{
    private String speciality;
    private String degree;

    //Constructor
    public Teacher(int id, String name, int age, String gender, String speciality, String degree) {
        super(id, name, age, gender);
        this.speciality = speciality;
        this.degree = degree;
    }

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
}
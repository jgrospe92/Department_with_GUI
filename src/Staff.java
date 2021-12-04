public class Staff extends Person implements PayRoll{
    private String duty;
    private int workload;

    // Empty Constructor
    public Staff(){

    }

    // Constructor
    public Staff(int id, String name, int age, String gender, String duty, int workload) {
        super(id, name, age, gender);
        this.duty = duty;
        this.workload = workload;
    }
    // Constructor for ID
    public Staff(int id){
        super(id);
    }

    //Setters
    public void setDuty(String duty) {
        this.duty = duty;
    }

    public void setWorkload(int workload) {
        this.workload = workload;
    }

    //Getters
    public String getDuty() {
        return duty;
    }
    
    public int getWorkload() {
        return workload;
    }
    
    //Methods
    @Override
    public double computerPayRoll(double pay){
        return pay;
    }
    @Override
    public void display(){
        super.display();
        System.out.println("Course: " + this.duty + "\n" + 
                            "Semester: " + this.workload + "\n");
    }


    @Override
    public boolean equals(Object obj){
        if (obj!=null) {
            if (obj.getClass()==this.getClass()) {
                Staff staff = (Staff) obj;
                return (staff.getId() == this.getId());
            }
        }
        return true;
    }

    
}
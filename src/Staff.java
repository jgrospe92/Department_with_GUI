public class Staff extends Person implements PayRoll{
    private String duty;
    private int workload;

    //Constructor
    public Staff(int id, String name, int age, String gender, String duty, int workload) {
        super(id, name, age, gender);
        this.duty = duty;
        this.workload = workload;
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

    
}
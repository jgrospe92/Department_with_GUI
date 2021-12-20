public class Staff extends Person implements PayRoll{
    private String duty;
    private int workload;
    private double salary;
    private int fkDeptID;

    // Empty Constructor
    public Staff(){

    }

    // Constructor
    public Staff(int id, String name, int age, String gender, String duty, int workload, int pk) {
        super(id, name, age, gender);
        this.duty = duty;
        this.workload = workload;
        this.salary = computePayRoll();
        this.fkDeptID = pk;
        
    }
    // Constructor for ID
    public Staff(int id, int fk ) {
        super(id);
        this.fkDeptID = fk;
    }

    public Staff(int fk){
        this.fkDeptID = fk;
    }

    //Setters
    public void setDuty(String duty) {
        this.duty = duty;
    }

    public void setWorkload(int workload) {
        this.workload = workload;
    }
    public void setFk(int fk){
        this.fkDeptID = fk;
    }

    //Getters
    public String getDuty() {
        return duty;
    }
    
    public int getWorkload() {
        return workload;
    }
    public double getSalary(){
        return this.salary;
    }
    public int getFkDeptID(){
        return this.fkDeptID;
    }
    
    //Methods
    @Override
    public double computePayRoll(){

        double result = 0.0;
        if (this.workload <= 36 && this.workload >= 0){
            result = (this.workload * 32 * 2 ) * 0.82;
        } else {
            System.out.println("Workload exceeds limit");
        }
        return result = Math.round(result * 100.0)/100.0;
    }
    @Override
    public void display(){
        super.display();
        System.out.println("Duty: " + this.duty + "\n" + 
                            "Workload: " + this.workload + "\n" +
                            "Salary: " + this.salary +
                            "FK: " + this.fkDeptID + "\n");
    }

    @Override
    public String formatted(){
        return super.formatted() + "," + duty + "," + workload + "," + fkDeptID;
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
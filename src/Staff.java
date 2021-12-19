public class Staff extends Person implements PayRoll{
    private String duty;
    private int workload;
    private int staffFKDeptID;
    private double salary;

    // Empty Constructor
    public Staff(){

    }

    // Constructor
    public Staff(int id, String name, int age, String gender, String duty, int workload, int pk) {
        super(id, name, age, gender);
        this.duty = duty;
        this.workload = workload;
        this.staffFKDeptID = pk;
        this.salary = computePayRoll();
    }
    // Constructor for ID
    public Staff(int fk){
        this.staffFKDeptID = fk;
    }

    //Setters
    public void setDuty(String duty) {
        this.duty = duty;
    }

    public void setWorkload(int workload) {
        this.workload = workload;
    }
    public void setFk(int fk){
        this.staffFKDeptID = fk;
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
    public int getFK(){
        return this.staffFKDeptID;
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
                            "FK: " + this.staffFKDeptID + "\n" + "Salary: " + this.salary);
    }

    @Override
    public String formatted(){
        return super.formatted() + "," + duty + "," + workload + "," + staffFKDeptID;
    }


    @Override
    public boolean equals(Object obj){
        if (obj!=null) {
            if (obj.getClass()==this.getClass()) {
                Staff staff = (Staff) obj;
                return (staff.getFK() == this.getFK());
            }
        }
        return true;
    }
    
}
public abstract class Person{
    private int id;
    private String name;
    private int age;
    private String gender;

     // empty constructor
     protected Person(){

    }
    //Constructor for ID only
    protected Person(int id){
        this.id = id;
    }
    //Constructor
    protected Person(int id, String name, int age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
   

    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public void display(){
        System.out.println("ID: " + this.id + "\n" +
                            "Name: " + this.name + "\n" +
                            "Age : " + this.age + "\n" +
                            "Gender : " + this.gender);
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
    

}
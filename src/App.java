import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class App {
    public static void main(String[] args) throws Exception {

       ArrayList<Student> StuList = new ArrayList<>();
       
       Student ss1 = new Student(123, "jeffrey", 21, "male", "pc", 1);
       Student ss2 = new Student(222, "ped", 21, "male", "pc", 1);
       StuList.add(ss1);
       StuList.add(ss2);
       Student find = new Student(222, "ped", 21, "male", "pc", 1);
       Student find1 = new Student(555);

        //System.out.println(StuList.contains(find1));
       //StuList.get(0).display();
       Iterator<Student> stuIterator = StuList.iterator();
       Student currentStu = new Student();

       while(stuIterator.hasNext()){
        currentStu = stuIterator.next();
          currentStu.display();
       }

    }
}

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class DepartmentTest {

    @Test
    public void testSetDean() {
        Department department1 = new Department(1001,"Computer Science");
        Teacher teacher1 = new Teacher(7777,"phil",14,"Male","Computer","phd",1001);
        Student student1 = new Student(2222, "Jeffrey", 41, "Male", "Computer Science", 3, 1001);

        Teacher result1 = teacher1;
        Student result2 = student1;

        Teacher expResult1 = new Teacher();
        Student expResult2 = new Student();

        department1.setDean(teacher1);

        assertEquals(expResult2,department1); //Making a Teacher a dean, will work
        // assertNotEquals(expResult2, result2); //Making a student a dean, will fail

    }
}


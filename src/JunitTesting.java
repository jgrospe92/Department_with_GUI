
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.rules.ExpectedException;

public class JunitTesting {

    @Test
    public void testComputePayRollTeacher(){

        String degree = "phd";
        Teacher t1 = new Teacher(1111, "Apple", 24, "M", "Design", degree, 1001);
        
        // Possible outcome based on Degree
        double zero = 0.0;
        double phd = 6128.64;
        double master = 4487.04;
        double bachelor = 2298.24;

        double actual = t1.computePayRoll();

        Assertions.assertEquals(phd, actual);

    }

    @Test
    public void testComputePayRollStaff(){

        int hourswkrd = 20;
        int exceedHr = 40;
        Staff s1 = new Staff(1111, "Donkey", 21, "M", "Janitor", hourswkrd, 1001);

        double expected = 1049.6;

        double actual = s1.computePayRoll();

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void testAddTeacherToDept(){
        // The test will passed if the department ID matches with the Teacher Dept ID
        Department d1 = new Department(1001, "Testing");
        Teacher t1 = new Teacher(1111, "Apple", 24, "M", "Design", "phd", 1001);
        if (d1.getId() == t1.getFkDeptID()) {
            d1.getTeacherList().add(t1);
        }
        // If tha above condition is met the Teacher is added to the Dept Teacher list Test will passed
        Assertions.assertTrue(!d1.getTeacherList().isEmpty()); 
        Assertions.assertEquals(1, d1.getTeacherList().size());
    }

    @Test
    public void testAddStaffToDept(){
        // The test will passed if the department ID matches with the Teacher Dept ID
        Department d1 = new Department(1001, "Testing");
        Staff s1 = new Staff(1111, "Donkey", 21, "M", "Janitor", 22, 1001);
        if (d1.getId() == s1.getFkDeptID()) {
            d1.getStaffList().add(s1);
        }
        // If tha above condition is met the Staff is added to the Dept Teacher list Test will passed
        Assertions.assertTrue(!d1.getStaffList().isEmpty());
        Assertions.assertEquals(1, d1.getStaffList().size());

    }

    @Test
    public void testAddStudentToDept(){
        // The test will passed if the department ID matches with the Teacher Dept ID
        Department d1 = new Department(1001, "Testing");
        Student student = new Student(1111, "Fiora", 23, "F", "Nursing", 3, 1001);
        if (d1.getId() == student.getFkDeptID()) {
            d1.getStudentList().add(student);
        }
        // If tha above condition is met the Staff is added to the Dept Teacher list
        // Test will passed
        Assertions.assertTrue(!d1.getStudentList().isEmpty());
        Assertions.assertEquals(1, d1.getStudentList().size());

    }

    
}

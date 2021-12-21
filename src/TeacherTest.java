import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class TeacherTest {

    public TeacherTest() {
    }

    @Test
    public void testComputePayRoll() {
        Teacher teacher1 =  new Teacher(5546,"Sana Malkesh",28,"female","topology","master",1001);
        System.out.println("PayRoll");
        String n = "masters";
        double expResult = 4362.4;
        double result = teacher1.computePayRoll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    // PHD 112 Master 82 Bachhelor 42
    //Formula (36*saldegree*2)*0.76
    //PHD 5958.4 Master 4362.4 Bachelor 2234.4

    // 1234,Steve James,27,male,computer vision,master,1001
    // 2345,Patrick Dalton,30,other,pre-history,bachelor,1003
    // 5546,Sana Malkesh,28,female,topology,master,1001
    // 6854,Anastasia Ponomareva,32,female,micro economy,phd,1005

}

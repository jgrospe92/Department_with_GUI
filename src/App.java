import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{
    public static void main(String[] args) {

        // ArrayList 
        ArrayList<Department> departmentList = new ArrayList<>(); 
        ArrayList<Teacher> teacherLit = new ArrayList<>();
        ArrayList<Student> studentList = new ArrayList<>();
        ArrayList<Staff> StaffList = new ArrayList<>();

        launch(args);
        
    }
    

    @Override
    public void start(Stage stage) throws Exception {
       Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
       Scene scene = new Scene(root);
       stage.setScene(scene);
       stage.show();
        
    }

  
 
}

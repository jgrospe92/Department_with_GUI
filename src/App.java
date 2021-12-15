import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
      
       try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Cegep");
        
            stage.setScene(scene);
            stage.show();
        } catch (Exception e){

        }
    }
    public static void main(String[] args) {

        // ArrayList
        ArrayList<Department> departmentList = new ArrayList<>();
        ArrayList<Teacher> teacherLit = new ArrayList<>();
        ArrayList<Student> studentList = new ArrayList<>();
        ArrayList<Staff> StaffList = new ArrayList<>();

        launch(args);

    }

  
        
    

}

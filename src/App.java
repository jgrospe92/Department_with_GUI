import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
      
        Parent root = FXMLLoader.load(getClass().getResource("Admin.fxml")); // use / to check outside
        Scene scene = new Scene(root);
        primaryStage.setTitle("Vanier College");

        Image icon = new Image("Image/programming.png"); // Image needs to be inside the src folder
        primaryStage.getIcons().add(icon); // set it


        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {

       
        launch(args);

    }

  
        
    

}

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class testForUI extends Application {

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
       try {
           
           
           Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml")); // use / to check outside
           Scene scene = new Scene(root);
           primaryStage.setTitle("Vanier College");

           Image icon = new Image("Image/programming.png"); // Image needs to be inside the src folder
           primaryStage.getIcons().add(icon); // set it


           primaryStage.setScene(scene);
           primaryStage.show();

       } catch (Exception e) {
           e.printStackTrace();
       }
        
    }

}
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;

public class SceneCont1 {



    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button login;

    @FXML
    private TextField tfName;

    @FXML
    public void login(ActionEvent event) throws IOException {

        String username = tfName.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("sscene2.fxml"));
        root = loader.load();

        SceneCont2 sceneCont2 = loader.getController();
        sceneCont2.displayName(username); 

        //root = FXMLLoader.load(getClass().getResource("sscene2.fxml")); // use / to check outside
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
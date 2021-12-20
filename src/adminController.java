
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class adminController {

    private boolean isJeff = false;
    private boolean isPhil = false;
    private boolean isValidPass = false;

    
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label invalidUser;

    @FXML
    private Label invalidPass;

    @FXML
    private Button btnSubmit;

    @FXML
    private PasswordField tfPass;

    @FXML
    private TextField tfUser;

    @FXML
    public void onClicked(ActionEvent event) throws Exception {

        String username = tfUser.getText();
        String password = tfPass.getText();

        try {
            verify(event, username, password);
           

        } catch (Exception e){
            System.out.print(e);
        }
        
    }

    private void verify(ActionEvent event, String username, String password) throws IOException{
        
        try {
            String formattedName = username.toLowerCase();
            isJeff = (formattedName.equals("jeffrey"));
            isPhil = (formattedName.equals("philip"));

            int passW = Integer.parseInt(password);

            isValidPass = (passW == 1234) && isJeff || (passW == 1111) && isPhil;

        } catch (Exception e) {
            invalidUser.setVisible(true);
            System.out.println(e);
        }
       

        if(username.length() == 0 || password == null) {
            invalidUser.setVisible(true);
            invalidUser.setVisible(true);

        }
        
        if(isJeff || isPhil){
            System.out.println(username);
            invalidUser.setVisible(false);
            if(isValidPass) {
                System.out.println(password);
                invalidPass.setVisible(false);

                FXMLLoader loader = new FXMLLoader(getClass().getResource("Body.fxml"));
                root = loader.load();
    
                BodyController sceneCont2 = loader.getController();
                sceneCont2.displayName(username);
                sceneCont2.displaySection();
    
                // root = FXMLLoader.load(getClass().getResource("sscene2.fxml")); // use / to
                // check outside
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            } else {
                invalidPass.setVisible(true);
                System.out.println("Invalid pass");
            }
        } else {
            invalidUser.setVisible(true);
            System.out.println("invalid");
        }
       
    }

}



import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class BodyController {

    @FXML
    private AnchorPane bodyPane;

    @FXML
    private Button btnSubmit;

    @FXML
    private Label labelWelcome;

    @FXML
    private Label lblImport;

    @FXML
    private Label lblSection;

    @FXML
    private TabPane mainTabPane;

    @FXML
    private MenuItem menuImpDept;

    @FXML
    private MenuItem menuLogout;

    @FXML
    private Tab tabDean;

    @FXML
    private Tab tabDepartment;

    @FXML
    private TableColumn<?, ?> tblViewDean;

    @FXML
    private TableColumn<?, ?> tblViewDesc;

    @FXML
    private TableColumn<?, ?> tblViewID;

    @FXML
    private TextField tfDean;

    @FXML
    private TextField tfDesc;

    @FXML
    private TextField tfId;

    @FXML
    private TextField tftImportName;

    

    Stage stage;

    // ArrayList
    ArrayList<Department> departmentList = new ArrayList<>();
    ArrayList<Teacher> teacherLit = new ArrayList<>();
    ArrayList<Student> studentList = new ArrayList<>();
    ArrayList<Staff> StaffList = new ArrayList<>();

    // ObservableList

    public void tabAction(ActionEvent event){

        if (event.getSource() == menuLogout) {
            stage = (Stage) bodyPane.getScene().getWindow();
            System.out.println("You are logout");
            stage.close();
        } else if (event.getSource() == menuImpDept) {
            lblImport.setVisible(true);
            tftImportName.setVisible(true);
            btnSubmit.setVisible(true);
            System.out.println("import");
        }   
 
    }
    public void btnAction(ActionEvent event) {
        if (event.getSource() == btnSubmit) {
            lblImport.setVisible(false);
            tftImportName.setVisible(false);
            btnSubmit.setVisible(false);
            System.out.println("import done");
            
        }
    }

    public void displayName(String username) {
        labelWelcome.setText("Hello: " + username);
    }

    public void displaySection(){
       
        lblSection.setText("Section: " + tabDepartment.getText());
    
    }

    public void displaySectionDean(){
        lblSection.setText("Section: " + tabDean.getText());

    }


}

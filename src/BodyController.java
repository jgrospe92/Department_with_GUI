import java.util.ArrayList;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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

    // Table view for Department
    @FXML
    private TableColumn<Department, String> tblViewDean;

    @FXML
    private TableColumn<Department, String> tblViewDesc;

    @FXML
    private TableColumn<Department, Integer> tblViewID;

    @FXML
    private TableView<Department> tvDept;

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
    public static ArrayList<Department> departmentList = new ArrayList<>();
    public static ArrayList<Teacher> teacherList = new ArrayList<>();
    public static ArrayList<Student> studentList = new ArrayList<>();
    public static ArrayList<Staff> StaffList = new ArrayList<>();

    // ObservableList
    public static ObservableList<Department> obsDeptList;

    // Initialize Dept
    public void initializeBooks(ObservableList<Department> dept) {
        tblViewID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblViewDesc.setCellValueFactory(new PropertyValueFactory<>("description"));
        tblViewDean.setCellValueFactory(new PropertyValueFactory<>("deanName"));
        tvDept.setItems(dept);
    }

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
            
            FileReadandWrite fileImp = new FileReadandWrite();
            String filename = tftImportName.getText();
            fileImp.fileImportDepartment(filename, departmentList, teacherList);
            
            obsDeptList = FXCollections.observableArrayList(departmentList);

            System.out.println("obs");
            obsDeptList.get(0).showInfo();
            initializeBooks(obsDeptList);
            lblImport.setVisible(false);
            tftImportName.setVisible(false);
            btnSubmit.setVisible(false);

            
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

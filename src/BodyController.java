import java.util.ArrayList;
import java.util.Iterator;

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
    private Button btnExport;
    @FXML
    private Button btnAddDept;

    @FXML
    private Button btnSearchDept;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnModify;

    @FXML
    private Label lblDean;

    @FXML
    private Label labelWelcome;

    @FXML
    private Label lblImport;

    @FXML
    private Label lblSection;

    @FXML
    private Label lblSearch; // Search Label

    @FXML
    private TabPane mainTabPane;

    // Drop down Menu function
    @FXML
    private MenuItem menuImpDept;

    @FXML
    private MenuItem menuExport;
    
    @FXML
    private MenuItem menuLogout;
    
    @FXML
    private MenuItem menuSearch;

    @FXML
    private MenuItem menuDelete;

    @FXML
    private MenuItem menuUpdate;

    @FXML
    private MenuItem menuAdd;

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

    // Department Section
    @FXML
    private TextField tfDean;

    @FXML
    private TextField tfDesc;

    @FXML
    private TextField tfId;

    @FXML
    private TextField tftImportName;

    @FXML
    private TextField tftSearchDept;

    

    Stage stage;

    // ArrayList
    public static ArrayList<Department> departmentList = new ArrayList<>();
    public static ArrayList<Teacher> teacherList = new ArrayList<>();
    public static ArrayList<Student> studentList = new ArrayList<>();
    public static ArrayList<Staff> StaffList = new ArrayList<>();

    // ObservableList
    public static ObservableList<Department> obsDeptList = FXCollections.observableArrayList(departmentList);

    // Initialize Dept
    public void initializeBooks(ObservableList<Department> dept) {
        tblViewID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblViewDesc.setCellValueFactory(new PropertyValueFactory<>("description"));
        tblViewDean.setCellValueFactory(new PropertyValueFactory<>("deanName"));
        tvDept.setItems(dept);
    }

    private void showField(){
        lblSearch.setVisible(true);
        tftSearchDept.setVisible(true);
        btnSearchDept.setVisible(true);
    }
    private void hideField(){
        lblSearch.setVisible(false);
        tftSearchDept.setVisible(false);
        btnSearchDept.setVisible(false);
    }
    private void hideFieldDept(){
        lblImport.setVisible(false);
        tftImportName.setVisible(false);
        btnSubmit.setVisible(false);
    }
    private void showDeleteField(){
        lblSearch.setVisible(true);
        tftSearchDept.setVisible(true);
        btnDelete.setVisible(true);
    }
    private void hideDeleteField(){
        lblSearch.setVisible(false);
        tftSearchDept.setVisible(false);
        btnDelete.setVisible(false);
    }
    private void hideImport(){
        lblImport.setVisible(false);
        tftImportName.setVisible(false);
        btnSubmit.setVisible(false);
    }

    public void tabAction(ActionEvent event){

        if (event.getSource() == menuLogout) {
           
            stage = (Stage) bodyPane.getScene().getWindow();
            System.out.println("You are logout");
            stage.close();
        } else if (event.getSource() == menuImpDept) {
            btnModify.setVisible(false);
            hideDeleteField();
            hideField();
            lblImport.setText("import");
            lblImport.setVisible(true);
            tftImportName.setVisible(true);
            btnSubmit.setVisible(true);
            btnExport.setVisible(false);

        } else if (event.getSource() == menuExport)  {
            hideDeleteField();
            hideField();
            hideImport();
            lblImport.setText("export");
            lblImport.setVisible(true);
            tftImportName.setVisible(true);
            btnExport.setVisible(true);
            btnModify.setVisible(false);
          
        }  
        else if (event.getSource() == menuSearch){
            btnModify.setVisible(false);
            hideDeleteField();
            hideFieldDept();
            showField();
            hideImport();
            btnExport.setVisible(false);
        } else if (event.getSource() == menuDelete) {
            btnAddDept.setVisible(false);
            btnModify.setVisible(false);
            hideFieldDept();
            hideField();
            showDeleteField();
            btnExport.setVisible(false);
            hideImport();            
        }
         else if (event.getSource() == menuAdd) {
            hideImport();
            btnExport.setVisible(false);
            btnModify.setVisible(false);
            btnAddDept.setVisible(true);
            tfDean.setVisible(true);
            lblDean.setVisible(true);
        } else if (event.getSource() == menuUpdate) {
            System.out.printf("update");
            hideImport();
            hideDeleteField();
            btnAddDept.setVisible(false);
            btnModify.setVisible(true);
            tfDean.setVisible(false);
            lblDean.setVisible(false);
            btnExport.setVisible(false);

        }
 
    }
    public void btnAction(ActionEvent event) {
        if (event.getSource() == btnSubmit) {
            
            FileReadandWrite fileImp = new FileReadandWrite();
            String filename = tftImportName.getText();
            fileImp.fileImportDepartment(filename, departmentList, teacherList);
            
            obsDeptList = FXCollections.observableArrayList(departmentList);

            //System.out.println("obs");
            //obsDeptList.get(0).showInfo();
            initializeBooks(obsDeptList);
            lblImport.setVisible(false);
            tftImportName.setVisible(false);
            btnSubmit.setVisible(false);
            
        }
        if (event.getSource() == btnExport) {
            FileReadandWrite fileExport = new FileReadandWrite();
            String filename = tftImportName.getText();
            fileExport.fileExportDepartment(filename, new ArrayList<>(obsDeptList));
            lblImport.setVisible(false);
            tftImportName.setVisible(false);
            btnExport.setVisible(false);
        }
        if (event.getSource() == btnAddDept) {
            Department newDept;
            System.out.println("Add");
            
            newDept = new Department(Integer.parseInt(tfId.getText()), tfDesc.getText());
            obsDeptList.add(newDept);
            initializeBooks(obsDeptList);
            
          
        }
        if (event.getSource() == btnSearchDept) {
            searchItem();
            hideField();
        }
        if (event.getSource() == btnDelete) {
            
            for (int i = 0; i < obsDeptList.size(); i++) {
                if (obsDeptList.get(i).getId() == Integer.parseInt(tftSearchDept.getText())){
                    obsDeptList.remove(i);
                }
            }
            System.out.println("delete successful");
            hideDeleteField();
        }
        if (event.getSource() == btnModify) {
            Department modifyDept = new Department();
            int id = Integer.parseInt(tfId.getText());
            modifyDept.setId(id);
            modifyDept.setDescription(tfDesc.getText());
            for (int i = 0; i < obsDeptList.size(); i++) {
                if (obsDeptList.get(i).getId() == id) {
                    obsDeptList.set(i , modifyDept);
                }
            }
        }
    }
    // Iterator Method
    private void searchItem(){
        Department currentDept = new Department();
        Iterator<Department> iterator = obsDeptList.iterator();

        while(iterator.hasNext()){

            currentDept = iterator.next();
         
            if (currentDept.getId() == Integer.parseInt(tftSearchDept.getText())){
            
                tfId.setText(Integer.toString(currentDept.getId()));
                tfDesc.setText((currentDept.getDescription()));
                tfDean.setText(currentDept.getDeanName());

            } 
        }
        hideField();

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

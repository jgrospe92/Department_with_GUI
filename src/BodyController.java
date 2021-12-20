import java.util.ArrayList;
import java.util.Iterator;

import javafx.beans.Observable;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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
    private MenuItem menuSave;
    
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

    @FXML
    private Tab tabTeacher;

    // Table view for Department
    @FXML
    private TableColumn<Department, String> tblViewDesc;

    @FXML
    private TableColumn<Department, Integer> tblViewID;

    @FXML
    private TableView<Department> tvDept;

    // Table view Dean

    @FXML
    private TableView<Teacher> tvDean;
    // Dean and Teacher  table column 
    @FXML
    private TableColumn<Teacher, String> tblViewDeanSpec;

    @FXML
    private TableColumn<Teacher, Integer> tblViewDeanAge;

    @FXML
    private TableColumn<Teacher, Integer> tblViewDeanID;

    @FXML
    private TableColumn<Teacher, String> tblViewDeanName;

    @FXML
    private TableColumn<Teacher, String> tblViewDeanDegree;

    @FXML
    private TableColumn<Teacher, String> tblViewDeanGender;

    @FXML 
    private TableColumn<Teacher, Double> tblViewDeanSal;

    @FXML
    private TableColumn<Teacher, Integer> tblViewDeanFK;
    

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
    // assign dean
    @FXML
    private MenuItem menuItemAssDean;

    @FXML
    private Button btnAssDean;

    // Teacher Section
    @FXML
    private TableColumn<Teacher, String> tblViewDeanSpec1;

    @FXML
    private TableColumn<Teacher, Integer> tblViewDeanAge1;

    @FXML
    private TableColumn<Teacher, Integer> tblViewDeanID1;

    @FXML
    private TableColumn<Teacher, String> tblViewDeanName1;

    @FXML
    private TableColumn<Teacher, String> tblViewDeanDegree1;

    @FXML
    private TableColumn<Teacher, String> tblViewDeanGender1;

    @FXML 
    private TableColumn<Teacher, Double> tblViewDeanSal1;

    @FXML
    private TableColumn<Teacher, Integer> tblViewDeanFK1;

    @FXML
    private Button btnAddTeach;

    @FXML
    private MenuItem menuImpTeacher;

    @FXML
    private Label lblImportTeach;

    @FXML
    private TextField tfImpTeach;

    @FXML
    private Button btnImpoTeach;

    @FXML
    private MenuItem menuExportTeach;

    @FXML
    private MenuItem menuTeacherAdd;

    @FXML
    private MenuItem menuDelTeacher;

    @FXML
    private MenuItem menuUpdateTeach;

    @FXML
    private MenuItem menuSearchTeach;

    @FXML
    private TableView<Teacher> tvTeacher;

    @FXML
    private TextField tfTeacherAge;

    @FXML
    private TextField tfTeacherDeg;

    @FXML
    private TextField tfTeacherFk;

    @FXML
    private TextField tfTeacherGender;

    @FXML
    private TextField tfTeacherId;

    @FXML
    private TextField tfTeacherName;

    @FXML
    private TextField tfTeacherSpec;
    // Export
    @FXML
    private Label lblExportTeacher;

    @FXML
    private TextField tfExportTeacher;

    @FXML
    private Button btnExportTeacher;
    // Search
    @FXML
    private Label lblSearchTeacher;

    @FXML
    private TextField tfSearchTeacher;

    @FXML
    private Button btnSearchTeacher;

    @FXML
    private Label lblTempSal;

    @FXML
    private TextField tfTempSal;
    // Update
    @FXML
    private Button btnUpdateTeacher;
    // Delete
    @FXML
    private Label lblDelTeacher;

    @FXML
    private TextField tfDelTeacher;

    @FXML
    private Button btnDelTeacher;
    // Staff Section
    @FXML
    private Tab tabStaff;
    
    @FXML
    private TableView<Staff> tvStaff;

    @FXML
    private TableColumn<Staff, Integer> tblViewStaffID;

    @FXML
    private TableColumn<Staff, Integer> tblVstaffAge;

    @FXML
    private TableColumn<Staff, String> tblVstaffDuty;

    @FXML
    private TableColumn<Staff, Integer> tblVstaffFK;

    @FXML
    private TableColumn<Staff, String> tblVstaffGender;

    @FXML
    private TableColumn<Staff, String> tblVstaffName;

    @FXML
    private TableColumn<Staff, Double> tblVstaffSal;

    @FXML
    private TableColumn<Staff, Integer> tblVstaffWKL;
    //Staff textField
    @FXML
    private TextField tfStaffAge;

    @FXML
    private TextField tfStaffDuty;

    @FXML
    private TextField tfStaffFK;

    @FXML
    private TextField tfStaffGender;

    @FXML
    private TextField tfStaffID;

    @FXML
    private TextField tfStaffName;

    @FXML
    private TextField tfStaffWorkload;
    // Staff MenuItems
    @FXML
    private MenuItem menuImpStaff;
    @FXML
    private MenuItem menuExportStaff;
    @FXML
    private MenuItem menuAddStaff;
    @FXML
    private MenuItem menuDelStaff;
    @FXML
    private MenuItem menuUpdateStaff;
    @FXML
    private MenuItem menuSStaff;
    // Import function
    @FXML private Label lblImportStaff;
    @FXML private TextField tfImpStaff;
    @FXML private Button btnImpStaff;
    // Export function
    @FXML private Label lblExpoStaff;
    @FXML private TextField tfExpoStaff;
    @FXML private Button btnExpoStaff;
    // Add function
    @FXML private Button btnAddStaff;
    // Dell Function
    @FXML private Label lblDelStaff;
    @FXML private TextField tfDelStaff;
    @FXML private Button btnDelStaff;
    // Update Function
    @FXML private Button btnUpdateStaff;
    // Search Function
    @FXML private Label lblSStaff;
    @FXML private TextField tfSStaff;
    @FXML private Button btnSStaff;
    @FXML private Label lblStaffSal;
    @FXML private TextField tfStaffStall;
    // Student Section
    @FXML private Tab tabStudent;
    
    @FXML
    private TextField tfStuAge;

    @FXML
    private TextField tfStuCourse;

    @FXML
    private TextField tfStuFK;

    @FXML
    private TextField tfStuGender;

    @FXML
    private TextField tfStuID;

    @FXML
    private TextField tfStuName;

    @FXML
    private TextField tfStuSem;

    // Table view
    @FXML
    private TableView<Student> tvStudent;

    @FXML
    private TableColumn<Student, Integer> tblVstuAge;

    @FXML
    private TableColumn<Student, String> tblVstuCourse;

    @FXML
    private TableColumn<Student, Integer> tblVstuFK;

    @FXML
    private TableColumn<Student, String> tblVstuGender;

    @FXML
    private TableColumn<Student, Integer> tblVstuID;

    @FXML
    private TableColumn<Student, String> tblVstuName;

    @FXML
    private TableColumn<Student, Integer> tblVstuSem;

    // MenuItem
    @FXML private MenuItem menuImpStu;
    @FXML private MenuItem menuExpoStu;
    @FXML private MenuItem menuAddStu;
    @FXML private MenuItem menuDelStu;
    @FXML private MenuItem menuUpdateStu;
    @FXML private MenuItem menuSStu;
    // Import function
    @FXML private Label lblImportStu;
    @FXML private TextField tfImportStu;
    @FXML private Button btnImportStu;
    // Export Function
    @FXML private Label lblExportStu;
    @FXML private TextField tfExportStu;
    @FXML private Button btnExportStu;
    // Import Function
    @FXML private Button btnAddStu;
    // Delete Function
    @FXML private Label lblDelStu;
    @FXML private TextField tfDelStu;
    @FXML private Button btnDelStu;
    // Update Function
    @FXML private Button btnUpdateStu;
    // Search function
    @FXML private Label lblSearchStu;
    @FXML private TextField tfSearchStu;
    @FXML private Button btnSearchStu;
    // Department View
    @FXML private Tab tabDisplayDept;
    @FXML private MenuItem menuDisplayDept;

    // TableView
    @FXML private TableView<Department> tvDisplayDept;
    @FXML private TableColumn<Department, Integer> tblVdisplayId;
    @FXML private TableColumn<Department, String> tblVdisplayDesc;
    @FXML private TableColumn<Department, String> tblVdisplayDean;
    @FXML private TableColumn<Department, ArrayList<String>> tblVdisplayTeacher;
    @FXML private TableColumn<Department, ArrayList<String>> tblVdisplayStaff;
    @FXML private TableColumn<Department, ArrayList<String>> tblVdisplayStu;
    @FXML private TextField tfDisplayID;
    @FXML private Button btnDisplaySub;






    Stage stage;

    // ArrayList
    public static ArrayList<Department> departmentList = new ArrayList<>();
    public static ArrayList<Teacher> teacherList = new ArrayList<>();
    public static ArrayList<Student> studentList = new ArrayList<>();
    public static ArrayList<Staff> staffList = new ArrayList<>();

    // ObservableList
    public static ObservableList<Department> obsDeptList = FXCollections.observableArrayList(/*departmentList*/);
    public static ObservableList<Teacher> obsDeanList = FXCollections.observableArrayList();
    public static ObservableList<Teacher> obsTeacherList = FXCollections.observableArrayList(/*teacherList*/);
    public static ObservableList<Department> deanTempList = FXCollections.observableArrayList(/*departmentList*/);
    public static ObservableList<Staff> obsStaff = FXCollections.observableArrayList();
    public static ObservableList<Student> obsStudentList = FXCollections.observableArrayList();
    public static ObservableList<Department> obsDisplayDept = FXCollections.observableArrayList(); // Display Dept info



    // Initialize Dept display it to the corresponding table column
    public void initializeDept(ObservableList<Department> dept) {
        tblViewID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblViewDesc.setCellValueFactory(new PropertyValueFactory<>("description"));
        tvDept.setItems(dept);

    }
    // Initialize Dean that is assign to a department and display it to the corresponding table column
    private ObservableList<Teacher> getDeanNow (){
        for (int i = 0; i < obsDeptList.size(); i++) {
            
            if(obsDeptList.get(i).getDean() != null ) {
                obsDeanList.add(obsDeptList.get(i).getDean());
                obsTeacherList.add(obsDeptList.get(i).getDean());
            }
       }
       
       return obsDeanList;
    }
    // Initialize Dean display it to the corresponding table column
    public void initializeDean(ObservableList<Teacher> teacher){
       tblViewDeanID.setCellValueFactory(new PropertyValueFactory<>("id"));
       tblViewDeanName.setCellValueFactory(new PropertyValueFactory<>("name"));
       tblViewDeanAge.setCellValueFactory(new PropertyValueFactory<>("age"));
       tblViewDeanGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
       tblViewDeanSpec.setCellValueFactory(new PropertyValueFactory<>("speciality"));
       tblViewDeanDegree.setCellValueFactory(new PropertyValueFactory<>("degree"));
       tblViewDeanSal.setCellValueFactory(new PropertyValueFactory<>("salary"));
       tblViewDeanFK.setCellValueFactory(new PropertyValueFactory<>("fkDeptID"));
       tvDean.setItems(teacher);
           
    }
    // Initialize Staff display it to the corresponding table column
    private void initializeStaff(ObservableList<Staff> staff){
        tblViewStaffID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblVstaffName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tblVstaffAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        tblVstaffGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        tblVstaffDuty.setCellValueFactory(new PropertyValueFactory<>("duty"));
        tblVstaffWKL.setCellValueFactory(new PropertyValueFactory<>("workload"));
        tblVstaffSal.setCellValueFactory(new PropertyValueFactory<>("salary"));
        tblVstaffFK.setCellValueFactory(new PropertyValueFactory<>("fkDeptID"));
        tvStaff.setItems(staff); 
    }
    // Initialize Student display it to the corresponding table column
    public void initializeStudent(ObservableList<Student> student) {
        tblVstuID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblVstuName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tblVstuAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        tblVstuGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        tblVstuCourse.setCellValueFactory(new PropertyValueFactory<>("course"));
        tblVstuSem.setCellValueFactory(new PropertyValueFactory<>("semester"));
        tblVstuFK.setCellValueFactory(new PropertyValueFactory<>("fkDeptID"));
        tvStudent.setItems(student);
    }
    // Initialize Teacher display it to the corresponding table column
    private void initializeTeacher(ObservableList<Teacher> teacher){
        tblViewDeanID1.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblViewDeanName1.setCellValueFactory(new PropertyValueFactory<>("name"));
        tblViewDeanAge1.setCellValueFactory(new PropertyValueFactory<>("age"));
        tblViewDeanGender1.setCellValueFactory(new PropertyValueFactory<>("gender"));
        tblViewDeanSpec1.setCellValueFactory(new PropertyValueFactory<>("speciality"));
        tblViewDeanDegree1.setCellValueFactory(new PropertyValueFactory<>("degree"));
        tblViewDeanSal1.setCellValueFactory(new PropertyValueFactory<>("salary"));
        tblViewDeanFK1.setCellValueFactory(new PropertyValueFactory<>("fkDeptID"));
        tvTeacher.setItems(teacher); 
    }
    // Initialize Display
    private void initializeDisplay(ObservableList<Department > dept){
        
        tblVdisplayId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblVdisplayDesc.setCellValueFactory(new PropertyValueFactory<>("description"));
        tblVdisplayDean.setCellValueFactory(new PropertyValueFactory<>("deanName"));
        tblVdisplayTeacher.setCellValueFactory(new PropertyValueFactory<>("teacherName"));
        tblVdisplayStaff.setCellValueFactory(new PropertyValueFactory<>("staff"));
        tblVdisplayStu.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        tvDisplayDept.setItems(dept);


    }
    // Methods to show and hide label, TextField & buttons. 
    private void showSearchStu(){
        lblSearchStu.setVisible(true);
        tfSearchStu.setVisible(true);
        btnSearchStu.setVisible(true);
    }
    private void hideSearchStu(){
        lblSearchStu.setVisible(false);
        tfSearchStu.setVisible(false);
        btnSearchStu.setVisible(false);
    }
    private void showDelStu(){
        lblDelStu.setVisible(true);
        tfDelStu.setVisible(true);
        btnDelStu.setVisible(true);
    }
    private void hideDelStu(){
        lblDelStu.setVisible(false);
        tfDelStu.setVisible(false);
        btnDelStu.setVisible(false);
    }
    private void showExportStu(){
        lblExportStu.setVisible(true);
        tfExportStu.setVisible(true);
        btnExportStu.setVisible(true);
    }
    private void hideExportStu(){
        lblExportStu.setVisible(false);
        tfExportStu.setVisible(false);
        btnExportStu.setVisible(false);
    }

    private void showImpStu(){
        lblImportStu.setVisible(true);
        tfImportStu.setVisible(true);
        btnImportStu.setVisible(true);
    }
    private void hideImpStu(){
        lblImportStu.setVisible(false);
        tfImportStu.setVisible(false);
        btnImportStu.setVisible(false);
    }
    private void showSStaff(){
        lblSStaff.setVisible(true);
        tfSStaff.setVisible(true);
        btnSStaff.setVisible(true);
        lblStaffSal.setVisible(true);
        tfStaffStall.setVisible(true);
    }
    private void hideSStaff(){
        lblSStaff.setVisible(false);
        tfSStaff.setVisible(false);
        btnSStaff.setVisible(false);
        lblStaffSal.setVisible(false);
        tfStaffStall.setVisible(false);

    }
    private void showDelStaff(){
        lblDelStaff.setVisible(true);
        tfDelStaff.setVisible(true);
        btnDelStaff.setVisible(true);
    }
    private void hideDelStaff(){
        lblDelStaff.setVisible(false);
        tfDelStaff.setVisible(false);
        btnDelStaff.setVisible(false);
    }
    private void showExpoStaff(){
        lblExpoStaff.setVisible(true);
        tfExpoStaff.setVisible(true);
        btnExpoStaff.setVisible(true);
    }

    private void hideExpoStaff(){
        lblExpoStaff.setVisible(false);
        tfExpoStaff.setVisible(false);
        btnExpoStaff.setVisible(false);
    }
    private void showImpStaff(){
        lblImportStaff.setVisible(true);
        tfImpStaff.setVisible(true);
        btnImpStaff.setVisible(true);
    }
    private void hideImpStaff(){
        lblImportStaff.setVisible(false);
        tfImpStaff.setVisible(false);
        btnImpStaff.setVisible(false);
    }

    private void showAddDean(){
        btnAssDean.setVisible(true);
        tfDesc.setDisable(true);
        tfDean.setVisible(true);
        lblDean.setVisible(true);
    }
    private void hideAddDean(){
        btnAssDean.setVisible(false);
        tfDesc.setDisable(false);
        tfDean.setVisible(false);
        lblDean.setVisible(false);

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
    private void hideImportTeacher(){
        lblImportTeach.setVisible(false);
        tfImpTeach.setVisible(false);
        btnImpoTeach.setVisible(false);
    }
    private void showImportTeacher(){
        lblImportTeach.setVisible(true);
        tfImpTeach.setVisible(true);
        btnImpoTeach.setVisible(true);
    }
    private void showExportTeacher(){
        lblExportTeacher.setVisible(true);
        tfExportTeacher.setVisible(true);
        btnExportTeacher.setVisible(true);
    }
    private void hideExportTeacher(){
        lblExportTeacher.setVisible(false);
        tfExportTeacher.setVisible(false);
        btnExportTeacher.setVisible(false);
    }
    private void showSearchTeacher(){
        lblSearchTeacher.setVisible(true);
        tfSearchTeacher.setVisible(true);
        btnSearchTeacher.setVisible(true);
        lblTempSal.setVisible(true);
        tfTempSal.setVisible(true);
    }
    private void hideSearchTeacher(){
        lblSearchTeacher.setVisible(false);
        tfSearchTeacher.setVisible(false);
        btnSearchTeacher.setVisible(false);
        lblTempSal.setVisible(false);
        tfTempSal.setVisible(false);
    }
    private void showDelTeacher(){
        lblDelTeacher.setVisible(true);
        tfDelTeacher.setVisible(true);
        btnDelTeacher.setVisible(true);
    }
    private void hideDelTeacher(){
        lblDelTeacher.setVisible(false);
        tfDelTeacher.setVisible(false);
        btnDelTeacher.setVisible(false);
    }

    // Action for the MenuItem
    public void tabAction(ActionEvent event){

        if (event.getSource() == menuLogout) {

            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Logout");
            alert.setHeaderText("You're about to logout!");
            alert.setContentText("Would you like to save before existing?: ");
            
            ButtonType yesBtn = new ButtonType("Yes");
            ButtonType noBtn = new ButtonType("No");

            alert.getButtonTypes().setAll(noBtn, yesBtn);

            if(alert.showAndWait().get() == yesBtn) {

                FileReadandWrite saveData = new FileReadandWrite();
                saveData.saveDepartment(new ArrayList<>(obsDeptList));
                saveData.saveTeacher(new ArrayList<>(obsTeacherList));
                saveData.saveStaff(new ArrayList<>(obsStaff));
                saveData.saveStudent(new ArrayList<>(obsStudentList));
                stage = (Stage) bodyPane.getScene().getWindow();
                System.out.println("You are logout");
                stage.close();
            }else if (alert.showAndWait().get() == noBtn) {
                stage = (Stage) bodyPane.getScene().getWindow();
                System.out.println("You are logout");
                stage.close();
            }
           
        } else if (event.getSource() == menuSave) {
            FileReadandWrite saveData = new FileReadandWrite();
            saveData.saveDepartment(new ArrayList<>(obsDeptList));
            saveData.saveTeacher(new ArrayList<>(obsTeacherList));
            saveData.saveStaff(new ArrayList<>(obsStaff));
            saveData.saveStudent(new ArrayList<>(obsStudentList));
            // Save option for Teacher, Student and Staff
            // Create save method inside FileReadandWrite class
        }
        // Department
        else if (event.getSource() == menuImpDept) {
            btnModify.setVisible(false);
            hideDeleteField();
            hideField();
            lblImport.setText("import");
            lblImport.setVisible(true);
            tftImportName.setVisible(true);
            btnSubmit.setVisible(true);
            btnAddDept.setVisible(false);
            btnExport.setVisible(false);
            hideAddDean();

        } else if (event.getSource() == menuExport)  {
            hideDeleteField();
            hideField();
            hideImport();
            lblImport.setText("export");
            lblImport.setVisible(true);
            tftImportName.setVisible(true);
            btnExport.setVisible(true);
            btnModify.setVisible(false);
            hideAddDean();
        }  
        else if (event.getSource() == menuSearch){
            btnModify.setVisible(false);
            hideDeleteField();
            hideFieldDept();
            showField();
            hideImport();
            btnExport.setVisible(false);
            hideAddDean();
        } else if (event.getSource() == menuDelete) {
            btnAddDept.setVisible(false);
            btnModify.setVisible(false);
            hideFieldDept();
            hideField();
            showDeleteField();
            btnExport.setVisible(false);
            hideImport();    
            hideAddDean();        
        }
         else if (event.getSource() == menuAdd) {
            hideImport();
            hideDeleteField();
            btnExport.setVisible(false);
            btnModify.setVisible(false);
            btnAddDept.setVisible(true);
            tfDean.setVisible(true);
            lblDean.setVisible(true);
            hideAddDean();
        } else if (event.getSource() == menuUpdate) {
            hideImport();
            hideDeleteField();
            hideField();
            btnAddDept.setVisible(false);
            btnModify.setVisible(true);
            tfDean.setVisible(false);
            lblDean.setVisible(false);
            btnExport.setVisible(false);
            hideAddDean();
          
        } else if (event.getSource() == menuItemAssDean) {
            hideImport();
            hideDeleteField();
            hideField();
            btnAddDept.setVisible(false);
            tfDean.setVisible(false);
            lblDean.setVisible(false);
            btnExport.setVisible(false);
            btnModify.setVisible(false);
            showAddDean();
        } else if (event.getSource() == menuDisplayDept) {
            tabDisplayDept.setDisable(false);
        }
        // Teacher
        else if (event.getSource() == menuTeacherAdd) {
            btnAddTeach.setVisible(true);
            hideImportTeacher();
            hideExportTeacher();
            hideSearchTeacher();
            btnUpdateTeacher.setVisible(false);
            hideDelTeacher();
        } else if (event.getSource() == menuImpTeacher) {
            btnAddTeach.setVisible(false);
            showImportTeacher();
            hideSearchTeacher();
            hideExportTeacher();
            btnUpdateTeacher.setVisible(false);
            hideDelTeacher();

        } else if (event.getSource() == menuExportTeach ) {
            showExportTeacher();
            hideSearchTeacher();
            hideImportTeacher();
            btnAddTeach.setVisible(false);
            btnUpdateTeacher.setVisible(false);
            hideDelTeacher();
        } else if (event.getSource() == menuSearchTeach) {
            showSearchTeacher();
            hideExportTeacher();
            hideImportTeacher();
            btnAddTeach.setVisible(false);
            btnUpdateTeacher.setVisible(false);
            hideDelTeacher();
        } else if (event.getSource() == menuUpdateTeach) {
            btnUpdateTeacher.setVisible(true);
            showSearchTeacher();
            hideExportTeacher();
            hideImportTeacher();
            btnAddTeach.setVisible(false);
            hideSearchTeacher();
            hideDelTeacher();
        } else if (event.getSource() == menuDelTeacher) {
            btnUpdateTeacher.setVisible(false);
            showSearchTeacher();
            hideExportTeacher();
            hideImportTeacher();
            btnAddTeach.setVisible(false);
            hideSearchTeacher();
            showDelTeacher();
        }
        // Staff
        else if (event.getSource() == menuImpStaff) {
            btnUpdateTeacher.setVisible(false);
            hideExportTeacher();
            hideImportTeacher();
            btnAddTeach.setVisible(false);
            hideSearchTeacher();
            showImpStaff();
            hideExpoStaff();
            btnAddStaff.setVisible(false);
            hideDelStaff();
            hideSStaff();
            btnUpdateStaff.setVisible(false);
        } else if (event.getSource() == menuExportStaff) {
            btnUpdateTeacher.setVisible(false);
            hideExportTeacher();
            hideImportTeacher();
            btnAddTeach.setVisible(false);
            hideSearchTeacher();
            hideImpStaff();
            showExpoStaff();
            btnAddStaff.setVisible(false);
            hideDelStaff();
            hideSStaff();
            btnUpdateStaff.setVisible(false);
        } else if (event.getSource() == menuAddStaff) {
            btnUpdateTeacher.setVisible(false);
            hideExportTeacher();
            hideImportTeacher();
            btnAddTeach.setVisible(false);
            hideSearchTeacher();
            hideImpStaff();
            hideExpoStaff();
            btnAddStaff.setVisible(true);
            hideDelStaff();
            btnUpdateStaff.setVisible(false);
            hideSStaff();
        } else if (event.getSource() == menuDelStaff) {
            btnUpdateTeacher.setVisible(false);
            hideExportTeacher();
            hideImportTeacher();
            btnAddTeach.setVisible(false);
            hideSearchTeacher();
            hideImpStaff();
            hideExpoStaff();
            btnAddStaff.setVisible(false);
            btnUpdateStaff.setVisible(false);
            hideSStaff();
            showDelStaff();
        } else if (event.getSource() == menuUpdateStaff) {
            btnUpdateTeacher.setVisible(false);
            hideExportTeacher();
            hideImportTeacher();
            btnAddTeach.setVisible(false);
            hideSearchTeacher();
            hideImpStaff();
            hideExpoStaff();
            btnAddStaff.setVisible(false);
            hideDelStaff();
            hideSStaff();
            btnUpdateStaff.setVisible(true);
        } else if (event.getSource() == menuSStaff) {
            btnUpdateTeacher.setVisible(false);
            hideExportTeacher();
            hideImportTeacher();
            btnAddTeach.setVisible(false);
            hideSearchTeacher();
            hideImpStaff();
            hideExpoStaff();
            btnAddStaff.setVisible(false);
            hideDelStaff();
            btnUpdateStaff.setVisible(false);
            showSStaff();
        }
        // Student
        else if (event.getSource() == menuImpStu) {
            showImpStu();
            btnAddStu.setVisible(false);
            hideExportStu();
            btnUpdateStu.setVisible(false);
            hideDelStu();
            hideSearchStu();
        } else if (event.getSource() == menuExpoStu) {
            hideImpStu();
            showExportStu();
            hideDelStu();
            btnUpdateStu.setVisible(false);
            btnAddStu.setVisible(false);
            hideSearchStu();
        } else if (event.getSource() == menuAddStu) {
            hideImpStu();
            btnUpdateStu.setVisible(false);
            hideExportStu();
            btnAddStu.setVisible(true);
            hideSearchStu();
        } else if (event.getSource() == menuDelStu) {
            hideImpStu();
            hideExportStu();
            btnAddStu.setVisible(false);
            showDelStu();
            btnUpdateStu.setVisible(false);
            hideSearchStu();
        } else if (event.getSource() == menuUpdateStu) {
            hideImpStu();
            hideExportStu();
            btnAddStu.setVisible(false);
            hideDelStu();
            btnUpdateStu.setVisible(true);
            hideSearchStu();
        } else if (event.getSource() == menuSStu) {
            hideImpStu();
            hideExportStu();
            btnAddStu.setVisible(false);
            hideDelStu();
            btnUpdateStu.setVisible(false);
            showSearchStu();
        }
 
    }
    // Button Action
    public void btnAction(ActionEvent event) {
        // Department Button Events
        if (event.getSource() == btnSubmit) {
            
            FileReadandWrite fileImp = new FileReadandWrite();
            String filename = tftImportName.getText();
            fileImp.fileImportDepartment(filename, departmentList, teacherList);
            
            obsDeptList = FXCollections.observableArrayList(departmentList);

            initializeDean(getDeanNow());

            initializeDept(obsDeptList);
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
            
            newDept = new Department(Integer.parseInt(tfId.getText()), tfDesc.getText());
            Department deptCheck = new Department(newDept.getId());
            if( !departmentList.contains(deptCheck)) {
                obsDeptList.add(newDept);
                departmentList.add(newDept);
                initializeDept(obsDeptList);
            } else {
                primaryKeyConstraint();
            }
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
        if (event.getSource() == btnAssDean) {
            assignDean();
            hideAddDean();
        }
        // Teacher Button Event
        if (event.getSource() == btnAddTeach) {
            addBtnTeacher();
           btnAddTeach.setVisible(false);
        }
        if (event.getSource() == btnImpoTeach) {
            FileReadandWrite importTeacher = new FileReadandWrite();
            String filename = tfImpTeach.getText();
            importTeacher.fileImportTeacher(filename, departmentList, teacherList);
            obsTeacherList = FXCollections.observableArrayList(teacherList);
            initializeTeacher(obsTeacherList);
            hideImportTeacher();
        }
        if (event.getSource() == btnExportTeacher) {
            FileReadandWrite exportTeacher = new FileReadandWrite();
            String filename = tfExportTeacher.getText();
            exportTeacher.fileExportTeacher(filename, new ArrayList<>(obsTeacherList));
            hideExportTeacher();
        }
        if (event.getSource() == btnSearchTeacher) {
            searchTeacher();
        }
        if (event.getSource() == btnUpdateTeacher) {
            int id = Integer.parseInt(tfTeacherId.getText());
            String name =  tfTeacherName.getText();
            int age = Integer.parseInt(tfTeacherAge.getText());
            String gender = tfTeacherGender.getText();
            String spec = tfTeacherSpec.getText();
            String degree = tfTeacherDeg.getText();
            int fk = Integer.parseInt(tfTeacherFk.getText());
            Teacher updateTeacher = new Teacher(id, name, age, gender,spec,degree,fk);
            
            Department relation = new Department(updateTeacher.getFkDeptID());
            if (departmentList.contains(relation)){

                for (int i = 0 ; i < obsTeacherList.size(); i++) {
                    if(obsTeacherList.get(i).getId() == id) {
                        obsTeacherList.set(i,updateTeacher);
                    }
                }
            } else {
                PKDoesNotExist();
            }

        }
        if (event.getSource() == btnDelTeacher) {
            for (int i = 0; i < obsTeacherList.size(); i++) {
                if (obsTeacherList.get(i).getId() == Integer.parseInt(tfDelTeacher.getText())){
                    obsTeacherList.remove(i);
                }
            }
            hideDelTeacher();
            tfDelTeacher.clear();
        }
        // Staff Btn Action
        if (event.getSource() == btnImpStaff) {
            FileReadandWrite impStaff = new FileReadandWrite();
            String filename = tfImpStaff.getText();
            impStaff.fileImportStaff(filename, departmentList, staffList);
            obsStaff = FXCollections.observableArrayList(staffList);
            initializeStaff(obsStaff);
            hideImpStaff();
        }
        if (event.getSource() == btnExpoStaff) {
            FileReadandWrite expoStaff = new FileReadandWrite();
            String filename = tfExpoStaff.getText();
            expoStaff.fileExportStaff(filename, new ArrayList<>(obsStaff));
            hideExpoStaff();
        }
        if (event.getSource() == btnAddStaff) {
            addBtnStaff();
            btnAddStaff.setVisible(false);
        }
        if (event.getSource() == btnDelStaff) {
            for (int i = 0; i < obsStaff.size(); i++) {
                if (obsStaff.get(i).getId() == Integer.parseInt(tfDelStaff.getText())){
                    obsStaff.remove(i);
                }
            }
            hideDelStaff();
            tfDelStaff.clear();
        }
        if (event.getSource() == btnUpdateStaff){
            int id = Integer.parseInt(tfStaffID.getText());
            String name = tfStaffName.getText();
            int age = Integer.parseInt(tfStaffAge.getText());
            String gender = tfStaffGender.getText();
            String duty = tfStaffDuty.getText();
            int workload = Integer.parseInt(tfStaffWorkload.getText());
            int fk = Integer.parseInt(tfStaffFK.getText());
            Staff updateStaff = new Staff(id, name, age, gender, duty, workload, fk);

            Department relation = new Department(updateStaff.getFkDeptID());
            if (departmentList.contains(relation)){

                for (int i = 0 ; i < obsStaff.size(); i++) {
                    if(obsStaff.get(i).getId() == id) {
                        obsStaff.set(i,updateStaff);
                    }
                }
            } else {
                PKDoesNotExist();
            }
        }
        if (event.getSource() == btnSStaff) {
            searchStaff();
        }
        // Student Button Function
        if (event.getSource() == btnImportStu) {
            FileReadandWrite impStaff = new FileReadandWrite();
            String filename = tfImportStu.getText();
            impStaff.fileImportStudent(filename, departmentList, studentList);
            obsStudentList = FXCollections.observableArrayList(studentList);
            initializeStudent(obsStudentList);
            hideImpStaff();
        }
        if (event.getSource() == btnExportStu) {
            FileReadandWrite exportStu = new FileReadandWrite();
            String filename = tfExportStu.getText();
            exportStu.fileExportStudent(filename, new ArrayList<>(obsStudentList));
            hideExportStu();
        }
        if (event.getSource() == btnAddStu) {
            addBtnStu();
            btnAddStaff.setVisible(false);
        }
        if (event.getSource() == btnDelStu) {
            for (int i = 0; i < obsStudentList.size(); i++) {
                if (obsStudentList.get(i).getId() == Integer.parseInt(tfDelStu.getText())){
                    obsStudentList.remove(i);
                }
            }
            hideDelTeacher();
            tfDelStu.clear();
        }
        if (event.getSource() == btnUpdateStu) {
            int id = Integer.parseInt(tfStuID.getText());
            String name = tfStuName.getText();
            int age = Integer.parseInt(tfStuAge.getText());
            String gender = tfStuGender.getText();
            String course = tfStuCourse.getText();
            int semester = Integer.parseInt(tfStuSem.getText());
            int fk = Integer.parseInt(tfStuFK.getText());
            Student updateStu = new Student(id, name, age, gender, course, semester, fk);

            Department relation = new Department(updateStu.getFkDeptID());
            if (departmentList.contains(relation)){

                for (int i = 0 ; i < obsStudentList.size(); i++) {
                    if(obsStudentList.get(i).getId() == id) {
                        obsStudentList.set(i,updateStu);
                    }
                }
            } else {
                PKDoesNotExist();
            }
        }
        if (event.getSource() == btnSearchStu) {
            searchStudent();
        }
        // Display view
        if (event.getSource() == btnDisplaySub) {
            obsDisplayDept.clear();
            for (int i = 0; i < obsDeptList.size(); i++) {
                if(obsDeptList.get(i).getId() == Integer.parseInt(tfDisplayID.getText())) {
                    obsDisplayDept.add(obsDeptList.get(i));
                    initializeDisplay(obsDisplayDept);
                    
                }
            }
        }
    }
    
    private void searchStudent(){
        Student currentStu = new Student();
        Iterator<Student> iterator = obsStudentList.iterator();

        while(iterator.hasNext()) {
            currentStu = iterator.next();
            if (currentStu.getId() == Integer.parseInt(tfSearchStu.getText())){

                tfStuID.setText(Integer.toString(currentStu.getId()));
                tfStuName.setText(currentStu.getName());
                tfStuAge.setText(Integer.toString(currentStu.getAge()));
                tfStuGender.setText(currentStu.getGender());
                tfStuCourse.setText(currentStu.getCourse());
                tfStuSem.setText(Integer.toString(currentStu.getSemester()));
                tfStuFK.setText(Integer.toString(currentStu.getFkDeptID()));
                
            }
        }


    }
    // Method for adding Student
    private void addBtnStu(){
        Student addStu;
        int id = Integer.parseInt(tfStuID.getText());
        String name = tfStuName.getText();
        int age = Integer.parseInt(tfStuAge.getText());
        String gender = tfStuGender.getText();
        String course = tfStuCourse.getText();
        int semester = Integer.parseInt(tfStuSem.getText());
        int fk = Integer.parseInt(tfStuFK.getText());

        addStu = new Student(id, name, age, gender, course, semester, fk);
        Department relation = new Department(addStu.getFkDeptID());
        Student fkT = new Student(addStu.getId(), addStu.getFkDeptID());

        if (departmentList.contains(relation) && !studentList.contains(fkT)) {
            obsStudentList.add(addStu);
            studentList.add(addStu);
            initializeStudent(obsStudentList);
            // Add this Teacher directly to the corresponding department.
            for (int i = 0;i < obsDeptList.size(); i++ ) {
                if (obsDeptList.get(i).getId() == addStu.getFkDeptID()) {
                    obsDeptList.get(i).getStudentList().add(addStu);
                }
            }

        } else {
            PKDoesNotExist();
           
        }
    }
    // Method for searching Staff
    private  void searchStaff(){
        Staff currentStaff = new Staff();
        Iterator<Staff> iterator = obsStaff.iterator();

        while(iterator.hasNext()) {
            currentStaff = iterator.next();
            if (currentStaff.getId() == Integer.parseInt(tfSStaff.getText())){

                tfStaffID.setText(Integer.toString(currentStaff.getId()));
                tfStaffName.setText(currentStaff.getName());
                tfStaffAge.setText(Integer.toString(currentStaff.getAge()));
                tfStaffGender.setText(currentStaff.getGender());
                tfStaffDuty.setText(currentStaff.getDuty());
                tfStaffWorkload.setText(Integer.toString(currentStaff.getWorkload()));
                tfStaffFK.setText(Integer.toString(currentStaff.getFkDeptID()));
                tfStaffStall.setText(Double.toString(currentStaff.getSalary()));
            }
        }
    }
    // Method for Adding Staff
    private void addBtnStaff(){
        Staff addStaff;
            int id = Integer.parseInt(tfStaffID.getText());
            String name = tfStaffName.getText();
            int age = Integer.parseInt(tfStaffAge.getText());
            String gender = tfStaffGender.getText();
            String duty = tfStaffDuty.getText();
            int workload = Integer.parseInt(tfStaffWorkload.getText());
            int fk = Integer.parseInt(tfStaffFK.getText());

            addStaff = new Staff(id, name, age, gender, duty, workload, fk);
            Department relation = new Department(addStaff.getFkDeptID());
            Staff fkT = new Staff(addStaff.getId(), addStaff.getFkDeptID());

            if (departmentList.contains(relation) && !staffList.contains(fkT)) {
                obsStaff.add(addStaff);
                staffList.add(addStaff);
                initializeStaff(obsStaff);
                // Add this Teacher directly to the corresponding department.
                for (int i = 0;i < obsDeptList.size(); i++ ) {
                    if (obsDeptList.get(i).getId() == addStaff.getFkDeptID()) {
                        obsDeptList.get(i).getStaffList().add(addStaff);
                    }
                }
    
            } else {
                PKDoesNotExist();
               
            }
    }
    // Method for assigning Dean
    private void assignDean(){

        boolean foundIt = false;
        boolean teacherNotInDept = false;

        int deptId = Integer.parseInt(tfId.getText());
        int teacherId = Integer.parseInt(tfDean.getText());
        obsDeptList = FXCollections.observableArrayList(departmentList);// del
        for (int i = 0 ; i < obsDeptList.size(); i ++) {
            if (obsDeptList.get(i).getId() == deptId && obsDeptList.get(i).getDean() == null ) {
                foundIt = true;

                for (int j = 0; j < obsDeptList.get(i).getTeacherList().size(); j ++) {
                    if (obsDeptList.get(i).getTeacherList().get(j).getId() == teacherId) {
                        obsDeptList.get(i).setDean(obsDeptList.get(i).getTeacherList().get(j));
                        teacherNotInDept = true;
                        obsDeanList.add(obsDeptList.get(i).getTeacherList().get(j));

                     
                     
                        initializeDept(obsDeptList); // remove ths
                        
                        break;
                    }
                }
            }
            
            obsDeptList.get(i).showInfo();
        }
        initializeDept(obsDeptList); 
        for(Department dep: departmentList) {
            dep.showInfo();
        }
        //initializeDean(obsTeacherList);
        for(int i = 0; i < obsDeanList.size(); i ++) {
            obsDeanList.get(i).display();
        }
        if (foundIt && teacherNotInDept) {
            System.out.println("found it");
        } else {
            PKDoesNotExist();
        }
    
    
    }
    // Method to show error
    private void primaryKeyConstraint(){
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Primary Key Constraint");
        alert.setHeaderText("Department ID must be unique");
        alert.setHeight(50);
        alert.setWidth(80);
        alert.showAndWait();
        ExceptionHandling pkConstraint = new ExceptionHandling("Department ID must be unique");
        System.out.println(pkConstraint.getMessage());
    }
    // Method for Searching Teacher
    private void searchTeacher(){
        Teacher currentTeacher = new Teacher();
        Iterator<Teacher> iterator = obsTeacherList.iterator();

        while(iterator.hasNext()) {
            currentTeacher = iterator.next();
            if (currentTeacher.getId() == Integer.parseInt(tfSearchTeacher.getText())){

                tfTeacherId.setText(Integer.toString(currentTeacher.getId()));
                tfTeacherName.setText(currentTeacher.getName());
                tfTeacherAge.setText(Integer.toString(currentTeacher.getAge()));
                tfTeacherGender.setText(currentTeacher.getGender());
                tfTeacherSpec.setText(currentTeacher.getSpeciality());
                tfTeacherDeg.setText(currentTeacher.getDegree());
                tfTeacherFk.setText(Integer.toString(currentTeacher.getFkDeptID()));
                tfTempSal.setText(Double.toString(currentTeacher.getSalary()));

            }
        }

    }
    // Method to show error
    private void PKDoesNotExist(){
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Fk Constraint");
        alert.setHeaderText("Department ID does not exist or duplicate ID");
        alert.setHeight(50);
        alert.setWidth(80);
        alert.showAndWait();
        ExceptionHandling fkConstraint = new ExceptionHandling("Department ID does not exist or duplicate ID");
        System.out.println(fkConstraint.getMessage());
    }
    // Method to add Teacher
    private void addBtnTeacher(){
        Teacher addTeacher;
   
        addTeacher = new Teacher(Integer.parseInt(tfTeacherId.getText()) , tfTeacherName.getText(), Integer.parseInt(tfTeacherAge.getText()),
        tfTeacherAge.getText(), tfTeacherSpec.getText(), tfTeacherDeg.getText(), Integer.parseInt(tfTeacherFk.getText()));
        Department relation = new Department(addTeacher.getFkDeptID());
        Teacher fkT = new Teacher(Integer.parseInt(tfTeacherId.getText()), addTeacher.getFkDeptID()); // This fix the duplicate issue
       
        if (departmentList.contains(relation) && !teacherList.contains(fkT)) {
            obsTeacherList.add(addTeacher);
            teacherList.add(addTeacher);
            initializeTeacher(obsTeacherList);
            // Add this Teacher directly to the corresponding department.
            for (int i = 0;i < obsDeptList.size(); i++ ) {
                if (obsDeptList.get(i).getId() == addTeacher.getFkDeptID()) {
                    obsDeptList.get(i).getTeacherList().add(addTeacher);
                }
            }

        } else {
            PKDoesNotExist();
           
        }
        
    }

    // Method for Searching Department using Iterator
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
    // Method to show the currently login user
    public void displayName(String username) {
        labelWelcome.setText("Hello: " + username);
    }
    // Method to disable view
    public void displayView(Event event){
        if(event.getSource() == tabDisplayDept) {
            tabDisplayDept.setDisable(true);
        }
    }
 
    // Methods to display the active tab
    public void tabSwitchAction(Event event) {
       
        if( event.getSource() == tabTeacher) {
           
            lblSection.setText("Section: " + tabTeacher.getText());
            if (!obsTeacherList.contains(obsTeacherList)) {
                initializeTeacher(obsTeacherList);
            }
            
            
        }
        if (event.getSource() == tabDean) {
            lblSection.setText("Section: " + tabDean.getText());
           
          
        }
        if (event.getSource() == tabDepartment) {
            lblSection.setText("Section: " + tabDepartment.getText());
            
        }
        if (event.getSource() == tabStaff) {
            lblSection.setText("Section: " + tabStaff.getText());
        }
        if (event.getSource() == tabStudent) {
            lblSection.setText("Section: " + tabStudent.getText());

        }
        if (event.getSource() == tabDisplayDept) {
            lblSection.setText("Section: " + tabDisplayDept.getText());
        }

    }
    public void displaySection(){
        lblSection.setText("Section: " + tabDepartment.getText());
    }

    public void displaySectionDean(){
        lblSection.setText("Section: " + tabDean.getText());
        
    }
}

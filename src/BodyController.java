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
    private TableColumn<Department, String> tblViewDean;

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

    

    Stage stage;

    // ArrayList
    public static ArrayList<Department> departmentList = new ArrayList<>();
    public static ArrayList<Teacher> teacherList = new ArrayList<>();
    public static ArrayList<Student> studentList = new ArrayList<>();
    public static ArrayList<Staff> StaffList = new ArrayList<>();

    // ObservableList
    public static ObservableList<Department> obsDeptList = FXCollections.observableArrayList(/*departmentList*/);
    public static ObservableList<Teacher> obsDeanList = FXCollections.observableArrayList();
    public static ObservableList<Teacher> obsTeacherList = FXCollections.observableArrayList(/*teacherList*/);

    // Initialize Dept
    public void initializeDept(ObservableList<Department> dept) {
        tblViewID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblViewDesc.setCellValueFactory(new PropertyValueFactory<>("description"));
        tblViewDean.setCellValueFactory(new PropertyValueFactory<>("deanName"));
        tvDept.setItems(dept);

    }

    private ObservableList<Teacher> getDeanNow (){
        for (int i = 0; i < obsDeptList.size(); i++) {
            
            if(obsDeptList.get(i).getDean() != null ) {
                obsDeanList.add(obsDeptList.get(i).getDean());
                obsTeacherList.add(obsDeptList.get(i).getDean());
            }
       }
       
       return obsDeanList;
    }
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
            // Save option for Teacher, Student and Staff
            // Create save method inside FileReadandWrite class
        } 
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
            hideDeleteField();
            btnExport.setVisible(false);
            btnModify.setVisible(false);
            btnAddDept.setVisible(true);
            tfDean.setVisible(true);
            lblDean.setVisible(true);
        } else if (event.getSource() == menuUpdate) {
            System.out.printf("update");
            hideImport();
            hideDeleteField();
            hideField();
            btnAddDept.setVisible(false);
            btnModify.setVisible(true);
            tfDean.setVisible(false);
            lblDean.setVisible(false);
            btnExport.setVisible(false);

        } else if (event.getSource() == menuTeacherAdd) {
            btnAddTeach.setVisible(true);
            hideImportTeacher();
            hideExportTeacher();
            hideSearchTeacher();
            btnUpdateTeacher.setVisible(false);

        } else if (event.getSource() == menuImpTeacher) {
            btnAddTeach.setVisible(false);
            showImportTeacher();
            hideSearchTeacher();
            hideExportTeacher();
            btnUpdateTeacher.setVisible(false);
            

        } else if (event.getSource() == menuExportTeach ) {
            showExportTeacher();
            hideSearchTeacher();
            hideImportTeacher();
            btnAddTeach.setVisible(false);
            btnUpdateTeacher.setVisible(false);

        } else if (event.getSource() == menuSearchTeach) {
            showSearchTeacher();
            hideExportTeacher();
            hideImportTeacher();
            btnAddTeach.setVisible(false);
            btnUpdateTeacher.setVisible(false);

        } else if (event.getSource() == menuUpdateTeach) {
            btnUpdateTeacher.setVisible(true);
            showSearchTeacher();
            hideExportTeacher();
            hideImportTeacher();
            btnAddTeach.setVisible(false);
            hideSearchTeacher();
        }
            
        
 
    }
    public void btnAction(ActionEvent event) {
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
            System.out.println("Add");
            
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
            System.out.println("export Teacher");
            FileReadandWrite exportTeacher = new FileReadandWrite();
            String filename = tfExportTeacher.getText();
            exportTeacher.fileExportTeacher(filename, new ArrayList<>(obsTeacherList));
            hideExportTeacher();
        }
        if (event.getSource() == btnSearchTeacher) {
            searchTeacher();
            System.out.println("search...");
            
        }
        if (event.getSource() == btnUpdateTeacher) {
            System.out.println("update");
            int id = Integer.parseInt(tfTeacherId.getText());
            String name =  tfTeacherName.getText();
            int age = Integer.parseInt(tfTeacherAge.getText());
            String gender = tfTeacherGender.getText();
            String spec = tfTeacherSpec.getText();
            String degree = tfTeacherDeg.getText();
            int fk = Integer.parseInt(tfTeacherFk.getText());
            //Teacher updateTeacher = new Teacher(id, name, age, gender,spec,degree,fk);
            Teacher updateTeacher = new Teacher();
            updateTeacher.setId(id);
            updateTeacher.setName(name);
            updateTeacher.setAge(age);
            updateTeacher.setGender(gender);
            updateTeacher.setSpeciality(spec);
            updateTeacher.setDegree(degree);
            updateTeacher.setFK(fk);
            
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
    }
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
    private void addBtnTeacher(){
        Teacher addTeacher;
   
        addTeacher = new Teacher(Integer.parseInt(tfTeacherId.getText()) , tfTeacherName.getText(), Integer.parseInt(tfTeacherAge.getText()),
        tfTeacherAge.getText(), tfTeacherSpec.getText(), tfTeacherDeg.getText(), Integer.parseInt(tfTeacherFk.getText()));
        Department relation = new Department(addTeacher.getFkDeptID());
        Teacher fkT = new Teacher(addTeacher.getFkDeptID()); // This fix the duplicate issue
       
        if (departmentList.contains(relation) && !teacherList.contains(fkT)) {
            obsTeacherList.add(addTeacher);
            teacherList.add(addTeacher);
            initializeTeacher(obsTeacherList);

        } else {
            PKDoesNotExist();
           
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
      
      
    }

}

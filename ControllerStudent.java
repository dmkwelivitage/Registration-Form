import java.sql.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class ControllerStudent {

    Connection conDB = CreateDB.DBCreate();
    Connection connStu = null;

    @FXML
    private CheckBox tfCourseIT;

    @FXML
    private CheckBox tfCourseBio;

    @FXML
    private CheckBox tfCourseScience;

    @FXML
    private TextField tfStuAddress;

    @FXML
    private TextField tfStuAge;

    @FXML
    private TextField tfStuName;

    @FXML
    private TextField tfStuNumber;

    @FXML
    void btnStuClearClicked(ActionEvent event) {
        tfStuName.setText("");
        tfStuAddress.setText("");
        tfStuAge.setText("");
        tfStuNumber.setText("");
        tfCourseIT.setSelected(false);
        tfCourseBio.setSelected(false);
        tfCourseScience.setSelected(false);
    }

    @FXML
    void btnStuSubmitClicked(ActionEvent event) throws SQLException {
        connStu = DBConnStudent.connect();
        Statement stmt = connStu.createStatement();
        String StuName = tfStuName.getText();
        String StuAge = tfStuAge.getText();
        String StuAddress = tfStuAddress.getText();
        String StuNumber = tfStuNumber.getText();
        try {
            String q = "Insert into Student_details(Student_Name, Student_Address, Student_Age, Student_ContactNumber) values ('"+StuName+"' , '"+StuAddress+"' , '"+StuAge+"' , '"+StuNumber+"')";
            PreparedStatement pst = connStu.prepareStatement(q);
            pst.execute();
            String q1 = "Select StudentID from Student_details Where Student_Name = '"+StuName+"'";
            ResultSet rSetName = stmt.executeQuery(q1);
            rSetName.next();
            int StuID = rSetName.getInt("StudentID");
            System.out.println(StuID);
            if (tfCourseIT.isSelected() == true){
                String ITname = tfCourseIT.getText();
                String strSelectIT = "Select CourseID from Course_details Where Course_Name = '"+ITname+"'";
                ResultSet rSetIT = stmt.executeQuery(strSelectIT);
                rSetIT.next();
                int IDIT = rSetIT.getInt("CourseID");
                String q2 = "Insert into Student_Course(StudentID , CourseID) values ('"+StuID+"' , '"+IDIT+"')";
                PreparedStatement pst2 = connStu.prepareStatement(q2);
                pst2.execute();
            }
            else{
                System.out.println("Error!");
            }
            if (tfCourseBio.isSelected() == true){
                String Bioname = tfCourseBio.getText();
                String strSelectBio = "Select CourseID from Course_details Where Course_Name = '"+Bioname+"'";
                ResultSet rSetBio= stmt.executeQuery(strSelectBio);
                rSetBio.next();
                int IDBio = rSetBio.getInt("CourseID");
                String q3 = "Insert into Student_Course(StudentID , CourseID) values ('"+StuID+"' , '"+IDBio+"')";
                PreparedStatement pst3 = connStu.prepareStatement(q3);
                pst3.execute();
            }
            else{
                System.out.println("Error!");
            }
            if (tfCourseScience.isSelected() == true){
                String Sciencename = tfCourseScience.getText();
                String strSelectScience = "Select CourseID from Course_details Where Course_Name = '"+Sciencename+"'";
                ResultSet rSetScience = stmt.executeQuery(strSelectScience);
                rSetScience.next();
                int IDScience = rSetScience.getInt("CourseID");
                String q4 = "Insert into Student_Course(StudentID , CourseID) values ('"+StuID+"' , '"+IDScience+"')";
                PreparedStatement pst4 = connStu.prepareStatement(q4);
                pst4.execute();
            }
            else{
                System.out.println("Error!");
            }
            System.out.println("Done!");
            DBConnect.connect().close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.sql.*;
import javafx.scene.control.TextField;

public class ControllerCourse {

    Connection conDB = CreateDB.DBCreate();
    Connection con = null;

    @FXML
    void btnClearClicked(ActionEvent event){
        tfName.setText("");
        tfDescription.setText("");
        tfPeriod.setText("");
        tfPrice.setText("");
    }

    @FXML
    void btnSubmitClicked(ActionEvent event){
        con = DBConnect.connect();
        String Name = tfName.getText();
        String Description = tfDescription.getText();
        String Price = tfPrice.getText();
        String Period = tfPeriod.getText();
        tfName.setText("");
        tfDescription.setText("");
        tfPeriod.setText("");
        tfPrice.setText("");
        try {
            String q = "Insert into Course_details(Course_Name , Course_Description, Course_Price, Course_Period) values ('"+Name+"' , '"+Description+"' , '"+Price+"' , '"+Period+"')";
            PreparedStatement pst = con.prepareStatement(q);
            pst.execute();
            System.out.println("Done!");
            DBConnect.connect().close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    private TextField tfDescription;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfPeriod;

    @FXML
    private TextField tfPrice;


}

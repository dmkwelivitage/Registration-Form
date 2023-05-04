import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main_Student extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Student.fxml"));
        primaryStage.setTitle("Main");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        
    }


    public static void main(String[] args) {
        launch(args);
    }
}

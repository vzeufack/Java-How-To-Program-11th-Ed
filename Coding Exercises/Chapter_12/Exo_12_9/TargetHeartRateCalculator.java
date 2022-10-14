import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TargetHeartRateCalculator extends Application{
   @Override
   public void start(Stage stage) throws Exception{
      Parent root = FXMLLoader.load(getClass().getResource("TargetHeartRateCalculator.fxml"));
      Scene scene = new Scene(root);
      stage.setTitle("Target Heart Rate Calculator");
      stage.setScene(scene);
      stage.show();
   }
   
   public static void main(String[] args){
      launch(args);
   }
}
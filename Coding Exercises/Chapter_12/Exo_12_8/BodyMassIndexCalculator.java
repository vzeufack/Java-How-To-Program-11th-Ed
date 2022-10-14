import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BodyMassIndexCalculator extends Application{
   @Override
   public void start(Stage stage) throws Exception{
      Parent root = FXMLLoader.load(getClass().getResource("BodyMassIndexCalculator.fxml"));
      Scene scene = new Scene(root);
      stage.setTitle("Body Mass Index Calculator");
      stage.setScene(scene);
      stage.show();
   }
   
   public static void main(String[] args){
      launch(args);
   }
}
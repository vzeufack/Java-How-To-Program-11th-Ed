import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class TargetHeartRateCalculatorController {

    @FXML
    private TextField ageTextField;

    @FXML
    private TextField maxHeartRateTextField;

    @FXML
    private TextField maxTargetHeartRateTextField;

    @FXML
    private TextField minTargetHeartRateTextField;

    @FXML
    void calculateButtonPressed(ActionEvent event) {
      try{
         int age = Integer.parseInt(ageTextField.getText());
         if(age < 0)
            throw new IllegalArgumentException();
         
         int maxHeartRate = 220 - age;
         double minTargetHeartRate = maxHeartRate * (50.0/100);
         double maxTargetHeartRate = maxHeartRate * (85.0/100);
         
         maxHeartRateTextField.setText(String.valueOf(maxHeartRate));
         minTargetHeartRateTextField.setText(String.valueOf(minTargetHeartRate));
         maxTargetHeartRateTextField.setText(String.valueOf(maxTargetHeartRate));
      }
      catch (IllegalArgumentException ex) {
         ageTextField.setText("Enter a valid age");
         ageTextField.selectAll();
         ageTextField.requestFocus();
      }
       
    }
}

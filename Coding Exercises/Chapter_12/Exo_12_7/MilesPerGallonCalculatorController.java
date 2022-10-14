import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MilesPerGallonCalculatorController {

    @FXML
    private Button calculateBtn;

    @FXML
    private TextField gallonsTextField;

    @FXML
    private TextField mileageTextField;

    @FXML
    private Label milesPerGallonTextField;

    @FXML
    void calculateBtnPressed(ActionEvent event) {
      boolean mileageIsValid = false;
      boolean gallonsIsValid = false;
      double mileage = 0, gallons = 0;
      
      milesPerGallonTextField.setText("");
      
      try {         
         mileage = Double.parseDouble(mileageTextField.getText()); 
         mileageIsValid = true; 
      }
      catch (NumberFormatException ex) {
         mileageTextField.setText("Enter a valid mileage");
         mileageTextField.selectAll();
         mileageTextField.requestFocus();
      }
      
      try{
         gallons = Double.parseDouble(gallonsTextField.getText());
         if(gallons == 0.0)
            throw new NumberFormatException();
         gallonsIsValid = true;
      }
      catch (NumberFormatException ex) {
         gallonsTextField.setText("Enter a valid number of gallons");
         gallonsTextField.selectAll();
         gallonsTextField.requestFocus();
      }
      
      if(mileageIsValid && gallonsIsValid)
         milesPerGallonTextField.setText(String.valueOf(String.format("%.2f mi/gl", mileage/gallons)));
    } 
    
    private double getMileage(){
      double mileage = 0.0;
      
      try {         
         mileage = Double.parseDouble(gallonsTextField.getText()); 
      }
      catch (NumberFormatException ex) {
         mileageTextField.setText("Enter a valid mileage");
         mileageTextField.selectAll();
         mileageTextField.requestFocus();
      }
      
      return mileage;
    }
}

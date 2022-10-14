import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AdditionController {

    @FXML
    private Button calculateBtn;

    @FXML
    private TextField num1TextField;

    @FXML
    private TextField num2TextField;

    @FXML
    private Label totalLabel;

    @FXML
    void calculateBtnPressed(ActionEvent event) {
      boolean num1IsValid = false;
      boolean num2IsValid = false;
      int num1 = 0, num2 = 0;
      
      try {         
         num1 = Integer.parseInt(num1TextField.getText()); 
         num1IsValid = true; 
      }
      catch (NumberFormatException ex) {
         totalLabel.setText("");
         num1TextField.setText("Enter a valid integer");
         num1TextField.selectAll();
         num1TextField.requestFocus();
      }
      
      try{
         num2 = Integer.parseInt(num2TextField.getText());
         num2IsValid = true;
      }
      catch (NumberFormatException ex) {
         totalLabel.setText("");
         num2TextField.setText("Enter a valid integer");
         num2TextField.selectAll();
         num2TextField.requestFocus();
      }
      
      if(num1IsValid && num2IsValid)
         totalLabel.setText(String.valueOf(num1 + num2));
    } 
}

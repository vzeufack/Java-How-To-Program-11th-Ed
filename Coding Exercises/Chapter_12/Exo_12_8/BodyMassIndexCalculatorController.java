import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;

public class BodyMassIndexCalculatorController {
    private double weight;
    private double height;

    @FXML
    private TextField bodyMassTextField;

    @FXML
    private TextField heightTextField;

    @FXML
    private ChoiceBox<String> unitStandardChoiceBox;

    @FXML
    private TextField weightTextField;

    @FXML
    void calculateButtonPressed(ActionEvent event) {
      String unitStandard = unitStandardChoiceBox.getValue();
      double bodyMass = 0.0;
      
      bodyMassTextField.setText("");
         
      if(isValidWeight(weightTextField.getText()) && isValidHeight(heightTextField.getText())){
         if(unitStandard.equalsIgnoreCase("metric"))
            bodyMassTextField.setText(String.valueOf(weight/Math.pow(height, 2)));
         else
            bodyMassTextField.setText(String.valueOf((weight * 703)/Math.pow(height, 2)));
      }
    }
    
    // called by FXMLLoader to initialize the controller
    public void initialize() {
      weight = 0.0;
      height = 0.0;
      String [] unitStandards = {"Metric", "British"};
      unitStandardChoiceBox.setItems(FXCollections.observableArrayList(unitStandards));
      unitStandardChoiceBox.setValue(unitStandards[0]);
    }
    
    private boolean isValidWeight(String measurement){
      try{
         double value = Double.parseDouble(measurement);
         if(value > 0){
            weight = value;
            return true;
         }
         else
            throw new IllegalArgumentException();
            
      }
      catch (IllegalArgumentException ex) {
         weightTextField.setText("Enter a valid weight"); 
         weightTextField.selectAll();
         weightTextField.requestFocus();    
      }
      
      return false;      
    }
    
    private boolean isValidHeight(String measurement){
      try{
         double value = Double.parseDouble(measurement);
         if(value > 0){
            height = value;
            return true;
         }
         else
            throw new IllegalArgumentException();
            
      }
      catch (IllegalArgumentException ex) {
         heightTextField.setText("Enter a valid height"); 
         heightTextField.selectAll();
         heightTextField.requestFocus();    
      }
      
      return false;      
    }
}

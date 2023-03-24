import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.control.TitledPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import java.util.Set;
import javafx.scene.layout.VBox;
import javafx.scene.control.Toggle;

public class PainterController {
   @FXML private Pane drawingAreaPane;
   @FXML private TitledPane colorTitledPane;
   private ToggleGroup colorToggleGroup = new ToggleGroup();
   private VBox content = new VBox();
   private Paint brushColor = Color.BLACK; // drawing color
   
   ColorChooser colorChooser = new ColorChooser();
   
   // set user data for the RadioButtons
   public void initialize() {
      Set<String> colorNames = colorChooser.getColorNames();
      for(String color: colorNames){
         RadioButton colorBtn = new RadioButton(color);
         colorBtn.setToggleGroup(colorToggleGroup);
         colorBtn.setUserData(colorChooser.getColor(color));
         content.getChildren().add(colorBtn);
      }
      colorTitledPane.setContent(content);
      content.setSpacing(5);
      
      colorToggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
         public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
            if (colorToggleGroup.getSelectedToggle() != null) {
               brushColor = (Color) colorToggleGroup.getSelectedToggle().getUserData();
            }
         }
      });   
   }
   
   private void colorRadioButtonSelected(ActionEvent e){
      brushColor = (Color) colorToggleGroup.getSelectedToggle().getUserData();
   }
   
   // handles drawingArea's onMouseDragged MouseEvent
   @FXML
   private void drawingAreaMouseDragged(MouseEvent e) {
      Circle newCircle = new Circle(e.getX(), e.getY(), 4, brushColor);
      drawingAreaPane.getChildren().add(newCircle); 
   }
      
   // handles Undo Button's ActionEvents
   @FXML
   private void undoButtonPressed(ActionEvent event) {
      int count = drawingAreaPane.getChildren().size();

      // if there are any shapes remove the last one added
      if (count > 0) {
         drawingAreaPane.getChildren().remove(count - 1);
      }
   }
   
   // handles Clear Button's ActionEvents
   @FXML
   private void clearButtonPressed(ActionEvent event) {
      drawingAreaPane.getChildren().clear(); // clear the canvas
   }
}

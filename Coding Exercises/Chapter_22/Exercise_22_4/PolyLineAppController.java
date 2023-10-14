// Fig. 22.6: PolyShapesController.java
// Drawing Polylines, Polygons and Paths.
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class PolyLineAppController {
   // enum representing shape types
   private enum ShapeType {POLYLINE, POLYGON, PATH};
   
   // instance variables that refer to GUI components
   @FXML private Pane drawingPane;
   @FXML private Polyline polyline;

   Circle circle = null;
   
   // set user data for the RadioButtons and display polyline object
   public void initialize() {
      polyline.setVisible(true);
   }

   @FXML
   private void drawingAreaMouseDragged(MouseEvent e){
      if(circle != null){
         drawingPane.getChildren().remove(circle);
      }
      circle = new Circle(e.getX(), e.getY(), 5, Color.BLACK);
      drawingPane.getChildren().addAll(circle);

      ObservableList<Double> points = polyline.getPoints();
      if(points.size() == 50)
         points.remove(0, 2);
      points.addAll(e.getX(), e.getY());
   }
}

/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/

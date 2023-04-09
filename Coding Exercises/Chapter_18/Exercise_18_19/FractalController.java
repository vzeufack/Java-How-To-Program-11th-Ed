// Fig. 18.20: FractalController.java
// Drawing the "Lo feather fractal" using recursion.
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;    

public class FractalController {
   // constants 
   private static final int MIN_LEVEL = 0;
   private static final int MAX_LEVEL = 15;

   // instance variables that refer to GUI components
   @FXML private Canvas canvas;
   @FXML private ColorPicker colorPicker;
   @FXML private ColorPicker colorPicker1;
   @FXML private ColorPicker colorPicker2;
   @FXML private ColorPicker colorPicker3;
   @FXML private ColorPicker colorPicker4;
   @FXML private Label levelLabel;

   private Color[] currentColors = {Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW, Color.ORANGE};
   private int level = MIN_LEVEL; // initial fractal level
   private GraphicsContext gc; // used to draw on Canvas

   // initialize the controller
   public void initialize() {
      levelLabel.setText("Level: " + level);
      colorPicker.setValue(currentColors[0]); // start with purple
      colorPicker1.setValue(currentColors[1]);
      colorPicker2.setValue(currentColors[2]);
      colorPicker3.setValue(currentColors[3]);
      colorPicker4.setValue(currentColors[4]);
      gc = canvas.getGraphicsContext2D(); // get the GraphicsContext
      drawFractal();
   }
   
   // sets currentColor when user chooses a new Color
   @FXML
   void colorSelected(ActionEvent event) {
      currentColors[0] = colorPicker.getValue(); // get new Color
      currentColors[1] = colorPicker1.getValue();
      currentColors[2] = colorPicker2.getValue();
      currentColors[3] = colorPicker3.getValue();
      currentColors[4] = colorPicker4.getValue();
      drawFractal();
   }

   // decrease level and redraw fractal
   @FXML
   void decreaseLevelButtonPressed(ActionEvent event) {
      if (level > MIN_LEVEL) {
         --level;
         levelLabel.setText("Level: " + level);
         drawFractal();
      }
   }

   // increase level and redraw fractal
   @FXML
   void increaseLevelButtonPressed(ActionEvent event) {
      if (level < MAX_LEVEL) {
         ++level;
         levelLabel.setText("Level: " + level);
         drawFractal();
      }
   }

   // clear Canvas, set drawing color and draw the fractal
   private void drawFractal() {
      int xA = 40;
      int yA = 40;
      int xB = 195;
      int yB = 195;
      int origX = 195;
      int origY = 195;
      double theta = Math.toRadians(72);

      gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

      for(int i = 0; i < 5; i++) {
         gc.setStroke(currentColors[i]);
         drawFractal(level, xA, yA, xB, yB);
         int tempXA = xA;
         xA = (int)(((xA - origX) * Math.cos(theta)) - ((yA - origY) * Math.sin(theta)) + origX);
         yA = (int)(((tempXA - origX) * Math.sin(theta)) + ((yA - origY) * Math.cos(theta) )+ origY);
      }
   }

   // draw fractal recursively
   public void drawFractal(int level, int xA, int yA, int xB, int yB) {
      // base case: draw a line connecting two given points
      if (level == 0) {
         gc.strokeLine(xA, yA, xB, yB);
      }
      else { // recursion step: determine new points, draw next level
         // calculate midpoint between (xA, yA) and (xB, yB)
         int xC = (xA + xB) / 2;
         int yC = (yA + yB) / 2;

         // calculate the fourth point (xD, yD) which forms an 
         // isosceles right triangle between (xA, yA) and (xC, yC) 
         // where the right angle is at (xD, yD)
         int xD = xA + (xC - xA) / 2 - (yC - yA) / 2;
         int yD = yA + (yC - yA) / 2 + (xC - xA) / 2;
         
         // recursively draw the Fractal
         drawFractal(level - 1, xD, yD, xA, yA);
         drawFractal(level - 1, xD, yD, xC, yC);
         drawFractal(level - 1, xD, yD, xB, yB);  
      } 
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

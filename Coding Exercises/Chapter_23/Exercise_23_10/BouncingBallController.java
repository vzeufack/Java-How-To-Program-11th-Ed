// BallAnimationTimerController.java
// Bounce a circle around a window using an AnimationTimer subclass. 
import java.security.SecureRandom;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;

public class BouncingBallController {
   @FXML private Circle c;
   @FXML private Pane pane;
   
   public void initialize() {
      c.setVisible(false);
   }

   @FXML
   void generateBall(MouseEvent event) {
      SecureRandom random = new SecureRandom();
      Color color = new Color(random.nextDouble(), random.nextDouble(), random.nextDouble(), random.nextDouble());
      Circle newCircle = new Circle(c.getRadius(), color);
      Ellipse shadow = new Ellipse(50, 25);

      pane.getChildren().add(newCircle);
      pane.getChildren().add(shadow);
      newCircle.setStroke(c.getStroke());
      newCircle.setStrokeWidth(c.getStrokeWidth());
      newCircle.setVisible(true);
      shadow.setVisible(true);
      newCircle.setLayoutX(event.getSceneX());
      newCircle.setLayoutY(event.getSceneY());
      shadow.setLayoutX(newCircle.getLayoutX());
      shadow.setLayoutY(400);


      GenerateBallTask task = new GenerateBallTask(newCircle, shadow, pane.getBoundsInLocal());
      ExecutorService executorService = Executors.newFixedThreadPool(1);
      executorService.execute(task);
      executorService.shutdown();
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

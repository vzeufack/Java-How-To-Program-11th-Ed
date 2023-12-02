import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.util.Duration;

import java.security.SecureRandom;

public class GenerateBallTask extends Task {
    private SecureRandom random = new SecureRandom();
    private Circle c;
    private Ellipse shadow;
    private Bounds bounds;

    public GenerateBallTask(Circle circle, Ellipse shadow, Bounds bounds) {
        this.bounds = bounds;
        this.c = circle;
        this.shadow = shadow;
    }

    private boolean hitRightOrLeftEdge(Bounds bounds) {
        return (c.getLayoutX() <= (bounds.getMinX() + c.getRadius())) ||
                (c.getLayoutX() >= (bounds.getMaxX() - c.getRadius()));
    }

    // determines whether the circle hit top/bottom of the window
    private boolean hitTopOrBottom(Bounds bounds) {
        return (c.getLayoutY() <= (bounds.getMinY() + c.getRadius())) ||
                (c.getLayoutY() >= (bounds.getMaxY() - c.getRadius()));
    }

    @Override
    protected Object call() throws Exception {
        Timeline timelineAnimation = new Timeline(
                new KeyFrame(Duration.millis(10),
                        new EventHandler<ActionEvent>() {
                            int dx = 1 + random.nextInt(5);
                            int dy = 1 + random.nextInt(5);

                            // move the circle by the dx and dy amounts
                            @Override
                            public void handle(final ActionEvent e) {
                                c.setLayoutX(c.getLayoutX() + dx);
                                c.setLayoutY(c.getLayoutY() + dy);
                                shadow.setLayoutX(shadow.getLayoutX() + dx);

                                if (hitRightOrLeftEdge(bounds)) {
                                    dx *= -1;
                                }

                                if (hitTopOrBottom(bounds)) {
                                    dy *= -1;
                                }
                            }
                        }
                )
        );

        timelineAnimation.setCycleCount(Timeline.INDEFINITE);
        timelineAnimation.play();
        return null;
    }
}

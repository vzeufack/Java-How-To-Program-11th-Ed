import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.*;
import javafx.scene.shape.Rectangle;

import javafx.beans.value.ChangeListener;

public class UsingGradientsController {

    @FXML
    private RadioButton linearRadioButton;

    @FXML
    private ToggleGroup toggleGroup;

    @FXML
    private RadioButton radialRadioButton;

    @FXML
    private Slider redSliderStart;

    @FXML
    private Slider greenSliderStart;

    @FXML
    private Slider blueSliderStart;

    @FXML
    private Slider alphaSliderStart;

    @FXML
    private TextField redTextFieldStart;

    @FXML
    private TextField greenTextFieldStart;

    @FXML
    private TextField blueTextFieldStart;

    @FXML
    private TextField alphaTextFieldStart;

    @FXML
    private Slider redSliderEnd;

    @FXML
    private Slider greenSliderEnd;

    @FXML
    private Slider blueSliderEnd;

    @FXML
    private Slider alphaSliderEnd;

    @FXML
    private TextField redTextFieldEnd;

    @FXML
    private TextField greenTextFieldEnd;

    @FXML
    private TextField blueTextFieldEnd;

    @FXML
    private TextField alphaTextFieldEnd;

    @FXML
    private Rectangle rectangle;

    private LinearGradient linearGradient;
    private RadialGradient radialGradient;

    private enum GradientType{LINEAR, RADIAL};
    GradientType gradientType = GradientType.LINEAR;

    Color stop1 = Color.BLUE;
    Color stop2 = Color.WHITE;
    Stop[] stops = {new Stop(0, stop1), new Stop(1, stop2)};

    // instance variables for managing
    private int red = 0;
    private int green = 0;
    private int blue = 0;
    private double alpha = 1.0;

    // instance variables for managing
    private int redEnd = 0;
    private int greenEnd = 0;
    private int blueEnd = 0;
    private double alphaEnd = 1.0;

    public void initialize(){
        linearGradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
        radialGradient = new RadialGradient(0, 0, 0.5, 0.5, 0.6, true, CycleMethod.NO_CYCLE, stops);

        rectangle.setFill(linearGradient);

        linearRadioButton.setUserData(GradientType.LINEAR);
        radialRadioButton.setUserData(GradientType.RADIAL);
        initializeStartColor();
        initializeEndColor();
    }

    @FXML
    void radiantRadioButtonSelected(ActionEvent event) {
        gradientType = (GradientType) toggleGroup.getSelectedToggle().getUserData();
        updateRectangleFill();
    }

    private void updateRectangleFill(){
        rectangle.setFill(gradientType == GradientType.LINEAR? linearGradient: radialGradient);
    }

    public void initializeStartColor() {
        // bind TextField values to corresponding Slider values
        redTextFieldStart.textProperty().bind(
                redSliderStart.valueProperty().asString("%.0f"));
        greenTextFieldStart.textProperty().bind(
                greenSliderStart.valueProperty().asString("%.0f"));
        blueTextFieldStart.textProperty().bind(
                blueSliderStart.valueProperty().asString("%.0f"));
        alphaTextFieldStart.textProperty().bind(
                alphaSliderStart.valueProperty().asString("%.2f"));

        // listeners that set Rectangle's fill based on Slider changes
        redSliderStart.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> ov,
                                        Number oldValue, Number newValue) {
                        red = newValue.intValue();
                        stop1 = Color.rgb(red, green, blue, alpha);
                        stops[0] = new Stop(0, stop1);
                        linearGradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
                        radialGradient = new RadialGradient(0, 0, 0.5, 0.5, 0.6, true, CycleMethod.NO_CYCLE, stops);
                        updateRectangleFill();
                    }
                }
        );
        greenSliderStart.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> ov,
                                        Number oldValue, Number newValue) {
                        green = newValue.intValue();
                        stop1 = Color.rgb(red, green, blue, alpha);
                        stops[0] = new Stop(0, stop1);
                        linearGradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
                        radialGradient = new RadialGradient(0, 0, 0.5, 0.5, 0.6, true, CycleMethod.NO_CYCLE, stops);
                        updateRectangleFill();
                    }
                }
        );
        blueSliderStart.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> ov,
                                        Number oldValue, Number newValue) {
                        blue = newValue.intValue();
                        stop1 = Color.rgb(red, green, blue, alpha);
                        stops[0] = new Stop(0, stop1);
                        linearGradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
                        radialGradient = new RadialGradient(0, 0, 0.5, 0.5, 0.6, true, CycleMethod.NO_CYCLE, stops);
                        updateRectangleFill();
                    }
                }
        );
        alphaSliderStart.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> ov,
                                        Number oldValue, Number newValue) {
                        alpha = newValue.doubleValue();
                        stop1 = Color.rgb(red, green, blue, alpha);
                        stops[0] = new Stop(0, stop1);
                        linearGradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
                        radialGradient = new RadialGradient(0, 0, 0.5, 0.5, 0.6, true, CycleMethod.NO_CYCLE, stops);
                        updateRectangleFill();
                    }
                }
        );
    }

    public void initializeEndColor() {
        // bind TextField values to corresponding Slider values
        redTextFieldEnd.textProperty().bind(
                redSliderEnd.valueProperty().asString("%.0f"));
        greenTextFieldEnd.textProperty().bind(
                greenSliderEnd.valueProperty().asString("%.0f"));
        blueTextFieldEnd.textProperty().bind(
                blueSliderEnd.valueProperty().asString("%.0f"));
        alphaTextFieldEnd.textProperty().bind(
                alphaSliderEnd.valueProperty().asString("%.2f"));

        // listeners that set Rectangle's fill based on Slider changes
        redSliderEnd.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> ov,
                                        Number oldValue, Number newValue) {
                        redEnd = newValue.intValue();
                        stop2 = Color.rgb(redEnd, greenEnd, blueEnd, alphaEnd);
                        stops[1] = new Stop(1, stop2);
                        linearGradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
                        radialGradient = new RadialGradient(0, 0, 0.5, 0.5, 0.6, true, CycleMethod.NO_CYCLE, stops);
                        updateRectangleFill();
                    }
                }
        );
        greenSliderEnd.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> ov,
                                        Number oldValue, Number newValue) {
                        greenEnd = newValue.intValue();
                        stop2 = Color.rgb(redEnd, greenEnd, blueEnd, alphaEnd);
                        stops[1] = new Stop(1, stop2);
                        linearGradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
                        radialGradient = new RadialGradient(0, 0, 0.5, 0.5, 0.6, true, CycleMethod.NO_CYCLE, stops);
                        updateRectangleFill();
                    }
                }
        );
        blueSliderEnd.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> ov,
                                        Number oldValue, Number newValue) {
                        blueEnd = newValue.intValue();
                        stop2 = Color.rgb(redEnd, greenEnd, blueEnd, alphaEnd);
                        stops[1] = new Stop(1, stop2);
                        linearGradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
                        radialGradient = new RadialGradient(0, 0, 0.5, 0.5, 0.6, true, CycleMethod.NO_CYCLE, stops);
                        updateRectangleFill();
                    }
                }
        );
        alphaSliderEnd.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> ov,
                                        Number oldValue, Number newValue) {
                        alphaEnd = newValue.doubleValue();
                        stop2 = Color.rgb(redEnd, greenEnd, blueEnd, alphaEnd);
                        stops[1] = new Stop(1, stop2);
                        linearGradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
                        radialGradient = new RadialGradient(0, 0, 0.5, 0.5, 0.6, true, CycleMethod.NO_CYCLE, stops);
                        updateRectangleFill();
                    }
                }
        );
    }
}


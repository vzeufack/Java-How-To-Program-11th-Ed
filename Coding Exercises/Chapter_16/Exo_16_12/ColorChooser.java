import javafx.scene.paint.Color; 
import java.util.HashMap;
import java.util.Set;

/**
  ColorChooser.java by Vannel 2/2/2020
  Allows a user to get a color object by providing the color's name
  */
public class ColorChooser{
    private HashMap<String, Color> colorMap;
    
    /**
      Default constructor
      */
    public ColorChooser(){
       colorMap = new HashMap<>();
       
       colorMap.put("Black", Color.BLACK);
       colorMap.put("Blue", Color.BLUE);
       colorMap.put("Cyan", Color.CYAN);
       colorMap.put("Dark Gray", Color.DARKGRAY);
       colorMap.put("Gray", Color.GRAY);
       colorMap.put("Green", Color.GREEN);
       colorMap.put("Light Gray", Color.LIGHTGRAY);
       colorMap.put("Magenta", Color.MAGENTA);
       colorMap.put("Orange", Color.ORANGE);
       colorMap.put("Pink", Color.PINK);
       colorMap.put("Red", Color.RED);
       colorMap.put("White", Color.WHITE);
       colorMap.put("Yellow", Color.YELLOW);
    }
    
    /**
      * returns a color object given the color's name
      * @param colorName: String
      *    The color's name
      *
      * @return color: java.awt.Color
      */
     public Color getColor(String colorName){
        return colorMap.get(colorName);
     }
     
     public Set getColorNames(){
        return colorMap.keySet();
     } 
}
import java.awt.Color;
import java.util.HashMap;

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
       
       colorMap.put("black", Color.BLACK);
       colorMap.put("blue", Color.BLUE);
       colorMap.put("cyan", Color.CYAN);
       colorMap.put("darkgray", Color.DARK_GRAY);
       colorMap.put("gray", Color.GRAY);
       colorMap.put("green", Color.GREEN);
       colorMap.put("lightgray", Color.LIGHT_GRAY);
       colorMap.put("magenta", Color.MAGENTA);
       colorMap.put("orange", Color.ORANGE);
       colorMap.put("pink", Color.PINK);
       colorMap.put("red", Color.RED);
       colorMap.put("white", Color.WHITE);
       colorMap.put("yellow", Color.YELLOW);
    }
    
    /**
      * returns a color object given the color's name
      * @param colorName: String
      *    The color's name
      *
      * @return color: java.awt.Color
      */
     public Color getColor(String colorName){
        return colorMap.get(colorName.toLowerCase());
     } 
}
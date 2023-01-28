import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class MetricConverter{
   public static void main(String[] args){
      //System.out.println(answer("How many yards are in 17.5 miles?"));
      String test = "How many yards are in 17.5 miles?";
      String unitsPattern = "(kilometer|hectometer|decameter|meter|decimeter|centimeter|millimeter|inche?|yard|mile|feet|foot)s?";
      String pattern = "How\\smany\\s" + unitsPattern + "\\sare\\sin\\s\\d+(.\\d+)*\\s" + unitsPattern + "\\?";
      System.out.println(test.matches(pattern));
   }
   
   public static String answer(String question){
      Pattern unitsPattern = Pattern.compile("(kilometer|hectometer|decameter|meter|decimeter|centimeter|millimeter|inche?|yard|mile|feet|foot|\\d+(.\\d+)*)s?");
      Matcher matcher = unitsPattern.matcher(question);
      String[] targetValueSource = new String[3];
      int i = 0;
      
      while(matcher.find()){
         targetValueSource[i++] = matcher.group();
      }
            
      String sourceUnit = targetValueSource[2];
      double val = Double.parseDouble(targetValueSource[1]);
      String targetUnit = targetValueSource[0];
      
      if(isMetric(sourceUnit)){
         if(isMetric(targetUnit))
            return metricToMetricConverter(sourceUnit, val, targetUnit);
         else
            return metricToStandardConverter(sourceUnit, val, targetUnit);
      }
      else{
         if(isMetric(targetUnit))
             return standardToMetricConverter(sourceUnit, val, targetUnit);
         else
            return standardToStandardConverter(sourceUnit, val, targetUnit);
      }
   }
   
   private static boolean isMetric(String unit){
      return unit.contains("meter");
   }
   
   private static String metricToMetricConverter(String sourceUnit, double val, String targetUnit){
      double sourceToMeter = toMeter(sourceUnit);
      double targetToMeter = toMeter(targetUnit);
      return String.format("%.2f %s", (val * sourceToMeter)/targetToMeter, targetUnit);
   }
   
   private static String standardToStandardConverter(String sourceUnit, double val, String targetUnit){
      double sourceToInches = toInches(sourceUnit);
      double targetToInches = toInches(targetUnit);
      return String.format("%.2f %s", (val * sourceToInches)/targetToInches, targetUnit);
   }
   
   private static String metricToStandardConverter(String sourceUnit, double val, String targetUnit){
      double sourceToMeter = toMeter(sourceUnit);
      double meterToInches = val * sourceToMeter * 39.37008;
      return standardToStandardConverter("inches", meterToInches, targetUnit);
   }
   
   private static String standardToMetricConverter(String sourceUnit, double val, String targetUnit){
      double sourceToInches = toInches(sourceUnit);
      double inchesToMeter = val * sourceToInches * 0.0254;
      return metricToMetricConverter("meters", inchesToMeter, targetUnit);
   }
   
   private static double toInches(String unit){
      if(unit.matches("(foot|feet)"))
         return 12;
      else if (unit.matches("yards?"))
         return 36;
      else if (unit.matches("miles?"))
         return 63360;
      else
         return 1;
   }   
   
   private static double toMeter(String unit){
      String prefix = unit.replaceFirst("meters?", "");
      
      switch(prefix){
         case "kilo":
            return 1000;
         case "hecto":
            return 100;
         case "deca":
            return 10;
         case "deci":
            return 0.1;
         case "centi":
            return 0.01;
         case "milli":
            return 0.001;
         default:
            return 1;
      }
   }
}
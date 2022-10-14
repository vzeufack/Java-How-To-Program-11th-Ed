import java.util.ArrayList;

public class CarbonFootprintTest{
   public static void main(String[] args){
      ArrayList<CarbonFootprint> carbonFootprintObjects = new ArrayList<>();
      carbonFootprintObjects.add(new Bicycle());
      carbonFootprintObjects.add(new Car());
      carbonFootprintObjects.add(new Building());
      
      for(CarbonFootprint carbonFootprintObject: carbonFootprintObjects){
         System.out.println(carbonFootprintObject);
         System.out.printf("Carbon footprint = %.2f%n", carbonFootprintObject.getCarbonFootprint());
      }
   }
}
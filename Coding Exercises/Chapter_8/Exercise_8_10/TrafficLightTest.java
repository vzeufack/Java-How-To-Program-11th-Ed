public class TrafficLightTest{
   public static void main (String[] args){
      for(TrafficLight trafficLight: TrafficLight.values()){
         System.out.printf("%s - %2.2f\n", trafficLight, trafficLight.getDuration());
      }
   }
}
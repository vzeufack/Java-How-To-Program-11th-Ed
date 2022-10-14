public enum TrafficLight{
   RED(11),
   YELLOW(3),
   GREEN(11);
   
   private final double duration;
   
   TrafficLight(double duration){
      if(duration < 0)
         throw new IllegalArgumentException("duration must be positive");
      this.duration = duration;
   }
   
   public double getDuration(){
      return duration;
   }
}
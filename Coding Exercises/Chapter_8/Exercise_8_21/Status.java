import java.time.LocalDateTime;

public class Status{
   private StatusType statusType;
   private LocalDateTime statusTime;
   
   public Status(StatusType statusType, LocalDateTime statusTime){
      this.statusType = statusType;
      this.statusTime = statusTime;
   }
   
   public LocalDateTime getStatusTime(){
      return statusTime;
   }
   
   public String toString(){
      return String.format("%s -> %s\n", statusType, statusTime);
   }
}
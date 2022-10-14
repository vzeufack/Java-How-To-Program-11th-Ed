import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Represents a 911 emergency call
 */
public class Emergency{
   private ArrayList<Status> statuses;
   private String phoneNumber;
   private String address;
   private String description;
   private ResponseType response;
   
   public Emergency(){
      statuses = new ArrayList<Status>();
      Status status = new Status(StatusType.CALL_INITIATED, LocalDateTime.now());
      statuses.add(status);
      System.out.println("911 call launched at " + status.getStatusTime());
   }
   
   public ArrayList<Status> getStatuses(){
      return statuses;
   } 
   
   public String getPhoneNumber(){
      return phoneNumber;
   }
   
   public void setPhoneNumber(String phoneNumber){
      this.phoneNumber = phoneNumber;
      Status status = new Status(StatusType.PHONE_NUMBER_REGISTERED, LocalDateTime.now());
      statuses.add(status);
      System.out.println("Phone number successfully registered");
   }
   
   public String getAddress(){
      return address;
   }
   
   public void setAddress(String address){
      this.address = address;
      Status status = new Status(StatusType.ADDRESS_REGISTERED, LocalDateTime.now());
      statuses.add(status);
      System.out.println("Address successfully registered");
   }
   
   public String getDescription(){
      return description;
   }
   
   public void setDescription(String desc){
      this.description = desc;
      Status status = new Status(StatusType.DESCRIPTION_REGISTERED, LocalDateTime.now());
      statuses.add(status);
      System.out.println("Description successfully registered");
   }
   
   public ResponseType getResponseType(){
      return response;
   }
   
   public void setResponse(ResponseType response){
      this.response = response;
      Status status = new Status(StatusType.RESPONSE_SENT, LocalDateTime.now());
      statuses.add(status);
      System.out.println("Response sent");
   }

   public String toString(){
      String emergencyStr = "";      
      for(Status status: statuses){
         emergencyStr += status;
      }      
      
      return emergencyStr;
   }
}
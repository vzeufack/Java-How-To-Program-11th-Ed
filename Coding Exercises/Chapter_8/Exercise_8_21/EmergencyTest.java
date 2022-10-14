import java.util.Scanner;

public class EmergencyTest{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      
      //call initiated
      Emergency emergency = new Emergency();
      
      //phone number retrieval
      System.out.printf("Please provide your phone number > ");
      String phoneNumber = scan.nextLine();
      emergency.setPhoneNumber(phoneNumber);
      
      //address retrieval
      System.out.printf("Please provide your address > ");
      String address = scan.nextLine();
      emergency.setAddress(address);
      
      System.out.println("\nCall transfered to nearest PSAP ...\n");
      
      //information retrieval
      System.out.printf("what is the emergency > ");
      String desc = scan.nextLine();
      emergency.setDescription(desc);
      
      //response
      emergency.setResponse(ResponseType.FIRE);
      
      //emergency summary
      System.out.println("\n" + emergency);
   }
}
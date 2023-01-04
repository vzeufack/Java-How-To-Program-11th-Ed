import java.util.Scanner;

public class TokenizePhoneNumber{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      System.out.print("Enter a phone number in the format (555) 555 5555 > ");
      String areaCodeAndPhone = scan.nextLine();
      
      String[] splittedAreaCodeAndPhone = areaCodeAndPhone.split(" ");
      String[] phoneNumber = splittedAreaCodeAndPhone[1].split("-");
      
      System.out.println("Area code: " + splittedAreaCodeAndPhone[0].replaceAll("[\\(\\)]", ""));
      System.out.println("Phone number: " + phoneNumber[0] + phoneNumber[1]);
   }
}
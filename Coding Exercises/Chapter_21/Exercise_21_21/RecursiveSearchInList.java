package Exercise_21_21;

import com.deitel.datastructures.List;

import java.security.SecureRandom;
import java.util.Scanner;

public class RecursiveSearchInList {
    public static void main(String[] args) {
        List<Integer> list = new List<Integer>();
        SecureRandom randomNumber = new SecureRandom();
        Scanner input = new Scanner(System.in);

        for (int i = 1; i <= 20; i++) {
            int value = randomNumber.nextInt(100);
            list.insertAtBack(value);
        }

        list.print();
        String answer = "";
        do{
            System.out.printf("Enter a value to search or 's' to stop > ");
            answer = input.nextLine();

            if(!answer.equals("s")){
                Integer searchResult = list.search(Integer.parseInt(answer));
                if(searchResult != null){
                    System.out.println("Value was found!");
                }
                else{
                    System.out.println("Value was not found!");
                }
            }
        }while(!answer.equals("s"));
    }
}

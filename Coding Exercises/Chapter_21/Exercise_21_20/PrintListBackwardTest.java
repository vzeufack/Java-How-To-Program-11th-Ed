package Exercise_21_20;

import com.deitel.datastructures.List;

import java.security.SecureRandom;

public class PrintListBackwardTest {
    public static void main(String[] args) {
        List<Integer> list = new List<Integer>();
        SecureRandom randomNumber = new SecureRandom();

        System.out.println("Inserting the following values: ");

        for (int i = 1; i <= 20; i++) {
            int value = randomNumber.nextInt(100);
            list.insertAtBack(value);
        }

        list.print();
        list.printListBackward();
    }
}

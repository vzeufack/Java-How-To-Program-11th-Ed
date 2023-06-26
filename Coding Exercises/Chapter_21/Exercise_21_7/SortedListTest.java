package Exercise_21_7;

import java.security.SecureRandom;

public class SortedListTest {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        SortedList<Integer> list = new SortedList<>();
        for(int i = 0; i < 25; i++) {
            list.insert(random.nextInt(101));
        }
        list.print();
    }
}

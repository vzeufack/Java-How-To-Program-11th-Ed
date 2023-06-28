package Exercise_21_7;

import java.security.SecureRandom;

public class SortedListTest {

    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        SortedList<Integer> list1 = new SortedList<>();
        SortedList<Integer> list2 = new SortedList<>();

        for(int i = 0; i < 25; i++) {
            list1.insert(random.nextInt(101));
            list2.insert(random.nextInt(101));
        }
        list1.print();
        list2.print();

        list1.merge(list2);
        list1.print();
    }
}
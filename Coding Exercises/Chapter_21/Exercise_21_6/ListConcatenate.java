package Exercise_21_6;

import java.util.LinkedList;
import java.util.List;

public class ListConcatenate {
    public static void concatenate(List<Character> list1, List<Character> list2){
        if(list1 == null) {
            list1 = list2;
            return;
        }

        if(list2 != null)
            list1.addAll(list2);
    }
}

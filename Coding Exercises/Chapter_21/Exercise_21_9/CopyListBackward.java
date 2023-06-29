package Exercise_21_9;

import com.deitel.datastructures.List;

public class CopyListBackward {
    public static void main(String[] args) {
        List<Integer> list = new List<>();
        list.insertAtBack(1);
        list.insertAtBack(2);
        list.insertAtBack(3);
        list.print();

        List<Integer> reversedCopy = List.reverseCopy(list);
        reversedCopy.print();

        List<Integer> list2 = new List<>();
        list2.print();
        List.reverseCopy(list2).print();

        List<Integer> list3 = new List<>("Single element list");
        list3.insertAtFront(100);
        list3.print();
        List.reverseCopy(list3).print();
    }
}

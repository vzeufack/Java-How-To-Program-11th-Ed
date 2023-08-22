package Exercise_21_26;

import com.deitel.datastructures.List;

import java.util.NoSuchElementException;

public class InsertAndDeleteAnywhere {
    public static void main(String[] args) {
        //insert in empty list
        List<Integer> list = new List<>();
        list.insert(5, 0);
        list.print();

        //insert at the beginning
        list.insert(3, 0);
        list.print();

        //insert at the back
        list.insert(6, 2);
        list.print();

        //insert in the middle
        list.insert(4, 1);
        list.print();

        //insert with wrong index
        try {
            list.insert(4, 10);
        }
        catch(IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }

        //delete at the beginning
        list.remove(3);
        list.print();

        //delete in the middle
        list.remove(5);
        list.print();

        //delete in the end
        list.remove(6);
        list.print();

        //delete non existing element
        try {
            list.remove(10);
        }
        catch(NoSuchElementException e){
            System.out.println(e.getMessage());
        }

        //delete only element in list
        list.remove(4);
        list.print();

        //delete from empty list
        try {
            list.remove(100);
        }
        catch(NoSuchElementException e){
            System.out.println(e.getMessage());
        }
    }
}

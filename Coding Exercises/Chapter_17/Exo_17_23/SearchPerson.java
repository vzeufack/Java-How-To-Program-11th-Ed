import java.util.List;

public class SearchPerson{
   public static void main(String[] args){
      List<Person> list = List.of(
         new Person("test", "name"),
         new Person("Jason", "Jones"),
         new Person("Kabral", "Banbou"),
         new Person("Tonton", "Labo"),
         new Person("Last", "Jones"));
      
      System.out.println(
         list.stream()
             .filter(p -> p.getLastName().equals("Jones"))
             .findFirst()
             .get());
   }
}
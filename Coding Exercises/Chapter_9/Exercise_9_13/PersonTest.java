public class PersonTest{
   public static void main (String[] args){
      Person p = new Person();
      System.out.println(p.getAddress().getZip());
      p.modifyAddress();
      System.out.println(p.getAddress().getZip());
   }
}
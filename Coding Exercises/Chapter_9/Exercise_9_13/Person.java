public class Person{
   private String name;
   private Address address;
   
   public Person(){
      address = new Address();
   }
   
   public Address getAddress(){
      return address;
   }
   
   public void modifyAddress(){
      Address a = getAddress();
      a = new Address();
      a.setZip(2);
   }
}
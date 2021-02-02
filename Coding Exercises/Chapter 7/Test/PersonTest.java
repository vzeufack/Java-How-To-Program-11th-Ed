public class PersonTest{
   public static void main (String [] args){
      Address address = new Address("Street", "city state zip");
      Person p = new Person("name", address);
      Address addressTest = new Address("testAddrr", "testCSZ");
      System.out.println(addressTest.getStreet());
      p.modifyAddress(addressTest);
      System.out.println(addressTest.getStreet());
   }
}
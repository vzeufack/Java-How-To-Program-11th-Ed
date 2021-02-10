public class Person{
   private String name;
   private Address addr;
   
   public Person (String iname, Address iAddr){
      this.name = iname;
      this.addr = iAddr;
   }
   
   public void setAddress (Address newAddr){
       this.addr.setStreet(newAddr.getStreet());
       this.addr.setCsz(newAddr.getCsz());
   }
   
   public void modifyAddress(Address addr){
      Address a = addr;
      a.setStreet("street changed");
   }
}
public class Address{
   private String street;
   private String csz;
   
   public Address (String iStreet, String iCsz){
      this.street = iStreet;
      this.csz = iCsz;
   }
   
   public void setStreet(String newStreet){
       this.street = newStreet;
   }
   
   public void setCsz(String newCsz){
       this.csz = newCsz;
   }
   
   public String getStreet(){
      return street;
   }
   
   public String getCsz(){
      return csz;
   }
}
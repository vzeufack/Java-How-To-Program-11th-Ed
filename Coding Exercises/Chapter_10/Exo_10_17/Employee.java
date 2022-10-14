public class Employee {
   private String firstName;
   private String lastName;
   private String ssn;
   private CompensationModel compModel;

   public Employee (String firstName, String lastName, String ssn, CompensationModel compModel){
      this.firstName = firstName;
      this.lastName = lastName;
      this.ssn = ssn;
      this.compModel = compModel;
   }
   
   public CompensationModel getCompModel(){
      return compModel;
   }

   public void setCompensationModel(CompensationModel newCompModel){
      this.compModel = newCompModel;
   }
   
   public String getFirstName(){
      return firstName;
   }
   
   public String getLastName(){
      return lastName;
   }
   
   public String getSsn(){
      return ssn;
   }

   public double earnings(){
      return compModel.earnings();
   }
   
   @Override
   public String toString() {
      return String.format("%s %s%nsocial security number: %s%n%s", 
         getFirstName(), getLastName(), getSsn(), getCompModel());
   }
}

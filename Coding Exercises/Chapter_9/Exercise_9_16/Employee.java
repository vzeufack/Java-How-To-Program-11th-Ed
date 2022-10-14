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

   public void setCompensationModel(CompensationModel newCompModel){
      this.compModel = newCompModel;
   }

   public double earnings(){
      return compModel.earnings();
   }
}

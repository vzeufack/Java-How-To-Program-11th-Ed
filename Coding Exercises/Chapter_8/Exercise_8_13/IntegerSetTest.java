public class IntegerSetTest{
   public static void main (String [] args){
      IntegerSet set = new IntegerSet();
      System.out.println(set);
      
      set.insertElement(4);
      System.out.println(set);
      
      set.insertElement(10);
      System.out.println(set);
      
      set.deleteElement(4);
      System.out.println(set);
      
      set.insertElement(4);
      
      IntegerSet set2 = new IntegerSet();
      set2.insertElement(30);
      set2.insertElement(45);
      set2.insertElement(10);
      System.out.println(set2);

      IntegerSet set3 = IntegerSet.union(set, set2);
      System.out.println(set3);
      
      IntegerSet set4 = IntegerSet.intersection(set, set2);
      System.out.println(set4);
      
      try{
         set4.insertElement(4450);
      }catch(IllegalArgumentException e){
         System.out.println(e.getMessage());
      }
      
      try{
         set4.deleteElement(4450);
      }catch(IllegalArgumentException e){
         System.out.println(e.getMessage());
      }
   }
}
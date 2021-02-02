//InitArray.java by Vannel June 30, 2018
// Initializing the elements of an array to default values of zero.

public class InitArray {
   public static void main(String[] args) {
      int size;
	  
	  if (args.length == 0){
	    System.out.printf("No argument specified. Default value 10 will be used as array size%n");
		size = 10;
	  }
	  else{	  
	     size = Integer.parseInt(args[0]);		      
      }
	  
      int[] array = new int[size]; // create the array object           

	  System.out.printf("%s%8s%n", "Index", "Value"); // column headings
   
	  // output each array element's value                      
	  for (int counter = 0; counter < array.length; counter++) {
		 System.out.printf("%5d%8d%n", counter, array[counter]);
	  }  	  
   } 
}

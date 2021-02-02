public class Exercise8{
  public static void main (String [] args){
    for (int i = 0; i < 10; i++){
      System.out.println(sum(i));
    }    
  }
  
  public static int sum (int n){
    if (n == 0){
      return 0;
    }
    else{
      return n + sum(n-1);
    }
  }
}
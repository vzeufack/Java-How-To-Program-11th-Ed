import java.util.Scanner;

//Exercise_7_29 FibonacciSeries.java
public class FibonacciSeries{
    public static void main (String[] args){
        int n = 0;
        
        /*while (n != -1){
           n = readNumber();
           if (n != -1)
               System.out.printf("fibonacci(%d) = %d\n", n, fibonacci(n));
        }*/
        //System.out.println(Integer.MAX_VALUE); //2147483647
        
        //while (fibonacci(n) <= Integer.MAX_VALUE){
        while (fibonacci2(n) <= Double.MAX_VALUE){
            n++;
        }
        System.out.println(n);
        //Max int fibonacci number = 47
        //Max double fibonacci number = 1477
    }
    
    //readNumber
    private static int readNumber(){
        Scanner read = new Scanner(System.in);
        int n;
        
        do{
           System.out.print("Enter the value of n or -1 to stop > ");
           n = read.nextInt();  
        }while (n < -1);
        return n;
    }    
    
    //fibonacci
    private static long fibonacci(int n){
        long [] fibNumbers = new long [n+1];
        
        if (n == 0)
            return 0;            
        if (n == 1){
            //fibNumbers[1] = 1;
            return 1;
        }
            
        //fibNumbers[0] = 0;
        fibNumbers[1] = 1;
        
        for (int i = 2; i <= n; i++){
            fibNumbers[i] = fibNumbers[i-1] + fibNumbers[i-2];
        }        
        return fibNumbers[n];
    }
    
    //fibonacci2 with double parameter
    private static double fibonacci2 (int n){
        if (n == 0)
            return 0;
            
        if (n == 1)
            return 1;
            
        double [] fibNumbers = new double [n+1];
        //fibNumbers[0] = 0;
        fibNumbers[1] = 1;
        
        for (int i = 2; i <= n; i++){
            fibNumbers[i] = fibNumbers[i-1] + fibNumbers[i-2];
        }        
        return fibNumbers[n];
    }
}
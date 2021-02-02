public class Eratosthenes{
    public static void main (String [] args){
        isPrime(1000);
    }
    
    private static void isPrime (int n){
        boolean [] array = new boolean [n];
        for (int i = 0; i < array.length; i++){
            array[i] = true;
        }
        
        for (int i = 2; i < array.length; i++){
            if (array[i] == true)
                for (int j = i+1; j < array.length; j++){
                    if (j%i == 0)
                        array[j] = false;
                }
        }
        
       for (int i = 2; i < array.length; i++){
           if (array[i] == true)
               System.out.print(i + " ");
       }
    }
}
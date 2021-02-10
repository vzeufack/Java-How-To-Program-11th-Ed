//TortoiseTest.java
//Test the Tortoise class

public class TortoiseTest{

    public static void main (String [] args){
    
        //constructor
        Tortoise t1 = new Tortoise(1);
        Tortoise t2 = new Tortoise(2);
        
        //accessor
        System.out.println("***** Position accessor test *****");
        System.out.printf("Tortoise 1 position: %d | Tortoise 2 position: %d\n", t1.getPosition(), t2.getPosition());
        System.out.println("\n");
        
        //mutator
        System.out.println("***** Position mutator test *****");
        t1.setPosition(3);
        t2.setPosition(3);
        System.out.printf("Tortoise 1 position: %d | Tortoise 2 position: %d\n", t1.getPosition(), t2.getPosition());
        System.out.println("\n");
        
        //equals
        System.out.println("***** equals *****");
        String equality = (t1.equals(t2))?"t1 = t2":"t1 != t2";
        System.out.println(equality);
        t1.setPosition(2);
        equality = (t1.equals(t2))?"t1 = t2":"t1 != t2";
        System.out.println(equality);
        System.out.println("\n");
        
        //toString
        System.out.println("***** toString *****");
        System.out.printf("%s | %s\n", t1, t2);
        System.out.println("\n");
        
        //move
        System.out.println("***** Move *****");
        int [][] testCases = {{30,3},{30,6},{3,7},{70,9}, {60, 34}, {5,0}};
        for (int i = 0; i < testCases.length; i++){
              t1.setPosition(testCases[i][0]);
              t1.move(testCases[i][1]);
              System.out.printf("i:%2d | num:%2d | f:%2d\n", testCases[i][0], testCases[i][1], t1.getPosition());
        }
    }
}
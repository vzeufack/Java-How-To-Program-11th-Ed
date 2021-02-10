//Test hare class
public class HareTest{
    public static void main (String [] args){
        //constructor
        Hare h1 = new Hare(3);
        Hare h2 = new Hare(4);
        
        //accessor
        System.out.println("***** Position accessor test *****");
        System.out.printf("Hare 1 position: %d | Hare 2 position: %d\n", h1.getPosition(), h2.getPosition());
        System.out.println("\n");
        
        //mutator
        System.out.println("***** Position mutator test *****");
        h1.setPosition(45);
        h2.setPosition(70);
        System.out.printf("Hare 1 new position: %d | Hare 2 new position: %d\n", h1.getPosition(), h2.getPosition());
        System.out.println("\n");
        
        //equals
        System.out.println("***** equals *****");
        String equality = (h1.equals(h2))?"h1 = h2":"h1 != h2";
        System.out.println(equality);
        h2.setPosition(45);
        equality = (h1.equals(h2))?"h1 = h2":"h1 != h2";
        System.out.println(equality);
        System.out.println("\n");
        
        //toString
        System.out.println("***** toString *****");
        System.out.printf("%s | %s\n", h1, h2);
        System.out.println("\n");
        
        //move
        System.out.println("***** Move *****");
        int [][] testCases = {{35,1},{35,3},{35,5},{12,5},{60, 7},{5,9},{2,10},{35,0},{35,11}};
        for (int i = 0; i < testCases.length; i++){
              h1.setPosition(testCases[i][0]);
              h1.move(testCases[i][1]);
              System.out.printf("i:%2d | num:%2d | f:%2d\n", testCases[i][0], testCases[i][1], h1.getPosition());
        }
    }
}
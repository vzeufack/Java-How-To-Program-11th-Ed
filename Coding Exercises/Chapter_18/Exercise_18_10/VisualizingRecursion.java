public class VisualizingRecursion {
    public static void main(String[] args) {
        System.out.println("!5");
        factorial(5, 2);
    }
    public static long factorial(long number, int indent){
        if(number <= 1){
            System.out.println(String.format("%" + indent + "s%d", "", number));
            return 1;
        }
        else{
            System.out.println(String.format("%" + indent + "s%d * !%d", "", number, number - 1));
            return number * factorial(number - 1, indent + 2);
        }
    }
}

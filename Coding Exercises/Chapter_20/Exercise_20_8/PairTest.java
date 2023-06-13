package Exercise_20_8;

public class PairTest {
    public static void main(String[] args) {
        Integer i = 10;
        Double d = 5.0;
        Pair<Integer, Double> pair = new Pair(i, d);
        System.out.printf("Integer = %d | Double = %f\n", pair.getFirstElement(), pair.getSecondElement());
    }
}

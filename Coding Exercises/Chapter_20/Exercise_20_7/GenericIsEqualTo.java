package Exercise_20_7;

public class GenericIsEqualTo {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();
        System.out.printf("o1 = o2? %b\n", isEqualTo(o1, o2));

        Object o3 = o1;
        System.out.printf("o1 = o3? %b\n", isEqualTo(o1, o3));

        Integer i1 = 5;
        Integer i2 = 5;
        System.out.printf("i1 = i2? %b\n", isEqualTo(i1, i2));

        String s1 = "test";
        String s2 = "test";
        System.out.printf("s1 = s2? %b\n", isEqualTo(s1, s2));

        Double[] d1 = {7.3};
        Double[] d2 = {7.3};
        System.out.printf("d1 = d2? %b\n", isEqualTo(d1, d2));

        Car c1 = new Car("Mercedes");
        Car c2 = new Car("Mercedes");
        System.out.printf("c1 = c2? %b\n", isEqualTo(c1, c2));

        Car c3 = c2;
        System.out.printf("c2 = c3? %b\n", isEqualTo(c2, c3));
    }

    public static <T> boolean isEqualTo(T obj1, T obj2){
        return obj1.equals(obj2);
    }

    static class Car{
        private String model;

        public Car(String model){
            this.model = model;
        }
    }
}

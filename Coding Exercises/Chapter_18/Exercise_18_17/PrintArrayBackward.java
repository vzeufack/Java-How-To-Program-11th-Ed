public class PrintArrayBackward {
    public static void main(String[] args) {
        char[] a = {'a', 'b', 'c'};
        stringReverse(a, a.length-1);
    }

    private static void stringReverse(char[] a, int i){
        if(i == 0) {
            System.out.print(a[i]);
        }
        else {
            System.out.print(a[i]);
            stringReverse(a, i - 1);
        }
    }
}

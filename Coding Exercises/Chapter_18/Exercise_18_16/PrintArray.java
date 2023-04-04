public class PrintArray {
    public static void main(String[] args) {
        int[] a = {10, 20, 30, 40, 50};
        print(a, 0);
    }

    private static void print(int[] a, int i){
        if(a == null || a.length == 0)
            return;

        if(i == a.length-1) {
            System.out.print(a[i]);
        }
        else {
            System.out.printf("%d ", a[i]);
            print(a, i + 1);
        }
    }
}

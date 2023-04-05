public class ArrayMinimum {
    public static void main(String[] args) {
        int[] a = {4, 6, -3, 5};
        System.out.println(recursiveMinimum(a, 0));
    }

    private static int recursiveMinimum(int[] a, int i){
        if(i == a.length-1)
            return a[i];
        else
            return Math.min(recursiveMinimum(a, i+1), a[i]);
    }
}

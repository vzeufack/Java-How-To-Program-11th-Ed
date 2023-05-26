import java.util.Arrays;
public class SortingAlgorithms {
    public static void main(String[] args) {
        int[] array = new int[]{9, 4, 3, 1, 45, 10, 23, 100};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void bubbleSort(int[] array){
        for(int i = 0; i < array.length-1; i++){
            for(int j = 0; j < array.length-1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
    public static void enhancedBubbleSort(int[] array){
        boolean isSorted = false;

        for(int i = 0; i < array.length-1 && !isSorted; i++){
            isSorted = true;
            for(int j = 0; j < array.length-1-i; j++) {
                if (array[j] > array[j + 1]) {
                    isSorted = false;
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
    public static void bucketSort(int[] array){
        int[][] buckets = new int[10][array.length];
        int[] firstAvailableIndexByBucket = new int[10];
        resetBuckets(buckets, firstAvailableIndexByBucket);
        boolean sorted = false;
        int pos = 0;

        while(!sorted){
            //distribution pass
            for(int i = 0; i < array.length; i++) {
                int row = (array[i] / (int) Math.pow(10, pos)) % 10;
                buckets[row][firstAvailableIndexByBucket[row]++] = array[i];
            }

            int idx = 0;
            sorted = true;

            //gathering pass
            for(int i = 0; i < buckets.length && idx < array.length; i++){
                for(int j = 0; j < buckets[i].length && idx < array.length; j++){
                    if(buckets[i][j] != -1){
                        if(array[idx] != buckets[i][j]) {
                            array[idx] = buckets[i][j];
                            sorted = false;
                        }
                        idx++;
                    }
                }
            }

            resetBuckets(buckets, firstAvailableIndexByBucket);
            pos++;
        }

    }
    private static void resetBuckets(int[][] buckets, int[] firstAvailableIndexByBucket){
        for(int i = 0; i < buckets.length; i++){
            Arrays.fill(buckets[i], -1);
        }
        Arrays.fill(firstAvailableIndexByBucket, 0);
    }

    public static void quickSort(int[] array){
        quickSortHelper(array, 0, array.length-1);
    }

    private static void quickSortHelper(int[] array, int l, int r){
        if(l < r){
            int finalPosition = placeFirstElementAtRightPosition(array, l, r);
            quickSortHelper(array, l, finalPosition-1);
            quickSortHelper(array, finalPosition+1, r);
        }
    }

    private static int placeFirstElementAtRightPosition(int[] array, int l, int r){
        int pivot = array[l];
        int i = l;
        int j = r;
        boolean fromRight = true;
        boolean isAtRightPosition = false;

        while(!isAtRightPosition){
            if(fromRight) {
                while (j > i && array[j] >= pivot) {
                    j--;
                }

                if(j >= l && array[j] < pivot) {
                    swap(array, i, j);
                    i = j;
                    j = l;
                    fromRight = !fromRight;
                }
                else{
                    isAtRightPosition = true;
                }
            }
            else{
                while (j < i && array[j] <= pivot) {
                    j++;
                }

                if(j <= r && array[j] > pivot) {
                    swap(array, i, j);
                    i = j;
                    j = r;
                    fromRight = !fromRight;
                }
                else{
                    isAtRightPosition = true;
                }
            }
        }

        return i;
    }

    private static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class SearchingAlgorithms {

    public static int recursiveLinearSearch(int data[], int searchKey, int startIdx) {
        if(startIdx == data.length)
            return -1;

        if(data[startIdx] == searchKey)
            return startIdx;
        else
            return recursiveLinearSearch(data, searchKey, startIdx+1);
    }

    public static int recursiveBinarySearch(int[] data, int key, int startIdx, int endIdx){
        if(startIdx <= endIdx){
            int mid = (startIdx + endIdx)/2;
            if(data[mid] == key)
                return mid;
            else if (data[mid] > key)
                return recursiveBinarySearch(data, key, startIdx, mid-1);
            else
                return recursiveBinarySearch(data, key, mid+1, endIdx);
        }

        return -1;
    }
}

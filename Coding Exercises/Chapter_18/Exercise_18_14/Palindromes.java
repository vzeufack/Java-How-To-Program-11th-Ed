public class Palindromes {
    public static void main(String[] args) {
        System.out.println(isPalindrome("44?><?><<?"));
    }
    public static boolean isPalindrome(String str){
        String cleanStr = str.replaceAll("[^A-Za-z0-9]", "");
        return isPalindrome(cleanStr.toCharArray(), 0, cleanStr.length()-1);
    }

    private static boolean isPalindrome(char[] array, int i, int j){
        if(i >= j)
            return true;

        return array[i] == array[j] && isPalindrome(array, i+1, j-1);
    }
}

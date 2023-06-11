package Exercise_20_5;

public class OverloadedPrintArray {
    public static void main(String[] args) {
        // create arrays of Integer, Double and Character
        Integer[] integerArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7};
        Character[] characterArray = {'H', 'E', 'L', 'L', 'O'};

        System.out.printf("Array integerArray contains: ");
        printArray(integerArray); // pass an Integer array
        System.out.printf("Array doubleArray contains: ");
        printArray(doubleArray); // pass a Double array
        System.out.printf("Array characterArray contains: ");
        printArray(characterArray); // pass a Character array

        try {
            System.out.printf("\nElements between index 1 and 3 of integerArray contains: ");
            printArray(integerArray, 1, 3); // pass an Integer array
            System.out.printf("Elements between index 0 and 6 doubleArray contains: ");
            printArray(doubleArray, 0, 6); // pass a Double array
            System.out.printf("Elements between index 2 and 2 characterArray contains: ");
            printArray(characterArray, 2, 2); // pass a Character array
        }
        catch(InvalidSubscriptException e){}

        try {
            printArray(integerArray, -1, 3);
        }
        catch(InvalidSubscriptException e){
           System.out.println(e.getMessage());
        }

        try {
            printArray(integerArray, 0, -3);
        }
        catch(InvalidSubscriptException e){
            System.out.println(e.getMessage());
        }

        try {
            printArray(integerArray, 7, 5);
        }
        catch(InvalidSubscriptException e){
            System.out.println(e.getMessage());
        }

        try {
            printArray(integerArray, 0, 6);
        }
        catch(InvalidSubscriptException e){
            System.out.println(e.getMessage());
        }

        System.out.printf("\nArray stringArray contains: ");
        String[] stringArray = {"one", "two", "three", "four", "five", "six", "seven", "eight"};
        printArray(stringArray);
    }

    // generic method printArray
    public static <T> void printArray(T[] inputArray) {
        // display array elements
        for (T element : inputArray) {
            System.out.printf("%s ", element);
        }

        System.out.println();
    }

    public static <T> void printArray(T[] inputArray, int lowSubscript, int highSubscript) throws InvalidSubscriptException {
        if(lowSubscript < 0 || highSubscript < 0)
            throw new InvalidSubscriptException("subscripts must be strictly positive");

        if(lowSubscript > highSubscript)
            throw new InvalidSubscriptException("low subscript must be smaller or equal to high subscript");

        if(highSubscript >= inputArray.length)
            throw new InvalidSubscriptException(String.format("high subscript (%d) exceeds array length (%d) ", highSubscript, inputArray.length));

        // display array elements
        for (int i = lowSubscript; i <= highSubscript; i++) {
            System.out.printf("%s ", inputArray[i]);
        }

        System.out.println();
    }

    public static void printArray(String[] inputArray) {
        System.out.println();

        for (int i = 0; i < inputArray.length; i++) {
            if((i+1)%4 != 0)
                System.out.printf("%-10s", inputArray[i]);
            else
                System.out.printf("%-10s\n", inputArray[i]);
        }

        System.out.println();
    }
}

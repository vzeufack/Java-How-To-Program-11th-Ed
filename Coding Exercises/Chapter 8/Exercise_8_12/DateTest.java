//Tests the Date class
public class DateTest{
    public static void main (String [] args){
        Date date = new Date (12, 15, 2019);
        for (int i = 0; i < 100; i++){
            date.nextDay();
            System.out.println(date);
        }
    }
}
public class ConversionRate{
  private String currency1;
  private String currency2;
  private float value;
  
  public ConversionRate(String currency1, String currency2){
    this.currency1 = currency1;
    this.currency2 = currency2;
    this.value = -1;
  }  
  
  public ConversionRate(String currency1, String currency2, float value){
    this(currency1, currency2);
    this.value = value;
  }
  
  public String getCurrency1(){
    return currency1;
  }
  
  public String getCurrency2(){
    return currency2;
  }
  
  public float getValue(){
    return value;
  } 
}
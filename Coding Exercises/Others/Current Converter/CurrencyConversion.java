import java.util.*;

public class CurrencyConversion{
  public static void main (String[] args){
    ConversionRate[] conversionRates = new ConversionRate[2];
    conversionRates[0] = new ConversionRate("USD", "GBP", 2.0f);
    conversionRates[1] = new ConversionRate("GBP", "INR", 3.0f);
    
    ConversionRate[] queries = new ConversionRate[5];
    queries[0] = new ConversionRate("USD", "INR");
    queries[1] = new ConversionRate("GBP", "USD");
    queries[2] = new ConversionRate("USD", "CNY");
    queries[3] = new ConversionRate("USD", "USD");
    queries[4] = new ConversionRate("EUR", "EUR");
    
    float[] answers = findConversionRates(queries, conversionRates);
    
    for (int i = 0; i < answers.length; i++){
      System.out.print(answers[i] + " ");
    }
  }
  
  //find conversion rates of queries
  private static float[] findConversionRates(ConversionRate[] queries, ConversionRate[] conversionRates){
    float[] answers = new float[queries.length];
    HashMap<String, Integer> currencies = getCurrencies(conversionRates);
    
    for (int i = 0; i < queries.length; i++){ 
      String c1 = queries[i].getCurrency1(); //currency1
      String c2 = queries[i].getCurrency2(); //currency2    
      //if any of the currencies does not exists, set answer to -1
      if (!currencies.containsKey(c1) || !currencies.containsKey(c2)){
        answers[i] = -1;
      }
      //if the currencies are the same, set answer to 1
      else if (c1.equalsIgnoreCase(c2)){
        answers[i] = 1;
      }
      //if the currencies are different, look for any relationship, direct/indirect
      else{
        ArrayList<Integer> visited = new ArrayList<Integer>();
        visited.add(currencies.get(c1));
        float[][] conversionRatesTable = buildConversionRatesTable(conversionRates, currencies);
        answers[i] = findAnswer(currencies.get(c1), currencies.get(c2), 1, visited, conversionRatesTable);
      }            
    }
    
    return answers;
  }
  
  //recursively determines an answer given two currencies
  private static float findAnswer(int c1, int c2, float previousAnswer, ArrayList<Integer> visited, float[][] conversionTable){
    float answer = conversionTable[c1][c2];
    
    if (answer != -1)
      return answer * previousAnswer;
    else{
      ArrayList<Integer> visitedUpdate = new ArrayList<Integer>(visited);
      for (int i = 0; i < conversionTable[c1].length; i++){
         if (conversionTable[c1][i] != -1 && !visited.contains(i)){
           visitedUpdate.add(i);
           float temp = findAnswer(i, c2, previousAnswer * conversionTable[c1][i], visitedUpdate, conversionTable);
           if (temp != -1)
             return temp;
         }
      }
      return -1;
    }
  }
  
  //Retrieves the list of currencies and map them to a unique integer
  private static HashMap<String, Integer> getCurrencies(ConversionRate[] conversionRates){
    HashMap<String, Integer> result = new HashMap<String, Integer>();
    int i = 0;
    int j = 0;
    
    while (i < conversionRates.length){
      String c1 = conversionRates[i].getCurrency1();
      String c2 = conversionRates[i].getCurrency2();
      if (!result.containsKey(c1)){
        result.put(c1, j++);
      }
      if (!result.containsKey(c2)){
        result.put(c2, j++);
      }
      i++;
    }
    return result;
  }
  
  //build a 2-D array containing the conversion rate between every pair of currencies
  private static float[][] buildConversionRatesTable(ConversionRate[] conversionRates, HashMap<String, Integer> currencies){    
    //build conversion rate table
    float[][] result = new float[currencies.size()][currencies.size()];
    
    for (int i = 0; i < result.length; i++){
      for (int j = 0; j < result[i].length; j++){
        if (i==j)
          result[i][j] = 1;
        else
          result[i][j] = -1;
      }
    }
    
    for (int i = 0; i < conversionRates.length; i++){
      int c1 = currencies.get(conversionRates[i].getCurrency1());
      int c2 = currencies.get(conversionRates[i].getCurrency2());
      result[c1][c2] = conversionRates[i].getValue();
      result[c2][c1] = 1/conversionRates[i].getValue();
    }
    
    return result;
  }
}
//Tortoise.java
//Represents a tortoise

public class Tortoise{
    private int position;
    
    //constructor
    public Tortoise (int iPosition){
        position = iPosition;
    }
    
    //position accessor
    public int getPosition(){
        return position;
    }
    
    //position mutator
    public void setPosition(int newPosition){
        position = newPosition;
    }
    
    //equals
    public boolean equals (Object obj){
        if (!(obj instanceof Tortoise))
            return false;
        else{
            Tortoise t = (Tortoise) obj;
            if (t.getPosition() != position)
                return false;
        }
        return true;
    }
    
    //toString
    public String toString(){
        //return String.format("T:%d", position);
        return "T";
    }
    
    //modifies the tortoise's position
    public void move (int n){
            
        if (n >= 1 && n <= 10){
           if (n <= 5){
               this.position += 3;
           }
           else if (n <= 7){
               int newPosition = this.position - 6;
               this.position = (newPosition < 1) ? 1 : newPosition;
           }
           else{
               this.position += 1;
           } 
        }
        else{
            System.out.printf("\"%d\" is not a valid parameter to move the tortoise. ", n);
        }
    }
}
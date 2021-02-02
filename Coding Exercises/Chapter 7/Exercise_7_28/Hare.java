//Hare.java
public class Hare{
    private int position;
    
    //constructor
    public Hare (int iPosition){
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
        if (!(obj instanceof Hare))
            return false;
        else{
            Hare h = (Hare) obj;
            if (h.getPosition() != position)
                return false;
        }
        return true;
    }
    
    //toString
    public String toString(){
        //return String.format("H:%d", position);
        return "H";
    }
    
    //move
    public void move (int n){
        if (n >= 1 && n <= 10){
            if (n <= 2){
            }
            else if (n <= 4){
                this.position += 9;
            }
            else if (n == 5){
                int newPosition = this.position - 12;
                this.position = (newPosition < 1) ? 1 : newPosition;
            }
            else if (n <= 8){
                this.position += 1;
            }
            else{
                int newPosition = this.position - 2;
                this.position = (newPosition < 1) ? 1 : newPosition;
            }
        }
        else{
            System.out.printf("\"%d\" is not a valid parameter to move the hare. ", n);
        }
    }
}
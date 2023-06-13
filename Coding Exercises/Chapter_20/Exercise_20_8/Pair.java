package Exercise_20_8;

public class Pair <F, S> {
    private F firstElement;
    private S secondElement;

    public Pair(F firstElement, S secondElement){
        this.firstElement = firstElement;
        this.secondElement = secondElement;
    }

    public F getFirstElement(){
        return firstElement;
    }

    public S getSecondElement(){
        return secondElement;
    }
}

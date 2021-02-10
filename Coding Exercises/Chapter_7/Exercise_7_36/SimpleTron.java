//import java.util.Arrays;
import java.util.Scanner;

//a simpletron
public class SimpleTron{
    private int accumulator;
    private String [] memory;
    private Scanner scan = new Scanner(System.in);
    
    //constructor
    public SimpleTron(){
        memory = new String [100];        
    }    
    
    //Loads a program into memory
    public void load (String [] program){            
        System.arraycopy(program, 0, memory, 0, program.length);
    }
    
    //runs the loaded program
    public void run (){
        boolean haltFlag = true;
        for (int i = 0; i < memory.length && haltFlag == true; i++){
            haltFlag = execute(memory[i]);
        }
    }
    
    //execute a program line
    private boolean execute (String input){
    
        int instr = Integer.parseInt(input);
        if (instr < 0)
            return true;
        else{
            int opcode = Integer.parseInt(input.substring(0,2));
            int operand = Integer.parseInt(input.substring(2,4));
            switch (opcode){
                case 10:
                    System.out.print("Enter an integer > ");
                    memory[operand] = scan.nextInt();
                    break;
            }
        }
        
        return false;
    }
}
//Simpletron Simulator

import java.util.Scanner;
import java.util.InputMismatchException;

public class SimpletronSimulator{
    //field
    private static int [] memory = new int [1000];
    private static Scanner scan = new Scanner (System.in);
    
    private static int accumulator = 0;
    private static int instructionCounter = 0;
    private static int operationCode = 0;
    private static int operand = 0;
    private static int instructionRegister = 0;
    
    private static final int MIN = -9999;
    private static final int MAX = 9999;    
    
    //main
    /*
     * Test Cases
     * 1007 1008 2007 3008 2109 1109 4300 0 0 0 -9999 (adds two numbers)
     * 1007 1008 2008 3407 2109 1109 4300 0 0 0 -9999 (performs the remainder a%b)
     * 1007 1008 2008 3507 2109 1109 4300 0 0 0 -9999 (performs the remainder of a power b)
     * 1009 1010 2009 3110 4107 1109 4300 1110 4300 0 0 -9999 (determines the larger of two numbers)
     * 1013 2013 4100 2014 3013 2114 2015 3116 2115 4211 4000 1114 4300 0000 0000 0010 0001 -9999 (reads 10 positive numbers and display their sum)
     * 1014 2015 3014 2115 2016 3117 2116 4209 4000 2018 3215 2115 1115 4300 0000 0000 0007 0001 0007 -9999 (reads 7 numbers -positive or negative- and compute their average)
     * 1019 2019 4216 1017 2019 3120 2119 4215 1018 2018 3117 4104 2018 2117 4004 1117 4300 0000 0000 0000 0001 -9999 (reads a specified number and determines the largest)
     
     * 1007 1008 2007 3008 2109 1109 4300 0 0 0 -9999 (adds two numbers)
     * 1007 1008 2008 3407 2109 1109 4300 0 0 0 -9999 (performs the remainder a%b)
     * 1007 1008 2008 3507 2109 1109 4300 0 0 0 -9999 (performs the remainder of a power b)
     * 1009 1010 2009 3110 4107 1109 4300 1110 4300 0 0 -9999 (determines the larger of two numbers)
     * 1013 2013 4100 2014 3013 2114 2015 3116 2115 4211 4000 1114 4300 0000 0000 0010 0001 -9999 (reads 10 positive numbers and display their sum)
     * 1014 2015 3014 2115 2016 3117 2116 4209 4000 2018 3215 2115 1115 4300 0000 0000 0007 0001 0007 -9999 (reads 7 numbers -positive or negative- and compute their average)
     * 1019 2019 4216 1017 2019 3120 2119 4215 1018 2018 3117 4104 2018 2117 4004 1117 4300 0000 0000 0000 0001 -9999 (reads a specified number and determines the largest)
     */
    public static void main (String [] args){
        displayWelcomeMessage();
        readSMLProgram();
        executeSMLProgram();
        displayComputerDump();              
    }   
    
    //Displays the welcome message
    private static void displayWelcomeMessage(){
        String line1 = "*** Welcome To Simpletron! ***\n";
        String line2 = "Please enter your program one instruction";
        String line3 = "(or data word) at a time. I will display";
        String line4 = "the location number and a question mark (?).";
        String line5 = "You then type the word for that location.";
        String line6 = String.format("Type -%d to stop entering your program.", MIN);
        String [] messageLines = {line2, line3, line4, line5, line6};
        
        String welcomeMessage = line1;
        
        for (String line: messageLines){
             welcomeMessage += String.format("*** %-45s***\n", line);
        }
              
        System.out.println(welcomeMessage);
    }
    
    //reads the SML program entered the user
    private static void readSMLProgram(){
        int input = 0;
        int memoryIndex = 0;
        int sentinel = MIN;
        
        do{
           System.out.printf("%02d ? ", memoryIndex);
           input = scan.nextInt();
           
           if (input >= MIN && input <= MAX){
              memory[memoryIndex] = input;
              memoryIndex++;
           }  
           else{
               System.out.println(String.format("Error! Please enter a number between %d (incluse) and %d (inclusive)", MIN, MAX));
           }       
        }while (input != sentinel && memoryIndex < memory.length);
                
        System.out.println("*** Program loading completed ***");
        System.out.println();
    }
    
    //executes the SML program
    private static void executeSMLProgram(){
        System.out.println("*** Program execution begins  ***");
        
        final int READ = 10; //A
        final int WRITE = 11; //B
        final int LOAD = 20; //14 #10
        final int STORE = 21; //15 #11
        final int ADD = 30; //1E #20
        final int SUBTRACT = 31; //1F #21
        final int DIVIDE = 32; //20 #22
        final int MULTIPLY = 33; //21 #23
        final int REMAINDER = 34; // 22 #24 //computes the remainder of the division of a word from a specific location in memory into the word in the accumulator
        final int EXPONENT = 35;  // 23 #25 //raises a word from a specific location in memory to the power of the word in the accumulator
        final int BRANCH = 40; //28 #30
        final int BRANCHNEG = 41; //29 #31
        final int BRANCHZERO = 42; //2A #32
        final int HALT = 43; //2B #33
        final int NEWLINE = 50; //new line
        
        while (instructionRegister != 4300){
            instructionRegister = memory[instructionCounter];
            operationCode = instructionRegister/100;
            operand = instructionRegister % 100;
            
            switch (operationCode){
                 case READ:
                     System.out.print("Enter an integer > ");
                     do{
                        memory[operand] = scan.nextInt();
                        if(memory[operand] < MIN || memory[operand] > MAX){
                            System.out.printf(String.format("Error! Please enter an integer between %d (incluse) and %d (inclusive) > ", MIN, MAX));
                        } 
                     }while (memory[operand] < MIN || memory[operand] > MAX);
                     instructionCounter++;
                     break;
                 case WRITE:
                     System.out.println(memory[operand]);
                     instructionCounter++;
                     break;
                 case LOAD:
                     accumulator = memory[operand];
                     instructionCounter++;
                     break;
                 case STORE:
                     memory[operand] = accumulator;
                     instructionCounter++;
                     break;
                 case ADD:
                     accumulator += memory[operand];
                     handleAccOverflow();
                     break;
                 case SUBTRACT:
                     accumulator -= memory[operand];
                     handleAccOverflow();
                     break;
                 case DIVIDE:
                     if (accumulator == 0){
                         stopExecution("Attempt to divide by zero");
                     }
                     else{
                         accumulator = memory[operand] / accumulator;
                         handleAccOverflow();
                     }                     
                     break;
                 case MULTIPLY:
                     accumulator *= memory[operand];
                     handleAccOverflow();
                     break;
                 case REMAINDER:
                     accumulator = memory[operand] % accumulator;
                     handleAccOverflow();
                     break;
                 case EXPONENT:
                     accumulator = (int) Math.pow(memory[operand], accumulator);
                     handleAccOverflow();
                     break;
                 case BRANCH:
                     instructionCounter = operand;
                     break;
                 case BRANCHNEG:
                     if (accumulator < 0){
                         instructionCounter = operand;
                     }
                     else
                        instructionCounter++;
                     break;
                 case BRANCHZERO:
                     if (accumulator == 0){
                         instructionCounter = operand;
                     }
                     else
                        instructionCounter++;
                     break; 
                 case HALT:
                     instructionRegister = 4300;
                     break;
                 case NEWLINE:
                     System.out.println();
                     break;
                 default:
                     stopExecution("Invalid operation code");
                     break;
             }
        }   
        
        System.out.println("\n*** Simpletron execution terminated ***");
    }
    
    //displays an error message and stop the program
    private static void stopExecution(String msg){
        System.out.printf("*** %s ***\n", msg);
        System.out.println("*** Simpletron execution abnormally terminated ***");
        instructionRegister = 4300;
    }
    
    //handles accumulator overflow
    private static void handleAccOverflow(){
        if (accumulator < MIN || accumulator > MAX){
            stopExecution("Accumulator Overflow");
        }
        else{
            instructionCounter++;
        }
    }
    
    // Displays the computer dump
    private static void displayComputerDump(){
        System.out.println("REGISTERS:");
        System.out.printf("%-20s %+05d\n", "accumulator", accumulator);
        System.out.printf("%-23s %02d\n", "instructionCounter", instructionCounter);
        System.out.printf("%-20s %+05d\n", "instructionRegister", instructionRegister);
        System.out.printf("%-23s %02d\n", "operationCode", operationCode);
        System.out.printf("%-23s %02d\n", "operand", operand); 
        System.out.println();
        System.out.println("MEMORY:");
        System.out.printf("%3s","");
        
        int rows = 100;
        int cols = 10;
        
        for (int i = 0; i < cols; i++){
            System.out.printf("%6d", i);
        }
        System.out.println();
        for (int i = 0; i < rows; i++){
            System.out.printf("%3d ", i*cols);
            for (int j = 0; j < cols; j++){
                System.out.printf("%+05d ", memory[i*cols + j]);
            }
            System.out.println();
        }
    }
}
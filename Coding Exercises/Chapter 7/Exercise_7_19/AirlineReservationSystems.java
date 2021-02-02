import java.util.Scanner;
import java.util.InputMismatchException;
/*
 * AirlineReservationSystems.java by Vannel 9/16/2018
 * Assign seats on each flight of the airline's only plane
 */

public class AirlineReservationSystems{
    private static int fcCurrentSeat = 0;
	private static int econCurrentSeat = 5;
	private static boolean [] flight = new boolean [10];
	private static Scanner input = new Scanner (System.in);

    public static void main (String [] args){
	   int choice;	
	   displayMenu();
		choice = inputChoice();
		
		while (choice != 3){
		    switch (choice){
			    case 1: 
				    processFirstClassRequest();
					break;
				case 2:
				    processEconomyRequest();
					break;
				default:
				    System.out.println("Invalid choice entered!");
					break;
			}
		    displayMenu();
		    choice = inputChoice();
		}
		
		System.out.println("\nHave a good one. Bye!\n");
		
	} //end main method
	
	//displayMenu method
	private static void displayMenu(){
	    System.out.println("\nReservation options:");
		System.out.println("1- First Class");
		System.out.println("2- Economy");
		System.out.println("3- Stop");
		System.out.print("Please make a choice by typing 1 or 2 or 3 > ");
	}// end displayMenu method
	
	//inputChoice method
	private static int inputChoice(){
		int choice = 0;

		do{
			choice = input.nextInt();			
			if (choice != 1 && choice != 2 && choice != 3){
			    System.out.print("Error! Please enter 1,2 or 3 to make a selection > ");
			}
        } while (choice != 1 && choice != 2 && choice != 3);
        return choice;		
	} //end inputChoice method
	
	//processFirstClassRequest method
	private static void processFirstClassRequest(){		 
		 if (fcCurrentSeat != 5){
		     flight[fcCurrentSeat] = true;
			 showBoardingPass(1, fcCurrentSeat);
			 fcCurrentSeat++;
		 }
		 else{
		    int econAvSeat = econAvailableSeat();
			String switchAnswer = "";
			if (econAvSeat != -1){
			    do{
					System.out.printf("\nSorry, first class is full! Would you like to travel in economy? (y/n) > ");
					switchAnswer = input.next();
				} while (!switchAnswer.equalsIgnoreCase("y") && !switchAnswer.equalsIgnoreCase("n"));
			}
			if (switchAnswer.equalsIgnoreCase("y")){
			    processEconomyRequest();
			}
			else if (switchAnswer.equalsIgnoreCase("n")){
			    System.out.println("\nNext flight leaves in 3 hours\n");
			}
			else{
			    System.out.println("\nSorry, flight is full. Next flight leaves in 3 hours.\n");
			}
		 }
	} //end proceessFirstClassRequest
	
	//processEconomyRequest method
	private static void processEconomyRequest(){	
	    if (econCurrentSeat != 10){
		     flight[econCurrentSeat] = true;
			 showBoardingPass(2, econCurrentSeat);
			 econCurrentSeat++;
		 }
		 else{
		    int fcAvSeat = fcAvailableSeat();
			String switchAnswer = "";
			if (fcAvSeat != -1){
			    do{
					System.out.printf("\nSorry, economy section is full! Would you like to travel in first class? (y/n) > ");
					switchAnswer = input.next();
				} while (!switchAnswer.equalsIgnoreCase("y") && !switchAnswer.equalsIgnoreCase("n"));
			}
			if (switchAnswer.equalsIgnoreCase("y")){
			    processFirstClassRequest();
			}
			else if (switchAnswer.equalsIgnoreCase("n")){
			    System.out.println("\nNext flight leaves in 3 hours\n");
			}
			else{
			    System.out.println("\nSorry, flight is full. Next flight leaves in 3 hours.\n");
			}
		 }
	}
	
	//fcAvailability method
	private static int fcAvailableSeat(){
	    for (int i = 0; i < 5; i++){
		    if (flight[i] == false)
			    return i;
		}
		return -1;
	} //end fcAvailability
	
	//econAvailability method
	private static int econAvailableSeat(){
	    for (int i = 5; i < 10; i++){
		    if (flight[i] == false)
			    return i;
		}
		return -1;
	} //end econAvailability
	
	private static void showBoardingPass(int section, int seatNumber){
	    switch (section){
		    case 1:
			    System.out.printf("\n_____ Boarding Pass ______\n");
				System.out.println("Section: First Class");
				System.out.printf("Seat number: %d\n", seatNumber+1);				
				System.out.println("Thank you for travelling with us. Have a great journey!\n");
			    break;
			case 2:
			    System.out.printf("\n_____ Boarding Pass ______\n");
				System.out.println("Section: Economy");
				System.out.printf("Seat number: %d\n", seatNumber+1);				
				System.out.println("Thank you for travelling with us. Have a great journey!\n");
			    break;
		}
	}
	
} //end class
/* 
    Show menu selection
	if first class is selected
	    process first class request
	else if economy is selected
	    process economy request
	else if sentinel (3) is entered
	    stop the program
	else
	    ask to repeat the selection
		
		
	Test cases
	1- book first class
	2- book economy
	3- book first class till full
	4- book economy till full
	5- book first class when ecomy is full
	6- book economy when first class is full
	7- book first class when flight is full
	8- book economy when flight is full
	9- deny economy when first class is full and then book economy
	10- deny first class when enomy is full and then book first class
*/
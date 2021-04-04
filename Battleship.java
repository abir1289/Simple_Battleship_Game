//-------------------------------------------------------------------------
// Assignment 4
// Written by: Imran Ahmed 40172931 
// For COMP 248 Section EC - Fall 2020
//-------------------------------------------------------------------------

/* This program will simulate a game of Battleship between the user and the computer. Initially , each player has 
6 ships and 4 grenades. The ships and grenades are placed in a 8 x 8 grid and are hidden from both players. 
Then each player will have the chance to hit one of the position of the grid. If player A hits player B's ship , 
then player B will lose a ship and vice-versa.If player A hits player B's grenade , then player A will lose a turn and player B 
will play twice in a row and vice-versa. Ships and grenades can only be hit once. The goal of the game is to sink all ships 
of the opponent before the he/she does.
*/ 
// Date: 12/06/2020

import java.util.Scanner;

public class Battleship {

	public static void main(String[] args) {
		
		//Hi welcome to my program
		
		//Welcome message
		System.out.println("Welcome to Battleship");
		
		//Declaring the scanner
		Scanner keyIn = new Scanner(System.in);
		
		//Creating a object called "game1" of the class Battleshipgame
		Battleshipgame game1 = new Battleshipgame();
		
		
		//Declaring a variable of object 2-DArray with name "gamegrid" of type char and initializing to 9 and 9
		char [][] gamegrid = new char[9][9];
		
		
		//Assigning '_' to each index of the 2-D array "gamegrid" 
		for (int i = 1 ; i < gamegrid.length ; i++) 
		{
			for (int j = 1 ; j < gamegrid[1].length  ; j++)
			{
				gamegrid[i][j] = '_';
			}
				
		}
		
		
		//Prompt user to enter coordinate of ships and check its validity (correct range and not called before) 
		for (int i = 1 ; i < 7 ; i++) {
			System.out.print("Enter the coordinates of your ship#" +i +": ");
			String coordinate = keyIn.next();
			coordinate = coordinate.toUpperCase();
			char firstcharcther1 = game1.getfirstcharacther(coordinate);
			int firstcharacther1number = game1.getShipletter(firstcharcther1);
			int firstcharactherascii = game1.getfirstcharachterascii(firstcharcther1);
			int secondcharacther2 = game1.getsecondcharacther(coordinate);
			
			while( game1.checkcoordinate(firstcharactherascii, secondcharacther2)) {
				System.out.println("Coordinate is out of range. Try again");
				System.out.print("Enter the coordinates of your ship#" +i +": ");
				coordinate = keyIn.next();
				coordinate = coordinate.toUpperCase();
				firstcharcther1 = game1.getfirstcharacther(coordinate);
				firstcharacther1number = game1.getShipletter(firstcharcther1);
				firstcharactherascii = game1.getfirstcharachterascii(firstcharcther1);
				secondcharacther2 = game1.getsecondcharacther(coordinate);
			}
			
			while( gamegrid[secondcharacther2][firstcharacther1number] != '_') {
				System.out.println("Coordinate is already used try again : ");
				System.out.print("Enter the coordinates of your ship#" +i +": ");
				coordinate = keyIn.next();
				coordinate = coordinate.toUpperCase();
				firstcharcther1 = game1.getfirstcharacther(coordinate);
				firstcharacther1number = game1.getShipletter(firstcharcther1);
				firstcharactherascii = game1.getfirstcharachterascii(firstcharcther1);
				secondcharacther2 = game1.getsecondcharacther(coordinate);
			 }
			 
			 gamegrid[secondcharacther2][firstcharacther1number] = 's';	
			}
				
			
		//Prompt user to enter coordinate of grenades and check validity (correct range and not called before)
		int i;
		for (i = 1 ; i < 5 ;i++) {
			System.out.print("Enter the coordinates of your grenade#" +(i) +":");
			String grenade = keyIn.next();
			grenade = grenade.toUpperCase();
			char firstcharachterofgrenade = game1.getfirstcharactherofgrenade(grenade);
			int firstcharachterofgrenadeascii = game1.getfirstcharachterascii(firstcharachterofgrenade);
			int secondcharactherofgrenade = game1.getsecondcharactherofgrenade(grenade);
			int firstcharachterofgreandenumber = game1.getGrenadeletter(firstcharachterofgrenade);
			
			 while( game1.checkcoordinate(firstcharachterofgrenadeascii, secondcharactherofgrenade)) {
				System.out.println("Coordinate is out of range. Try again : ");
				grenade = keyIn.next();
				firstcharachterofgrenade = game1.getfirstcharactherofgrenade(grenade);
				firstcharachterofgrenadeascii = game1.getfirstcharachterascii(firstcharachterofgrenade);
				secondcharactherofgrenade = game1.getsecondcharactherofgrenade(grenade);
				firstcharachterofgreandenumber = game1.getGrenadeletter(firstcharachterofgrenade);
				
			}
			
			while((gamegrid[secondcharactherofgrenade][firstcharachterofgreandenumber] == 's') || (gamegrid[secondcharactherofgrenade][firstcharachterofgreandenumber] != '_')){
				System.out.println("Coordinate is already used try again : ");
				System.out.print("Enter the coordinates of your grenade#" +(i) +": ");
				grenade = keyIn.next();
				grenade = grenade.toUpperCase();
				firstcharachterofgrenade = game1.getfirstcharactherofgrenade(grenade);
				firstcharachterofgrenadeascii = game1.getfirstcharachterascii(firstcharachterofgrenade);
				secondcharactherofgrenade = game1.getsecondcharactherofgrenade(grenade);
				firstcharachterofgreandenumber = game1.getGrenadeletter(firstcharachterofgrenade);
			 }	
			gamegrid[secondcharactherofgrenade][firstcharachterofgreandenumber] = 'g';
			
		}
		
		
		//Displaying the message that computer has placed its ships and grenades
		System.out.println("OK , the computer placed its ships and grenades at random . Let's play");
		
		
		//Computer input position for ships.
		for (i = 1 ; i < 7 ; i++) {
			int first_coordinate_of_cpu = game1.generaterandomcoordinateforfirst();
			int second_coordinate_of_cpu = game1.generaterandomcoordinateforsecond();
			
		
			while (gamegrid[second_coordinate_of_cpu][first_coordinate_of_cpu ] != '_' || gamegrid[second_coordinate_of_cpu][first_coordinate_of_cpu] == 's' || gamegrid[second_coordinate_of_cpu][first_coordinate_of_cpu] == 'g'){
			first_coordinate_of_cpu = game1.generaterandomcoordinateforfirst();
			second_coordinate_of_cpu = game1.generaterandomcoordinateforsecond();
			}
			gamegrid[second_coordinate_of_cpu][first_coordinate_of_cpu ] = 'S';
		}
		
		//Computer input position for grenades.
		for (i = 1 ; i < 5 ; i++) {
			int first_coordinate_of_cpuforgrenade = game1.generaterandomcoordinateforfirst();
			int second_coordinate_of_cpuforgrenade = game1.generaterandomcoordinateforsecond();
			
			while (gamegrid[second_coordinate_of_cpuforgrenade ][first_coordinate_of_cpuforgrenade] != '_' || gamegrid[second_coordinate_of_cpuforgrenade][first_coordinate_of_cpuforgrenade] == 's' || gamegrid[second_coordinate_of_cpuforgrenade][first_coordinate_of_cpuforgrenade] == 'S' || gamegrid[second_coordinate_of_cpuforgrenade][first_coordinate_of_cpuforgrenade] == 'g'  ) {
				first_coordinate_of_cpuforgrenade = game1.generaterandomcoordinateforfirst();
				second_coordinate_of_cpuforgrenade = game1.generaterandomcoordinateforsecond();
			}
			
			gamegrid[second_coordinate_of_cpuforgrenade][first_coordinate_of_cpuforgrenade] = 'G';
			}
		
		
		
		//Declaring a variable of object 2-D array and naming it "emptygrid"
		char[][] emptygamegrid;
				
		//Assigning content of 2-D array "gamegrid" into the 2-D array "emptygamegrid"
		emptygamegrid = copyarray(gamegrid);
		
		//Displaying the 2-D array named "emptygrid" into the console 
		for (i = 1 ; i < emptygamegrid.length ; i++) 
		{
			for (int j = 1 ; j < emptygamegrid[1].length  ; j++)
			{
				emptygamegrid [i][j] = '_';
				System.out.print(emptygamegrid[i][j] + " ");
			}
			System.out.println();
		}
		
		
		//Declaring variables with names "nbOfships" , "nbOfgrenade" , "nbOfshipscpu" , "nbOfgrenadescpu" , "playerturns" , "cputurns" and 
		//assigning it to 6, 4, 6, 4 , 0 and 0 respectively,
		int nbOfships = 6;
		int nbOfgrenade = 4;
		int nbOfshipscpu = 6;
		int nbOfgrenadecpu = 4;
		int playerturns = 0;
		int cputurns = 0;
		
		
		//While loop to keep the game going until winner is declared
		while (nbOfships != 0 && nbOfshipscpu != 0) {
			
			
			//do while loop to check if user has extra turn or not 
			do
			{
			if (playerturns > 0) {
				playerturns--;
			}
			else if (playerturns == 0) {
				playerturns = 0;
			}
			
			//Prompt user to input coordinate of rocket and check its validity (correct range)
			System.out.print("Position of your rocket : ");
			String rocket = keyIn.next();
			rocket = rocket.toUpperCase();
			char firstcharctherofrocket = game1.getfirstcharacther(rocket);
			int firstcharacther1numberofrocket = game1.getRocketletter(firstcharctherofrocket);
			int firstcharactherasciiofrocket = game1.getfirstcharachterascii(firstcharctherofrocket);
			int secondcharacther2ofrocket = game1.getsecondcharacther(rocket);
			
			while(game1.checkcoordinate(firstcharactherasciiofrocket, secondcharacther2ofrocket)) {
				System.out.println("Coordinate is out of range. Try again : ");
				rocket = keyIn.next();
				rocket = rocket.toUpperCase();
				firstcharctherofrocket = game1.getfirstcharacther(rocket);
				firstcharacther1numberofrocket = game1.getRocketletter(firstcharctherofrocket);
				firstcharactherasciiofrocket = game1.getfirstcharachterascii(firstcharctherofrocket);
				secondcharacther2ofrocket = game1.getsecondcharacther(rocket);
			}
			
			//If statement to update the 2-D array emptygamegrid if position of rocket has already been called
			if(emptygamegrid[secondcharacther2ofrocket][firstcharacther1numberofrocket] == 'S' || emptygamegrid[secondcharacther2ofrocket][firstcharacther1numberofrocket] == 'G' || emptygamegrid[secondcharacther2ofrocket][firstcharacther1numberofrocket] == '*' || emptygamegrid[secondcharacther2ofrocket][firstcharacther1numberofrocket] == 'g' || emptygamegrid[secondcharacther2ofrocket][firstcharacther1numberofrocket] == 's' ) {
				System.out.println("Position already called");
				for (i = 1 ; i < emptygamegrid.length ; i++) 
				{
					for (int j = 1 ; j < emptygamegrid[1].length  ; j++)
					{
						if (emptygamegrid[i][j] == '*') {
							emptygamegrid[i][j] = '*';
						}
						else if (emptygamegrid[i][j] == 'G')
						{
						emptygamegrid[i][j] = 'G';
						}	
						else if (emptygamegrid[i][j] == 'S')
						{
						emptygamegrid[i][j] = 'S';	
						}
						else if (emptygamegrid[i][j] == 's') {
							emptygamegrid[i][j] ='s';
						}
						else if (emptygamegrid[i][j] == 'g') {
							emptygamegrid[i][j] = 'g';
						}
						else 
						{
							emptygamegrid[i][j] ='_';
						}
						System.out.print(emptygamegrid[i][j] + " ");
							
					}
					System.out.println();	
				}
				
			}
			
			//Else if statement to update emptygamegrid if player's rocket hits cpu's ship
			else if (gamegrid[secondcharacther2ofrocket][firstcharacther1numberofrocket] == 'S') {
				nbOfshipscpu = nbOfshipscpu - 1;
				System.out.println("Ship hit");
				for (i = 1 ; i < emptygamegrid.length ; i++) 
				{
						for (int j = 1 ; j < emptygamegrid[1].length  ; j++)
						{
							if (emptygamegrid[i][j] == '*') 
							{
								emptygamegrid[i][j] = '*';
							}
							else if (emptygamegrid [i][j] == 'G')
							{
								emptygamegrid [i][j] = 'G';
							}
							else if (emptygamegrid[i][j] == 'S')
							{
								emptygamegrid[i][j] = 'S';
							}	
							else if (emptygamegrid[i][j] == 's') {
								emptygamegrid[i][j] ='s';
							}
							else if (emptygamegrid[i][j] == 'g') {
								emptygamegrid[i][j] = 'g';
							}
							else 
							{
								emptygamegrid[i][j] = '_';
							}
							emptygamegrid[secondcharacther2ofrocket][firstcharacther1numberofrocket] = 'S';
							System.out.print(emptygamegrid[i][j] + " ");
							
						}
						System.out.println();	
					}
			}
			
			//Else if statement to update emptygamegrid array if position of rocket hits cpu's grenade 
			else if (gamegrid[secondcharacther2ofrocket][firstcharacther1numberofrocket] == 'G') {
				nbOfgrenadecpu = nbOfgrenadecpu - 1;
				cputurns = cputurns + 2;
				
				System.out.println("Grenade hit");
				for (i = 1 ; i < emptygamegrid.length ; i++) 
				{
					for (int j = 1 ; j < emptygamegrid[1].length  ; j++)
					{
						if (emptygamegrid[i][j] == '*') 
						{
							emptygamegrid[i][j] = '*';
						}
						else if (emptygamegrid[i][j] == 'G')
						{
						emptygamegrid[i][j] = 'G';
						}	
						else if (emptygamegrid[i][j] == 'S')
						{
						emptygamegrid[i][j] = 'S';	
						}
						else if (emptygamegrid[i][j] == 's') {
							emptygamegrid[i][j] ='s';
						}
						else if (emptygamegrid[i][j] == 'g') {
							emptygamegrid[i][j] = 'g';
						}
						else
						{
							emptygamegrid[i][j] ='_';
						}
						emptygamegrid[secondcharacther2ofrocket][firstcharacther1numberofrocket] = 'G';
						System.out.print(emptygamegrid[i][j] + " ");
							
					}
					System.out.println();	
				}
				
			}
			
			//Else if statement to update gamegrid if player's rocket hits nothing 
			else if (gamegrid[secondcharacther2ofrocket][firstcharacther1numberofrocket] == '_') {
				System.out.println("Nothing");
				for (i = 1 ; i < emptygamegrid.length ; i++) 
				{
					for (int j = 1 ; j < emptygamegrid[1].length  ; j++)
					{
						if (emptygamegrid[i][j] == '*') {
							emptygamegrid[i][j] = '*';
						}
						else if (emptygamegrid[i][j] == 'G')
						{
						emptygamegrid[i][j] = 'G';
						}	
						else if (emptygamegrid[i][j] == 'S')
						{
						emptygamegrid[i][j] = 'S';	
						}
						else if (emptygamegrid[i][j] == 's') {
							emptygamegrid[i][j] ='s';
						}
						else if (emptygamegrid[i][j] == 'g') {
							emptygamegrid[i][j] = 'g';
						}
						else
						{
							emptygamegrid[i][j] ='_';
						}
						emptygamegrid[secondcharacther2ofrocket][firstcharacther1numberofrocket] = '*';
						System.out.print(emptygamegrid[i][j] + " ");
							
					}
					System.out.println();	
				}
			
			
			}
			
			} while(playerturns != 0);
			
			//Do while loop to check if computer has extra turn or not
			do
			{
			if (cputurns > 0) {
				cputurns--;
			}
			else if (cputurns == 0) {
				cputurns = 0;
			}
			
			//Random coordinate generated for cpu's rocket
			int firstcoordinaterocket = game1.generaterandomcoordinateforfirst();
			int secondcoordinaterocket = game1.generaterandomcoordinateforsecond();
			String firstcoordinaterocketletter = game1.getRocketlettercpu(firstcoordinaterocket);
			
			while (gamegrid[secondcoordinaterocket][firstcoordinaterocket] == 'S' || gamegrid[secondcoordinaterocket][firstcoordinaterocket] == 'G') {
				firstcoordinaterocket = game1.generaterandomcoordinateforfirst();
				secondcoordinaterocket = game1.generaterandomcoordinateforsecond();
				firstcoordinaterocketletter = game1.getRocketlettercpu(firstcoordinaterocket);
			}
			System.out.println("Position of my rocket :" +(firstcoordinaterocketletter)+(secondcoordinaterocket));
			
			
			//If statement to update emptygamegrid array if computer hits a position already called
			if(emptygamegrid[secondcoordinaterocket][firstcoordinaterocket] == 'S' || emptygamegrid[secondcoordinaterocket][firstcoordinaterocket] == 'G' || emptygamegrid[secondcoordinaterocket][firstcoordinaterocket] == '*' || emptygamegrid[secondcoordinaterocket][firstcoordinaterocket] == 'g' || emptygamegrid[secondcoordinaterocket][firstcoordinaterocket] == 's' ) {
				System.out.println("Position already called");
				for (i = 1 ; i < emptygamegrid.length ; i++) 
				{
					for (int j = 1 ; j < emptygamegrid[1].length  ; j++)
					{
						if (emptygamegrid[i][j] == '*') {
							emptygamegrid[i][j] = '*';
						}
						else if (emptygamegrid[i][j] == 'G')
						{
						emptygamegrid[i][j] = 'G';
						}	
						else if (emptygamegrid[i][j] == 'S')
						{
						emptygamegrid[i][j] = 'S';	
						}
						else if (emptygamegrid[i][j] == 's') {
							emptygamegrid[i][j] ='s';
						}
						else if (emptygamegrid[i][j] == 'g') {
							emptygamegrid[i][j] = 'g';
						}
						else 
						{
							emptygamegrid[i][j] ='_';
						}
						System.out.print(emptygamegrid[i][j] + " ");
							
					}
					System.out.println();	
				}
			}
			
			//Else if statement to update gamegrid if cpu's rocket hits nothing
			else if (gamegrid[secondcoordinaterocket][firstcoordinaterocket] == '_') {
				System.out.println("Nothing");
				for (i = 1 ; i < emptygamegrid.length ; i++) 
				{
					for (int j = 1 ; j < emptygamegrid[1].length  ; j++)
					{
						if (emptygamegrid[i][j] == '*') {
							emptygamegrid[i][j] = '*';
						}
						else if (emptygamegrid[i][j] == 'G')
						{
						emptygamegrid[i][j] = 'G';
						}	
						else if (emptygamegrid[i][j] == 'S')
						{
						emptygamegrid[i][j] = 'S';	
						}
						else if (emptygamegrid[i][j] == 's')
						{
							emptygamegrid[i][j] = 's';
						}
						else if (emptygamegrid[i][j] == 'g')
						{
							emptygamegrid[i][j] = 'g';
						}
						else
						{
							emptygamegrid[i][j] ='_';
						}
						emptygamegrid[secondcoordinaterocket][firstcoordinaterocket] = '*';
						System.out.print(emptygamegrid[i][j] + " ");
							
					}
					System.out.println();	
				}
			}
			
			//Else if statement to update "emptygamegrid" array if cpu's hits player's ship	
			else if (gamegrid[secondcoordinaterocket][firstcoordinaterocket] == 's' ) {
				nbOfships = nbOfships - 1;
				System.out.println("Ship hit");
				for (i = 1 ; i < emptygamegrid.length ; i++) 
				{
					for (int j = 1 ; j < emptygamegrid[1].length  ; j++)
					{
						if (emptygamegrid[i][j] == '*') 
							{
							emptygamegrid[i][j] = '*';
							}
						else if (emptygamegrid [i][j] == 'G')
							{
							emptygamegrid [i][j] = 'G';
							}
						else if (emptygamegrid[i][j] == 'S')
							{
								emptygamegrid[i][j] = 'S';
							}
						else if (emptygamegrid[i][j] == 's')
						{
							emptygamegrid[i][j] = 's';
						}
						else if (emptygamegrid[i][j] == 'g')
						{
							emptygamegrid[i][j] = 'g';
						}
						else 
							{
								emptygamegrid[i][j] = '_';
							}
						emptygamegrid[secondcoordinaterocket][firstcoordinaterocket] = 's';
						System.out.print(emptygamegrid[i][j] + " ");
							
						}
						System.out.println();	
				}
			}
			
				
			//Else if statement to update "emptygamegrid" array if cpu'rocket hits player's grenade	
			else if (gamegrid[secondcoordinaterocket][firstcoordinaterocket] == 'g') {
					nbOfgrenade = nbOfgrenade - 1;
					playerturns = playerturns + 2;
			
					System.out.println("Grenade hit");
					for (i = 1 ; i < emptygamegrid.length ; i++) 
					{
						for (int j = 1 ; j < emptygamegrid[1].length  ; j++)
						{
							if (emptygamegrid[i][j] == '*') 
							{
								emptygamegrid[i][j] = '*';
							}
							else if (emptygamegrid[i][j] == 'G')
							{
							emptygamegrid[i][j] = 'G';
							}	
							else if (emptygamegrid[i][j] == 'S')
							{
							emptygamegrid[i][j] = 'S';	
							}
							else if (emptygamegrid[i][j] == 's')
							{
								emptygamegrid[i][j] = 's';
							}
							else if (emptygamegrid[i][j] == 'g')
							{
								emptygamegrid[i][j] = 'g';
							}
							else
							{
								emptygamegrid[i][j] ='_';
							}
							emptygamegrid[secondcoordinaterocket][firstcoordinaterocket] = 'g';
							System.out.print(emptygamegrid[i][j] + " ");
								
						}
						System.out.println();	
					}
				}
				
			}while(cputurns != 0 );
			
		}
		
		//If-else statement to delcare the winner of the game
		if (nbOfships == 0) {
			System.out.println("You lost!");
		}
		else if (nbOfshipscpu == 0) {
			System.out.println("You won!");
		}
		       
		//Display the gamegrid with all ships and grenade visible of user and computer
		for (i = 1 ; i < gamegrid.length ; i++) 
		{
			for (int j = 1 ; j < gamegrid[1].length  ; j++)
			{
				if (gamegrid[i][j] == '*') 
				{
					gamegrid[i][j] = '*';
				}
				else if (gamegrid[i][j] == 'G')
				{
				gamegrid[i][j] = 'G';
				}	
				else if (gamegrid[i][j] == 'S')
				{
				gamegrid[i][j] = 'S';	
				}
				else if (gamegrid[i][j] == 's')
				{
					gamegrid[i][j] = 's';
				}
				else if (gamegrid[i][j] == 'g')
				{
					gamegrid[i][j] = 'g';
				}
				else
				{
					gamegrid[i][j] ='_';
				}
				System.out.print(gamegrid[i][j] + " ");
					
			}
			System.out.println();	
		}
		
		//Closing message
		System.out.println("Thanks for playing Battleship!");
		
		//Cleaning up
		keyIn.close();
		
	}//End of main()
			
			
		
	// Static method to create duplicate of an array 
	public static char[][] copyarray(char[][] theoriginal){
		char [][] thecopy = new char[theoriginal.length][theoriginal.length];
		for (int i = 0 ; i < theoriginal.length ; i++)
		{
			for (int j = 1 ; j < theoriginal[1].length ; j++)
				thecopy[i][j] = theoriginal[i][j];
			
		}
			return thecopy;
	}
	
	
	
	
}// End of class Battleship

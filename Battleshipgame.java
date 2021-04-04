//-------------------------------------------------------------------------
// Assignment 4
// Written by: Imran Ahmed 40172931 
// For COMP 248 Section EC - Fall 2020
//-------------------------------------------------------------------------

/*This program will simulate a game of Battleship between the user and the computer. Initially , each player have 
6 ships and 4 grenades. The ships and grenades are placed in a 8 x 8 grid and are hidden from both players. 
Then each player will have the chance to hit one of the position of the grid. If player A hits player B's ship , 
then player B will lose a ship and vice-versa.If player A hits player B's grenade , then player A will lose a turn and player B 
will play twice in a row and vice-versa. Ships and grenades can only be hit once. The goal of the game is to sink all ships 
of the opponent before the he/she does.
*/
// Date: 12/06/2020

import java.util.Scanner;

public class Battleshipgame {
		
		private String coordinate;
		private int ascii;
		private int firstletter;
		private int secondletter;
		private int num; 
		private char letter2;
		private int num2;
		private int nbOfships;
		private int max;
		private int min;
		private int first_letter_of_cpu;
		private int second_letter_of_cpu;
		
		//Method called "getfirstcharacther" that returns a characther. To get the first letter of the coordinate called by the user/cpu for ships
		public char getfirstcharacther(String somecoordinate) {
			char firstcharacther = somecoordinate.charAt(0);
			return firstcharacther;
		}
		
		//Method called "getfirstcharactherascii" that returns a integer. To get ascii for the first letter of the ship's position
		public int getfirstcharachterascii(char someletter) {
			int firstcharachterascii = (int) someletter;
			return firstcharachterascii;
		}
		
		//Method called "getsecondcharacther" that returns a integer. To get second character of the coordinate for ship
		public int getsecondcharacther(String somecoordinate) {
			String secondcharacther = somecoordinate.substring(1);
			int secondcharacther1 = Integer.parseInt(secondcharacther);
			return secondcharacther1;
		}
		
		//Method called "getfirstcharactherofgrenade" that returns a char. To get first letter of the coordiante called by the user/cpu for grenades
		public char getfirstcharactherofgrenade(String somecoordinate) {
			char firstcharactherofgrenade = somecoordinate.charAt(0);
			return firstcharactherofgrenade;
		}
		
		//Method called "getfirstcharactherasciiofgrenade" that returns a integer. To get ascii for the first letter of grenade's position
		public int getfirstcharactherasciiofgrenade(char someletter) {
			int firstcharactherasciiofgrenade = (int) someletter;
			return firstcharactherasciiofgrenade;
		}
		
		//Method called "getsecondcharactherofgrenade" that returns a integer. To get second character of the coordinate for grenade
		public int getsecondcharactherofgrenade(String somecoordinate) {
			String secondcharactherofgrenade = somecoordinate.substring(1);
			int secondcharactherofgrenade1 = Integer.parseInt(secondcharactherofgrenade);
			return secondcharactherofgrenade1;
		}
		
		
		//Method called "checkcoordinate" that returns a boolean value . To check if coordinate is in the correct range
		public boolean checkcoordinate(int asciioffirstcoordinate , int numberofsecondcoordinate) {
			if ((asciioffirstcoordinate < 65 || asciioffirstcoordinate > 72) || (numberofsecondcoordinate < 1 || numberofsecondcoordinate > 8 )) {
				return true;
			}
			else 
				return false;
		}
		
		
		//Method called "getShipletter" that returns a integer. To convert the letter of the ship's position of player/cpu into a number 
		public int getShipletter(char letter) {
			if (letter == 'A')
				return 1;
			else if (letter == 'B')
				return 2;
			else if (letter == 'C')
				return 3;
			else if (letter == 'D')
				return 4;
			else if (letter == 'E')
				return 5;
			else if (letter == 'F')
				return 6;
			else if (letter == 'G')
				return 7;
			else if (letter == 'H')
				return 8;
			else
				return 0;
		}
		
		//Method called "getGreandeletter" that returns a integer. To convert the letter of the grenade's position of player/cpu into a number
		public int getGrenadeletter(char letter) {
			if (letter == 'A')
				return 1;
			else if (letter == 'B')
				return 2;
			else if (letter == 'C')
				return 3;
			else if (letter == 'D')
				return 4;
			else if (letter == 'E')
				return 5;
			else if (letter == 'F')
				return 6;
			else if (letter == 'G')
				return 7;
			else if (letter == 'H')
				return 8;
			else
				return 0;
		}
			
		
		//Method called "getRocketletter" that returns a integer. To get coordinate for letter of the rocket
		public int getRocketletter(char letter) {
			if (letter == 'A')
				return 1;
			else if (letter == 'B')
				return 2;
			else if (letter == 'C')
				return 3;
			else if (letter == 'D')
				return 4;
			else if (letter == 'E')
				return 5;
			else if (letter == 'F')
				return 6;
			else if (letter == 'G')
				return 7;
			else if (letter == 'H')
				return 8;
			else
				return 0;
		}
		
		//Method called "getRocketlettercpu" that returns a String. To convert numerical coordinate to letter coordinate
		public String getRocketlettercpu(int coordinate) {
			if (coordinate == 1)
				return "A";
			else if (coordinate == 2)
				return "B";
			else if (coordinate == 3)
				return "C";
			else if (coordinate == 4)
				return "D";
			else if (coordinate == 5)
				return "E";
			else if (coordinate == 6)
				return "F";
			else if (coordinate == 7)
				return "G";
			else if (coordinate == 8)
				return "H";
			else 
				return "Error";
		}
		
		//Method called "generaterandomcoordinateforfirst" that returns a integer. To generate random coordinate for cpu's ships
		public int generaterandomcoordinateforfirst() {
			int max = 8;
			int min = 1;
			int first_letter_of_cpu = (int)(Math.random() * (max - min + 1) + min);
			return first_letter_of_cpu;
			
		}
		
		//Method called "generaterandomcoordinateforsecond" that returns a integer. To generate random coordinate for cpu's grenade
		public int generaterandomcoordinateforsecond() {
			int max1 = 8;
			int min1= 1;
			int second_letter_of_cpu = (int)(Math.random() * (max1 - min1 + 1) + min1);
			return second_letter_of_cpu;
			
		}
		
		//Method called "getfirst_random_coordinate_cpu" that returns a integer. To get first letter of the cpu's ship or grenade position
		public int getfirst_random_coordinate_cpu() {
			return first_letter_of_cpu;
		}

		//Method called "getsecond_random_coordinate_cpu" that returns a integer. To get second letter of the cpu's ship or grenade position
		public int getsecond_random_coordinate_cpu() {
			return second_letter_of_cpu;
		}
		
}// End of class Battleshipgame

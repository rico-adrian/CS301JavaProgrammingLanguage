import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;

/**
 * 		Program: polyProduct
 * 
 * 		Computes the product of first degree polynomials with integer coefficients
 *
 */
public class polyProductP1 {
	
	public static void main(String[] args) {
		
		//Arraylist that holds the polynomial product answer
		ArrayList<Integer> answer = new ArrayList<Integer>(100);
		
		//Opens the binomial file holding the binomial to be multiplied
		Scanner file = null;
		try {
			file = new Scanner(new FileInputStream("binomials.txt"));
		}
		
		//Prints out an error if the file is not in the same folder as the class
		catch (FileNotFoundException e){
			System.out.println("File is not found, please check if binomials file" +
						" is in correct folder.");
			System.exit(-1);
		}
		
		//Adds the first polynomial to the array answer to start the algorithm below 
		//and ignores the x
		String s = file.next();
		String [] parts= s.split("x");
		answer.add( 0,Integer.parseInt(parts[0]));
		if(file.next().equals("+")){
			//Bypassing the addition sign since we know 
			//the following value is positive
			answer.add(1, Integer.parseInt(file.next()));
		}
		else {
			//Ignoring the minus sign and then multiplying 
			//the value by -1 to make it negative
			answer.add(1,-1*Integer.parseInt(file.next()));
		}
		
		//While loop that will continue to run while there is another equation 
		//in the file to be read
		while( file.hasNextLine()){
			
			//Three temporary arrays for holding the product of the first new x value and
			//the previous polynomial product, the product of the second new value and the previous 
			//polynomial product, and the third for holding the new total product after adding the first
			//and the second.
			ArrayList<Integer> a1 = new ArrayList<Integer>();
			ArrayList<Integer> a2 = new ArrayList<Integer>();
			ArrayList<Integer> a3 = new ArrayList<Integer>();
			
			//Holds the new x value and the second value
			int temporaryX = 0;
			int temporaryNonX =0;
			
			//Retrieves next equation and places the x value into a temporary integer
			String r = file.next();
			String [] equation= r.split("x");
			temporaryX = Integer.parseInt(equation[0]);
			
			//If it is a plus sign, then the second value is stored
			if(file.next().equals("+")){
				temporaryNonX = Integer.parseInt(file.next());
			}
			
			//If it a minus sign, then value is multiplied by -1 and 
			//stored in order to be negative
			else{
				temporaryNonX= -1*Integer.parseInt(file.next());
			}
	
			//Multiplies current product answer with the first number on the polynomial
			//being read in
			for(int i= 0; i<answer.size(); i++){ 
				a1.add(temporaryX*answer.get(i));
			}
			a1.add(0);		//This adds zero to the back of the first temporary array
			
			a2.add(0);		//This adds zero to the start of the second temporary array
			
			//Multiplies current product answer with the second number on the polynomial
			//being read in
			for(int i = 0; i<answer.size();i++){
				a2.add(temporaryNonX * answer.get(i));
			}
			
			//Adds the two temporary arrays to get our new polynomial product so far 
			for(int i = 0; i<a2.size(); i++){
				a3.add(a1.get(i) + a2.get(i));
			}
			
			//Assigns the added temporary arrays to the answer array which holds the current
			//total polynomial product
			answer=a3;
		}
		
		//For loop that prints out the final product of all the given polynomials with the proper
		//sign
		for(int i = 0; i<answer.size();i++){
			if((answer.size()-(i+1)) > 1){
				if(answer.get(i)>=0)
					System.out.print(answer.get(i)+ "x^" + (answer.size()-(i+1)) + " + ");
				else{
					System.out.print(answer.get(i)+ "x^" + (answer.size()-(i+1)) + " ");
				}
			}
			else if((answer.size()-(i+1) == 1)){
				if(answer.get(i)>=0){
				System.out.print(answer.get(i)+ "x + " );
				}
				else{
				System.out.print(answer.get(i)+ "x " );
				}
			}
			else{
				System.out.print(answer.get(i));
			}
		}
	}
}

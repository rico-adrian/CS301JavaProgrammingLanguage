//import statements
import java.util.*;
import java.io.*;
import java.lang.*;


public class RecursiveLongInteger {
   public static void main (String[]args) {
      
      //try-catch block
      try {
         
         //LongInteger nonRecursive= new LongInteger();
         //read the file
         Scanner file = new Scanner(new File("integer.txt"));
         BufferedReader in = new BufferedReader(new FileReader("integer.txt"));
         
         
         //declare the variable
         long longNumber;
         int count=0; 
         String str;  //to read the file later
         int divisor; //the divisor
         //ask the user for input of divisor
         Scanner keyboard= new Scanner(System.in);
         System.out.println("What is the divisor?");
         System.out.println("Please enter a number 1-9");
         divisor=keyboard.nextInt();
         
         //ask for input again if the number is not 1-9
         while (divisor<1||divisor>9) {
            System.out.println("Please enter a number 1-9");
            divisor=keyboard.nextInt();
         }         

         
         
         while ((str = in.readLine())!=null) {
            //split the numbers in file and store them into an array of string
            String [] listOfInteger = str.split("");
             //set a temporary variable with a value of first digit on the file
            
            String remainders=listOfInteger[count];
            long longInteger=Integer.parseInt(listOfInteger[count]);
            System.out.print("The result in the form of integer is ");
            //if statement that print 0 if the long integer is smaller
            //than divisor and the number of digit in the file is only 1
            if(longInteger<divisor&&listOfInteger.length==1) {
               System.out.print(count);
            }
            
            //if statement for the case of long integer in the file is bigger or equal
            //to the divisor 
            if(longInteger>=divisor) {
               //the recursive method to get the value of the result of integer
               long resultInteger=recursionResult(longInteger,divisor,0);
               //the recursive method to get the value of the remainder
               long resultRemainder=recursionRemainder(longInteger,divisor);
               //convert the remainder value into a string to add it together later on
               remainders=String.valueOf(resultRemainder);
               //prints the result of the first digit of integer result
               System.out.print(resultInteger);
               //for loop to keep doing the recursive method based on the number of digit
               //in the file 
               for(int i=1;i<listOfInteger.length;i++) {
                   //add the remainder(variable remainders) to the second digit
                   //and convert them into integer, keep looping until the last digit
                   int addString= Integer.parseInt(remainders+listOfInteger[count+1]);
                   //add the value of addString into the recursion to get the remainder
                   //this is the recursive method  
                   long remainder=recursionRemainder(addString,divisor);
                   //save the longInteger value into remainders and add this remainder
                   //into the next digit, keep looping until the last digit
                   remainders=String.valueOf(remainder);
                   ////the recursive method to get the value of the result of integer
                   //and print the result
                   long integerValue=recursionResult(addString,divisor,0);
                   System.out.print(integerValue);
                   //iterate the count(for the list of digit)
                   count++;
                  
               }
            
            }
            
            //the case of first digit in the file is less than divisor
            else if(longInteger<divisor) {
               for(int k=1;k<listOfInteger.length;k++) {
                  //because the first digit in the file is less than divisor,
                  //go to the next digit immediately and add them together
                  int addString= Integer.parseInt(remainders+listOfInteger[count+1]);
                  //the rest are the same as the previous if statements
                  long integerValue=recursionResult(addString,divisor,0);
                  long remainder=recursionRemainder(addString,divisor);            
                  remainders=String.valueOf(remainder);
                  System.out.print(integerValue);
                  count++;
      
               }
            
               
              
            }
            
            //print the remainder
            System.out.println("");
            System.out.print("The remainder is ");
            System.out.println(remainders);
            
            
         }
            
         }
         
         
         //some catch block to catch exceptions
         catch (FileNotFoundException e) {
            System.out.println("file not found");
         
         }
         catch (NumberFormatException e) {
            System.out.println("It is not a number");
         
         }
         catch (IOException e) {
            System.out.println("The program is exploding");
         
         }
     
      }
        
       
   
   
                        
            
            
      
        
      
            

        
         
      
      

   
   
   
   //the recursive method to get the remainder
   public static long recursionRemainder ( long longNumber, int divisor) {
      //base case
      if (longNumber < divisor) {
         return longNumber;
      }
      else {
       //keep calling the recursive method until it satisfy the base case
         return recursionRemainder(longNumber-divisor,divisor);
      }

   }
   //the recursive method to get the result of the integer
   public static long recursionResult (long longNumber, int divisor,int count) {
      //base case
      if (longNumber< divisor) {
         return count;
      }
      else {
         //keep calling the recursive method until it satisfy the base case
         return recursionResult(longNumber-divisor,divisor,++count);
         
         
      } 

   

   }

}
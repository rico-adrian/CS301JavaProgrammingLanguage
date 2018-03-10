//import statements
import java.util.*;
import java.io.*;

public class LongInteger {
   public static void main (String[]args) {
      try {
      
      
         LongInteger nonRecursive= new LongInteger();
         //read the file
         Scanner file = new Scanner(new File("integer.txt"));
         BufferedReader in = new BufferedReader(new FileReader("integer.txt"));
         
         
         //declare the variable
         long longNumber;
         int counter=0;
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
               while(longInteger>=divisor) {
                     longInteger=longInteger-divisor;
   
                     counter++;
                     
               }
               remainders=String.valueOf(longInteger);
               
               System.out.print(counter);
               counter=0;
             for(int i=1;i<listOfInteger.length;i++) {
                   int addString= Integer.parseInt(remainders+listOfInteger[count+1]);
                   while(addString>=divisor) {
                     addString=addString-divisor;
                     counter++;
                     
                   }
                   System.out.print(counter);
                   counter=0;
                   remainders=String.valueOf(addString);
                   count++;
                  
               }
            
            }
            
            //the case of first digit in the file is less than divisor

            else if(longInteger<divisor) {
               for(int k=1;k<listOfInteger.length;k++) {
                  int addString=Integer.parseInt(remainders+listOfInteger[count+1]); 
                  while(addString>=divisor) {
                    addString=addString-divisor;
                     counter++;
                     
                   }                          
                  remainders=String.valueOf(addString);
                  System.out.print(counter);
                  counter=0;
                  count++;
      
               }
            
               
              
            }
             System.out.println("");
             System.out.println("The remainder is "+remainders);
   
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

}
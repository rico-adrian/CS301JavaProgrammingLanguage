import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.*;


public class Factor {
   public static void main (String [] args) {

   System.out.println(factor(819));



   }
   
  
   public static List<Integer> factor(int n) {
   ArrayList<Integer> factors = new ArrayList<Integer>(100);
   boolean done=false;


   int x = (int)Math.sqrt(n);
   double x2 = Math.sqrt((Math.pow(x,2))-n);
   
   if (x*x == n) {
      factors.add(x);
      
   } else {
      x=(int)Math.sqrt(n)+1;
      }
   
   while (true) {  
   if ((n+1)/2==x) {
         factors.add(n);
         factors.add(n/n);
         
      } else if (Math.sqrt((Math.pow(x,2))-n)==(int)Math.sqrt((Math.pow(x,2))-n)) { 
         
         factors.add((int)Math.sqrt((Math.pow(x,2))-n)+x);
         factors.add(n/((int)Math.sqrt((Math.pow(x,2))-n)+x));
         x++;
         }
        else {
         x++;
          }
    if (factors.contains(1)) {
    break;
    }   
          
   }
   
   
   return factors;
  
      
}

}
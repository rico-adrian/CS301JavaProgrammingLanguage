import java.util.*;


public class ArrayProgram {
   public static void main (String[] args) {
  
  Scanner keyboard=new Scanner(System.in);
  Random rand=new Random();
  int [] anArray =new int[3];
  anArray[0]=rand.nextInt(11);
  anArray[1]=rand.nextInt(11);
  anArray[2]=rand.nextInt(11);
  ArrayProcessor array=new ArrayProcessor();
  array.print3IntArray(anArray);
  array.sort3IntArray(anArray);
  array.reverse3IntArray(anArray);
  
}
  
  
  
  
 
  
  
}






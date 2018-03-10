import java.util.*;
public class    ArrayInsertion{  

//  capacity and size of the array 
private static final int  CAPACITY=100000;
private static int  curSize=0;

      public static void main (String[] argv){ 
    	 long startTime=System.nanoTime();
         int j;
         double val;

         //double []  darray = new double[CAPACITY];
         ArrayList<Double> darray=new ArrayList<Double>();
         Random r = new Random();

         int maxSize = CAPACITY ;  

           j = 0;
           while  ( j < maxSize) {
               val = r.nextDouble();

              // Bad: inserts at position 0
              //insert(darray, 0, val);
               darray.add(val);
              // Good: inserts at  end
              //darray.add(0,val); 
              //insert(darray,j,val);

              ++j;
              }

        System.out.println("The  array size is now: " + curSize); 
        //display(darray);
        
        long estimatedTime=System.nanoTime()-startTime;
        System.out.println("");
        System.out.println(estimatedTime);
	} 

   
// Displays the contiguous array, up to entry curSize-1
//     @param   a1   --array 
   private static void display(double [] a1) { 
     for( int i=0 ; i < curSize; ++i)
        System.out.print(a1[i]+" "); 

   }


// This procedure has a worstTime(n) = n , where n is the current size. 
// The averageTime(n) is also O(n)
//
// This is what makes array-based implementation of List<E> 
// not appealing in some applications.
//  
//     @param   a1   --array 
//     @param   ip   --position of the insertion 
//     @param   val  --  value to be inserted 
//
//  Uses static field curSize
   
   private static void  insert(double [] a1, int ip, double val) { 
   try{
       for (int j = curSize-1 ;  ip <= j ; --j)
            a1[j+1] = a1[j];
       a1[ip] = val;
       ++curSize;
     }
     catch ( RuntimeException k) {
            System.out.println("Cannot insert: possibly  array is full");
            System.exit(-1);
           }
   }
   
// from ReSizable.java
   private static double [] resize (double [] a1) { 
     int oldSize = a1.length;
     double [] a2 = new double[2 * oldSize];

     for( int i=0 ; i < oldSize ; ++i)
         a2[i] = a1[i];
    return a2;
   } 

}

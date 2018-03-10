import java.util.*;
public class    ArithmeticSeries {  
/** Each function computes the  nth terms of the series 
 *
 *    with  term  x + i r 
 *
 *   Using as unit number of aditions,
 *
 *   -- arithSum1 
 *   -- arithSum2 
 *   -- arithSum3 
 *
 *   are all O(n) (linear running time)
 *
 *   But...
 *   arithSum3 is   also  O(1) (constant running time!).
*/

// straigthforward 
public static  double  arithSum1   ( double x ,  double r,int n ) {   //6,3,3
  double result=0;

  for ( int i = 0; i < n ; ++i )
      result +=  x  + i*r ; //0+6+0*3+6+1*3+6+2*3

   return result;
}

// improved 
public static double   arithSum2   ( double x , double r, int n ) { //6,3,3
   double sum=0;
   for ( int i = 0; i < n ; ++i )
       sum +=  i   ;

   return  n * x  + sum * r; //*6+6*3

}

// optimal
public static  double arithSum3   ( double x ,  double r,int n ) {

   return  n * ( x  + (n - 1)  * r / 2.0)  ; // 3*(6+(3-1)*3/2)

  }

 } 

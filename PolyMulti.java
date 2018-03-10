import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PolyMulti {
   public static void main (String [] args) {
       
       ArrayList<Integer> first = new ArrayList<Integer>();
       ArrayList<Integer> second = new ArrayList<Integer>();
       ArrayList<Integer> third = new ArrayList<Integer>();
       ArrayList<Integer> fourth = new ArrayList<Integer>();
       first.add(-2);
       first.add(-3);
       first.add(3);
       first.add(-8);
       first.add(-3);
       first.add(3);
       first.add(3);
       second.add(7);
       second.add(1);
       third.add(2);
       third.add(1);
       fourth.add(3);
       fourth.add(1);
       ArrayList<Integer> fifth=polyMult(first,second);
       ArrayList<Integer> sixth=polyMult(fifth,third);
       ArrayList<Integer> seventh=polyMult(sixth,fourth);
      
       
       
       System.out.println(getDegree(first,second));
       System.out.println(getDegree(fifth,third));  
       System.out.println(sixth);
       System.out.println(getDegree(sixth,fourth));
       System.out.println(seventh);
       
      
   
   
   
   }
   

    
     
   static ArrayList<Integer> first = new ArrayList<Integer>();
   static ArrayList<Integer> second = new ArrayList<Integer>();
   int deg;
 
   

   
  
   
   //return coefficient
   public static ArrayList<Integer> polyMult(ArrayList<Integer> f, ArrayList<Integer> g) {
   
     int fDeg = f.size()-1;
     int gDeg = g.size()-1;
     final int hDeg = fDeg + gDeg;
     final ArrayList<Integer> h = new ArrayList<>(hDeg + 1);
     h.add(f.get(0)*g.get(0));
     for (int i=0;i<fDeg;i++) {
         h.add(f.get(i)*g.get(1)+f.get(i+1)*g.get(0));
     }
     h.add(f.get(fDeg)*g.get(gDeg));    
        
     //  if (fDeg == 1 && gDeg == 1) {
//          final int a1 = f.get(0), b1 = f.get(1);
//          final int a2 = g.get(0), b2 = g.get(1);
//          return Arrays.asList(a1*a2,a1*b2+b1*a2,b1*b2);
//       }
//       if (fDeg == 2 && gDeg == 1) {
//          final int a1 = f.get(0), b1 = f.get(1),c1=f.get(2);
//          final int a2 = g.get(0), b2 = g.get(1);
//          return Arrays.asList(a1*a2,a1*b2+b1*a2,c1*a2+b1*b2,c1*b2);
//       }
//       if (fDeg == 3 && gDeg == 1) {
//          final int a1 = f.get(0), b1 = f.get(1),c1=f.get(2),d1=f.get(3);
//          final int a2 = g.get(0), b2 = g.get(1);
//          return Arrays.asList(a1*a2,a1*b2+b1*a2,b1*b2+c1*a2,c1*b2+d1*a2,d1*b2);
//       }
//       if (fDeg == 4 && gDeg == 1) {
//          final int a1 = f.get(0), b1 = f.get(1),c1=f.get(2),d1=f.get(3),e1=f.get(4);
//          final int a2 = g.get(0), b2 = g.get(1);
//          return Arrays.asList(a1*a2,a1*b2+b1*a2,c1*a1+b1*b2,d1*a2+c1*b2,e1*a2+d1*b2,e1*b2);
//       }
                  //return Arrays.asList();
                  return h;
    }  
    //x^3+x^2+x+1 * 2x+1   
    //return degree
   public static String getDegree (ArrayList<Integer> f, ArrayList<Integer> g) {
     int fDeg = f.size()-1;
     int gDeg = g.size()-1;
      final int hDeg = fDeg + gDeg;
     final List<Integer> h = new ArrayList<Integer>(hDeg + 1);

      final StringBuilder sb = new StringBuilder();
      int poly=polyMult(f,g).size();
      for (int i= hDeg; i >= 0; i--) {
      if (polyMult(f,g).get(hDeg-i)< 0) {
      sb.append("");
      } else if (i==hDeg) {
         sb.append(""); 
      } else {
        sb.append("+ ");
      }
      sb.append(polyMult(f,g).get(hDeg-i));
      
      if (i>0) {
      sb.append("x^");
      
      sb.append(i);
      
      }
      
     // sb.append("+");
     //System.out.println(sb);

    } 

       return sb.toString();
       
   }
   
}
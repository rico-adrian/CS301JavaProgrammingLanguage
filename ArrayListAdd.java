import java.util.ArrayList;
import java.util.*;


public class ArrayListAdd {
   public static void main (String[] args) {
      
      
      ArrayList<Integer> list1 = new ArrayList<Integer>(8);
      ArrayList<String> list2 = new ArrayList<String>();  
      
      list1.add(8);
      list1.add(20);
      list1.add(11);
      
      list1.add(8);
      list1.add(30);
      list1.add(6);
      
      
      list2.add("int");
      list2.add("double");
      list2.add("data type");
      
      //list1.remove(0);
      //list2.remove(0);
      for (int i=0;i<list1.size();i++) {
         int j=0;
         if (j<=list1.get(i)) {
            
            j=list1.get(i);
            System.out.println(j);

      }
            }
      System.out.println(Collections.max(list1));
      System.out.println(list2);

   
   
   }



}
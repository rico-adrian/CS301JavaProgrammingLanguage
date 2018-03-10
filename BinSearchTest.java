import java.util.*;
public class BinSearchTest {
   public static void main(String[]args) {
      
      BinSearch b=new BinSearch();
      ArrayList<Integer> array= new ArrayList<Integer>();
      array.add(1);
      array.add(6);
      array.add(12);
      array.add(19);
      array.add(30);
      array.add(45);
      array.add(50);
      array.add(60);
      array.add(70);
      array.add(90);
      int first=0;
      int last=9;
      int value=70;
      System.out.println(b.binarySearch(array,first,last,value));
      
   
   
   
   



   }


}
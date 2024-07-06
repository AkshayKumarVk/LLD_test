package Accessibility.passByValue;

public class PassByValue 	{


   public static void main (String[] args) {
	  int x=10;
	  System.out.println (x);
	  fun (x);
	  System.out.println (x);
   }
   public static void fun (int x){
	  x+=10;
   }
}

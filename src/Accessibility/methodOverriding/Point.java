package Accessibility.methodOverriding;

public class Point {
   protected  int x;
   protected int y;

   Point(int x, int y){
	  this.x=x;
	  this.y=y;
   }

   public  void display(){
	  System.out.println (x +" "+ y);
	  System.out.println ("point");
   }
}

public class Rectangle {

   public Point topLeft;
   public Point bottomRight;

   public  Rectangle(int topLeftX, int topLeftY, int bottomRightX, int bottomRightY){
this.topLeft= new Point (topLeftX,topLeftY);
   }

   public  Rectangle(Point topLeft, Point bottomRight){
	  this.topLeft=topLeft;
	  this.bottomRight=bottomRight;
   }

   public Rectangle (Rectangle rectangle){
	  this.topLeft=new Point (rectangle.topLeft);
	  this.bottomRight=new Point (rectangle.bottomRight);

	  System.out.println ("jghgh");
   }
}

package vehicle;

public class Car {
   String model;
   int year;
   Engine engine;

   Car (String model, int year, Engine engine) {
	  this.model = model;
	  this.year = year;
	  this.engine = engine;

	  System.out.println ("Normal constructor");
   }

   Car (Car car) {
	  this.model = car.model;
	  this.year = car.year;
	  this.engine = car.engine;

	  System.out.println ("Copy constructor");
   }


   public static void main (String[] args) {

	  Engine engine = new Engine ("V12");

	  Car car1 = new Car ("Maruthi", 2003, engine);
	  Car car2 = new Car (car1);

	  Car car3 =car1;
	  car3.model="Swift";
   }
}

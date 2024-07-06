package lld27_06_2024;

public class Client {
   public static void main (String[] args) {
	  System.out.println ("I am the main class");

	  Adder adder = new Adder ();
	  Thread thread = new Thread (adder);
	  thread.start ();

	  Subtractor subtractor = new Subtractor ();
	  ScalerThread scalerThread=new ScalerThread (subtractor);
	  scalerThread.start ();
   }
}

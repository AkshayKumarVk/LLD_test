package lld01_05_07_2024.addersubtractor;

public class Client {
   public static void main (String[] args) throws InterruptedException {
	  Counter counter = new Counter ();

	  Adder adder = new Adder (counter);
	  Subtractor subtractor = new Subtractor (counter);
	  Thread t1 = new Thread (adder);
	  Thread t2 = new Thread (subtractor);

	  t1.start ();
	  t2.start ();
	  t1.join ();
	  t2.join ();


	  System.out.println (counter.value);
   }
}

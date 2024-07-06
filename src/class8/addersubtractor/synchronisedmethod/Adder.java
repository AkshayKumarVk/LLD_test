package class8.addersubtractor.synchronisedmethod;


public class Adder implements Runnable {
   private Count count;

   public Adder (Count count) {
	  this.count = count;
   }

   public void run () {
	  for (int i = 1; i <= 10000; i++) {
		 count.increment ();
		 System.out.println ("Adder " + i + ' ' + Thread.currentThread ().getName () + " Count= " + count.getValue ());
	  }
   }
}
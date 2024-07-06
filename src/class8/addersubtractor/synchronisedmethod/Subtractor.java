package class8.addersubtractor.synchronisedmethod;

public class Subtractor implements Runnable{
   private Count count;

   public Subtractor (Count count) {
	  this.count = count;
   }


   public void run () {
	  for (int i = 1; i <= 10000; i++) {
		 count.decrement ();
			System.out.println ("Subtractor " + i + ' ' + Thread.currentThread ().getName () + " Count= " + count.getValue ());
	  }
   }
}

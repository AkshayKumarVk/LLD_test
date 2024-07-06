package class8.addersubtractor.synchronisedblock;


public class Adder implements Runnable {
   private Count count;

   public Adder (Count count) {
	  this.count = count;
   }

   public void run () {
	  for (int i = 1; i <= 10000; i++) {
		 synchronized (count) {
			 count.value+=1;
			System.out.println ("Adder " + i + ' ' + Thread.currentThread ().getName () + " Count= " + count.value);
		 }

	  }
   }
}
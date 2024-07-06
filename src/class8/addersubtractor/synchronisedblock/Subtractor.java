package class8.addersubtractor.synchronisedblock;

public class Subtractor implements Runnable{
   private Count count;

   public Subtractor (Count count) {
	  this.count = count;
   }

   public void run () {
	  for (int i = 1; i <= 10000; i++) {
		 synchronized (count){
			count.value -= 1;
			System.out.println ("Subtractor " + i + ' ' + Thread.currentThread ().getName () + " Count= " + count.value);
		 }
	  }
   }
}

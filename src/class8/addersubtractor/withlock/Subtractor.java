package class8.addersubtractor.withlock;

import java.util.concurrent.locks.Lock;

public class Subtractor implements Runnable {
   private  Count count;
   private  Lock lock;

   public Subtractor (Count count, Lock lock) {
	  this.count = count;
	  this.lock = lock;
   }

   public void run () {

	  for (int i = 1; i <= 10000; i++) {
		 lock.lock ();
//		 System.out.println (lock.tryLock ());
		 System.out.println ("Subtractor " + i + ' ' + Thread.currentThread ().getName () + " Count= " + count.value);
		 count.value -= 1;
		 lock.unlock ();
	  }
   }
}
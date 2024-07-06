package class8.addersubtractor.atomic_integer;

public class Subtractor implements Runnable{
   Count count;

   public Subtractor(Count count) {
	  this.count=count;
   }

   @Override
   public void run () {
	  for(int i=1;i<=10000;i++) {
		 count.value.addAndGet (-1);
		 System.out.println ("Subtractor " + i + ' ' + Thread.currentThread ().getName () + " Count= " + count.get ());
	  }
   }
}

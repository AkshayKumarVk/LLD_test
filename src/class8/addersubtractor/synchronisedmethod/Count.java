package class8.addersubtractor.synchronisedmethod;

public class Count {
   public int value = 0;

   public synchronized void increment () {
	  value++;
   }

   public synchronized void decrement () {
	  value--;
   }

   public int getValue () {
	  return value;
   }
}

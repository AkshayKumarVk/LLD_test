package lld01_05_07_2024.addersubtractor;

public class Adder implements Runnable{
   private Counter count;

   public Adder(Counter count) {
	  this.count = count;
   }
   @Override
   public void run() {
	  for (int i = 1; i <=10000; i++) {
		 count.value+=i;
	  }
   }
}

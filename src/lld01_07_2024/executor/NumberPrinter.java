package lld01_07_2024.executor;

public class NumberPrinter implements Runnable {


   public int number;

   public NumberPrinter (int number) {
	  this.number = number;
   }


   @Override
   public void run () {
	  System.out.println ("NumberPrinter: " + " " + this.number + " " + Thread.currentThread ().getName ());
   }
}

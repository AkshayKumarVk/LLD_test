package lld01_07_2024.executor;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

   public static void main (String[] args) {

	  Scanner scanner = new Scanner(System.in);

	  System.out.println ("Enter 1 or other number5");
	  int num=scanner.nextInt();

	  if(num==1){
		 numberPrinterNormal ();
	  }
	  else {
		 numberPrinterExecutable ();
	  }
   }

   public static void numberPrinterExecutable () {

	  ExecutorService executorService = Executors.newFixedThreadPool (10);

	  for (int i = 1; i <= 100; i++) {
		 executorService.execute (new NumberPrinter (i));
	  }
   }

   public static void numberPrinterNormal () {

	  for (int i = 1; i <= 100; i++) {
		 NumberPrinter numberPrinter = new NumberPrinter (i);
		 Thread thread = new Thread (numberPrinter);
		 thread.start ();
	  }
   }
}

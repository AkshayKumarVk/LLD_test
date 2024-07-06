package class8.addersubtractor.synchronisedmethod;

public class Client {
   public static void main (String[] args) throws Exception {
	  Count count;
	  count = new Count ();

	  Adder adder;
	  adder = new Adder (count);

	  Subtractor subtractor;
	  subtractor = new Subtractor (count);

	  Thread t1 = new Thread (adder);
	  Thread t2 = new Thread (subtractor);

	  t1.start ();
	  t2.start ();
	  t1.join ();
	  t2.join ();

	  System.out.println (count.value);

   }
}

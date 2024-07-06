package class8.addersubtractor.atomic_integer;

public class Client {
   public static void main (String[] args) throws Exception {
	  Count count = new Count ();
	  Subtractor subtractor = new Subtractor (count);
	  Adder adder = new Adder (count);

	  Thread t1 = new Thread (adder);
	  Thread t2 = new Thread (subtractor);

	  t1.start ();
	  t2.start ();
	  t1.join ();
	  t2.join ();
	  System.out.println (count.get ());
   }
}

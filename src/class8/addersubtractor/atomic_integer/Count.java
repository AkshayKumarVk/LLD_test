package class8.addersubtractor.atomic_integer;

import java.util.concurrent.atomic.AtomicInteger;

public class Count {
   AtomicInteger value =new AtomicInteger (0);

   public int get() {
	  return value.get ();
   }
}

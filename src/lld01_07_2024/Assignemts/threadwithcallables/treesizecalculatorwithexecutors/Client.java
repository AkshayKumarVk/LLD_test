package lld01_07_2024.Assignemts.threadwithcallables.treesizecalculatorwithexecutors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
   public static void main (String[] args) throws ExecutionException, InterruptedException {
	  ExecutorService executorService= Executors.newCachedThreadPool ();
	  Node root = new Node (1);
	  root.left = new Node (2);
	  root.right = new Node (3);
	  root.left.left = new Node (4);
	  root.left.right = new Node (5);
	  root.right.left = new Node (6);
	  root.right.right = new Node (7);

	  TreeSizeCalculator treeSizeCalculator=new TreeSizeCalculator (root, executorService);
	  System.out.println (treeSizeCalculator.call ());
   }
}

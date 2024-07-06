package lld01_07_2024.Assignemts.threadwithcallables.treesizecalculatorwithexecutors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class TreeSizeCalculator implements Callable {

   private final Node root;
   private final ExecutorService executorService;

   public TreeSizeCalculator (Node root, ExecutorService executorService) {
	  this.root = root;
	  this.executorService = executorService;
   }

   /**
	* Calculates the size of the tree starting from the root node.
	* If the root is null, the size is 0.
	* If the root is not null, it recursively calculates the size of the left subtree and right subtree.
	* Adds the sizes of the left and right subtrees to get the total size of the tree.
	*
	* @return the size of the tree
	* @throws ExecutionException   if the computation threw an exception
	* @throws InterruptedException if the computation was interrupted
	*/
   public Integer call () throws ExecutionException, InterruptedException {

	  // Check if the root is null
	  if (root == null) {
		 return 0;
	  }

	  // Initialize Future objects for left and right subtree sizes
	  Future<Integer> leftSize = null;
	  Future<Integer> rightSize = null;

	  // Submit tasks to calculate the size of left and right subtrees
	  if (root.left != null) {
		 leftSize = executorService.submit (new TreeSizeCalculator (root.left, executorService));
	  }
	  if (root.right != null) {
		 rightSize = executorService.submit (new TreeSizeCalculator (root.right, executorService));
	  }

	  // Initialize size with 1 (root node)
	  int size = 1;

	  // Add the size of the left subtree if it exists
	  if (leftSize != null) {
		 size += leftSize.get ();
	  }

	  // Add the size of the right subtree if it exists
	  if (rightSize != null) {
		 size += rightSize.get ();
	  }

	  // Return the total size of the tree
	  return size;
   }
}
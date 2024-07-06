package lld01_07_2024.callables.mergeSortWithExecutors;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
   public static void main (String[] args) throws ExecutionException, InterruptedException {

	  List<Integer> inputList = List.of (9, 4, 8, 3, 1, 2, 0, 7, 6, 5);
	  System.out.println ("Input List: " + inputList);

	  System.out.println ("Output List: " + callMergerSorter (inputList).get ());
   }

//   public static void printList (List<Integer> list) {
//	  for (Integer integer : list) {
//		 System.out.print (integer + " ");
//	  }
//	  System.out.println ();
//   }

   public static Future<List<Integer>> callMergerSorter (List<Integer> listToSort) {

	  ExecutorService executorService = Executors.newCachedThreadPool ();

	  MergeSorter mergeSorter = new MergeSorter (listToSort, executorService);
	  Future<List<Integer>> sortedListFuture = executorService.submit (mergeSorter);
	  return sortedListFuture;

//	  return mergeSorter.call ();
   }

}

package lld01_07_2024.callables.mergeSortWithExecutors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


public class MergeSorter implements Callable {

   private final List<Integer> listToSort;
   private final ExecutorService executorService;

   public MergeSorter (List<Integer> listToSort,ExecutorService executorService) {
	  this.listToSort = listToSort;
	  this.executorService = executorService;
   }

   @Override
   public List<Integer> call () throws ExecutionException, InterruptedException {
	  if (listToSort.size () <= 1) {
		 return listToSort;
	  }

	  List<Integer> leftList = new ArrayList<Integer> ();
	  int mid = listToSort.size () / 2;
	  for (int i = 0; i < mid; i++) {
		 leftList.add (listToSort.get (i));
	  }

	  List<Integer> rightList = new ArrayList<Integer> ();
	  for (int i = mid; i < listToSort.size (); i++) {
		 rightList.add (listToSort.get (i));
	  }

//	  ExecutorService executorService= Executors.newCachedThreadPool ();
	  MergeSorter leftMergeSorter = new MergeSorter (leftList,executorService);
	  MergeSorter rightMergeSorter = new MergeSorter (rightList,executorService);


	  Future<List<Integer>> leftSortedListFuture = executorService.submit (leftMergeSorter);
	  Future<List<Integer>> rightSortedListFuture = executorService.submit (rightMergeSorter);
//	  List<Integer>leftSortedList=leftMergeSorter.call();
//	  List<Integer>rightSortedList=rightMergeSorter.call();


	  return mergeList (leftSortedListFuture, rightSortedListFuture, listToSort.size ());
   }

   public List<Integer> mergeList (Future<List<Integer>> leftList, Future<List<Integer>> rightList, int size) throws ExecutionException, InterruptedException {
//Extracting form future to list
	  List<Integer> leftSortedListFuture = leftList.get ();
	  List<Integer> rightSortedListFuture = rightList.get ();
	  List<Integer> sortedList = new ArrayList();

	  int i = 0;
	  int j = 0;

	  while (i < leftSortedListFuture.size () && j < rightSortedListFuture.size ()) {
		 if (leftSortedListFuture.get (i) < rightSortedListFuture.get (j)) {
			sortedList.add (leftSortedListFuture.get (i));
			i++;
		 } else {
			sortedList.add (rightSortedListFuture.get (j));
			j++;
		 }
	  }

	  if (i < leftSortedListFuture.size ()) {
		 while (i < leftSortedListFuture.size ()) {
			sortedList.add (leftSortedListFuture.get (i));
			i++;
		 }
	  } else if (j < rightSortedListFuture.size ()) {
		 sortedList.add (rightSortedListFuture.get (j));
		 j++;
	  }
	  return sortedList;
   }
}
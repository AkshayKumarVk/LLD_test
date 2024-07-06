package lld01_07_2024.callables.mergeSortWithoutThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;


public class MergeSorter implements Callable {

   private List<Integer> listToSort;

   public MergeSorter (List<Integer> listToSort) {
	  this.listToSort = listToSort;
   }

   @Override
   public List<Integer> call () {

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

	  MergeSorter leftMergeSorter = new MergeSorter (leftList);
	  MergeSorter rightMergeSorter = new MergeSorter (rightList);

	  List<Integer>leftSortedList=leftMergeSorter.call();
	  List<Integer>rightSortedList=rightMergeSorter.call();



	  return mergeList (leftSortedList, rightSortedList,listToSort.size () );
   }

   public List<Integer> mergeList (List<Integer> leftList, List<Integer> rightList, int size) {

	  List<Integer> sortedList = new ArrayList<Integer> ();

	  int i=0;
	  int j=0;

	  while(i<leftList.size ()&&j<rightList.size ()) {
		 if(leftList.get(i)<rightList.get(j)) {
			sortedList.add (leftList.get(i));
			i++;
		 } else {
			sortedList.add (rightList.get(j));
			j++;
		 }
	  }

	  if (i<leftList.size ()) {
		 while (i < leftList.size ()) {
			sortedList.add (leftList.get (i));
			i++;
		 }
	  }
	  else if (j< rightList.size ()){
		 sortedList.add(rightList.get(j));
		 j++;
	  }
	  return sortedList;
   }
}
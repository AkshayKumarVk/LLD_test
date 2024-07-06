package lld01_07_2024.callables.mergeSortWithoutThread;

import java.util.List;

public class Client {
   public static void main (String[] args) {

	  List<Integer> inputList = List.of (9, 4, 8, 3, 1, 2, 0, 7, 6, 5);

	  System.out.println ("Input List: " + inputList);
//	  printList (inputList);

//	  List<Integer> outputList = callMergerSorter (inputList);
	  System.out.println ("Output List: " + callMergerSorter (inputList));
//	  printList (outputList);
   }

//   public static void printList (List<Integer> list) {
//	  for (Integer integer : list) {
//		 System.out.print (integer + " ");
//	  }
//	  System.out.println ();
//   }

   public static List<Integer> callMergerSorter (List<Integer> listToSort) {

	  MergeSorter mergeSorter = new MergeSorter (listToSort);

	  return mergeSorter.call ();
   }

}

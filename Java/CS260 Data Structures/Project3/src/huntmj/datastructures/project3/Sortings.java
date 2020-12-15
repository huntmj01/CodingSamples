package huntmj.datastructures.project3;

/**
* 
* NAME: 		Matthew Hunt
* PROJECT:		Project 3 
* COURSE: 		CS260 
* INSTRUCTOR:	Petruska 
* DUE DATE:		12/12/2016
* 
* DESCRIPTION: Sorting holds the sorting algorithms to test.
* 
* CLASS METHODS:
* 		merge()
* 			is a helper method for mergeSort() to merge
* 			the split array/linked list back together.
* 		getMiddle()
* 			divide() is a helper method for mergeSort() 
*			to get the middle of the linked list.
*		heapify()
*			turns a subtree into a heap.
* 
* INSTANCE METHODS: 
* 		insertionSort()
* 			sorts an array or linked list using
* 			the insertion sort algorithm.
* 		mergeSort()
* 			sorts an array or linked list using
* 			the merge sort algorithm.
* 		heapsort()
* 			sorts an array using the heapsort
* 			algorithm.
* 		
**/
public class Sortings {

	/**
	 * 
	 * insertionSort() takes an array and sorts it 
	 * using the insertion sort algorithm.
	 * 
	 */
	public static void insertionSort(
			int[] data		// the array to sort
					) {

		// loop through each element in the array
		for (int i = 1; i < data.length; i++) {

			//
			// declare local variables to hold the
			// current element in the array and
			// the iteration count of the nested for loop
			//
			int temp = data[i];
			int j;

			// loop through the sorted part of the array backwards
			for (j = i - 1; j >= 0 && temp < data[j]; j--) {
				// swap the next item with the current item
				// of the sorted part of the array
				data[j + 1] = data[j];
			}

			// set the next item to the current item of the array
			data[j + 1] = temp;

		}

	}

	/**
	 * 
	 * insertionSort() takes a linked list and 
	 * sorts it using the insertion sort algorithm.
	 * 
	 */
	public static Node<Integer> insertionSort(Node<Integer> head) {

		// check to make sure head isn't null
		if (head == null)return null;
		
		// set the sorted part of the list to the beggining
		// of the list
		Node<Integer> sortedList = head;
		// move forward one
		head = head.getLink();
		// severe the sorted lists link
		sortedList.setLink(null);

		// loop until we hit the end of the list
		while (head != null) {

			// set the current item to the front of the list
			Node<Integer> current = head;
			// move forward one
			head = head.getLink();
			
			// check to see if the current item is less than the next
			// item in the sorted list
			if (current.getData() < sortedList.getData()) {
				// move the current to the sorted list
				current.setLink(sortedList);
				sortedList = current;
			
			// else the current item is not the next item
			// in the sorted list
			} else {

				// set the search to the beggining of the sorted list
				Node<Integer> search = sortedList;

				// loop while search is not the last item in the list
				// and the current item is greater than the next item after search
				while (search.getLink() != null && current.getData() > search.getLink().getData())
					// advance search one forward
					search = search.getLink();
				
				// swap search and current
				current.setLink(search.getLink());
				search.setLink(current);
			}
		}
		
		// return the sorted list
		return sortedList;

	}

	/**
	 * 
	 * mergeSort() takes an array and sorts 
	 * it using the merge sort algorithm.
	 * 
	 */
	public static void mergeSort(int[] data, // the array to sort
			int startIndex, // the index to start sorting from
			int stopIndex // the index to stop sorting
	) {

		//
		// declare local variables to hold the sizes
		// of the first and the second half of the array
		//
		int firstHalfSize;
		int secondHalfSize;

		// check if the array has more than one element
		if (stopIndex > 1) {

			// compute the sizes of the two halves
			firstHalfSize = stopIndex / 2;
			secondHalfSize = stopIndex - firstHalfSize;

			mergeSort(data, startIndex, firstHalfSize); // sort data[start]
														// through
														// data[startIndex+firstHalfSize-1]
			mergeSort(data, startIndex + firstHalfSize, secondHalfSize); // sort
																			// data[first+firstHalfSize]
																			// to
																			// the
																			// end

			// merge the two sorted halves
			merge(data, startIndex, firstHalfSize, secondHalfSize);
		}
	}

	/**
	 * 
	 * mergeSort() takes an a LinkedList and sorts it 
	 * using the merge sort algorithm.
	 * 
	 */
	public static Node<Integer> mergeSort(Node<Integer> head // the head of the
																// linked list
	) {

		// check to make sure the list isn't null or only have one element
		if (head == null || head.link == null)
			return head;

		//
		// declare local variables to hold the middle
		// and the second half of the linked list
		//
		Node<Integer> middle = getMiddle(head); // get the middle of the list
		Node<Integer> sHalf = middle.link; // get the next item after the middle
											// in the linked list
		middle.link = null; // split the list into two halves

		return merge(mergeSort(head), mergeSort(sHalf)); // keep splitting and
															// merging the
															// linked list until
															// it's sorted
	}

	/**
	 * 
	 * heapsort() takes an array and sorts it 
	 * using the heapsort algorithm.
	 * 
	 */
	public static void heapsort(
			int data[]			// the array to sort
					){
		
        int n = data.length;
 
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(data, n, i);
 
        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            int temp = data[0];
            data[0] = data[i];
            data[i] = temp;
 
            // call max heapify on the reduced heap
            heapify(data, i, 0);
        }
    }
 
    /**
     * 
     * heapify() turns a subtree into a heap.
     * 
     */
    private static void heapify(int arr[], int n, int i){
        int largest = i;  // Initialize largest as root
        int l = 2*i + 1;  // left = 2*i + 1
        int r = 2*i + 2;  // right = 2*i + 2
 
        // check if left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;
 
        // check if right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;
 
        // check if largest is not the root
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
	
	
	/**
	 * 
	 * merge() is a helper method for mergeSort() to merge
	 * the split array back together.
	 * 
	 */
	private static void merge(int[] data, // the array to merge
			int startIndex, // the index to start merging at
			int firstHalfSize, // the size of the first half
			int secondHalfSize // the size of the second half
	) {

		//
		// declare local variables to allocate a temporary array, hold
		// the number of elements copied from data to temp, hold the number
		// of elements copied from the first half of data, hold the number
		// of elements copied ffrom the second half of data, the index of
		// of the array to copy from temp back into data
		//
		int[] temp = new int[firstHalfSize + secondHalfSize]; // allocate
																// temporary
																// array
		int copied = 0; // number of elements copied from data to temp
		int copied1 = 0; // number copied from the first half of data
		int copied2 = 0; // number copied from the second half of data
		int i; // array index to copy from temp back into data

		// merge elements, copying from two halves of data to the tmp array
		while ((copied1 < firstHalfSize) && (copied2 < secondHalfSize)) {
			// check to see if the first half item is less than the second half
			// item
			if (data[startIndex + copied1] < data[startIndex + firstHalfSize + copied2]) {
				// add the left half to the temp array
				temp[copied++] = data[startIndex + copied1++];
				// else the second half item is less than the first half item
			} else {
				// add the second half item to the temp array
				temp[copied++] = data[startIndex + firstHalfSize + copied2++];
			}
		}

		// copy any remaining entries in the left subarray(but not from the
		// right subarray, because those entries are already in the correct
		// spot of the data array).
		while (copied1 < firstHalfSize) {
			temp[copied++] = data[startIndex + (copied1++)];
		}

		// copy from temp back to the data array
		for (i = 0; i < copied; i++) {
			data[startIndex + i] = temp[i];
		}

	}

	/**
	 * 
	 * merge() is a helper method for mergeSort() to merge the split linked list
	 * back together.
	 * 
	 */
	private static Node<Integer> merge(Node<Integer> firstHalf, // the head of
																// the first
																// half of the
																// linked list
			Node<Integer> secondHalf // the head of the second half of the
										// linked list
	) {

		//
		// declare local variables to hold a dummy
		// head and cursor
		//
		Node<Integer> dummyHead;
		Node<Integer> cursor;

		// set dummy head to an empty node
		dummyHead = new Node<Integer>(0, null);
		// assign the cursor to the dummy
		cursor = dummyHead;

		// loop until we reach the end of the first half or second half
		while (firstHalf != null && secondHalf != null) {

			// check to see if the current item of the first half
			// is less than or equal to the current item
			// of the second half
			if (firstHalf.data <= secondHalf.data) {
				// move the cursor to the first half
				cursor.link = firstHalf;
				// move the first half forward one
				firstHalf = firstHalf.link;

				// else the current item of the first half
				// is greater than to the current item
				// of the second half
			} else {
				// set the cursor to the second half
				cursor.link = secondHalf;
				// move the second half forward one
				secondHalf = secondHalf.link;
			}
			// move the cursor forward one
			cursor = cursor.link;
		}

		// set the cursor to the first or second half
		cursor.link = (firstHalf == null) ? secondHalf : firstHalf;

		// return the Node in front of the dummy Node
		return dummyHead.link;
	}

	/**
	 * 
	 * divide() is a helper method for mergeSort() to get the middle of the
	 * linked list.
	 * 
	 */
	private static Node<Integer> getMiddle(Node<Integer> head // the head of the
																// linked list
																// to split
	) {

		// make sure linked list isn't empty
		if (head == null) {
			return head;
		}

		//
		// declare local variables to hold the middle
		// and last Node in the list
		//
		Node<Integer> slow; // holds the middle Node in the linked
		Node<Integer> fast; // holds the last node in the linked list

		// set slow and fast to equal head
		slow = head;
		fast = head;

		// loop through the linked list
		while (fast.link != null && fast.link.link != null) {
			// move slow forward one and fast forward two
			slow = slow.link;
			fast = fast.link.link;
		}

		// return the middle link
		return slow;
	}

}



































































//public static void heapsort(int[] data, int n){
//
//int unsorted;	// Size of the unsorted part of the array
//int temp;		// Used during the swapping of two array locations
//
//makeHeap(data, n);
//
//unsorted = n;
//
//while (unsorted > 1){
//	unsorted--;
//	// swap the largest element (data[0]) with the final element of unsorted part
//	temp=data[0];
//	data[0] = data[unsorted];
//	data[unsorted]=temp;
//	reheapifyDown(data, unsorted);
//}
//System.out.println("");
//}
//
//private static void makeHeap(int[] data, int n){
//int i,k, temp;
//
//// make a heap from an array called data with n elements
//for (i=1;i<n; i++){
//	
//	k=i; // index of new element
//	
//	while(data[k] != data[0] && !isLeaf(data, parent(k)) && data[k] > data[parent(k)]){
//		// swap data k with  its parent
//		temp = data[k];
//		data[k] = data[parent(k)];
//		data[parent(k)] = temp;
//	}
//	
//}
//}
//
//private static int parent(int k){
//return (k-1)/2;
//}
//
//private static void reheapifyDown(int[] data, int n){
//
//int current;			// index of the node that's moving down
//int bigChildIndex;		// index of current's larger child
//boolean heapOkay;		// will become true when heap is correct
//
//current = 0;
//heapOkay = false;
//
//while((!heapOkay)&&(!isLeaf(data, 2*current+1))){
//	// set bigChildIndex to be the index of the larger child
//	// of the current node)
//	if (data[2*current+1]<data[2*current+2]){
//		bigChildIndex = 2*current+2;
//	}else{
//		bigChildIndex = 2*current+1;
//	}
//	
//	if (data[current] < data[bigChildIndex]){
//		// swap data[current] with data[bigChildIndex]
//		int temp = data[current];
//		data[current] = data[bigChildIndex];
//		data[bigChildIndex] =temp;
//		current = bigChildIndex;
//	}else{
//		heapOkay = true;
//	}
//}
//
//}
//
//private static boolean isLeaf(int[] data, int rightChild){
//try{
//	data[rightChild] = data[rightChild];
//	return false;
//}catch (Exception e){
//	return true;
//}
//}




// public static void insertionSort(Node<Integer> head) {
//
// if (head == null){
// System.out.println("linked list is empty or only has one element");
// return;
// }
//
// Node<Integer> inOrder = head;
// Node<Integer> checkOrder;
// Node<Integer> precursor = head;
// Node<Integer> cursor = head.link;
//
// while(inOrder.link != null){
//
// // checkOrder assigned to inOrder.link
// checkOrder = inOrder.link;
// // store checkorder data in a temp variable
// int temp = checkOrder.data;
//
// // check if the temp is less than the heads data
// if (temp < head.data){
// // rearrange links to insert check order before head
// checkOrder.link = head;
// // update head
//
// }else{
// // declare node references
// precursor = head;
// cursor = head.link;
//
// }
//
// while (cursor.data < temp){
// // move one step forward
// cursor = cursor.link;
// precursor = precursor.link;
//
// }
//
// if (!cursor.equals(checkOrder)){
// // rearrange links to insert checkOrder between precursor and cursor
// cursor = cursor.link;
// precursor.link = checkOrder;
//
// }else{
// inOrder = inOrder.link;
// System.out.println("");
// }
//
// }
//
// }

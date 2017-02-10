/**
	Integer array implementation of sorting algorithms
	@author Jason Wu
*/
public class Sorting {
	private int[] arr;
	private int maxSize = 10;
	
	//TODO implement initialization check
	//private boolean intialized = false;
	
	public Sorting(int[] a){
		arr = CopyArray(a);
	}
	
	public int[] toArray() {
		//@SuppressWarnings("unchecked")
		//T[] temp = (T[])new Object[a.length];
		int[] temp = new int[arr.length];
		for (int i = 0; i < arr.length; i++){
			temp[i] = arr[i];
		}
		return temp;
	}
	
	public int[] CopyArray(int[] a) {
		//@SuppressWarnings("unchecked")
		//T[] temp = (T[])new Object[a.length];
		int[] temp = new int[a.length];
		for (int i = 0; i < a.length; i++){
			temp[i] = a[i];
		}
		return temp;
	}
	
	/**
	 * Applies an iterative implementation of selective sort to array
	 * @return sorted array
	 */
	public int[] SelectiveSortIterative(){
		int[] temp = CopyArray(arr);
		
		int least;
		for (int i = 0; i < temp.length; i++){
			least = i;
			
			for (int j = i+1; j < temp.length; j++){
				// check all for least, swap least to i
				if (temp[j] < temp[least])
					least = j;
				System.out.println(temp[least]);
			}
			
			swap(temp,i,least);
		}
		
		return temp;
	}
	
	
	/**
	 * User access version of SelectiveSortRecursive
	 * @return copy of sorted array
	 */
	public int[] SelectiveSortRecursive(){
		return SelectiveSortRecursive(CopyArray(arr), 0, 1, -1);
	}
	
	/**
	 * Implementation of recursive selective sorting algorithm
	 * @param tempArray array to sort
	 * @param currentIndex starting index (i)
	 * @param checkingIndex should always equal current index + 1 at start (j)
	 * @param least records index with least value, -1 if starting to check for least
	 * @return copy of sorted array
	 */
	private int[] SelectiveSortRecursive(int[] tempArray, int currentIndex, int checkingIndex, int least){
		
		if (currentIndex < tempArray.length) { // if current index less than length
			if (least == -1){ //if on new current index, set least
				least = currentIndex;
			}
			if (checkingIndex < tempArray.length){ // if checking is less then length
				if (tempArray[checkingIndex] < tempArray[least]) { //set checking to least if least
					least = checkingIndex;
				}
				//do recursive again with checkingIndex++
				return SelectiveSortRecursive(tempArray,  currentIndex, checkingIndex+1, least);
			}
			else //if finished checking for least (j loop)
			{
				swap(tempArray, currentIndex, least);
			}
		}
		else {
			return tempArray; // executes once recursive stack completes	
		}
		//assign least to -1 to get reassigned
		return SelectiveSortRecursive(tempArray,  currentIndex+1, currentIndex+2, -1);
	}
	
	/**
	 * iterative implementation of insertion sort
	 * @return copy of sorted array
	 */
	public int[] InsertionSortIterative(){
		int[] temp = CopyArray(arr);
		int e;
		for (int i = 1; i < temp.length; i++){
			e = i;
			for (int j = i-1; j >= 0; j--){
				if (temp[e] < temp[j]){
					swap(temp,e,j);
					e = j;
				}
				else break;
			}
		}
		return temp;
	}
	
	
	/**
	 * client use of recursive implementation of insertion sort
	 * @return copy of sorted array
	 */
	public int[] InsertionSortRecursive(){
		return InsertionSortRecursive(CopyArray(arr),1,0,-1);
	}
	
	/**
	 * implementation of insertion sort through recursion
	 * @param temp array to sort
	 * @param i counter through element
	 * @param j counter to check
	 * @param e current index
	 * @return copy of sorted array
	 */
	private int[] InsertionSortRecursive(int[] temp, int i, int j, int e) {
		if (i < temp.length){
			if (e == -1){
				e = i;
			}
			
			if (j >=0){
				if (temp[e] < temp[j]){
					swap(temp,e,j);
					e = j;
				}
				return InsertionSortRecursive(temp, i,j-1,e);
			}
		}
		else{
			return temp;
		}
		//if finish check
		return InsertionSortRecursive(temp, i+1, i,-1);
	}

	/**
	 * Swaps the values of the current array at index a and b
	 * @param array array to swap
	 * @param a first index
	 * @param b second index
	 */
	private void swap(int[] array, int a, int b){
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}

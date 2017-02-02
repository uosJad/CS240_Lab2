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
	
	private int[] CopyArray(int[] a) {
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
		for (int i = 1; i < temp.length; i++){
			least = i;
			
			for (int j = i+1; j < temp.length; j++){
				// check all for least, swap least to i
				if (arr[j] < least)
					least = j;
			}
			if (i!=least)
				swap(temp,i,least);
		}
		
		return temp;
	}
	
	
	/**
	 * User access version of SelectiveSortRecursive
	 * @return copy of sorted array
	 */
	public int[] SelectiveSortRecursive(){
		return SelectiveSortRecursive(CopyArray(arr), 1, 1+1, -1);
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
				if (tempArray[checkingIndex] < tempArray[currentIndex]) { //set checking to least if least
					least = checkingIndex;
				}
				
				//do recursive again with checking++
				SelectiveSortRecursive(tempArray,  currentIndex, checkingIndex+1, least);
				
			}
			else //if finished checking for least (j loop)
			{
				if (currentIndex != least)
					swap(tempArray, currentIndex, least);
				
				//assign least to -1 to get reassigned
				SelectiveSortRecursive(tempArray,  currentIndex+1, checkingIndex+2, -1);
			}
		}
		
		return tempArray; // executes once recursive stack completes	
	}
	
	
	/**
	 * Swaps the values of the current array at index a and b
	 * @param array array to swap
	 * @param a first index
	 * @param b second index
	 */
	private void swap(int[] array, int a, int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}

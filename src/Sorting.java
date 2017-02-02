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
			
			for (int j = i; j < temp.length; j++){
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

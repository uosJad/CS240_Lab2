/**
	Int Array implemetation of sorting algorithms
	@author Jason Wu
*/
public class Sorting {
	int[] arr;
	
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
	
	public int[] SelectiveSortIterative(){
		//@SuppressWarnings("unchecked")
		int[] temp = new int[arr.length];
		int least;
		for (int i = 1; i < arr.length; i++){
			least = i;
			
			for (int j = i; j < arr.length; j++){
				// check all for least, swap least to i
				if (arr[j] < least)
					least = j;
			}
			if (i!=least)
				swap(i,least);
			
		}
		
		return temp;
	}
	
	private void swap(int a, int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	
	
	
}

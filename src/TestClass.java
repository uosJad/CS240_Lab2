
import java.util.Random;

public class TestClass {

	public static void main(String[] args) {
		Sorting s = new Sorting(randomArray());
		printArray(s.toArray());
		
		printArray(s.RadixSortRecursive());
		
		
		
		
		
		
		
	}

	public static int[] randomArray(){
		int[] n = new int[10];
		for (int  i = 0; i < n.length; i++){
			n[i] = new Random().nextInt(1000);
		}
		return n;
	}
	
	
	public static void printArray(int[] a){
		for (int i = 0; i < a.length; i++){
			System.out.print(a[i]+ " ");
		}
		System.out.println();
	}
}

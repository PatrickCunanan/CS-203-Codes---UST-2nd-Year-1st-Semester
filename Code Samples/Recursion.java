import java.util.*;

public class Recursion{
	static String s = "";
	static Scanner Scan = new Scanner(System.in); 
	
	static void reverse(String Split[], int p, int q){
		if(p == q)
			System.out.println(Split[p]);
		else if(p < q-1)
			reverse(Split, (p+1), q);
			System.out.println(Split[p]);			
	}
	
	public static void main (String [] args){
		int t;
		/*
		how to get number from math.random
		int rand = (int)(Math.random() * (max - min) + min);
		*/
		System.out.println("Input Values");
		System.out.print("t = ");
		t = Scan.nextInt();
		System.out.print("s = ");
		Scan.nextLine();
		s = Scan.nextLine();
		String SplitArray[] = s.split(" ");
		
		if(t == 1){
			System.out.println("Output");
			for(int i = 0; i < SplitArray.length; i++){
				System.out.println(SplitArray[i]);
			}
			System.out.println("The reversal is");
			reverse(SplitArray, 0, SplitArray.length);
			
		}
		
		
	}
	
	
}
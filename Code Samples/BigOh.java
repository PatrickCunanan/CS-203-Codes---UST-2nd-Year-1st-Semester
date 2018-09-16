import java.util.*;

public class BigOh{
	static Scanner Scan = new Scanner(System.in);
	
	static void OrderedPair(int num){
		System.out.println("Ordered Pairs:");
		for(int i = 1; i <= num; i++){
			for(int j = 1; j<= num; j++){
				System.out.print("("+ i + "," + j + ") ");
			}
		}
	}
	
	static void TowerOfHanoi(int num, String fromP, String toP, String useP){
		if (num>0){
			TowerOfHanoi(num-1, fromP, useP, toP);
			System.out.println("Move disk from the " + fromP + " post to the " + toP +" post");
			TowerOfHanoi(num-1, useP, toP, fromP);
		}
	}
	
	public static void main(String [] args){
		int maxTime, n=1;
		long startTime, currentTime, elapsed;
		double secondsConverted = 0;
		System.out.print("Input a non negative integer: ");
		maxTime = Scan.nextInt();		
		while(secondsConverted <= maxTime){
			System.out.println("n = " +n);
			startTime = System.nanoTime();
			OrderedPair(n);
			currentTime = System.nanoTime();
			System.out.println("\n\n");
			elapsed = currentTime - startTime;
			secondsConverted = (double)elapsed/1000000000.0;
			n++;
		}
		
		System.out.println("\n\n");
		n=1;
		secondsConverted = 0;
		while(secondsConverted <= maxTime){
			System.out.println("n = " +n);
			startTime = System.nanoTime();
			TowerOfHanoi(n,"left","right","middle");
			currentTime = System.nanoTime();
			System.out.println("\n\n");
			elapsed = currentTime - startTime;
			secondsConverted = (double)elapsed/1000000000.0;
			n++;
		}
		
		
	}
}
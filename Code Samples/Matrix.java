//Cunanan, Patrick Bryan F.
//CS 203 2CS-B
//Lab Exercise 1
//Lab Exercise on matrices
//and iterative algorithms
import java.util.*;

public class Matrix{
	//static initialization of Scanner
	static Scanner Scan = new Scanner (System.in);
	//global variables
	static int i, j, k, l, m = 0, n = 0, p = 0, r = 0, s = 0, u = 0, v = 0;
	static int M [][] = new int[][]{
			{2,1,1,1,1,1,1,1,1,2},
			{1,0,0,0,0,0,0,0,0,1},
			{1,0,-1,-1,-1,-1,-1,-1,0,1},
			{1,0,2,2,0,0,1,1,0,1},
			{1,0,2,2,0,0,1,1,0,1},
			{1,0,3,3,4,5,-2,-2,0,1},
			{1,0,3,3,6,7,-2,-2,0,1},
			{1,0,-1,-1,-1,-1,-1,-1,0,1},
			{1,0,0,0,0,0,0,0,0,1},
			{2,1,1,1,1,1,1,1,1,2}
		};
	static int A [][] = new int[100][100];
	static int B [][] = new int[100][100];
	static int P [][] = new int[100][100];
	
	static void printsSubmatrixA (){
		for (i = 0, j = r; j < (m+r); i++, j++){
			for (k = 0, l = s; l < (n+s); k++, l++){
				A[i][k] = M[j][l];
			}
		}
		System.out.println("A");
		for (i = 0; i < m; i++){
			for (j = 0; j < n; j++){
				System.out.printf("%3d ",A[i][j]);
			}
			System.out.println("");
		}
	}
	
	static void printsSubmatrixB (){
		for (i = 0, j = u; j < (n+u); i++, j++){
			for (k = 0, l = v; l < (p+v); k++, l++){
				B[i][k] = M[j][l];
			}
		}
		System.out.println("B");
		for (i = 0; i < n; i++){
			for (j = 0; j < p; j++){
				System.out.printf("%3d ",B[i][j]);
			}
			System.out.println("");
		}
	}
	
	static void printsMatrixP (){
		int P[][] = new int[100][100];
		int ProductCounter = 0;
		for (i = 0; i < m; i++){
			for (j = 0; j < p; j++){
				for (k = 0; k < n; k++){
					ProductCounter += (A[i][k]*B[k][j]);
				}
				P[i][j] = ProductCounter;
				ProductCounter = 0;
			}
		}
		
		System.out.println("P");
		for (i = 0; i < m; i++){
			for (j = 0; j < p; j++){
				System.out.printf("%3d ",P[i][j]);
			}
			System.out.println("");
		}
	}
	
	public static void main (String[]args){
		//initializations of variables
		int t;
		
		//print Array M
		System.out.println("M");
		for (i = 0; i < 10; i++){
			for (j = 0; j < 10; j++){
				System.out.printf("%3d ",M[i][j]);
			}
			System.out.println("");
		}
		
		System.out.print("t = ");
		t = Scan.nextInt();
		
		if (t == 0){
			System.exit(0);
		}
		else if (t == 1){
			do{
				System.out.print("m = ");
				m = Scan.nextInt();
				System.out.print("n = ");
				n = Scan.nextInt();
				System.out.print("p = ");
				p = Scan.nextInt();
				System.out.print("r = ");
				r = Scan.nextInt();
				System.out.print("s = ");
				s = Scan.nextInt();
				System.out.print("u = ");
				u = Scan.nextInt();
				System.out.print("v = ");
				v = Scan.nextInt();
			
				printsSubmatrixA();
				printsSubmatrixB();
				printsMatrixP();
				
				System.out.print("t = ");
				t = Scan.nextInt();
			}while(t == 1);
		}
		else if (t == 2 || t ==3){
			//laboratory stuff
		}
	}
}
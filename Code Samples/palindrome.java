import java.util.*;
public class palindrome{
	static boolean isPalindrome(String s, int a, int b){
		int x = String.valueOf(s.charAt(a)).compareTo(String.valueOf(s.charAt(b)));
		if (a >= b)
			return true;
		else if (x != 0)
			return false;
		else
			return (isPalindrome(s, (a+1), (b-1)));
	}
	
	
	public static void main (String[]args){
		String test = "r a c eca r &&!#%$";
		String testnew = test.replaceAll("[^a-zA-Z]","");
		System.out.println(isPalindrome(testnew, 0, testnew.length()-1));
	}
}
public class Problem4 {
	public static void main(String[] args){
	//	System.out.println(new Problem4().isPalindrome("10001"));
		new Problem4().product2Digit();
	}
	public void product2Digit() {
		int start = 900, end = 999;
		int temp = 0;
		boolean stop = false;
		for(int i = end; i >= start && !stop; i-- ) {
			for(int j = end; j >= start && !stop; j--) {
				temp = i * j;
				if(isPalindrome(Integer.toString(temp))) {
					System.out.println(temp);
					stop = true;
				}
			}
		}
		
	}
	public boolean isPalindrome(String str) {
		int s = 0;
		int e = str.length()-1;
		int inc = 0;
		while(inc++ < str.length()/2) {
			if(str.charAt(s) != str.charAt(e)) return false; 
			s++; e--;
		}
		return true;
	}
}
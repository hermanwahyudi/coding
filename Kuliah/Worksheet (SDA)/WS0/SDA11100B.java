import java.util.Scanner;

public class SDA11100B{
    private static long[] ar;
    public static void main(String[] args){
	SDA11100B ws = new SDA11100B(new Scanner(System.in));
    }
    public SDA11100B(Scanner scan){
	    boolean ol = true;
	    int number = scan.nextInt();
	    if(number > 0 &&number<=1000)
	    { 
		ar = new long[number];
		for(int k = 0; k < ar.length && ol; k++){
		    ar[k] = scan.nextLong();
			ol = ar[k] <2000000000;
		}
		if(ol == true)
		{
			for(int i = 0; i <ar.length;i++)
			{
			  
			System.out.println(ar[i]*3);
			}
		}
	    }
    }
}

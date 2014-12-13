import java.util.Scanner;

public class SDA11100D{
    public static void main(String[] args){   
	new SDA11100D(new Scanner(System.in).nextInt());
    }
    public SDA11100D(int masukan){
	if(masukan >= 1 && masukan <= 20){ 
	    for(int i = masukan; i > 0; i--){
		for(int j = 0; j <= i-1; j++){
		    System.out.print("*");
		}
		System.out.println();
	    }
	}
    }
}
	 

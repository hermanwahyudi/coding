import java.util.*;

public class Latihan {
	public static void main(String[] args) {
		new Latihan().segitigaBintang(5);
		new Latihan().segitigaABC();
	}
	public void segitigaBintang(int N) {
		int M = N;
		for(int i = N; i > 0; i--) {
			for(int j = 0; j < M; j++) {
				System.out.print("*");
			}
			M--;
			System.out.println();
		}
	}
	public void segitigaABC() {
		int c = 65;
		int N = 8, M = 1;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(c == 91) {
					c = 65;
				}
				System.out.print((char) c++);
			}
			M++;
			System.out.println();
		}
	}
}
import java.io.*;

public class Terbilang
{
	private DataInputStream input;
	private String result;
	private String[] data = {"", "satu", "dua", "tiga", "empat", "lima", "enam", "tujuh", "delapan", "sembilan", "sepuluh", "sebelas"};
	public Terbilang() {
		input = new DataInputStream(System.in);
		result = "";
	}
	public void inputData() {
		int n;
		try {
			n = Integer.parseInt(input.readLine());
			result = terbilang(n);
		} catch(IOException e) { }
	}
	public void print() {
		System.out.println(result);
	}
	public String terbilang(int n) {
		if(n < 12) {
			return data[n];
		} else if(n < 20) {
			return terbilang(n%10) + " belas";
		} else if(n < 100) {
			return terbilang(n/10) + " puluh " + terbilang(n%10);
		} else if(n < 200) {
			return "seratus " + terbilang(n - 100);
		} else if(n < 1000) {
			return terbilang(n/100) + " ratus " + terbilang(n%100);
		} else if(n < 2000) {
			return "seribu " + terbilang(n - 1000);
		} else if(n < 1000000) {
			return terbilang(n/1000) + " ribu " + terbilang(n%1000);
		} else {
			return terbilang(n/1000000) + " juta " + terbilang(n%1000000);
		}
	}
	public static void main(String[] args) {
		Terbilang obj = new Terbilang();
		obj.inputData();
		obj.print();
	}
}
http://ideone.com/0LRir
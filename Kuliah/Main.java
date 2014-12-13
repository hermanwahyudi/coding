import java.io.*;
import java.util.*;

public class Main
{
	private DataInputStream baca;
	private int[][] arr;
	private int rows = 0, columns = 0, arrLength = 0;
	public Main() {
		baca = new DataInputStream(System.in);
	}
	public void inputData() {
		String in, s = "";
		StringTokenizer tok;
		try {
			in = baca.readLine();
			rows = columns = in.split(" ").length;
			arr = new int[rows][columns];
			arrLength = arr[0].length;
			for(int i = 0; i < rows; i++) {
				tok = new StringTokenizer(in);
				for(int j = 0; j < columns; j++) {
					arr[i][j] = Integer.parseInt(tok.nextToken());
				}
				if(rows-1 != i) {
					in = baca.readLine();
				}
			}
			printRelasi();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void printRelasi() {
		String result = "Relasi yang Anda masukan adalah R = {";
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				if(arr[i][j] == 1) {
					result += "{" + getElement(i) + "," + getElement(j) + "},";
				}
			}
		}
		result += result.substring(0,result.length()-1) + "}\n\n";
		if(isRefleksif())
			result += "Refleksif\n";
		if(isIrrefleksif())
			result += "Irrefleksif\n";
		if(isSimetri())
			result += "Simetri\n";
		if(isAntiSimetri())
			result += "Anti Simetri\n";
		if(isAsimetri())
			result += "Asimetri\n";
		if(isTransitif())
			result += "Transitif\n";
		result += "Penutup refleksi relasi input adalah " + closeRefleksifRelations() + "\n";
		result += "Penutup simetri relasi input adalah " + closeSimetriRelations() + "\n";
		result += "Penutup transitif relasi input adalah " + closeTransitifRelations() + "\n";
		result += partitionSet();
		System.out.println(result);
	}
	public String getElement(int i) {
		switch(i) {
			case 0 : return "a";
			case 1 : return "b";
			case 2 : return "c";
			case 3 : return "d";
			case 4 : return "e";
			case 5 : return "f";
			case 6 : return "g";
			case 7 : return "h";
			case 8 : return "i";
			case 9 : return "j";
			default : return "";
		}
	}
	public boolean isRefleksif(){
		boolean result = true;
		// Cek diagonal matrix
		for (int i = 0; i < arrLength; i++) {
			if (arr[i][i] == 1){
				// Jika diagonal sama dengan 1
				result = result && true;
			} else {
				result = false;
			}
		}
		return result;
	}
	public boolean isIrrefleksif(){
		boolean result = true;
		// Cek diagonal matrix
		for (int i = 0; i < arrLength; i++) {
			if (arr[i][i] == 1){
				// Jika diagonal sama dengan 1
				result = false;
			}
		}
		return result;
	}
	public boolean isSimetri() {
		boolean result = true;
		// Cek transpose Matrix
		for (int i = 0; i < arrLength; i++) {
			for (int j = 0; j < arrLength; j++) {
				if (arr[i][j] == arr[j][i]) {
					// Jika (a,b) ada maka (b,a) juga ada
					result = result && true;
				} else {
					result = false;
				}
			}
		}
		return result;
	}
	public boolean isAntiSimetri() {
		boolean result = true;
		// Cek transpose Matrix and identity
		for (int i = 0; i < arrLength; i++) {
			for (int j = 0; j < arrLength; j++) {
				if (arr[i][j] == 1 && arr[j][i] == 1 && i != j) {
					// Jika (a, b) ada maka (b, a) tidak boleh ada, (a, a) diperbolehkan
					result = false;
				}
			}
		}
		return result;
	}
	public boolean isAsimetri() {
		boolean result = true;
		// Cek transpose Matrix and identity
		for (int i = 0; i < arrLength; i++) {
			for (int j = 0; j < arrLength; j++) {
				if (arr[i][j] == 1 && arr[j][i] == 1) {
				// Jika (a, b) ada maka (b, a) tidak boleh ada, (a, a) tidak diperbolehkan
				result = false;
				}
			}
		}
		return result;
	}
	public boolean isTransitif() {
		boolean result = true;
		for (int i = 0; i < arrLength; i++) {
			for (int j = 0; j < arrLength; j++) {
				// For each element if (a, b) exist and (b, c) exist then (a, c) must exist
				for (int k = 0; k < arrLength; k++) {
					if (arr[i][j] == 1 && arr[j][k] == 1) {
						if (arr[i][k] == 1) {
							result = result && true;
						} else {
							result = false;
						}
					}
				}
			}
		}
		return result;
	}
	public String closeRefleksifRelations() {
		String result = "{";
		for (int i = 0; i < arrLength; i++) {
			if (arr[i][i] == 0){
				// Jika diagonal sama dengan 0
				result += "{" + getElement(i) + "," + getElement(i) + "},";
			}
		}
		return (result.length() != 0)? result.substring(0, result.length() - 1) + "}": "null";
	}
	public String closeSimetriRelations() {
		String result = "{";
		for (int i = 0; i < arrLength; i++) {
			for (int j = 0; j < arrLength; j++) {
				if (arr[i][j] == 1 && arr[j][i] == 0) {
					// Jika (a,b) ada maka (b,a) juga ada
					result += "{" + getElement(j) + "," + getElement(i) + "},";
				}
			}
		}
		return (result.length() != 0)? result.substring(0, result.length() - 1) + "}": "null";
	}
	public String closeTransitifRelations() {
		String result = "{";
		int[][] temp = arr.clone();
		while (!isTransitif()) {
			for (int i = 0; i < arrLength; i++) {
				for (int j = 0; j < arrLength; j++) {
					// For each element if (a, b) exist and (b, c) exist then (a, c) must exist
					for (int k = 0; k < arrLength; k++) {
						if (arr[i][j] == 1 && arr[j][k] == 1 && arr[i][k] == 0) {
							arr[i][k] = 1;
							result += "{" + getElement(i) + "," + getElement(k) + "},";
						}
					}
				}
			}
		}
		arr = temp;
		return (result.length() != 0)? result.substring(0, result.length() - 1) + "}": "null";
	}
	public boolean isEquivalen() {
		return isRefleksif() && isSimetri() && isTransitif();
	}
	public String partitionSet() {
		String result = "";
		if (!isEquivalen()) {
			return "Not Equivalen Relation";
		}
		boolean[] status = new boolean[arrLength];
		for (int i = 0; i < arrLength; i++) {
			for (int j = 0; j < arrLength; j++) {
				if (arr[i][j] == 1 && !status[j]) {
					status[j] = true;
					result += j + ",";
				}
			}
			result = result.substring(0, result.length() - 1);
			result += "\n";
		}
		return result;
	}
	public static void main(String[] args) {
		new Main().inputData();
	}
}
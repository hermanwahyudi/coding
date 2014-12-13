import java.io.*;

public class SearchRoom
{
	private DataInputStream baca;
	private char[][] c;
	private int baris, kolom;
	public SearchRoom() {
		baca = new DataInputStream(System.in);
		this.baris = 0;
		this.kolom = 0;
	}
	public void inputData() {
		String[] s;
		try {
			s = baca.readLine().split(" ");
			baris = Integer.parseInt(s[0]);
			kolom = Integer.parseInt(s[1]);
			c = new char[baris][kolom];
			s = baca.readLine().split(" ");
			for(int i = 0; i < baris; i++) {
				String str = baca.readLine();
				for(int j = 0; j < kolom; j++) {
					c[i][j] = str.charAt(j);
				}
			}
			searchRoom(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void searchRoom(int i, int j) {
		if(i - 1 >= 0 && j < c[0].length && (c[i-1][j] == '-' || c[i-1][j] == 'K')) {
			c[i][j] = ' ';
			if(c[i-1][j] == 'K') {
				return;
			}
			searchRoom(i-1, j);
		}
		else if(i >= 0 && j + 1 < c[0].length && (c[i][j+1] == '-' || c[i][j+1] == 'K')) {
			c[i][j] = ' ';
			if(c[i][j+1] == 'K') {
				return;
			}
			searchRoom(i, j+1);
		}
		else if(i + 1 < baris && j < c[0].length && (c[i+1][j] == '-' || c[i+1][j] == 'K')) {
			c[i][j] = ' ';
			if(c[i+1][j] == 'K') {
				return;
			}
			searchRoom(i+1, j);
		}
		else if(i >= 0 && j - 1 >= 0 && (c[i][j-1] == '-' || c[i][j-1] == 'K')) {
			c[i][j] = ' ';
			if(c[i][j-1] == 'K') {
				return;
			}
			searchRoom(i, j-1);
		}

		//Jalan Buntu
		else if(i - 1 >= 0 && j < c[0].length && (c[i-1][j] == ' ' || c[i-1][j] == 'K')) {
			c[i][j] = 'x';
			if(c[i-1][j] == 'K') {
				return;
			}
			searchRoom(i-1, j);
		}
		else if(i >= 0 && j + 1 < c[0].length && (c[i][j+1] == ' ' || c[i][j+1] == 'K')) {
			c[i][j] = 'x';
			if(c[i][j+1] == 'K') {
				return;
			}
			searchRoom(i, j+1);
		}
		else if(i + 1 <= baris && j < c[0].length && (c[i+1][j] == ' ' || c[i+1][j] == 'K')) {
			c[i][j] = 'x';
			if(c[i+1][j] == 'K') {
				return;
			}
			searchRoom(i+1, j);
		}
		else if(i >= 0 && j - 1 >= 0 && (c[i][j-1] == ' ' || c[i][j-1] == 'K')) {
			c[i][j] = 'x';
			if(c[i][j-1] == 'K') {
				return;
			}
			searchRoom(i, j-1);
		}
	}
	public void printRute(int i, int j) {
		if(i - 1 >= 0 && j < c[0].length && (c[i-1][j] == ' ' || c[i-1][j] == 'K')) {
			c[i][j] = '0';
			System.out.print("U");
			printRute(i-1, j);
		}
		else if(i >= 0 && j + 1 < c[0].length && (c[i][j+1] == ' ' || c[i][j+1] == 'K')) {
			c[i][j] = '0';
			System.out.print("T");
			printRute(i, j+1);
		}
		else if(i + 1 < baris && j < c[0].length && (c[i+1][j] == ' ' || c[i+1][j] == 'K')) {
			c[i][j] = '0';
			System.out.print("S");
			printRute(i+1, j);
		}
		else if(i >= 0 && j - 1 >= 0 && (c[i][j-1] == ' ' || c[i][j-1] == 'K')) {
			c[i][j] = '0';
			System.out.print("B");
			printRute(i, j-1);
		}
	}
	public void print() {
		for(int i = 0; i < baris; i++) {
			for(int j = 0; j < kolom; j++) {
				System.out.print(c[i][j]);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		SearchRoom obj = new SearchRoom();
		obj.inputData();
		System.out.println();
		obj.print();
		System.out.println();
		obj.printRute(0, 5);
	}
}
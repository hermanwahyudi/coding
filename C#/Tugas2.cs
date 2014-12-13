using System;
using System.IO;

namespace DDP2011
{
	public class Tugas2
	{
		private int field;
		private char[,] data;
		private Random r = new Random();
		private bool stop;
		public Tugas2() {
			this.field = 0;
			this.stop = false;
		}
		public void solve() {
			Console.Write("Masukan ukuran field: ");
			try {
				field = int.Parse(Console.ReadLine());
				data = new char[field,field];
				int ranjau = random();
				int notRanjau = field * field - ranjau;
				int count = 0;
				string coordinat = "";
				if(ranjau >= field+1 && ranjau <= field * (field - 1)) {
					while(!stop) {
						display(coordinat);
						Console.WriteLine("Jumlah Ranjau: {0}", ranjau);
						Console.Write("Pilih Posis: ");
						coordinat = Console.ReadLine();
						stop = answer(int.Parse("" + coordinat[0])-1, int.Parse("" + coordinat[1])-1);
						if(!stop) count++;
						else {
							gameover();
							Console.WriteLine("Anda Gagal!");
						}
						if(count == notRanjau) {
							win();
							stop = true;
							Console.WriteLine("Selamat Anda Memenangkan Permainan Ini!");
						}
					}
				} else {
					Console.WriteLine("Banyak ranjau melebihi atau lebih kecil dari field!\nRanjau -> {0}", ranjau);
				}
			} catch(Exception) {
				Console.WriteLine("Error!");
			}
		}
		public void display(string coordinat) {
			for(int i = 0; i < field; i++) {
				for(int j = 0; j < field; j++) {
					if(coordinat.Length != 0) {
						int m = int.Parse("" + coordinat[0])-1;
						int n = int.Parse("" + coordinat[1])-1;
						if(m == i && n == j) {
							Console.Write("o  ");
							data[m,n] = '1';
						} else {
							if(data[i,j] == '1') {
								Console.Write("o  ");
							} else Console.Write("{0}{1} ", i+1, j+1);
						}
					} else Console.Write("{0}{1} ", i+1, j+1);
				}
				Console.WriteLine();
			}
		}
		public int random() {
			int jumlahRanjau = 0;
			int k;
			for(int i = 0; i < field; i++) {
				for(int j = 0; j < field; j++) {
					k = r.Next(2);
					if(k == 1) {
						data[i,j] = 'x';
						jumlahRanjau++;
					} else data[i,j] = 'o';
				}
			}
			return jumlahRanjau;
		}
		public bool answer(int i, int j) {
			return (data[i,j] == 'x') ? true : false;
		}
		public void gameover() {
			for(int i = 0; i < field; i++) {
				for(int j = 0; j < field; j++) {
					if(data[i,j] == '1') Console.Write("o  ");
					else if(data[i,j] == 'x') {
						Console.Write("{0}  ", data[i,j]);
					} else Console.Write("{0}{1} ", i+1, j+1);
				}
				Console.WriteLine();
			}
		}
		public void win() {
			for(int i = 0; i < field; i++) {
				for(int j = 0; j < field; j++) {
					if(data[i,j] == '1' || data[i,j] == 'o') {
						Console.Write("o ");
					} else Console.Write("x ");
				}
				Console.WriteLine();
			}
		}
		public static void Main() {
			Tugas2 obj = new Tugas2();
			obj.solve();

		}
	}
}
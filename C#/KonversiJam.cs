using System;
using System.Windows.Forms;

namespace Test {
	class KonversiJam
	{
		private int detik;
		public KonversiJam() {
			this.detik = 0;
		}
		public static void Main() {
			KonversiJam obj = new KonversiJam();
			obj.detik = int.Parse(Console.ReadLine());
			obj.ConvertToTime(obj.detik);
		}
		public void ConvertToTime(int detik) {
			int jam, menit;
			jam   = detik/3600;
			menit = (detik%3600)/60;
			detik = detik%60;
			
			MessageBox.Show(jam + " : " + menit + " : " + detik);
		}
	}
}
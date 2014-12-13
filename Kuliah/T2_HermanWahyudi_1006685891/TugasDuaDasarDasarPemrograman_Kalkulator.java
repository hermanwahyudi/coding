/***************************************************************************************************************************************************************************************************************************************************************************/
/*  Nama			: Herman Wahyudi
 *  NPM			: 1006685891
 *  Mata Kuliah 	: Dasar-dasar Pemrograman (6 SKS)
 *  Fakultas    	: Ilmu Komputer, Universitas Indonesia
 *  Dosen		: Drs. Lim Yohanes Stefanus M.Math., Ph.D
 */														   														   */
/***************************************************************************************************************************************************************************************************************************************************************************/

//package java.util dan memakai Class Scanner
import java.util.Scanner;

public class TugasDuaDasarDasarPemrograman_Kalkulator //Nama class
{
    public static void main(String[] args)
    {
	// Deklarasi variabel pilih operator dan pilih memori dengan tipe Integer
	int pilihOperator = 0; int pilihMemori = 0;

	//Delarasi variabel hasil/input dan Inialisasi
	double hasil = 0; double inputPertama = 0; double inputKedua = 0; double pindahInput = 0;

	//Deklarasi variabel Memori dan Inialisasi
	double MemoriSatu = 0; double MemoriDua = 0;   double MemoriTiga = 0;    double MemoriEmpat = 0;    double MemoriLima = 0;
	double MemoriEnam = 0; double MemoriTujuh = 0; double MemoriDelapan = 0; double MemoriSembilan = 0; double MemoriSepuluh = 0;

	Scanner input = new Scanner(System.in);

	//Masukan bilangan pertama dan tidak diikutsertakan lagi di dalam looping
	System.out.print("Masukan bilangan (dari memory: M[Lokasi_Memory]): ");

	inputPertama = input.nextDouble();
	pindahInput = inputPertama;
	hasil = pindahInput;
	pindahInput = hasil;

	System.out.println("\nJumlah: " + pindahInput + "\n");

	for(int Ulang = 1; Ulang > 0 ;Ulang++) //Looping akan terus berjalan, jika kita memberi masukan Ulang < 0 maka looping akan berhenti
	{
	    System.out.print("1. Tambah \n2. Kurang \n3. Kali \n4. Bagi \n5. Simpan ke Memory \n6. Hapus Display \n7. Keluar");
	    System.out.print("\nPilihan Anda: "); //Pilih Operator
	    pilihOperator = input.nextInt();
	    if(pilihOperator == 1) //Jika memilih operator 2 dan bukan 1, 3, 4, 5, 6, 7
	    {
		System.out.print("Masukan bilangan (dari memory: M[Lokasi_Memory]): ");
		String masuk = input.next();

		//Masukan pertama adalah String dan jika masuknya adalah Bilangan maka akan dikonversi ke Double, jika tidak akan memilih M1 atau s/d M10
		if(masuk.equals(masuk) && !masuk.equals("M0") && !masuk.equals("M1") && !masuk.equals("M2") && !masuk.equals("M3") && !masuk.equals("M4") && !masuk.equals("M5") && !masuk.equals("M6") && !masuk.equals("M7") && !masuk.equals("M8") && !masuk.equals("M9"))
		{
		    inputKedua = Double.parseDouble(masuk); System.out.print("" + pindahInput + " + " + inputKedua + " = " + (pindahInput+inputKedua) + "\n");
		    hasil = (pindahInput+inputKedua); System.out.print("\nJumlah: " + hasil + "\n\n");
		    pindahInput = hasil; }  //hasil akan tersimpan ke pindahInput agar terus dioperasikan ke operator berikutnya
		 else if(masuk.equals("M0")){ hasil = (pindahInput+MemoriSatu);    System.out.print("" + pindahInput + " + " + MemoriSatu     + " = " + hasil + "\n\n"); System.out.print("Jumlah: " + hasil + "\n\n"); pindahInput = hasil; }
		 else if(masuk.equals("M1")){ hasil = (pindahInput+MemoriDua);     System.out.print("" + pindahInput + " + " + MemoriDua      + " = " + hasil + "\n\n"); System.out.print("Jumlah: " + hasil + "\n\n"); pindahInput = hasil; }
		 else if(masuk.equals("M2")){ hasil = (pindahInput+MemoriTiga);    System.out.print("" + pindahInput + " + " + MemoriTiga     + " = " + hasil + "\n\n"); System.out.print("Jumlah: " + hasil + "\n\n"); pindahInput = hasil; }
		 else if(masuk.equals("M3")){ hasil = (pindahInput+MemoriEmpat);   System.out.print("" + pindahInput + " + " + MemoriEmpat    + " = " + hasil + "\n\n"); System.out.print("Jumlah: " + hasil + "\n\n"); pindahInput = hasil; }
		 else if(masuk.equals("M4")){ hasil = (pindahInput+MemoriLima);    System.out.print("" + pindahInput + " + " + MemoriLima     + " = " + hasil + "\n\n"); System.out.print("Jumlah: " + hasil + "\n\n"); pindahInput = hasil; }
		 else if(masuk.equals("M5")){ hasil = (pindahInput+MemoriEnam);    System.out.print("" + pindahInput + " + " + MemoriEnam     + " = " + hasil + "\n\n"); System.out.print("Jumlah: " + hasil + "\n\n"); pindahInput = hasil; }
		 else if(masuk.equals("M6")){ hasil = (pindahInput+MemoriTujuh);   System.out.print("" + pindahInput + " + " + MemoriTujuh    + " = " + hasil + "\n\n"); System.out.print("Jumlah: " + hasil + "\n\n"); pindahInput = hasil; }
		 else if(masuk.equals("M7")){ hasil = (pindahInput+MemoriDelapan); System.out.print("" + pindahInput + " + " + MemoriDelapan  + " = " + hasil + "\n\n"); System.out.print("Jumlah: " + hasil + "\n\n"); pindahInput = hasil; }
		 else if(masuk.equals("M8")){ hasil = (pindahInput+MemoriSembilan);System.out.print("" + pindahInput + " + " + MemoriSembilan + " = " + hasil + "\n\n"); System.out.print("Jumlah: " + hasil + "\n\n"); pindahInput = hasil; }
		 else if(masuk.equals("M9")){ hasil = (pindahInput+MemoriSepuluh); System.out.print("" + pindahInput + " + " + MemoriSepuluh  + " = " + hasil + "\n\n"); System.out.print("Jumlah: " + hasil + "\n\n"); pindahInput = hasil; }
	    }
	    else if(pilihOperator == 2) //Jika memilih operator 2 dan bukan 1, 3, 4, 5, 6, 7
	    {
		System.out.print("Masukan bilangan (dari memory: M[Lokasi_Memory]): ");
		String masuk = input.next();

		//Masukan pertama adalah String dan jika masuknya adalah Bilangan maka akan dikonversi ke Double, jika tidak akan memilih M1 atau s/d M10
		if(masuk.equals(masuk) && !masuk.equals("M0") && !masuk.equals("M1") && !masuk.equals("M2") && !masuk.equals("M3") && !masuk.equals("M4") && !masuk.equals("M5") && !masuk.equals("M6") && !masuk.equals("M7") && !masuk.equals("M8") && !masuk.equals("M9"))
		{
		    inputKedua = Double.parseDouble(masuk); System.out.print("" + pindahInput + " - " + inputKedua + " = " + (pindahInput-inputKedua) + "\n");
		    hasil = (pindahInput-inputKedua); System.out.print("\nJumlah: " + hasil + "\n\n");
		    pindahInput = hasil; }  //hasil akan tersimpan ke pindahInput agar terus dioperasikan ke operator berikutnya
		 else if(masuk.equals("M0")){ hasil = (pindahInput-MemoriSatu);     System.out.print("" + pindahInput + " - " + MemoriSatu     + " = " + hasil + "\n\n"); System.out.print("Jumlah: " + hasil + "\n\n"); pindahInput = hasil; }
		 else if(masuk.equals("M1")){ hasil = (pindahInput-MemoriDua);      System.out.print("" + pindahInput + " - " + MemoriDua      + " = " + hasil + "\n\n"); System.out.print("Jumlah: " + hasil + "\n\n"); pindahInput = hasil; }
		 else if(masuk.equals("M2")){ hasil = (pindahInput-MemoriTiga);     System.out.print("" + pindahInput + " - " + MemoriTiga     + " = " + hasil + "\n\n"); System.out.print("Jumlah: " + hasil + "\n\n"); pindahInput = hasil; }
		 else if(masuk.equals("M3")){ hasil = (pindahInput-MemoriEmpat);    System.out.print("" + pindahInput + " - " + MemoriEmpat    + " = " + hasil + "\n\n"); System.out.print("Jumlah: " + hasil + "\n\n"); pindahInput = hasil; }
		 else if(masuk.equals("M4")){ hasil = (pindahInput-MemoriLima);     System.out.print("" + pindahInput + " - " + MemoriLima     + " = " + hasil + "\n\n"); System.out.print("Jumlah: " + hasil + "\n\n"); pindahInput = hasil; }
		 else if(masuk.equals("M5")){ hasil = (pindahInput-MemoriEnam);     System.out.print("" + pindahInput + " - " + MemoriEnam     + " = " + hasil + "\n\n"); System.out.print("Jumlah: " + hasil + "\n\n"); pindahInput = hasil; }
		 else if(masuk.equals("M6")){ hasil = (pindahInput-MemoriTujuh);    System.out.print("" + pindahInput + " - " + MemoriTujuh    + " = " + hasil + "\n\n"); System.out.print("Jumlah: " + hasil + "\n\n"); pindahInput = hasil; }
		 else if(masuk.equals("M7")){ hasil = (pindahInput-MemoriDelapan);  System.out.print("" + pindahInput + " - " + MemoriDelapan  + " = " + hasil + "\n\n"); System.out.print("Jumlah: " + hasil + "\n\n"); pindahInput = hasil; }
		 else if(masuk.equals("M8")){ hasil = (pindahInput-MemoriSembilan); System.out.print("" + pindahInput + " - " + MemoriSembilan + " = " + hasil + "\n\n"); System.out.print("Jumlah: " + hasil + "\n\n"); pindahInput = hasil; }
		 else if(masuk.equals("M9")){ hasil = (pindahInput-MemoriSepuluh);  System.out.print("" + pindahInput + " - " + MemoriSepuluh  + " = " + hasil + "\n\n"); System.out.print("Jumlah: " + hasil + "\n\n"); pindahInput = hasil; }
	    }
	    else if(pilihOperator == 3) //Jika memilih operator 2 dan bukan 1, 3, 4, 5, 6, 7
	    {
		System.out.print("Masukan bilangan (dari memory: M[Lokasi_Memory]): ");
		String masuk = input.next();

		//Masukan pertama adalah String dan jika masuknya adalah Bilangan maka akan dikonversi ke Double, jika tidak akan memilih M1 atau s/d M10
		if(masuk.equals(masuk) && !masuk.equals("M0") && !masuk.equals("M1") && !masuk.equals("M2") && !masuk.equals("M3") && !masuk.equals("M4") && !masuk.equals("M5") && !masuk.equals("M6") && !masuk.equals("M7") && !masuk.equals("M8") && !masuk.equals("M9"))
		{
		    inputKedua = Double.parseDouble(masuk); System.out.print("" + pindahInput + " x " + inputKedua + " = " + (pindahInput*inputKedua) + "\n");
		    hasil = (pindahInput*inputKedua); System.out.print("\nJumlah: " + hasil + "\n\n");
		    pindahInput = hasil; }  //hasil akan tersimpan ke pindahInput agar terus dioperasikan ke operator berikutnya
		 else if(masuk.equals("M0")){ hasil = (pindahInput*MemoriSatu);     System.out.print("" + pindahInput + " x " + MemoriSatu     + " = " + hasil + "\n\n"); System.out.print("Jumlah: " + hasil + "\n\n"); pindahInput = hasil; }
		 else if(masuk.equals("M1")){ hasil = (pindahInput*MemoriDua);      System.out.print("" + pindahInput + " x " + MemoriDua      + " = " + hasil + "\n\n"); System.out.print("Jumlah: " + hasil + "\n\n"); pindahInput = hasil; }
		 else if(masuk.equals("M2")){ hasil = (pindahInput*MemoriTiga);     System.out.print("" + pindahInput + " x " + MemoriTiga     + " = " + hasil + "\n\n"); System.out.print("Jumlah: " + hasil + "\n\n"); pindahInput = hasil; }
		 else if(masuk.equals("M3")){ hasil = (pindahInput*MemoriEmpat);    System.out.print("" + pindahInput + " x " + MemoriEmpat    + " = " + hasil + "\n\n"); System.out.print("Jumlah: " + hasil + "\n\n"); pindahInput = hasil; }
		 else if(masuk.equals("M4")){ hasil = (pindahInput*MemoriLima);     System.out.print("" + pindahInput + " x " + MemoriLima     + " = " + hasil + "\n\n"); System.out.print("Jumlah: " + hasil + "\n\n"); pindahInput = hasil; }
		 else if(masuk.equals("M5")){ hasil = (pindahInput*MemoriEnam);     System.out.print("" + pindahInput + " x " + MemoriEnam     + " = " + hasil + "\n\n"); System.out.print("Jumlah: " + hasil + "\n\n"); pindahInput = hasil; }
		 else if(masuk.equals("M6")){ hasil = (pindahInput*MemoriTujuh);    System.out.print("" + pindahInput + " x " + MemoriTujuh    + " = " + hasil + "\n\n"); System.out.print("Jumlah: " + hasil + "\n\n"); pindahInput = hasil; }
		 else if(masuk.equals("M7")){ hasil = (pindahInput*MemoriDelapan);  System.out.print("" + pindahInput + " x " + MemoriDelapan  + " = " + hasil + "\n\n"); System.out.print("Jumlah: " + hasil + "\n\n"); pindahInput = hasil; }
		 else if(masuk.equals("M8")){ hasil = (pindahInput*MemoriSembilan); System.out.print("" + pindahInput + " x " + MemoriSembilan + " = " + hasil + "\n\n"); System.out.print("Jumlah: " + hasil + "\n\n"); pindahInput = hasil; }
		 else if(masuk.equals("M9")){ hasil = (pindahInput*MemoriSepuluh);  System.out.print("" + pindahInput + " x " + MemoriSepuluh  + " = " + hasil + "\n\n"); System.out.print("Jumlah: " + hasil + "\n\n"); pindahInput = hasil; }
	    }
	    else if(pilihOperator == 4) //Jika memilih operator 2 dan bukan 1, 3, 4, 5, 6, 7
	    {
		System.out.print("Masukan bilangan (dari memory: M[Lokasi_Memory]): ");
		String masuk = input.next();

		//Masukan pertama adalah String dan jika masuknya adalah Bilangan maka akan dikonversi ke Double, jika tidak akan memilih M1 atau s/d M10
		if(masuk.equals(masuk) && !masuk.equals("M0") && !masuk.equals("M1") && !masuk.equals("M2") && !masuk.equals("M3") && !masuk.equals("M4") && !masuk.equals("M5") && !masuk.equals("M6") && !masuk.equals("M7") && !masuk.equals("M8") && !masuk.equals("M9"))
		{
		    inputKedua = Double.parseDouble(masuk); System.out.print("" + pindahInput + " : " + inputKedua + " = " + (pindahInput/inputKedua) + "\n");
		    hasil = (pindahInput/inputKedua); System.out.print("\nJumlah: " + hasil + "\n\n");
		    pindahInput = hasil; }  //hasil akan tersimpan ke pindahInput agar terus dioperasikan ke operator berikutnya
		 else if(masuk.equals("M0")){ hasil = (pindahInput/MemoriSatu);     System.out.print("" + pindahInput + " : " + MemoriSatu     + " = " + hasil + "\n\n"); System.out.print("Jumlah: " + hasil + "\n\n"); pindahInput = hasil; }
		 else if(masuk.equals("M1")){ hasil = (pindahInput/MemoriDua);      System.out.print("" + pindahInput + " : " + MemoriDua      + " = " + hasil + "\n\n"); System.out.print("Jumlah: " + hasil + "\n\n"); pindahInput = hasil; }
		 else if(masuk.equals("M2")){ hasil = (pindahInput/MemoriTiga);     System.out.print("" + pindahInput + " : " + MemoriTiga     + " = " + hasil + "\n\n"); System.out.print("Jumlah: " + hasil + "\n\n"); pindahInput = hasil; }
		 else if(masuk.equals("M3")){ hasil = (pindahInput/MemoriEmpat);    System.out.print("" + pindahInput + " : " + MemoriEmpat    + " = " + hasil + "\n\n"); System.out.print("Jumlah: " + hasil + "\n\n"); pindahInput = hasil; }
		 else if(masuk.equals("M4")){ hasil = (pindahInput/MemoriLima);     System.out.print("" + pindahInput + " : " + MemoriLima     + " = " + hasil + "\n\n"); System.out.print("Jumlah: " + hasil + "\n\n"); pindahInput = hasil; }
		 else if(masuk.equals("M5")){ hasil = (pindahInput/MemoriEnam);     System.out.print("" + pindahInput + " : " + MemoriEnam     + " = " + hasil + "\n\n"); System.out.print("Jumlah: " + hasil + "\n\n"); pindahInput = hasil; }
		 else if(masuk.equals("M6")){ hasil = (pindahInput/MemoriTujuh);    System.out.print("" + pindahInput + " : " + MemoriTujuh    + " = " + hasil + "\n\n"); System.out.print("Jumlah: " + hasil + "\n\n"); pindahInput = hasil; }
		 else if(masuk.equals("M7")){ hasil = (pindahInput/MemoriDelapan);  System.out.print("" + pindahInput + " : " + MemoriDelapan  + " = " + hasil + "\n\n"); System.out.print("Jumlah: " + hasil + "\n\n"); pindahInput = hasil; }
		 else if(masuk.equals("M8")){ hasil = (pindahInput/MemoriSembilan); System.out.print("" + pindahInput + " : " + MemoriSembilan + " = " + hasil + "\n\n"); System.out.print("Jumlah: " + hasil + "\n\n"); pindahInput = hasil; }
		 else if(masuk.equals("M9")){ hasil = (pindahInput/MemoriSepuluh);  System.out.print("" + pindahInput + " : " + MemoriSepuluh  + " = " + hasil + "\n\n"); System.out.print("Jumlah: " + hasil + "\n\n"); pindahInput = hasil; }
	    }
	    else if(pilihOperator == 5){ //Jika memilih operator 5 dan bukan 2, 3, 4, 1, 6, 7 dan akan memilih memori 0 atau s/d 9
		System.out.print("Pilih Lokasi Memory(0-9): " );
		pilihMemori = input.nextInt();
		if(pilihMemori == 0){ MemoriSatu = hasil; System.out.print("Jumlah Tersimpan!\n\n"); System.out.print("Jumlah: " + MemoriSatu  + "\n\n"); }
		else if(pilihMemori == 1){ MemoriDua      = hasil; System.out.print("Jumlah Tersimpan!\n\n"); System.out.print("Jumlah: " + MemoriDua      + "\n\n"); }
		else if(pilihMemori == 2){ MemoriTiga     = hasil; System.out.print("Jumlah Tersimpan!\n\n"); System.out.print("Jumlah: " + MemoriTiga     + "\n\n"); }
		else if(pilihMemori == 3){ MemoriEmpat    = hasil; System.out.print("Jumlah Tersimpan!\n\n"); System.out.print("Jumlah: " + MemoriEmpat    + "\n\n"); }
		else if(pilihMemori == 4){ MemoriLima     = hasil; System.out.print("Jumlah Tersimpan!\n\n"); System.out.print("Jumlah: " + MemoriLima     + "\n\n"); }
		else if(pilihMemori == 5){ MemoriEnam     = hasil; System.out.print("Jumlah Tersimpan!\n\n"); System.out.print("Jumlah: " + MemoriEnam     + "\n\n"); }
		else if(pilihMemori == 6){ MemoriTujuh    = hasil; System.out.print("Jumlah Tersimpan!\n\n"); System.out.print("Jumlah: " + MemoriTujuh    + "\n\n"); }
		else if(pilihMemori == 7){ MemoriDelapan  = hasil; System.out.print("Jumlah Tersimpan!\n\n"); System.out.print("Jumlah: " + MemoriDelapan  + "\n\n"); }
		else if(pilihMemori == 8){ MemoriSembilan = hasil; System.out.print("Jumlah Tersimpan!\n\n"); System.out.print("Jumlah: " + MemoriSembilan + "\n\n"); }
		else if(pilihMemori == 9){ MemoriSepuluh  = hasil; System.out.print("Jumlah Tersimpan!\n\n"); System.out.print("Jumlah: " + MemoriSepuluh  + "\n\n"); }
	    }
	    else if(pilihOperator == 6){ hasil = 0; System.out.print("\nJumlah: " + hasil + "\n\n"); pindahInput = hasil; } //Jika memilih operator 6 dan hasil akan di assignment NOL
	    else if(pilihOperator == 7){ Ulang = -1; System.out.print("Bye!"); } //Looping akan berhenti jika di Ulang di assignment = -1
	}
   }
}
/****************************************************************************************************************** Alhamdulillah *************************************************************************************************************************************************************/

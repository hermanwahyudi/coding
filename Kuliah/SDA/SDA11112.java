/*
 * SDA11112, MasukanKeluaran, PembandingBanyakKluster, Kluster, FaceLangUser, PembandingKluster
 *
 * Version:
 * - 1.0 (31-05-2011): develop SDA11112, MasukanKeluaran, FaceLangUser.
 * - 2.0 (02-06-2011): develop Kluster, PembandingKluster.
 * - 3.0 (04-06-2011): develop PembandingBanyakKluster
 *
 * Copyright 2011 Herman Wahyudi.
 */


import java.io.DataInputStream;
import java.io.BufferedWriter;
import java.io.InputStreamReader;;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Arrays;
import java.util.Set;


/**
  * Kelas SDA11112 mempresentasikan menjalankan semua metode, peubah
  * dan konstruktor dari kelas-kelas lain.
  *
  * @author Herman Wahyudi (1006685891)
  * Kolaborator : Randy Lukmana
  *				Mohd Irfan Nasution
  *				Aditya Rahman Ananda
  */

public class SDA11112
{
	/** Mebuat objek dari kelas MasukanKeluaran agar biss megeksekusi metode-metode didalam kelas tersebut */
    MasukanKeluaran io = new MasukanKeluaran();

	//Constructor(s)

	/**
	  * Menjalankan metode masukan dan mencetak keluaran dari kelas MasukanKeluaran
	  */
    public SDA11112() {
		try {
			io.dataMasukan(); //Membaca masukan teman, cetak kluster, terbesar, mutual, dan temankluster
			io.dataKeluaran(); // Mencetak keluaran cetak kluster, terbesar, mutual, dan temankluster
		 } catch(IOException e) {
			e.printStackTrace(); //Jika ada yang error akan ditangkap
		}
    }

	/**
	  * Metode main akan memerintahkan semua metode dikelas lain.
	  */
    public static void main(String[] args) {
		SDA11112 sda = new SDA11112();
    }
}


/**
  * Kelas MasukanKeluaran akan mempresentasikan masukan-masukan yang diberikan dan mencetak keluran yang diperintahkan masukan
  */
class MasukanKeluaran extends Kluster
{
	/** Membuat objek membaca masukan dari kelas DataInputStream */
    DataInputStream baca;
	/** Membuat objek mencetak keluaran dari kelas BufferedWriter */
    BufferedWriter tulis;
	/** Membuat objek antrian berdasarkan prioritas terbesar */
	PriorityQueue<Kluster> prioritasTerbesar;
	/** Membuat objek himppunan untuk memetakan kluster-kluster yang dibuat */
    HashMap<Integer, Kluster> himpunan;
	/** Variabel orangPertamaFace dan orangKeduaFace untuk mengecek teman-teman yang sama  */
	FaceLangUser orangPertamaFace, orangKeduaFace;
	/**  Variabel ini untuk menghitung ID setiap kluster */
    int konektor = 0;


	//Constructor(s)

	/**
	  * Membangun objek-objek dari kelas DataInputStream
	  * BufferedWriter, PriorityQueue, dan HashMap
	  */
    public MasukanKeluaran() {
		baca = new DataInputStream(System.in);
		tulis = new BufferedWriter(new OutputStreamWriter(System.out));
		himpunan = new HashMap<Integer, Kluster>();
		prioritasTerbesar = new PriorityQueue<Kluster>(1000, new PembandingKluster());
    }

	//Method(s)

	/**
	  * Method ini berguna untuk membaca perintah dari konsole.
	  */
    public void dataMasukan() throws IOException {
		StringTokenizer token; //Untuk memecah perintah denagn delimiter adalah spasi
		String masukan = baca.readLine(); // Membaca dari konsole
		while(masukan != null) {
			token = new StringTokenizer(masukan);
			if(token.countTokens() == 3) { //Jika panjang token adalah tiga seperti teman A B, dan mutual A B
				String str1 = token.nextToken();
				String str2 = token.nextToken();
				String str3 = token.nextToken();
				if(str1.equals("teman")) {
					tambahKoneksi(str2, str3); //akan memerintahkan method tambah koneksi dari orang pertama dan orang kedua
				}
				else if(str1.equals("mutual")) {
					tulis.write("" + cetakMutual(str2, str3)); //akan memerintahkan method mutual dan mencetak mutual dari orang pertama dan kedua
				}
			}
			else if(token.countTokens() == 2) { //jika panjang token adalah 2, seperti cetak terbesar, cetak kluster, dan cetak teman kluster
				String str1 = token.nextToken();
				String str2 = token.nextToken();
				if(str2.equals("kluster")) {
					tulis.write("" + cetakKluster()); //akan memerintahkan method cetak kluster untuk mencetak banyaknya kluster
				}
				else if(str2.equals("temankluster")) {
					tulis.write("" + cetakBertemanDenganSemua()); //akan memerintahkan method snggota kluster yang berteman dengan semua anggota
				}
				else if(str2.equals("terbesar")) { // akan mencetak kluster yang anggotanya terbesar
					Set<Integer> setInt = himpunan.keySet();
					Integer[] arInt = setInt.toArray(new Integer[0]);
					for(int i = 0; i < arInt.length; i++) {
						prioritasTerbesar.add(himpunan.get(arInt[i]));
					}
					tulis.write((!prioritasTerbesar.isEmpty()) ?  "" + prioritasTerbesar.poll().kumpulanAnggotaKluster() + "\n" : "\n");
				}
			}
			masukan = baca.readLine(); //Membaca terus sampai null
		}
	}

	/**
	  * Metode ini akan mencetak semua perintah yang dibaca dari konsole
	  */
	public void dataKeluaran() throws IOException {
		tulis.flush();
	}

	/**
	  * Metode ini mempresentasikan menambah jalinan pertemanan antara dua orang berbeda.
	  * @param orang1 mempresentasikan orang pertama.
	  * @param orang2 mempresentasikan orang kedua.
	  */
	public void tambahKoneksi(String orang1, String orang2) {
		Kluster klusterA = null;
		Kluster klusterB = null;
		int i = 0; boolean bool = true;
		Set<Integer> setInt = himpunan.keySet();
		Integer[] arInt = setInt.toArray(new Integer[0]);
		for(int j = 0; j < arInt.length; j++) {
			if(bool == true) {
		        if(himpunan.get(arInt[j]).terdapat(orang1) && himpunan.get(arInt[j]).terdapat(orang2)) {
					i = 1; klusterA = himpunan.get(arInt[j]);
					bool = false;
				}
				else if(himpunan.get(arInt[j]).terdapat(orang1)) {
					i = i + 2; klusterA = himpunan.get(arInt[j]);
				}
				else if(himpunan.get(arInt[j]).terdapat(orang2)) {
					i = i + 3; klusterB = himpunan.get(arInt[j]);
				}
				bool = (klusterA != null && klusterB != null) ? false : true;
			}
		}
		kondisiPertemanan(i, klusterA, klusterB, orang1, orang2);
    }

	/**
	  * Metode ini berguna
	  * @param i menkondisikan apakah dua orang terdapat pada suatu himpunan HashMap.
	  * @param klusterA objek bantu jika terdapat orang pertama atau kedua pada himpunan HashMap.
	  * @param klusterB objek bantu jika terdapat orang pertama atau kedua pada himpunan HashMap.
	  * @param orang1 mempresentasikan orang pertama yang akan dijalin pertemanannya dengan orang kedua.
	  * @param orang2 mempresentasikan orang kedua yang akan dijalin pertemanannya dengan orang pertama.
	  */
	public void kondisiPertemanan(int i, Kluster klusterA, Kluster klusterB, String orang1, String orang2) {
		if(i == 0) {
			Kluster kluster = new Kluster();
			kluster.id = ++konektor;
			kondisiPertama(orang1, orang2, konektor, kluster);
		}
		else {
			switch(i) {
				case 1 : jalinDuaOrang(himpunan.get(klusterA.id).ambil(orang1), klusterA.ambil(orang2)); break;
				case 2 : kondisiKedua(orang1, orang2, klusterA); break;
				case 3 : kondisiKetiga(orang1, orang2, klusterB); break;
				default : kondisiKeempat(orang1, orang2, klusterA, klusterB);
			}
		}
	}

	/**
	  * Metode ini berguna menjalin pertemanan dari dua FaceLangUser yang berbeda.
	  * @param A mempresentasikan orang yang pertama dengan tipe FaceLangUser.
	  * @param B mempresentasikan orang yang kedua dengan tipe FaceLangUser.
	  */
	public void jalinDuaOrang(FaceLangUser A, FaceLangUser B) {
		A.tambahTeman(B);
		B.tambahTeman(A);
	}

	/**
	  * Metode ini mempresentasikan bahwa dua FaceLangUser dalam satu kluster.
	  * @param A mempresentasikan orang yang pertama dengan tipe FaceLangUser.
	  * @param B mempresentasikan orang yang kedua dengan tipe FaceLangUser.
	  * @return kluster yang telah ditambahkan anggota A dan B dengan tipe FaceLangUser.
	  */
	public Kluster jalinDuaKluster(FaceLangUser A, FaceLangUser B, Kluster kluster) {
		kluster.tambahAnggota(A);
		kluster.tambahAnggota(B);
		return kluster;
	}

	/**
	  * Metode ini mempresentasikan orang pertama dan kedua belum ada di kluster/himpunan anggota.
	  * @param orang1 mempresentasikan orang pertama yang akan dijalin pertemanannya dengan orang kedua.
	  * @param orang2 mempresentasikan orang kedua yang akan dijalin pertemanannya dengan orang pertama.
	  * @param id mempresentasikan kluster kapan dibuat.
	  * @param kluster kumpulan anggota yang berisi orang-orang dari kelas FaceLangUser.
	  */
	public void kondisiPertama(String orang1, String orang2, int id, Kluster kluster) {
		FaceLangUser A = new FaceLangUser(orang1);
		FaceLangUser B = new FaceLangUser(orang2);
		jalinDuaOrang(A, B);
		himpunan.put(id, jalinDuaKluster(A, B, kluster));
	}

	/**
	  * Metode ini mempresentasikan orang pertama sudah ada di kluster/himpunan anggota.
	  * @param orang1 mempresentasikan orang pertama yang akan dijalin pertemanannya dengan orang kedua.
	  * @param orang2 mempresentasikan orang kedua yang akan dijalin pertemanannya dengan orang pertama.
	  * @param klusterA adalah objek yang berisikan orang pertama.
	  */
	public void kondisiKedua(String orang1, String orang2, Kluster klusterA) {
		FaceLangUser A = himpunan.get(klusterA.id).ambil(orang1);
		FaceLangUser B = new FaceLangUser(orang2);
		jalinDuaOrang(A, B);
		himpunan.get(klusterA.id).tambahAnggota(B);
	}

	/**
	  * Metode ini mempresentasikan orang kedua sudah ada di kluster/himpunan anggota.
	  * @param orang1 mempresentasikan orang pertama yang akan dijalin pertemanannya dengan orang kedua.
	  * @param orang2 mempresentasikan orang kedua yang akan dijalin pertemanannya dengan orang pertama.
	  * @param klusterB adalah objek yang berisikan orang kedua.
	  */
	public void kondisiKetiga(String orang1, String orang2, Kluster klusterB) {
		Kluster kluster = himpunan.get(klusterB.id);
		FaceLangUser A = new FaceLangUser(orang1);
		FaceLangUser B = kluster.ambil(orang2);
		kluster.tambahAnggota(A);
		jalinDuaOrang(A, B);
	}

	/**
	  * Metode ini mempresentasikan orang pertama atau orang kedua sudah ada di kluster/himpunan anggota.
	  * @param orang1 mempresentasikan orang pertama yang akan dijalin pertemanannya dengan orang kedua.
	  * @param orang2 mempresentasikan orang kedua yang akan dijalin pertemanannya dengan orang pertama.
	  * @param klusterA adalah objek yang berisikan orang pertama.
	  * @param klusterB adalah objek yang berisikan orang kedua.
	  */
	public void kondisiKeempat(String orang1, String orang2, Kluster klusterA, Kluster klusterB) {
		if(klusterA.id > klusterB.id) {
			Kluster temp = klusterA;
			klusterA = klusterB;
			klusterB = temp;
		}
		himpunan.get(klusterA.id).gabungKluster(himpunan.get(klusterB.id));
		himpunan.remove(himpunan.get(klusterB.id).id);
		jalinDuaOrang(himpunan.get(klusterA.id).ambil(orang1), himpunan.get(klusterA.id).ambil(orang2));
	}

	/**
	  * Metode ini berguna memproses teman yang sama dari dua orang berbeda.
	  * @param orang1 mempresentasikan orang pertama.
	  * @param orang2 mempresentasikan orang kedua.
	  * @return kumpulan nama-nama teman yang sama dari dua orang berbeda yang telah diurutkan.
	  */
    public String cetakMutual(String orang1, String orang2) {
		orangPertamaFace = null;
		orangKeduaFace = null;
		Set<Integer> set = himpunan.keySet();
		Integer[] intAr = set.toArray(new Integer[0]);
		boolean bool = true;
		for(int i = 0; i < intAr.length; i++) {
			if(bool == true) {
				if(himpunan.get(intAr[i]).terdapat(orang1)) {
					orangPertamaFace = himpunan.get(intAr[i]).ambil(orang1);
				}
				if(himpunan.get(intAr[i]).terdapat(orang2)) {
					orangKeduaFace = himpunan.get(intAr[i]).ambil(orang2);
				}
				bool = (orangPertamaFace != null && orangKeduaFace != null) ? false : true;
			}
		}
		Set<String> s = orangPertamaFace.koneksi.keySet();
		return (bool == true) ? "\n" : bantuCetakMutual(s, orangKeduaFace);
    }

	/**
	  * Metode ini berguna mencetak kumpulan nama-nama mutual friend dari dua orang
	  * @param set kumpulan nama-nama yang kan dibandingkan.
	  * @param orangKedua menbandingkan teman-teman orangKedua dengan orang pertama.
	  * @return kumpulan nama-nama yang telah diurutkan menaik.
	  */
	public String bantuCetakMutual(Set<String> set, FaceLangUser orangKedua) {
		PriorityQueue<String> mutual = new PriorityQueue<String>();
		String[] strAr = set.toArray(new String[0]);
		for(int i = 0; i < strAr.length; i++) {
			if(orangKedua.bertemanDengan(strAr[i])) {
				mutual.add(strAr[i]);
			}
		}
		String namaMutual = "";
		if(!mutual.isEmpty()) {
			namaMutual = mutual.poll();
			while(!mutual.isEmpty()) {
				namaMutual += "," + mutual.poll();
			}
		}
		return namaMutual + "\n";
	}

	/**
	  * Mtode ini akan memproses jumlah anggota dari setiap kluster dan akan diproses cetak pada metode urutanKluster.
	  * @return kumpulan angka-angkayang telah di iterasi pada metode urutanKluster dan telah diurutkan menurun.
	  */
    public String cetakKluster() {
		PriorityQueue<Kluster> prioritas = new PriorityQueue<Kluster>(100, new PembandingBanyakKluster());
		Set<Integer> setInt = himpunan.keySet();
		Integer[] arInt = setInt.toArray(new Integer[0]);
		for(int i = 0; i < arInt.length; i++) {
			prioritas.add(himpunan.get(arInt[i]));
		}
		return (!prioritas.isEmpty()) ? urutanKluster(prioritas) : "\n";
	}

	/**
	  * Metode ini berguna mencetak angka-angka yang mempresentasikan banyak
	  * anggota disetiap kluster.
	  * @param prioritas kumpulan angka-angka yang akan dicetak dan telah dibandingkan pada
	  * kelas PembandingBanyakKluster dengan ADT PriorityQueue.
	  * @return mencetak angka-angka terurut menurun yang telah diproses pada metodecetakKluster.
	  */
	public String urutanKluster(PriorityQueue<Kluster> prioritas) {
		String banyakKluster = "" + prioritas.poll().banyakAnggota;
		while(!prioritas.isEmpty()) {
			banyakKluster += "," + prioritas.poll().banyakAnggota;
		}
		return banyakKluster + "\n";
	}

	/**
	  * Metode ini berguna memproses seorang yang berteman dengan semua anggota pada kluster.
	  * @return kumpulan nama-nama yang telah diiterasi pada metode cetak.
	  */
	public String cetakBertemanDenganSemua() {
		TreeSet<String> kumpulanBertemanSemua = new TreeSet<String>();
		Set<Integer> setInt = himpunan.keySet();
		Integer[] arInt = setInt.toArray(new Integer[0]);
        for(int i = 0; i < arInt.length; i++) {
            Kluster kluster = himpunan.get(arInt[i]);
			Set<String> setStr = kluster.anggota.keySet();
			String[] arStr = setStr.toArray(new String[0]);
            for(int j = 0; j < arStr.length; j++) {
				int perbedaan = kluster.banyakAnggota - 1;
                if(kluster.ambil(arStr[j]).banyakTeman == perbedaan) {
                    kumpulanBertemanSemua.add(arStr[j]);
				}
			}
        }
		return cetak(kumpulanBertemanSemua);
	}

	/**
	  * Metode ini berguna mecetak kumpulan nama dari metode cetakBertemanDenganSemua.
	  * @param kumpulanBertemanSemua berisi nama-nama dari metode cetakBertemanDenganSemua.
	  * @return nama-nama yang telah diurutkan yang telah di proses pada metode cetakBertemanDenganSemua.
	  */
	public String cetak(TreeSet<String> kumpulanBertemanSemua) {
		Iterator<String> iterasi = kumpulanBertemanSemua.iterator();
		String nama = iterasi.next();
		while(iterasi.hasNext()) {
			nama += "," + iterasi.next();
		}
		return nama + "\n";
	}
}


/**
  * Kelas PembandingBanyakKluster untuk membandingkan banyak anggota dari setiap
  * kluster yang ada yang akan diperintahkan pada metode cetak kluster.
  */
class PembandingBanyakKluster implements Comparator<Kluster>
{
	//Method(s)

	/**
	  * Metode ini membandingkan banyaknya anggota dari setiap kluster.
	  * @param klusA berisi anggota yang telah ditambahkan dengan pertemanan yang ada dari setiap FaceLangUser.
	  * @param klusB juga berisi anggota yang telah ditambahkan dengan pertemanan yang ada dari setiap FaceLangUser.
	  * @return 1 jika klusA lebih sedikit dan -1 jika sebaliknya.
	  */
    public int compare(Kluster klusA, Kluster klusB) {
		return (klusA.banyakAnggota < klusB.banyakAnggota) ? 1 : -1;
	}
}


/**
  * Kelas PembandingKluster mempresentasikan membandingkan banyak anggota dari masing-masing kluster
  */
class PembandingKluster implements Comparator<Kluster>
{
	/** Variabel pembanding1, pembanding2, pembanding3 dengan inialisasi pertama ada;a true. */
    boolean pembanding1 = true, pembanding2 = true, pembanding3 = true;

	//Method(s)

	/**
	  * Metode compare adalah method abstrak yang diimplementasikan untuk mebandingkan
	  * banyak anggota dari kluster pertama dengan kluster kedua.
	  * @param klusterPertama berisi anggota yang telah ditambahkan dengan pertemanan yang ada dari setiap FaceLangUser.
	  * @param klusterKedua juga berisi anggota yang telah ditambahkan dengan pertemanan yang ada dari setiap FaceLangUser.
	  * @return -1 jika banyak kluster pertama lebih besar dan 1 jika sebaliknya
	  * jika banyak anggota kedua kluster sama maka yang dibandingkan adalah id nya.
	  */
    public int compare(Kluster klusterPertama, Kluster klusterKedua) {
		pembanding1 = klusterPertama.banyakAnggota > klusterKedua.banyakAnggota;
		pembanding2 = klusterPertama.banyakAnggota < klusterKedua.banyakAnggota;
		pembanding3 = klusterPertama.id < klusterKedua.id;
		return (pembanding1 ? -1 : (pembanding2 ? 1 : (pembanding3 ? -1 : 1)));
    }
}


/**
  * Kelas FaceLangUser mempresentasikan identitas orang-orang pada kluster berteman dengan siapa
  * dan menambah temannya.
  */
class FaceLangUser implements Comparable<FaceLangUser>
{
	/** Menciptakan instance variabel nama untukmembrikan nama dari Seseorang. */
    String nama;
	/** Menciptakan objek koneksi untuk memprsentasikan hubungan orang pertama dengan orang kedua dst.  */
    HashMap<String, FaceLangUser> koneksi = new HashMap<String, FaceLangUser>();
	/** Menghitung banyak orang dari setiap orang yang berteman dengan orang lain. */
    int banyakTeman = 0;

	//Constructor(s)

	/**
	  * Konstruktor berguna membaca nama orang yang kemudian di assign ke instance variabel.
	  * @param nama mempresentasikan nama orang pada FaceLangUser.
	  */
    public FaceLangUser(String nama) {
		this.nama = nama;
    }

	/**
	  * Metode berguna untuk mengecek apakah orang pertama berteman dengan orang kedua dan seterusnya.
	  * @param namaTeman nama orang yang kana di cek pertemanannya.
	  * @return True jika Saling berteman dan falsejika sebaliknya.
	  */
    public boolean bertemanDengan(String namaTeman) {
		return koneksi.containsKey(namaTeman);
    }

	/**
	  * Metode ini berguna untuk menambah teman dari seseorang pada FaceLangUser.
	  * @param orangLain adalah orang yang akan bertemanan dengan orang pertama.
	  */
    public void tambahTeman(FaceLangUser orangLain) {
		koneksi.put(orangLain.nama, orangLain);
		banyakTeman++;
    }

	/**
	  * Metode ini berguna membandingkan nama orang pertama dengan orang kkeduadan seterusnya.
	  * @param pengguna nama pengguna yang akan dibandingkan dengan pengguna yang lain.
	  * @return -1 jika nama pertama ada lebih dulu dalam kamus dan 1 jika sebaliknya.
	  */
    public int compareTo(FaceLangUser pengguna) {
		return nama.compareTo(pengguna.nama);
    }
}


/**
  * Kelas Kluster mempresentasikan kumpulan dari anggota kluster
  * atau kumpulan dari para FaceLangUser
  */
class Kluster implements Comparable<Kluster>
{
	/** Menciptakan objek anggota dari setiap kluster yang dipetaka ke kelas HashMap */
    HashMap<String, FaceLangUser> anggota;
	/** Variabel banyakAnggota untuk menghitung banyaknya anggota dari masing-masing kluster */
    int banyakAnggota = 0;
	/** Variabel id untuk menghitung kapan pertama kali kluster dibuat atau kapan terakhir kali dibuat */
    int id = 0;

	//Constructor(s)

	/**
	  * Konstruktor bertugas menciptakan objek anggota dari kelas HashMap dengan tipe String dan FaceLangUser
	  */
	public Kluster() {
		anggota = new HashMap<String, FaceLangUser>();
	}

	/**
	  * Metode ini untuk mengisyaratkan apakah terdapat nama orang yang diperintahkan
	  * pada konsole.
	  * @param orang untuk mengetes apakah ada orang tersebut didalam kluster
	  * @return True jika ada dan false jika tidak ada.
	  */
	public boolean terdapat(String orang) {
		return anggota.containsKey(orang);
	}

	/**
	  * Metode ini berguna untuk menambahkan anggota pada kluster yang dituju.
	  * @param anggotaLain menambahkan anggota lain kedalam suatu kluster
	  */
    public void tambahAnggota(FaceLangUser anggotaLain) {
		anggota.put(anggotaLain.nama, anggotaLain);
		banyakAnggota++;
    }

	/**
	  * Metode ini berguna untuk membandingkan banyaknya anggota pada kluster-kluster yang ada.
	  * @param klusterLain membandingkan banyak kluster lain dengan kluster saat ini.
	  * @return 1 jika banyak anggota dari kluster lain lebih kecil dan -1 jika sebaliknya
	  */
    public int compareTo(Kluster klusterLain) {
		return (banyakAnggota > klusterLain.banyakAnggota) ? -1 : 1;
    }

	/**
	  * Metode ini untuk menggabungkan dua kluster jika ada dua orang anggota
	  * dari kluster lain saling menjalin pertemanan.
	  * @param klusterLain kluster lain yang akan digabungkan dengan kluster saat ini.
	  */
    public void gabungKluster(Kluster klusterLain) {
		anggota.putAll(klusterLain.anggota);
		banyakAnggota = banyakAnggota + klusterLain.banyakAnggota;
    }

	/**
	  * Metode ini berguna mengambil anggota dari sebuah kluster.
	  * @param teman anggota yang akan diambil.
	  * @return anggota dengan tipe FaceLangUser.
	  */
    public FaceLangUser ambil(String teman) {
		return anggota.get(teman);
    }

	/**
	  * Metode ini berisi kumpulan anggota dari setiap kluster yang telah diurutkan.
	  * @return kumpulan nama anggota denagn tipe string.
	  */
    public String kumpulanAnggotaKluster() {
		Set<String> setAnggota = anggota.keySet();
		String[] arrayStr = setAnggota.toArray(new String[0]);
		Arrays.sort(arrayStr);
		String kumpulanNama = arrayStr[0];
		for(int i = 1; i < arrayStr.length; i++)
			kumpulanNama += "," + arrayStr[i];
		return kumpulanNama;
	}
}
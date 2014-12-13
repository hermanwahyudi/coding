/*
 * SDA11111, Masukan, HitungDataSama, Keluaran, SubPrioritas, FriendSuggestion
 *
 * Version:
 * - 1.0 (23-03-2011): develop SDA11111, Masukan, Keluaran, SubPrioritas, FriendSuggestion
 * - 2.0 (04-04-2011): develop HitungDataSama
 *
 * Copyright 2011 Herman Wahyudi.
 */


import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


/**
  * Kelas SDA11111 mempresentasikan menjalankan semua metode, peubah
  * dan konstruktor dari kelas-kelas lain.
  *
  * @author Herman Wahyudi (1006685891)
  * Kolaborator : Randy Lukmana
  *		    Andreas Andros
  *		    Denny Haryadi
  */

public class SDA11111 {

    /** Membuat objek dari kelas BufferedReader agar bisa membaca dari papan ketik. */
    BufferedReader baca = new BufferedReader(new InputStreamReader(System.in));
    /** Membuat objek dari kelas Masukan agar bisa membaca masukan dari pengguna dan teman-teman pengguna. */
    Masukan inputObjek = new Masukan();
    /** Membuat kelas objek dari kelas Keluaran untuk mencetak FriendSuggestion yang telah disaring. */
    Keluaran outputObjek = new Keluaran();

    //Constructor(s)

    /**
      * Membaca masukan bagian satu, dua, dan tiga serta mencetak nama dari friend suggest.
      */
    public SDA11111() {
        try {
            inputObjek.bagianSatu(baca); //Membaca isi data pengguna.
            inputObjek.bagianDua(baca); // Membaca isi data teman-teman pengguna.
            inputObjek.bagianTiga(baca); // Membaca isi friend suggest.
            outputObjek.cetak(); // Mencetak nama-nama friend suggest yang berhasil di saring di MacLangFilter maupun tidak.
	} catch(IOException e) {
	     e.printStackTrace();
	}
    }

    /**
        * Metode main akan memerintahkan semua metode dikelas lain.
        */
    public static void main(String[] args) {
	SDA11111 objekTugas = new SDA11111();
    }
}


/**
  * Kelas Masukan akan mempresentasikan masukan baik masukan pertama,kedua, dan ketiga
  * di kelas masukan juga akan diproses penyaringan  sesuai data-data yang ada di pengguna, teman pengguna dan friend suggest.
  */
class Masukan {

    /** Membuat antrian berdasarkan prioritas dari kelas SubPrioritas. */
    static PriorityQueue<FriendSuggestion> objekFriendSug = new PriorityQueue<FriendSuggestion>(4, new SubPrioritas());
    /** Kumpulan nama tipe String yang tidak tersaring MacLangFilter dan harus di urut berdasarkan menaik. */
    static TreeSet<String> takTersaring = new TreeSet<String>();
    /** Kumpulan antrian nama yang berhasil dirangkum MacLangFilter. */
    static Queue<String> tersaring = new LinkedList<String>();
    /** Kumpulan data dari friend suggest dengan batas indeks 1440 atau jam 24:00 */
    static FriendSuggestion[] FriendSugAr = new FriendSuggestion[1440];
    /** Pengguna serta data-data dari pengguna. */
    static FaceLangUser tokohUtama;
    /** Kumpulan dari teman-teman pengguna.  */
    static ArrayList<FaceLangUser> dataTemanPengguna = new ArrayList<FaceLangUser>();
    /** Batas waktu penyaringan di MacLangFilter, yaitu pukul 24:00 atau setara 1440 menit. */
    static final int BATAS_WAKTU = 1440;
    /** Membuat objek hitung mutual. */
    static HitungDataSama hitungDataSama;
    /** Penambahan waktu selang tiga menit */
    static final int PERTAMBAHAN_MENIT = 3;

    //Method(s)

    /**
        * Membuat metode yang berisi kumpulan data dari pengguna, atau teman pengguna, atau dari friend suggest.
        * @param baca Membaca data-data dari kumpulan data pengguna, teman pengguna, atau dari friend suggest.
        * @return Kumpulan dengan tipe HashSet yang telah di token dengan delimiter "koma".
        */
    public HashSet<String> bacaHash(BufferedReader baca) throws IOException {
        String masukan = baca.readLine();
        HashSet<String> objekHash = new HashSet<String>();
        if (masukan != null) {
	    StringTokenizer pecah = new StringTokenizer(masukan, ",");
            objekHash = new HashSet<String>();
            while (pecah.hasMoreTokens()) {
                objekHash.add(pecah.nextToken());
	    }
        } else {
            objekHash.add(null);
	}
        return objekHash;
    }

    /**
        * Membaca kumpulan masukan pada bagian satu, yaitu nama pengguna, teman pengguna
        * musuh pengguna, tempat yang perna dikunjungi pengguna, dan hobi pengguna.
        * @param baca Membaca masukan dari papan ketik dari kelas BufferedReader.
        */
    public void bagianSatu(BufferedReader baca) throws IOException {
	String namaPengguna = baca.readLine();
        HashSet<String> temanPengguna = bacaHash(baca);
        HashSet<String> musuhPengguna = bacaHash(baca);
        HashSet<String> wisataPengguna = bacaHash(baca);
        HashSet<String> hobbiPengguna = bacaHash(baca);
        tokohUtama = new FaceLangUser(namaPengguna, temanPengguna, musuhPengguna, wisataPengguna, hobbiPengguna);
    }

    /**
        * Membaca kumpulan data-data dari teman pengguna baik itu nama teman pengguna
        * teman temannya pengguna, musuh teman pengguna, tempat dikunjungi serta hobbi.
        * @param baca untuk mebaca data-data dari teman pengguna sebanyak teman pengguna.
        */
    public void bagianDua(BufferedReader baca) throws IOException {
	int i = 0;
        while (i < tokohUtama.sizeOfFriend()) {
            String nama = baca.readLine();
            HashSet<String> teman = bacaHash(baca);
            HashSet<String> musuh = bacaHash(baca);
            HashSet<String> wisata = bacaHash(baca);
            HashSet<String> hobbi = bacaHash(baca);
            dataTemanPengguna.add(new FaceLangUser(nama, teman, musuh, wisata, hobbi));
            i++;
	}
    }

    /**
        * Membaca Friend Suggest dengan data waktu masukan friend suggest dan data seperti pengguna.
        * @param baca membaca data-data dari friend suggest, yaitu jam masukan, nama friend suggest,
        * nama teman friend suggest, musuh friend suggest, tempat dikunjungi, dan hobbi.
        */
    public void bagianTiga(BufferedReader baca) throws IOException {
        hitungDataSama = new HitungDataSama(tokohUtama);
	int jumlahMenit = 0;
	StringTokenizer pecah;
	String jam = baca.readLine();
	while (jam != null) {
	      pecah = new StringTokenizer(jam, ":");
	      jumlahMenit = 60 * Integer.parseInt(pecah.nextToken()) + Integer.parseInt(pecah.nextToken());
	      String nama = baca.readLine();
	      int temanSama = hitungDataSama.hitungFriendWith(baca); baca.readLine();
	      int wisataSama = hitungDataSama.hitungEverVisits(baca);
	      int hobbiSama = hitungDataSama.hitungHobbiSamaa(baca);
	      FriendSugAr[jumlahMenit] = new FriendSuggestion(jumlahMenit, nama, temanSama, wisataSama, hobbiSama);
	      jam = baca.readLine();
	}
	prosesMacLangFilter();
    }

    /**
        * Membandingkan musuh-musuh dari teman pengguna dengan musuh friend suggest.
        * @param nama Nama friend suggest yang akan dibandingkan dengan teman pengguna.
        * @return TRUE jika banyak musuh lebih kecil dari banyak teman pengguna dibagi 2.
        */
    public boolean cekMusuh(String nama) {
        int banyakMusuh = 0;
	boolean boole = true;
	for (int i = 0; i < tokohUtama.sizeOfFriend() && boole; i++) {
	    FaceLangUser temanPengguna = dataTemanPengguna.get(i);
	    if (temanPengguna.hates(nama)) {
	        banyakMusuh++;
	    }
	    boole = tokohUtama.sizeOfFriend() / 2 < banyakMusuh ? false : true;
	}
	return boole;
    }

    /**
        * Proses penyaringan sesuai waktu masuk data-data dari friend suggest
        * dan juga membandingkan jumlah musuh yang sama. Di metode ini akan tersaring mana yang akan
        * tersaring oleh MacLangFilter atau tidak.
        */
    public void prosesMacLangFilter() {
        FriendSuggestion objek = null;
	int akhirProsesWaktu = 0;
	for (int menitBerikutnya = 0; menitBerikutnya < BATAS_WAKTU; menitBerikutnya++) {
	    dataFriendSuggest(menitBerikutnya);
	    if (!objekFriendSug.isEmpty()) {
		int bantu1 = akhirProsesWaktu - menitBerikutnya;
		int bantu2 = BATAS_WAKTU - (PERTAMBAHAN_MENIT + menitBerikutnya);
		if(bantu1 <= 0 &&  bantu2 >= 0) {
		    objek = objekFriendSug.poll();
		    int nilai = (cekMusuh(objek.namaFriendSuggest) == false) ? 1 : 0;
	            if (nilai == 1) {
		        takTersaring.add(objek.namaFriendSuggest);
	            } else {
			tersaring.offer(objek.namaFriendSuggest);
			akhirProsesWaktu = menitBerikutnya + PERTAMBAHAN_MENIT;
	            }
	        }
	    }
	}
	while (objekFriendSug.isEmpty() == false) {
	    takTersaring.add(objekFriendSug.poll().namaFriendSuggest);
	}
    }

    /**
        * Jika kumpulan Friend suggest sesuai indeks/menit saat dimasukkan tidak kosong maka
        * akan dimasukkan di ADT PriorityQueue.
        * @param menit Menit atau bisa disebut indeks adalah waktu friend suggest dimasukkan.
        */
    public void dataFriendSuggest(int menit) {
	if (FriendSugAr[menit] != null) {
	    objekFriendSug.add(FriendSugAr[menit]);
	}
     }
}


/**
  * Kelas HitungDataSama adalah kelas yang mempresentasikan perhitungan
  * jumlah data-data yang sama antara pengguna dengan friend suggest.
  */
class HitungDataSama {

    /** Menghitung banyak dari data yang sama. */
    int hitung;
    /** Men-Token kumpulan data dengan delimiter "koma". */
    StringTokenizer pecah;
    /** Data dari pengguna dengan tipe FaceLangUser dan akan dibandingkan dengan data friend suggest. */
    FaceLangUser tokohUtama;

    //Constructor(s)

    /**
        * Membangun objek pengguna sesuai isi parameter.
        * Menginialisasi hitung mutual dengan 0.
        * @param tokohUtama Kumpulan data dari pengguna baik itu temannya, musuhnya, tempat dikunjungi atau hobbi.
        */
    public HitungDataSama(FaceLangUser tokohUtama) {
	this.tokohUtama = tokohUtama;
	hitung = 0;
    }

    //Method(s)

    /**
        * Method berguna untuk membaca teman dari friend suggest dan membandingkannya dengan teman pengguna.
        * @param baca Membaca teman dari friend suggest.
        * @return Banyaknya teman yang sama antara pengguna dengan friend suggest.
        */
    public int hitungFriendWith(BufferedReader baca) throws IOException {
	hitung = 0;
	pecah = new StringTokenizer(baca.readLine(),",");
	while (pecah.hasMoreTokens()) {
	    if (tokohUtama.friendWith(pecah.nextToken())) {
	        hitung++;
	    }
	}
	return hitung;
    }

    /**
        * Metode ini berguna untuk membaca tempat dari friend suggest dan membandingkannya dengan tempat pengguna.
        * @param baca Membaca tempat dari friend suggest.
        * @return Banyaknya tempat yang sama antara pengguna dengan friend suggest.
        */
    public int hitungEverVisits(BufferedReader baca) throws IOException {
	hitung = 0;
	pecah = new StringTokenizer(baca.readLine(),",");
	while (pecah.hasMoreTokens()) {
	    if(tokohUtama.everVisits(pecah.nextToken())) {
	        hitung++;
	    }
	}
	return hitung;
    }

    /**
        * Method berguna untuk membaca hobbi dari friend suggest dan membandingkannya dengan hobbi pengguna.
        * @param baca Membaca hobbi dari friend suggest.
        * @return Banyaknya hobbi yang sama antara pengguna dengan friend suggest.
        */
    public int hitungHobbiSamaa(BufferedReader baca) throws IOException {
	hitung = 0;
	pecah = new StringTokenizer(baca.readLine(),",");
	while (pecah.hasMoreTokens()) {
	    if (tokohUtama.like(pecah.nextToken())) {
	        hitung++;
	    }
	}
	return hitung;
    }
}


/**
  * Kelas Keluaran memppresentasikan keluaran ke layar dengan informasi friend suggest yang tersarin
  * oleh MacLangFilter atau tidak.
  */
class Keluaran extends Masukan {

    /** Membuat objek tulis agar bisa mencetak semua nama teman friend suggest yang telah difilter. */
    BufferedWriter tulis;
    /** Nama-nama dari friend suggest yang berhasil dirangkum MacLangFilter. */
    String diterima;
    /** Nama-nama dari friend suggest yang tidak berhasil dirangkum MacLangFilter. */
    String ditolak;

    //Constructor(s)

    /**
      * Membangun objek tulis.
      */
    public Keluaran() {
        tulis = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    //Method(s)

    /**
      * Mencetak semua nama-nama friend suggest yang telah difilter, jika tidak ada friend akan
      * mencetak [KOSONG].
      */
    public void cetak() {
        try {
	    diterima = tersaring.isEmpty() ? "[KOSONG]" : methodDiterima(tersaring);
            tulis.write(diterima + "\n");
            ditolak = takTersaring.isEmpty() ? "[KOSONG]" : methodDitolak(takTersaring);
            tulis.write(ditolak);
            tulis.flush();
	 } catch(IOException e) {
             e.printStackTrace();
        }
    }

    /**
      * Method berisi kumpulan nama-nama yang berhasil dirangkum MacLangFilter.
      * @param app adalah kumpulan nama-nama yang berhasil dirangkum menggunakan ADT Queue.
      * @return Mengembalikan tipe String sesuai tipe Generic di ADT queue.
      */
    public String methodDiterima(Queue<String> diterima) {
        String kumpulanNama = diterima.poll();
        while (diterima.size() > 0) {
            kumpulanNama += "," + diterima.poll();
	}
        return kumpulanNama;
    }

    /** Method berisi kumpulan nama-nama friend suggest yang tidak berhasil dirangkum MacLangFilter.
      * @param rej kumpulan nama-nama yang tidak berhasil dirangkum MacLangFilter menggunakan ADT
      * TreeSet agar bisa di sort.
      * @return Mengembalikan String sesuai tipe generic yang dipakai di ADT TreeSet.
      */
    public String methodDitolak(TreeSet<String> ditolak) {
        Iterator<String> iterasi = ditolak.iterator();
        String kumpulanNama = iterasi.next();
        while (iterasi.hasNext()) {
            kumpulanNama += "," + iterasi.next();
	}
        return kumpulanNama;
    }
}


/**
  * Kelas SubPrioritas mempresentasikan pembandingan antara data-data objek friend suggest yang pertama
  * dengan objek friend suggest yang kedua dengan meng-implements Comparator tipe FriendSuggestion
  */
class SubPrioritas implements Comparator<FriendSuggestion> {

    //Method(s)

    /**
      * Membandingkan friend suggest yang pertama dan kedua dengan skala prioritas
      * teman sama, lalu tempat yang pernah dikunjungi sama, lalu hobi sama, yang terakhir
      * adalah perbedaan waktu dari kedua user.
      * @param userPertama Objek friend suggest yang pertama dengan data-data yang ada.
      * @param userKedua Objek friend suggest kedua dengan data-data yang ada.
      * @return Selisih nilai dengan perbedaan antara data-data dari friend suggest pertama dengan friend suggest kedua.
      */
    public int compare(FriendSuggestion objekPertama, FriendSuggestion objekKedua) {
        if (objekPertama.temanSama != objekKedua.temanSama) {
	    return objekKedua.temanSama - objekPertama.temanSama;
	} else if (objekPertama.wisataSama != objekKedua.wisataSama) {
            return objekKedua.wisataSama - objekPertama.wisataSama;
	} else if (objekPertama.hobbiSama != objekKedua.hobbiSama) {
            return objekKedua.hobbiSama - objekPertama.hobbiSama;
	} else {
            return objekPertama.waktu - objekKedua.waktu;
	}
    }
}


/**
  * Kelas FriendSuggestion mempresentasikan  menyimpan data-data dari friend suggest
  * yang dimasukkan ke MacLangFilter.
  */
class FriendSuggestion {

    /** Nama Friend Suggestion pada masukan ketiga. */
    String namaFriendSuggest = "";
    /** Waktu saat friend suggest dimasukan. */
    int waktu = 0;
    /** Teman yang sama dengan pengguna. */
    int temanSama = 0;
    /** Tempat yang sama pernah dikunjungi oleh pengguna. */
    int wisataSama = 0;
    /** Hobbi sama dengan pengguna. */
    int hobbiSama = 0;

    //Constructor(s)

    /**
        * Membangun instance variable sesuai parameter yang diberikan.
        * @param waktu Waktu saat friend suggest dimasukan.
        * @param namaFrienSuggest Nama dari friend suggest yang dimasukan.
        * @param temanSama Teman-teman yang sama dengan pengguna.
        * @param wisataSama Tempat yang pernah dikunjungi sama dengan pengguna.
        * @param hobbiSama Hobbi yang sama dengan pengguna.
        */
    public FriendSuggestion(int waktu, String namaFriendSuggest, int temanSama, int wisataSama, int hobbiSama) {
        this.waktu = waktu;
        this.namaFriendSuggest = namaFriendSuggest;
        this.temanSama = temanSama;
        this.wisataSama = wisataSama;
        this.hobbiSama = hobbiSama;
    }
}


/**
   * Kelas yang mempresentasikan data-data dari si pengguna, baik nama pengguna, teman pengguna, musuh pengguna
   * tempat yang pernah dikunjungi pengguna, dan hobbi pengguna.
   */
class FaceLangUser {
    /*
     * Kelas ini memiliki 5 atribut yakni :
     * - nama,
     * - daftar teman,
     * - daftar orang yang tidak disukai,
     * - daftar tempat wisata yang pernah dikunjungi, dan
     * - daftar hobi.
     *
     * Tiap daftar hanya menyimpan nama saja berkaitan dengan kategori yang ditentukan. Misalnya
     * daftar teman hanya akan menyimpan nama dari teman.
     *
     * Daftar yang dibangun harus dapat melakukan operasi pencarian suatu nama dengan cepat, dan
     * operasi pengaksesan semua anggota dalam daftar dengan tingkat kecepatan yang cukup cepat.
     */

    /** Nama pengguna. */
    private String name;
    /** Kumpulan nama pengguna lain yang merupakan teman dari pengguna. */
    private HashSet<String> setOfFriend;
    /** Kumpulan nama pengguna lain yang tidak disukai oleh pengguna. */
    private HashSet<String> setOfDislike;
    /** Kumpulan nama tempat wisata yang pernah dikunjungi oleh pengguna. */
    private HashSet<String> setOfPlace;
    /** Kumpulan nama hobi yang disukai oleh pengguna. */
    private HashSet<String> setOfHobby;

    //Constructor(s)

    /**
     * Membangun objek <code>FaceLangUser</code> dengan nama sesuai parameter yang diberikan.
     * Kumpulan nama teman, nama pengguna yang tidak disukai, nama tempat wisata yang pernah dikunjungi,
     * dan nama hobi yang disukai pengguna merupakan kumpulan kosong.
     * @param name nama pengguna ini.
     */
    public FaceLangUser(String name) {
        this.name = name;
        this.setOfFriend = new HashSet<String>();
        this.setOfDislike = new HashSet<String>();
        this.setOfPlace = new HashSet<String>();
        this.setOfHobby = new HashSet<String>();
    }

    /**
     * Membangun objek <code>FaceLangUser</code> sesuai dengan parameter yang diberikan.
     * @param name nama pengguna ini.
     * @param friends kumpulan nama teman dari pengguna ini.
     * @param dislikes kumpulan nama pengguna lain yang tidak disukai pengguna ini.
     * @param places kumpulan nama tempat wisata yang pernah dikunjungi oleh pengguna ini.
     * @param hobbies kumpulan nama hobi yang disukai oleh pengguna ini.
     */
    public FaceLangUser(String name, HashSet<String> friends, HashSet<String> dislikes, HashSet<String> places, HashSet<String> hobbies ) {
        this.name = name;
        this.setOfFriend = friends;
        this.setOfDislike = dislikes;
        this.setOfPlace = places ;
        this.setOfHobby = hobbies;
    }

    //Method(s)

    /**
     * Mengembalikan nilai <i>hash code</i> untuk pengguna ini.
     * @return Nilai <i>hash code</i> untuk pengguna ini.
     */
    public int hashCode() {
        return this.name.hashCode();
    }

    /**
     * Mengembalikan nilai kebenaran yang menyatakan bahwa apakah pengguna ini sama dengan objek yang diberikan pada bagian parameter input.
     * @param otherObject objek lain yang akan dibandingkan dengan pengguna ini.
     * @return TRUE jika pengguna ini sama dengan objek yang diberikan, FALSE untuk kondisi lainnya.
     */
    public boolean equals( Object otherObject ) {
        if( ! (otherObject instanceof FaceLangUser) ) {
            return false;
        }

        // mengubah otherObject yang bertipe Object menjadi objek dengan tipe FaceLangUser.
        FaceLangUser otherUser = (FaceLangUser) otherObject;
        return this.name.equals(otherUser);
    }

    /**
     * Mengembalikan nama dari pengguna ini.
     * @return nama dari pengguna ini.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Mengembalikan nilai kebenaran yang menyatakan bahwa apakah pengguna ini tidak menyukai pengguna lain yang memiliki nama sesuai dengan parameter input.
     * @param userName nama dari pengguna lain.
     * @return TRUE jika nama pada input masukan merupakan nama dari pengguna lain yang tidak disukai pengguna ini, FALSE untuk kondisi lainnya.
     */
    public boolean hates( String userName ) {
        return setOfDislike.contains( userName );
    }

    /**
     * Mengembalikan nilai kebenaran yang menyatakan bahwa apakah pengguna ini berteman dengan pengguna lain yang memiliki nama sesuai dengan parameter input.
     * @param userName nama dari pengguna lain.
     * @return TRUE jika nama pada input masukan merupakan nama salah satu teman dari pengguna ini, FALSE untuk kondisi lainnya.
     */
    public boolean friendWith( String userName ) {
        return setOfFriend.contains( userName );
    }

    /**
     * Mengembalikan nilai kebenaran yang menyatakan bahwa apakah pengguna ini pernah mengunjungi nama tempat wisata sesuai dengan parameter input.
     * @param placeName nama dari tempat wisata.
     * @return TRUE jika nama tempat wisata pada input masukan merupakan salah satu tempat wisata yang pernah dikunjungi oleh pengguna ini, FALSE untuk kondisi lainnya.
     */
    public boolean everVisits( String placeName ) {
        return setOfPlace.contains( placeName );
    }

    /**
     * Mengembalikan nilai kebenaran yang menyatakan bahwa apakah pengguna ini menyukai nama hobi yang sesuai dengan parameter input.
     * @param hobbyName nama dari hobi.
     * @return TRUE jika nama pada input masukan merupakan salah satu hobi yang disukai oleh pengguna ini, FALSE untuk kondisi lainnya.
     */
    public boolean like( String hobbyName ) {
        return setOfHobby.contains( hobbyName );
    }

    /**
     * Mengembalikan banyaknya teman yang dimiliki oleh pengguna ini.
     * @return ukuran atau banyaknya teman yang dimiliki pengguna ini.
     */
    public int sizeOfFriend() {
        return setOfFriend.size();
    }

    /**
     * Mengembalikan objek <code>Iterator</code> yang berkaitan dengan nama teman-teman dari pengguna ini.
     * @return objek <code>Iterator</code> yang berkaitan dengan nama teman-teman dari pengguna ini.
     *
     */
    public Iterator<String> iteratorForFriend() {
        return setOfFriend.iterator();
    }

    /**
     * Mengembalikan objek <code>Iterator</code> yang berkaitan dengan nama tempat wisata yang pernah dikunjungi oleh pengguna ini.
     * @return objek <code>Iterator</code> yang berkaitan dengan nama tempat wisata yang pernah dikunjungi oleh pengguna ini.
     */
    public Iterator<String> iteratorForPlace() {
        return setOfPlace.iterator();
    }

    /**
     * Mengembalikan objek <code>Iterator</code> yang berkaitan dengan nama hobi yang disukai oleh pengguna ini.
     * @return objek <code>Iterator</code> yang berkaitan dengan nama hobi yang disukai oleh pengguna ini.
     */
    public Iterator<String> iteratorForHobby() {
        return setOfHobby.iterator();
    }

    /**
     * Mengembalikan deskripsi dari pengguna ini.
     * @return deskripsi mengenai pengguna ini.
     */
    public String toString() {
        return this.name + "\n" +
            "friend: " + this.setOfFriend + "\n" +
            "dislike: " + this.setOfDislike + "\n" +
            "place: " + this.setOfPlace + "\n" +
            "hobby: " + this.setOfHobby + "\n";
    }
}
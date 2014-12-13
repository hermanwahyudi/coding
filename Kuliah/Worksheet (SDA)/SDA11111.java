/*
 * FaceLangUser
 *
 * Version:
 * - 1.0 (09-03-2011):membangun kelas FaceLangUser
 * - 1.0.1.1 (10-03-2011): mengganti struktur data pada daftar dari ArrayList menjadi HashMap.
 * - 1.0.1.2 (11-03-2011): mengganti struktur data pada daftar dari HashMap menjadi HashSet.
 * - 1.0.2.1 (12-03-2011): menambahkan dokumentasi.
 *
 * Kolaborator : Aldyra Dhien Swavira
 *               Egidius Richang
 *               Puji Martadinata
 *               Minami Yama Cahayani
 *               Afrishal Priyandana
 *               Tyara Tri Adistie

 *
 * Copyright 2011 Denvil Prasetya.
 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


/**
  * Kelas <code>FaceLangUser</code> merepresentasikan informasi mengenai pengguna FaceLang.
  *
  * @author Rizky Widia Amanda (1006686250)
  */

public class SDA11111 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
	// TODO code application logic here

	BacaInput baca= new BacaInput();
	cekMutual cek = new cekMutual();
	FaceLangUser nia = baca.bacaData();
	FaceLangUser temanNia;
	ArrayList<FaceLangUser> daftarTeman = new ArrayList<FaceLangUser>();
	PriorityQueue<String> ditolak = new PriorityQueue<String>();
	PriorityQueue<FriendSuggestion> diterima = new PriorityQueue<FriendSuggestion>(1440,new FriendCompare());
	ArrayList<String> pastiSuggest = new ArrayList<String>();
	int waktuSekarang=-1;

	for (int i = 0; i<nia.sizeOfFriend(); i++ ) {
	    temanNia = baca.bacaData();
	    daftarTeman.add(temanNia);
	}

	FriendSuggestion[] suggest = baca.bacafriendSuggestion();
	for(int i = 0;i<suggest.length;i++)
	{
	    if(suggest[i] != null)
		{
			cek.cekMutu(nia, daftarTeman, suggest[i]);
			if(suggest[i].benciDia > nia.sizeOfFriend()/2 || suggest[i].getWaktu() > 1437 )
			{
				ditolak.add(suggest[i].getName());
				suggest[i] = null;
			}
	    }
	}

		for (int i=0; i<suggest.length; i++)
		{
			if(suggest[i] != null)
		    {
				diterima.add(suggest[i]);
		    }
			if(!diterima.isEmpty() && i <= 1437 && i >= waktuSekarang + 3)
			{
				waktuSekarang = i;
				pastiSuggest.add(diterima.poll().getName());
			}
        }
		while(!diterima.isEmpty())
		{
			ditolak.add(diterima.poll().getName());
		}
		Output out = new Output();
		out.cetak(pastiSuggest, ditolak);
    }

}

class BacaInput {
	 BufferedReader buffr;
	 String nama = "";
	 HashSet<String> teman;
	 HashSet<String> musuh;
	 HashSet<String> tempat;
	 HashSet<String> hobi;
	 StringTokenizer pisah;
	 FaceLangUser pengguna;
	 FriendSuggestion calonTeman;
	 int waktu;

	 public BacaInput() {
	     buffr= new BufferedReader(new InputStreamReader(System.in));
	 }

	 public String bacaNama() throws Exception {
	     nama = buffr.readLine();
	     return nama;
	 }

	 public HashSet<String> bacaTeman() throws Exception {
	     teman = new HashSet<String>();
	     pisah = new StringTokenizer(buffr.readLine(), ",");
	     while (pisah.hasMoreTokens()) {
		teman.add(pisah.nextToken());
	     }
	     return teman;
	 }

	 public HashSet<String> bacaMusuh() throws Exception {
	     musuh = new HashSet<String> ();
	     pisah = new StringTokenizer(buffr.readLine(), ",");
	     while (pisah.hasMoreTokens()) {
		 musuh.add(pisah.nextToken());
	     }
	     return musuh;
	 }

	 public HashSet<String> bacaTempat() throws Exception {
	     tempat = new HashSet<String> ();
	     pisah = new StringTokenizer(buffr.readLine(), ",");
	     while (pisah.hasMoreTokens()) {
		 tempat.add(pisah.nextToken());
	     }
	     return tempat;
	 }

	  public HashSet<String> bacaHobi() throws Exception {
	     hobi = new HashSet<String> ();
	     pisah = new StringTokenizer(buffr.readLine(), ",");
	     while (pisah.hasMoreTokens()) {
		 hobi.add(pisah.nextToken());
	     }
	     return hobi;
	 }

	  public FaceLangUser bacaData() throws Exception
		  {
	      pengguna = new FaceLangUser(bacaNama(), bacaTeman(), bacaMusuh(), bacaTempat(), bacaHobi());
	      return pengguna;
	  }

	  public FriendSuggestion[] bacafriendSuggestion() throws Exception
	  {
		 FriendSuggestion suggest;
	     String jam;
	     FriendSuggestion[] Sug = new FriendSuggestion[24*60];
	     while((jam = buffr.readLine())!=null)
		 {
			pisah = new StringTokenizer(jam, ":");
			waktu = (Integer.parseInt(pisah.nextToken())*60)+(Integer.parseInt(pisah.nextToken()));
			suggest = new FriendSuggestion(bacaNama(),bacaTeman(),bacaMusuh(),bacaTempat(),bacaHobi(),waktu);
			Sug[waktu] = suggest;
		 }
	     return Sug;
	  }
    }

class Output
{
	 BufferedWriter buffw = new BufferedWriter(new OutputStreamWriter(System.out));

	 public void cetak(ArrayList<String> suggest, PriorityQueue<String> tolak) throws IOException
	 {
	     if(suggest.isEmpty())
			buffw.write("[KOSONG]");
		 else
		 {
			Iterator<String> sug = suggest.iterator();
			buffw.write(sug.next());
			while(sug.hasNext())
				buffw.write(","+sug.next());
		 }
	     buffw.newLine();
	     if(tolak.peek() == null)
			buffw.write("[KOSONG]");
		 else
		 {
			buffw.write(tolak.poll());
			while(tolak.peek() != null)
				buffw.write(","+tolak.poll());
	     }
	     buffw.flush();
	 }
}
     class FriendSuggestion extends FaceLangUser {
	 int waktu;
	 int mutualFriends=0,benciDia=0,mutualPlaces=0,mutualHobbies=0;
	 public FriendSuggestion(String name, HashSet<String> friends, HashSet<String> dislikes, HashSet<String> places, HashSet<String> hobbies, int waktu) {
	     super(name, friends, dislikes, places, hobbies);
	     this.waktu = waktu;
	 }

	 public int getWaktu() {
	     return waktu;
	 }
     }

     class cekMutual{
	 public void cekMutu(FaceLangUser bgan1, ArrayList<FaceLangUser> bgan2, FriendSuggestion bgan3){
	     for(int i =0;i<bgan2.size();i++){
		 cekBenci(bgan2.get(i),bgan3);
	     }
	     cekTeman(bgan1,bgan3);
	     cekTempat(bgan1,bgan3);
	     cekHobi(bgan1,bgan3);
	 }
	 public void cekTeman(FaceLangUser bgan1,FriendSuggestion bgan3){
	     Iterator<String> nama = bgan3.iteratorForFriend();
	     while(nama.hasNext()){
		if(bgan1.friendWith(nama.next())){
		     bgan3.mutualFriends++;
		}
	     }
	 }
	 public void cekBenci(FaceLangUser bgan2, FriendSuggestion bgan3){
	     if(bgan2.hates(bgan3.getName())){
		 bgan3.benciDia++;
	     }
	 }
	 public void cekTempat(FaceLangUser bgan1,FriendSuggestion bgan3){
	     Iterator<String> tempat = bgan3.iteratorForPlace();
	     while(tempat.hasNext()){
		if(bgan1.everVisits(tempat.next())){
		     bgan3.mutualPlaces++;
		}
	     }
	 }
	 public void cekHobi(FaceLangUser bgan1,FriendSuggestion bgan3){
	     Iterator<String> hobi = bgan3.iteratorForHobby();
	     while(hobi.hasNext()){
		if(bgan1.like(hobi.next())){
		     bgan3.mutualHobbies++;
		}
	     }
	 }
     }
     class FriendCompare implements Comparator<FriendSuggestion>
	 {
	// 1
	public int compare(FriendSuggestion o1, FriendSuggestion o2)
		 {
	    if(o1.mutualFriends != o2.mutualFriends)
			{
		return o2.mutualFriends - o1.mutualFriends;
	    }
			else
			{
		if(o1.mutualPlaces != o2.mutualPlaces)
				{
		   return o2.mutualPlaces - o1.mutualPlaces;
		}
				else
				{
		    if(o1.mutualHobbies != o2.mutualHobbies)
					{
			return o2.mutualHobbies - o1.mutualHobbies;
		    }
					else
					{
			return o1.getWaktu() - o2.getWaktu();
		    }
		}
	    }
	}
     }

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

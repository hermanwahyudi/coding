import java.io.*;
import java.util.*;

public class sda0904
{
    public static String masukan(BufferedReader entry) throws IOException
    {
	String pesan = "";
	int n = Integer.parseInt(entry.readLine()); 
	if(n == 1){
	    int[] po = {1};
	    pesan = kandang(po);
	}
	else if(n == 2){
	    int[] po = {1,3,1};
	    pesan = kandang(po);
	}
	else if(n == 3){
	    int[] po = {1,3,1};
	    pesan = numpuk(po,9);
	}
	else if(n == 4){
	    int[] po = {1,3,1,9,1,3,1};
	    pesan = numpuk(po,27);
	}
	else if(n == 5){
	    int[] po = {1,3,1,9,1,3,1,27,1,3,1,9,1,3,1};
	    pesan = numpuk(po,81);
	}
	else if(n == 6){
	    int[] po = {1,3,1,9,1,3,1,27,1,3,1,9,1,3,1,81,1,3,1,9,1,3,1,27,1,3,1,9,1,3,1};
	    pesan = numpuk(po,243);
	}
	else if(n == 7){
	    int[] po = {1,3,1,9,1,3,1,27,1,3,1,9,1,3,1,81,1,3,1,9,1,3,1,27,1,3,1,9,1,3,1,243,1,3,1,9,1,3,1,27,1,3,1,9,1,3,1,81,1,3,1,9,1,3,1,27,1,3,1,9,1,3,1};
	    pesan = numpuk(po,729);
	}
	else if(n == 8){
	    int[] po = {1,3,1,9,1,3,1,27,1,3,1,9,1,3,1,81,1,3,1,9,1,3,1,27,1,3,1,9,1,3,1,243,1,3,1,9,1,3,1,27,1,3,1,9,1,3,1,81,1,3,1,9,1,3,1,27,1,3,1,9,1,3,1,729,1,3,1,9,1,3,1,27,1,3,1,9,1,3,1,81,1,3,1,9,1,3,1,27,1,3,1,9,1,3,1,243,1,3,1,9,1,3,1,27,1,3,1,9,1,3,1,81,1,3,1,9,1,3,1,27,1,3,1,9,1,3,1};
	    pesan = numpuk(po,2187);
	}
	else if(n == 9){
	    int[] po = {1,3,1,9,1,3,1,27,1,3,1,9,1,3,1,81,1,3,1,9,1,3,1,27,1,3,1,9,1,3,1,243,1,3,1,9,1,3,1,27,1,3,1,9,1,3,1,81,1,3,1,9,1,3,1,27,1,3,1,9,1,3,1,729,1,3,1,9,1,3,1,27,1,3,1,9,1,3,1,81,1,3,1,9,1,3,1,27,1,3,1,9,1,3,1,243,1,3,1,9,1,3,1,27,1,3,1,9,1,3,1,81,1,3,1,9,1,3,1,27,1,3,1,9,1,3,1};
	    pesan = numpuknumpuk(po,2187,6561);
	}
	else if(n == 10){
	    int[] po = {1,3,1,9,1,3,1,27,1,3,1,9,1,3,1,81,1,3,1,9,1,3,1,27,1,3,1,9,1,3,1,243,1,3,1,9,1,3,1,27,1,3,1,9,1,3,1,81,1,3,1,9,1,3,1,27,1,3,1,9,1,3,1};
	    pesan = numpuknumpuknumpuk(po,729,2187,6561,19683);
	}
	return pesan;
   }
   public static String kandang(int[] pola)
   {
	String pesan = "";
	for(int i = 0; i < pola.length; i++){
	    pesan += "@";
	    for(int j = 0; j < pola[i]; j++)
		pesan += " "; 
	}
	return pesan+ "@";
   }
   public static String numpuk(int[] ar,int k)
   {
	String pesan = "";
	Stack<String> st = new Stack<String>();
	st.push(kandang(ar));
	String str = st.pop();
	for(int i = 0; i < k; i++)
	    pesan += " ";
	return str+ pesan+ str;
   }
   public static String numpuknumpuk(int[] ar, int k, int l)
   {
	Stack<String> st = new Stack<String>();
	st.push(kandang(ar));
	String str = st.pop();
	return str+spasi(k)+str+spasi(l)+str+spasi(k)+ str;
    }
    public static String numpuknumpuknumpuk(int[] ar, int k, int l, int m, int o)
    {
	Stack<String> st = new Stack<String>();
	st.push(kandang(ar));
	String str = st.pop();
	st.push(spasi(k));
	String pesan1 = st.pop() ; 
	String pesan2 = ""; 
	String pesan3 = ""; 
	String pesan4 = "";
	for(int i = 0; i < 3; i++)
	    pesan2 += pesan1;
	for(int i = 0; i < 9; i++)
	    pesan3 += pesan1;
	for(int i = 0; i < 27; i++)
	    pesan4 += pesan1;
	return str+pesan1+str+pesan2+str+pesan1+str+pesan3+str+pesan1+str+pesan2+str+pesan1+str+pesan4+str+pesan1+str+pesan2+str+pesan1+str+pesan3+str+pesan1+str+pesan2+str+pesan1+str;
    }
    public static String spasi(int k)
    {
	String pesan1 = "";
	for(int i = 0; i < k; i++)
	    pesan1 += " ";
	return pesan1;
    }
	
   public static void main(String[] args) throws IOException
   {
	System.out.println(masukan(new BufferedReader(new InputStreamReader(System.in))));
   }
}

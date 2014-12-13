/**
    1. Jelaskan apa yang salah dari implementasi kelas Stack tersebut, dan bagaimana seharusnya.
       Karena program akan menyimpan ratusan bahkan ribuan Thread, maka pada implementasi class Stack dibawah tidak perlu
       menggunakan instance varibale maxSize, dan di constructor-nya tidak perlu ada parameter size dimana u/ menginisisasi maxSize-nya, 
       karena objeck yang tersimpan akan banyak dan tak terbatasi dengan nilai tertentu. Selain itu, di method push tidak usah memerlukan kondisi
       size >= maxSize, karena jika iya, jika kondisi size melebihi maxSize, maka objek tak akan tersimpan lagi. Seperti menginisiasi 
       size-nya 4, maka jika melebihi 4 objek, objek ke-5 dst tak akan tersimpan.

    2. Perbaiki implementasi kelas Stack di atas.
       Dapat dilihat dibawah.
*/

import java.util.ArrayList;

class Stack {
    private int size;
    //private int maxSize;
    private final ArrayList<Object> list;

    public Stack() {
      this.size = 0;
      //this.maxSize = size;
      this.list = new ArrayList<Object>(size);
    }

    public boolean push(Object o) {
       // if(size >= maxSize) {
         // return false;
        //}
        synchronized (this.list) {
          this.list.add(o);
        }

        this.size++;

        return true;
    }

    public Object pop() {
        Object o;

        if (this.size == 0) {
          return null;
        }

        synchronized (this.list) {
          o = this.list.remove(size()-1);
        }

        this.size--;
        return o;
    }

    public int size() {
       return this.size;
    }

}

public class MainStack {
  
  public static void main(String[] args) {
      final Stack stack = new Stack();
      stack.push("9");
      stack.push("8");
      stack.push("6");
      System.out.println(stack.pop());
      System.out.println(stack.pop());
      System.out.println();

      for(int i = 0; i < 1000; i++) {
        final String data = "hello " + i;
        final int x = i;
        new Thread(new Runnable() {
          public void run() {
            if(x % 2 == 0) {
              System.out.println(stack.push(data));
            } else {
              System.out.println(stack.pop());
            }
          }
        }).start();
      }
  }
}
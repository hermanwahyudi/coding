import java.io.*;


public class SDA11103
{
    public static void main(String[] args) throws IOException
   {
          LinkedList AzumList = new LinkedList();
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	  BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	  long kelereng = 0, skor =0, color = 0, position = 0, combo = 0;
	  String tempor;
          String[] temp;
	  ListNode newNode;
	  Marble key;
            kelereng = Long.parseLong(br.readLine());
            for(long i = 0; i < kelereng; i++)
            {
               tempor = br.readLine();
               temp = tempor.split(" ");
               position = Long.parseLong(temp[0]);
               color = Long.parseLong(temp[1]);
               key = new Marble(color);
               newNode = new ListNode(key);

               if(AzumList.getSize() == 0 || position == 0)
               {
                    AzumList.addFirst(newNode);
                    position = 1;
                    newNode = AzumList.getNode(1);
               }
                else if(position >= AzumList.getSize())
               {
                    AzumList.addLast(newNode);
                    position = AzumList.getSize();
                    newNode = AzumList.getNode(position);
               }
                else
               {
                    AzumList.addPosition(++position, newNode);
                    newNode = AzumList.getNode(position);
               }
               combo = 0;
               if(AzumList.getSize() >= 4) skor += (long) cekCombo(newNode);
               System.out.println(skor-(kelereng*11));
            }
    }
    public static double cekCombo(ListNode newNode)
    {
        if (newNode == null) return 0;
		long startCombo = position - AzumList.prevCheck(newNode);
		long endCombo = position + AzumList.nextCheck(newNode);
		long marble = 1 + AzumList.prevCheck(newNode) + AzumList.nextCheck(newNode);
		if (marble>=4) {
			AzumList.deletePosition(startCombo, marble);
			if (startCombo == 1) {
				if (endCombo == AzumList.getSize()+marble) return (10*marble)*(Math.pow((++combo),3));
				position = 1;
				return (10*marble)*(Math.pow((++combo),3)) + cekCombo(AzumList.getNode(1));
			}
			position = startCombo;
			return (10*marble)*(Math.pow((++combo),3)) + cekCombo(AzumList.getNode(startCombo));
		}
		else return 0;
	}
    }


class LinkedList
{
    ListNode first;
    ListNode last;
    long size;


    public LinkedList()
    {
        first = ast = null;
        size = 0;
    }

    public long getSize()
    {
        return size;
    }

    public boolean isEmpty()
    {
        if(first == null && last == null) return true;
        return false;
    }

    public void addFirst(ListNode newNode)
    {
        if(isEmpty())
        {
            newNode = first;
            first.prev = null;
            first.next = null;

        }
        else
        {
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
        }
        size++;
    }

    public void addLast(ListNode newNode)
    {
            newNode.prev = last;
            last.next = newNode;
            last = newNode;
            size++;
    }

    public ListNode getNode(long position)
    {
       ListNode current;
        if(position <= size/2)
       {
        current = first;
        for(long i = 1; i < position; i++)
        {
            current = current.next;
        }
       }
        else
        {
         current = last;
         for(long i = size; i > position; i--)
         {
            current = current.prev;
         }
        }
           return current;
    }

    public void addPosition(long position, ListNode newNode)
    {
           ListNode temp = getNode(position);
           newNode.next = temp;
           newNode.prev = temp.prev;
           temp.prev.next = newNode;
           temp.prev = newNode;
           size++;
    }

    public void deletePosition(long position, long removeSize)
    {
            ListNode start = getNode(position);
            ListNode finish = start;
            for(int i = 1; i< removeSize; i++)
            {
                finish = finish.next;
            }
            if(start == first && finish == last)
            {
                first = null;
                last = null;
            }
            else if(start == first && finish != last)
            {
                finish.next = first;
                finish.next = null;
                first.prev = null;
            }
            else if(start != first && finish == last)
            {
                start.prev = last;
                start.prev = null;
                last.next = null;
            }
            else
            {
                start.prev.next = finish.next;
                finish.next.prev = start.prev;
                start.prev = null;
                finish.next = null;

            }
            size = size - removeSize;
    }
    public long prevCheck(ListNode temp)
    {
        if(temp == first) return 0;
        if(((Marble)(temp.data)).getWarna() == (((Marble)(temp.prev.data)).getWarna())) return 1 + prevCheck(temp.prev);
        return 0;
    }

    public long nextCheck(ListNode temp)
    {
        if(temp == last) return 0;
        if(((Marble)(temp.data)).getWarna() == (((Marble)(temp.next.data)).getWarna())) return 1 + nextCheck(temp.next);
        return 0;
    }
}

class ListNode<E>
{
    ListNode next;
    ListNode prev;
    E data;

    public ListNode(E data)
    {
        this.data = data;
        next = prev = null;
    }
}
class Marble extends Object
{
    long warna;
    public Marble(long warna)
    {
        this.warna=warna;
    }

    public long getWarna()
    {
        return warna;
    }
}

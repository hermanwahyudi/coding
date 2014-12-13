import java.io.*;

public class SDA11106
{
    static BufferedReader baca = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args)
    {
	BinaryHeap biHeap;
	try
	{
	    String masukan = baca.readLine();
	    if(masukan == null)
		System.out.println("[Empty]");
	    else
	    {
		String[] splitInput = masukan.split(" ");
		int[] arr = new int[splitInput.length];
		for(int i = 0; i < arr.length; i++)
		    arr[i] = Integer.parseInt(splitInput[i]);
		biHeap = new BinaryHeap(arr, arr.length);
		masukan = baca.readLine();
		while(masukan != null)
		{
		    splitInput = masukan.split(" ");
		    if(splitInput.length == 1)
			biHeap.deleteMin();
		    else
			biHeap.insert(Integer.parseInt(splitInput[1]));
		    masukan = baca.readLine();
		 }
		 biHeap.print();
	      }
	   }
	   catch(Exception e)
	   {
	      e.printStackTrace();
	   }
      }
}
class BinaryHeap
{
    private int[] array;
    private int updateSize;

    public BinaryHeap(int[] array, int size)
    {
	this.array = array;
	updateSize = size;
	heapify();
     }
     public int indexOfParent(int i)
     {
	return (i-1)/2;
     }
     public int indexOfLeftChild(int i)
     {
	return 2*i+1;
     }
     public int indexOfRightChild(int i)
     {
	return 2*(i+1);
     }
     public boolean isEmpty()
     {
	return updateSize == 0;
     }
     public void heapify()
     {
	for(int i = updateSize/2 ; i >= 0; i--)
	    percolateDown(i);
     }
     public int findMin()
     {
	if(isEmpty())
	    throw new RuntimeException("[Empty]");;
	return array[0];
      }
      public void deleteMin()
      {
	if (isEmpty())
	    return;
	else
	{
	    array[0] = array[updateSize-1];
	    updateSize--;
	    if (updateSize > 0)
	       percolateDown(0);
	 }
      }
      public void swap(int i, int j)
      {
	 array[i] = array[i] + array[j];
	 array[j] = array[i] - array[j];
	 array[i] = array[i] - array[j];
      }
      public void percolateUp(int i)
      {
	 int indexParent;
	 if(i != 0)
	 {
	    indexParent = indexOfParent(i);
	    if(array[i] < array[indexParent])
	    {
		swap(i, indexParent);
		percolateUp(indexParent);
	    }
	 }
      }
      public void percolateDown(int i)
      {
	  int leftChildIndex = indexOfLeftChild(i);
	  int rightChildIndex = indexOfRightChild(i);
	  int childIndex;

	  if(rightChildIndex >= updateSize)
	  {
	      if (leftChildIndex >= updateSize)
		 return;
	      else
		 childIndex = leftChildIndex;
	  }
	  else
	  {
	      if(array[leftChildIndex] <= array[rightChildIndex])
		childIndex = leftChildIndex;
	      else
		childIndex = rightChildIndex;
	  }
	  if(array[i] > array[childIndex])
	  {
	    swap(i, childIndex);
	    percolateDown(childIndex);
	  }
      }
      public void insert(int value)
      {
	 if(updateSize == array.length)
	    arrayDoubling();
	 updateSize++;
	 array[updateSize-1] = value;
	 percolateUp(updateSize-1);
      }
      public void arrayDoubling()
      {
	 int[] newArray = new int[array.length+1];
	 for(int i = 0; i < array.length; i++)
	    newArray[i] = array[i];
	 array = newArray;
      }
      public void print()
      {
	BufferedWriter tulis = new BufferedWriter(new OutputStreamWriter(System.out));
	try
	{
	    if(isEmpty())
		tulis.write("[Empty]");
	    else
	    {
		tulis.write(""+array[0]);
		for(int i = 1; i < updateSize; i++)
		    tulis.write(","+array[i]);
	    }
	    tulis.flush();
	 }
	 catch(IOException e)
	 {
	    e.printStackTrace();
	 }
      }
}

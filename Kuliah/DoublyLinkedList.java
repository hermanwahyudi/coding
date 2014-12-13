/* Copyright (c) 2011 the authors listed at the following URL, and/or
the authors of referenced articles or incorporated external code:
http://en.literateprograms.org/Doubly_linked_list_(Java)?action=history&offset=20100923154839

Permission is hereby granted, free of charge, to any person obtaining
a copy of this software and associated documentation files (the
"Software"), to deal in the Software without restriction, including
without limitation the rights to use, copy, modify, merge, publish,
distribute, sublicense, and/or sell copies of the Software, and to
permit persons to whom the Software is furnished to do so, subject to
the following conditions:

The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

Retrieved from: http://en.literateprograms.org/Doubly_linked_list_(Java)?oldid=16899
*/

class Node<E> {
	Node(E value) {
		this.value = value;
	}

	Node(E value, Node<E> prev, Node<E> next) {
		this.value = value;
		setPrev(prev);
		setNext(next);
	}


	void setPrev(Node<E> prev) {
		this.prev = prev;
	}

	void setNext(Node<E> next) {
		this.next = next;
	}


	Node<E> getPrev() {
		return prev;
	}

	Node<E> getNext() {
		return next;
	}

	E getValue() {
		return value;
	}


	E value;
	Node<E> prev;
	Node<E> next;

}

public class DoublyLinkedList<E> {
	public DoublyLinkedList()
	{
		head.setPrev(null);
		head.setNext(tail);
		tail.setPrev(head);
		tail.setNext(null);
	}


	public Node<E> get(int index) throws IndexOutOfBoundsException {
		Node<E> cursor = head;
		for (int i = 0; i < index; i++) {
			cursor = cursor.getNext();
		}
		return cursor;
	}


	public E remove(int index) throws IndexOutOfBoundsException {
		if (index == 0) {
			throw new IndexOutOfBoundsException();
		} else {
			Node<E> result = get(index);
			result.prev.next = result.next;
			result.next.prev = result.prev;
			length--;
			return result.getValue();
		}
	}


	public void add(int index, E value) throws IndexOutOfBoundsException {
		Node<E> cursor = get(index);
		Node<E> temp = new Node<E>(value);
		temp.prev = cursor;
		temp.next = cursor.next;
		cursor.next.prev = temp;
		cursor.next = temp;
		length++;
	}

	public void addHead(E value) {
		Node<E> cursor = head;
		Node<E> temp = new Node<E>(value);
		temp.setPrev(cursor);
		temp.setNext(cursor.getNext());
		cursor.getNext().setPrev(temp);
		cursor.setNext(temp);
		length++;
	}

	public void addTail(E value) {
		Node<E> cursor = tail.getPrev();
		Node<E> temp = new Node<E>(value);
		temp.setPrev(cursor);
		temp.setNext(cursor.getNext());
		cursor.getNext().setPrev(temp);
		cursor.setNext(temp);
		length++;
	}


	public int size() {
		return length;
	}

	public boolean isEmpty() {
		return length == 0;
	}

	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("(head) - ");
		Node<E> temp = head;
		while (temp.getNext() != tail) {
			temp = temp.getNext();
			result.append(temp.getValue() + " - ");
		}
		result.append("(tail)");
		return result.toString();
	}


	public static void main(String argv[]) {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
		list.addHead(new Integer(1));
		list.addHead(new Integer(2));
		list.addTail(new Integer(9));
		list.addHead(new Integer(3));
		list.addTail(new Integer(11));
		list.add(0, new Integer(0));
		System.out.println(list);
		list.remove(list.size());
		System.out.println(list);
	}


	private Node<E> head = new Node<E>(null);
	private Node<E> tail = new Node<E>(null);
	private int length = 0;

}


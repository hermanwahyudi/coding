/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author clara vania
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String sentence = in.readLine();

        StringTokenizer token;
        String input;
        String command;
        String word;
        String newWord;
        int start, end, position;
        DoublyLinkedList<String> list = new DoublyLinkedList();

        token = new StringTokenizer(sentence);

        while (token.hasMoreTokens()) {
            list.insertAtEnd(token.nextToken());
        }

        System.out.println(list.toString());

        while ((input = in.readLine()) != null) {

            token = new StringTokenizer(input);
            command = token.nextToken();

            if (command.equals("cut") || command.equals("copy")) {
                start = Integer.parseInt(token.nextToken());
                end = Integer.parseInt(token.nextToken());
                position = Integer.parseInt(token.nextToken());
                if (command.equals("cut")) {
                    list.cut(start, end, position);
                } else {
                    list.copy(start, end, position);
                }
                System.out.println(list.toString());
            } else if (command.equals("find")) {
                word = token.nextToken();
                System.out.println(list.find(word));
            } else if (command.equals("replace")) {
                word = token.nextToken();
                newWord = token.nextToken();
                list.replace(word, newWord);
                System.out.println(list.toString());
            }
        }
    }
}

class Node<T> {

    protected T data;
    protected Node<T> next;
    protected Node<T> previous;

    public Node(T data, Node<T> next, Node<T> previous) {
        this.data = data;
        this.next = next;
        this.previous = previous;
    }

    public Node<T> getNextNode() {
        return next;
    }

    public void setNextNode(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPreviousNode() {
        return previous;
    }

    public void setPreviousNode(Node<T> previous) {
        this.previous = previous;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

class DoublyLinkedList<T> {

    protected Node<T> firstNode;
    protected Node<T> lastNode;
    protected int size;

    public <T> DoublyLinkedList() {
        size = 0;
    }

    public Node<T> insertAtBeginning(T data) {
        if (firstNode == null) {
            firstNode = new Node<T>(data, null, null);
            lastNode = firstNode;
        } else {
            Node<T> newNode = new Node<T>(data, firstNode, null);
            firstNode.setPreviousNode(newNode);
            firstNode = newNode;
        }
        size++;
        return firstNode;
    }

    public Node<T> insertAtEnd(T data) {
        if (lastNode == null) {
            insertAtBeginning(data);
        } else {
            Node<T> newNode = new Node<T>(data, null, lastNode);
            lastNode.setNextNode(newNode);
            lastNode = newNode;
            size++;
        }
        return lastNode;
    }

    public Node<T> insertAfter(int index, T data) {
        Node<T> currentNode = getNode(index);
        if (currentNode != null) {
            Node<T> newNode = new Node<T>(data, currentNode.getNextNode(), currentNode);
            if (currentNode.getNextNode() == null) {
                lastNode = newNode;
            } else {
                currentNode.getNextNode().setPreviousNode(newNode);
            }
            currentNode.setNextNode(newNode);
            size++;
            return newNode;
        } else {
            return insertAtEnd(data);
        }
    }

    public Node<T> insertBefore(int index, T data) {
        Node<T> currentNode = getNode(index);
        if (currentNode != null) {
            Node<T> newNode = new Node<T>(data, currentNode, currentNode.getPreviousNode());
            if (currentNode.getPreviousNode() == null) {
                firstNode = newNode;
            } else {
                currentNode.getPreviousNode().setNextNode(newNode);
            }
            currentNode.setPreviousNode(newNode);
            size++;
            return newNode;
        } else {
            return insertAtBeginning(data);
        }
    }

    public Node<T> getNode(int index) {
        int i;
        Node<T> currentNode;
        if (index * 2 >= size) {
            i = size - 1;
            currentNode = lastNode;
            while ((currentNode != null) && (index < i)) {
                currentNode = currentNode.getPreviousNode();
                i--;
            }
        } else {
            i = 0;
            currentNode = firstNode;
            while ((currentNode != null) && (index > i)) {
                currentNode = currentNode.getNextNode();
                i++;
            }
        }
        return currentNode;
    }

    public T getAt(int index) {
        return getNode(index).getData();
    }

    public void deleteAt(int index) {
        Node<T> currentNode = getNode(index);
        deleteNode(currentNode);
    }

    public void deleteNode(Node<T> node) {
        if (node.getNextNode() != null) {
            node.getNextNode().setPreviousNode(node.getPreviousNode());
        } else {
            lastNode = node.getPreviousNode();
        }
        if (node.getPreviousNode() != null) {
            node.getPreviousNode().setNextNode(node.getNextNode());
        } else {
            firstNode = node.getNextNode();
        }
        size--;
    }

    public Node<T> getFirstNode() {
        return firstNode;
    }

    public Node<T> getLastNode() {
        return lastNode;
    }

    public int getSize() {
        return size;
    }

    public void cut(int start, int end, int position) {
        int c = end - start + 1;
		if (position == -1) {
            for (int i = 0; i < c; i++) {
                this.deleteNode(this.getNode(start));
            }
            return;
        }
        for (int i = 0; i < c; i++){
            this.insertAfter(position, this.getAt(end));
            if (end < position){
                end--;
            }
        }
        for (int i = 0; i < c; i++){
            if (start < position){
                this.deleteNode(this.getNode(start));
            }
            else{
                this.deleteNode(this.getNode(start+c));
            }
        }
    }

    public void copy(int start, int end, int position) throws Exception {
        int c = end - start + 1;
        for (int i = 0; i < c; i++){
            this.insertAfter(position, this.getAt(end));
            if (end < position){
                end--;
            }
        }
    }

    public String find(T newData) {
        Node<T> curr = firstNode;
        String g = "";
        int index = 0;

        while (curr != null) {
            if (curr.getData().equals(newData)) {
                g += "[" + index + "]";
            }
            curr = curr.getNextNode();
            index++;
        }
        return g;
    }

    public void replace(T oldData, T newData) {
        Node<T> curr = firstNode;

        while (curr != null) {
            if (curr.getData().equals(oldData)) {
                curr.data = newData;
            }
            curr = curr.getNextNode();
        }
    }

    public String toString() {
        int i = 0;
        Node<T> curr = firstNode;
        String g = "";
        while (curr != null) {
            g += "[" + i + "-" + curr.getData() + "]";
            curr = curr.getNextNode();
            i++;
        }
        return g;
    }
}
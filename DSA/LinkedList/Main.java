
public class Main extends LinkedList {

    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}

class LinkedList {

    private class Node {

        Node(int val) {
            this.value = val;
        }
        private int value;
        private Node next;
    }

    private Node first;
    private Node last;

    //METHODS:
    public void addLast(int value) {
        var node = new Node(value);
        if (first == null) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
    }
}

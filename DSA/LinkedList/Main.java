
public class Main extends LinkedList {

    public static void main(String[] args) {
        System.out.println("Hello World");
        var list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        System.err.println(list.printValues());
        System.err.println("Deleting first item: ");
        list.deleteFirst();
        System.err.println(list.printValues());

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
    public void addFirst(int value) {
        var nn = new Node(value);

        //if empty, Assign a new node as first
        if (first == null) {
            first = nn;
        } //if not empty, create new node, new node.next = first.
        else {
            nn.next = first;
            first = nn;
        }
    }

    public void addLast(int value) {
        var node = new Node(value);
        if (first == null) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
    }

    public String isEmpty() {
        if (first == null) {
            return "empty";
        } else {
            return "not empty";
        }
    }

    public LinkedList printList() {
        var resList = new LinkedList();

        Node current = first;
        while (current != null) {
            resList.addLast(current.value);
            current = current.next;
        }

        return resList;

    }

    public java.util.List<Integer> printValues() {
        java.util.List<Integer> resList = new java.util.ArrayList<>();

        Node current = first;
        while (current != null) {
            resList.add(current.value);
            current = current.next;
        }

        return resList;
    }

    public void deleteFirst() {
        //if empty, return;
        if (first == null) {
            return;
        }
        //first = first.next;
        first = first.next;

    }

}

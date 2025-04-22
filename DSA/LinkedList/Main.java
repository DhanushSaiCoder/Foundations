
public class Main extends LinkedList {

    public static void main(String[] args) {
        System.out.println("Hello World");
        var list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        System.out.println(list.printValues());
        System.out.println(list.indexOf(20));
    }
}

class LinkedList {

    private class Node {

        Node(int val) {
            this.value = val;
        }
        private final int value;
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

    public void deleteLast() {
        //if empty, return;
        if (first == null) {
            return;
        }

        //iterate upto curr.next == last as temp, temp.next = null;
        Node curr = first;
        while (curr.next != last) {
            curr = curr.next;
        }
        curr.next = null;
        last = curr;
    }

    public String containsNode(int item) {
        //iterate through the ll, if curr.value == item, return true;
        if (first == null) {
            return "false";
        }

        Node curr = first;
        while (curr != null) {
            if (curr.value == item) {
                return "true";
            }
            curr = curr.next;
        }

        return "false";
    }

    public int indexOf(int item) {
        //if empty return -1;
        if (first == null) {
            return -1;
        }
        Node curr = first;
        int index = 0;
        while (curr != null) {
            if (curr.value == item) {
                return index;
            }
            curr = curr.next;
            index++;
        }
        return -1;
    }

}

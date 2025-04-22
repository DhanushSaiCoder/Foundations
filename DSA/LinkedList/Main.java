
public class Main extends LinkedList {

    public static void main(String[] args) {
        System.out.println("Hello World");
        var list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        System.err.println(list.isEmpty());

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
    public String isEmpty(){
        if(first == null){
            return "empty";
        }
        else return "not empty";
    }
}

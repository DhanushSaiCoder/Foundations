
public class MergeKSortedLists extends LinkedList {

    public static void main(String[] args) {
        var list = new LinkedList();
        var aList = new LinkedList();
        var bList = new LinkedList();
        var cList = new LinkedList();

        aList.addLast(1);
        aList.addLast(3);
        aList.addLast(5);

        bList.addLast(1);
        bList.addLast(2);
        bList.addLast(3);
        bList.addLast(7);

        cList.addLast(2);
        cList.addLast(3);
        cList.addLast(4);
        cList.addLast(4);
        cList.addLast(7);

        list.addList(aList);
        list.addList(bList);
        list.addList(cList);

        System.out.println(list.printValues());
    }

}

class LinkedList {

    private class Node {

        public Node(int value) {
            this.value = value;
        }

        private final int value;
        private Node next;
    }
    private Node first;
    private Node last;

    //METHODS:
    public void addList(LinkedList newList) {
        if (first == null) {
            first = newList.first;
        }
        if (first == last) {
            first = last = newList.first;
            return;
        } else {
            last.next = newList.first;
            last = newList.last;
        }
    }

    public void linkNodes(int x, int y) {
        Node a, b;
        a = b = first;
        int aindex = 0, bindex = 0;
        while (aindex != x || bindex != y) {
            if (bindex != y) {
                b = b.next;
                bindex++;
            }
            if (aindex != x) {
                a = a.next;
                aindex++;
            }
        }
        System.out.println("Linking: " + b.value + " to " + a.value);
        b.next = a;
    }

    public void addFirst(int value) {
        var nn = new Node(value);

        //if empty, Assign a new node as first
        if (first == null) {
            first = last = nn;
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

    public void reverse() {
        //    [10 20 30 40]
        //   p  c  n
        // If the list is empty or has only one node, no need to reverse
        if (first == null || first == last) {
            return;
        }

        Node previous = null;
        Node current = first;
        Node next;

        // Traverse the list and reverse the links
        while (current != null) {
            next = current.next; // Save the next node
            current.next = previous; // Reverse the link
            previous = current; // Move previous to current
            current = next; // Move current to next
        }

        // Swap first and last nodes
        last = first;
        first = previous;
    }

    public int Kth(int k) {
        Node a = first, b = first;
        int bdistance = 0;
        while (b.next != null) {
            if (bdistance != k - 1) {
                b = b.next;
                bdistance++;
                continue;
            }
            a = a.next;
            b = b.next;
        }
        return a.value;
    }

    public void RemoveNthFromEnd(int n) {
        // [10 20 30 40] n=3
        // [10 30 40]

        // [10 20 30 40]
        //  x   a     b
        Node x, a, b;
        x = a = b = first;
        var abdist = 1;
        while (true) {
            if (b.next != null) {
                b = b.next;
                continue;
            }
            if (abdist != n - 1) {
                a = a.next;
                abdist++;
            } else if (x.next != a) {
                x = x.next;
            } else {
                break;
            }
        }

        x.next = a.next;
    }

    public int findCycleBeg() {
        // [10 20 30 40 50]
        //      |     |
        //       <-----

        // FLOYD'S ALGORITHM:
        // two pointers: a, b( a one step at at time, b 2 steps)
        //increment the pointers until they meet at some point, if they meet:
        // >> move a to head, and increment again,
        // >> they meet at the beg of the cycle.
        // >> move a to head and count the index of the meeting node, return the index.
        //if the first pointer reachs the tail, return -1 
        Node a = first;
        Node b = first;
        do {
            if (a.next == null || b.next == null) {
                return -1;
            }
            a = a.next;
            b = (b.next).next;
        } while (a != b);
        a = first;
        var index = 0;
        while (a != b) {
            a = a.next;
            index++;
            b = (b.next).next;
        }
        return a.value;
    }

}

import java.util.ArrayDeque;
import java.util.Queue;

public class ReverseAQueue{
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        
        System.out.println(queue.remove());

    }
}
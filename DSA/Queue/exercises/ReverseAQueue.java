
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class ReverseAQueue {

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        System.out.println(queue);
        System.out.println("After Reversing: ");
        queue = reverse(queue);
        System.out.println(queue);
    }

    public static Queue<Integer> reverse(Queue<Integer> queue) {
        // [10, 20, 30, 40] => [40, 30, 20, 10]
        
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
        return queue;

        // while (true) {
        //     if (!queue.isEmpty()) {
        //         var item = queue.remove();
        //         stack.push(item);
        //         continue;
        //     }
        //     if(stack.isEmpty()) return queue;
        //     queue.add(stack.pop());
        // }
    }
}

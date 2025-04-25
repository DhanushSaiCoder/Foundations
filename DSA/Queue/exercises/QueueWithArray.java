import  java.util.Arrays;

public class QueueWithArray {

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.dequeue();
        System.out.println("Queue: " + queue.print());

    }

    public static class ArrayQueue {

        private static  int front = -1;
        private static int rear = -1;
        private static int limit = 5;
        private static  int[] queue = new int[limit];

        public void enqueue(int item) {
            //if empty: 
            if (front == -1) {
                queue[0] = item;
                front++;
                rear++;
                return;
            }

            //if full: 
            if (rear - front >= limit) {
                return;
            }

            queue[++rear] = item;
        }

        public int dequeue() {
            //if empty: 
            if (front == -1) {
                return -1;
            }

            var item = queue[front];

            //if only one item left:
            if (front == rear) {
                front = rear = -1;
            }

            front++;
            return item;
        }

        public Boolean isEmpty() {
            return front == -1;
        }

        public String peek() {
            if (front != -1) {
                return String.valueOf(queue[front]);
            }
            return "Queue is empty.";
        }

        public String print() {
            if(isEmpty()) return "[]";
            int[] resultArr = new int[limit];
            int length=0, resultF = front;
            for(int i = front; i <= rear; i++){
                resultArr[length] = queue[resultF];
                length++;
                resultF++;
            }
            return Arrays.toString(resultArr);
        }
    }
}

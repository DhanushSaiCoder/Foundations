
public class QueueWithArray {

    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }

    public class ArrayQueue {

        private int front = -1;
        private int rear = -1;
        private int[] queue;
        private int limit = 5;

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

        public String peek(){
            if(front != -1) return String.valueOf(queue[front]);
            return "Queue is empty.";
        }

        public String print(ArrayQueue queue) {
            if(isEmpty()) return "Queue is empty.";
           
        }
    }
}

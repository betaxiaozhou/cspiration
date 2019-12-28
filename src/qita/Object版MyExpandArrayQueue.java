public class Main018_MyQueue {
    public static void main(String[] args) {
        Queue queue = new Queue(2);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        queue.offer(6);
        queue.offer(7);
        queue.offer(8);
        queue.poll();
        while (!queue.isEmpty()) {
            System.out.print("," + queue.poll());
        }
    }
}

// 数组实现可扩容循环队列
class ArrayQueue {//Object版
    private Object[] arr;// queArray
    private int capacity;// 它是数组的长度maxSize,最大能放的元素比它小1
    private int front;
    private int rear;

    public ArrayQueue(int initialCapacity) {// initialCapacity:不扩容初始能存的最大元素个数
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("队列初始容量不能小于0: " + initialCapacity);
        }
        capacity = initialCapacity + 1;
        arr = new Object[capacity];
        front = 0;
        rear = 0;
    }

    public void offer(Object element) {
        if (isFull()) expand();
        arr[rear] = element;
        rear = (rear + 1) % capacity;
    }

    public Object poll() {
        if (isEmpty()) {
            return null;
        } else {
            Object element = arr[front];
            front = (front + 1) % capacity;
            return element;
        }
    }

    public boolean isEmpty() {// 只有空
        return front == rear;
    }

    public boolean isFull() {// 空一个位置
        return ((rear + 1) % capacity) == front;// capacity==queArray.length
    }

    // 数组扩容
    private void expand() {
        int newSize = capacity * 2 + 1;// 新数组大小
        Object[] newArray = new Object[newSize];
        for (int i = 0; i < capacity; i++) {
            newArray[i] = arr[front];
            front = (front + 1) % capacity;
        }
        arr = newArray;
        front = 0;
        // 为啥是capacity - 1,因为rear是索引0开始到capacity-1,共capacity位,rear是最后一位capacity - 1,是一个空项
        rear = capacity - 1;// rear = nItems //上一次满了,那么就是只比容量小1
        capacity = newSize;
    }

}

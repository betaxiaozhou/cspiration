public class Main018_MyArray {
    public static void main(String[] args) throws Exception {
        MyArray myArray = new MyArray(4);
        myArray.add(0, 1);
        myArray.add(0, 2);
        myArray.add(0, 3);
        myArray.add(0, 4);
        myArray.remove(0);
        myArray.add(3, 5);
        myArray.add(100);
        myArray.output();
    }
}

class MyArray {
    private int[] arr;

    private int size;

    public MyArray(int capacity) {// initialCapacity
        this.arr = new int[capacity];
        this.size = 0;
    }

    /**
     * @param index   插入的元素的位置
     * @param element 插入的元素
     * @throws Exception
     */
    public void add(int index, int element) throws Exception {// insert
        if (index < 0 || index > size) {
            throw new Exception("插入的元素位置超越了数组实际的元素范围");
        }
        ensureCapacity(size + 1);// 检查容量
        // 这个循环就是在插入元素的时候，将指定位置上的元素都向后移动一位，
        // 给要插入的元素腾出位置
        // 移动顺序就是从最后一个元素开始向后移动，一直到原有位置的元素后移一位
        for (int i = size - 1; i >= index; i--) {
            arr[i + 1] = arr[i];
        }
        arr[index] = element;
        size++;
    }

    public boolean add(int element) {// insert
        ensureCapacity(size + 1);// 检查容量
        arr[size++] = element;
        return true;
    }

    //检查容量
    private void ensureCapacity(int size) {
        int len = arr.length;
        if (size > len) {// 数组已满
            grow();// 扩容
        }
    }

    /**
     * 数组进行扩容，这里必须选择正整数
     */
    private void grow() {
        int[] newArray = new int[arr.length * 2];
        // 将原有数组的内容复制到新数组中
        // 把原数组arr从索引0开始复制到新数组newArray中(新数组也从0开始),复制长度为arr.length
        System.arraycopy(arr, 0, newArray, 0, arr.length);
        // 原有数组指向新数组的内容
        arr = newArray;
//         arr = Arrays.copyOf(arr, arr.length * 2);//这样写也行，那么上面的都不用了
    }

    /**
     * 删除指定位置的元素
     *
     * @param index
     * @throws Exception
     */
    public void remove(int index) throws Exception {// delete
        if (index < 0 || index > size - 1) {
            throw new Exception("不存在该下标对应的元素");
        }
        //如果是删最后一个元素,不会走这个循环,直接size--
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
    }

    public void output() {
        for (int i = 0; i < size; i++) {
            System.out.println(arr[i]);
        }
    }

}

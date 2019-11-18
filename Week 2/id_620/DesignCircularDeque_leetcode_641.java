/**
 * 设计实现双端队列。
 你的实现需要支持以下操作：

 MyCircularDeque(k)：构造函数,双端队列的大小为k。
 insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
 insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
 deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
 deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
 getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
 getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
 isEmpty()：检查双端队列是否为空。
 isFull()：检查双端队列是否满了。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/design-circular-deque
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class MyCircularDeque {
    /**
     * 双端队列
     */
    private int[] deque;
    /**
     * 头指针
     */
    private int  head;
    /**
     * 尾指针
     */
    private int  tail;
    /**
     * 队列容量
     */
    private int capacity;
    private int flag;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.deque = new int[k];
        this.capacity = k;
        this.head = 0;
        this.tail = 0;
        this.flag = 0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        //判断队满
        if (this.isFull()){
            return false;
        }
        if (this.isEmpty()){
            this.deque[this.head] = value;
            this.tail++;
            if (this.tail == this.capacity){
                this.tail = 0;
            }
        }else {
            this.head--;
            if (this.head == -1){
                this.head = this.capacity -1;
            }
            this.deque[this.head] = value;
        }
        this.flag = 1;
        return true;

    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (this.isFull()){
            return false;
        }
        if (this.isEmpty()){
            this.deque[this.head] = value;
            this.tail++;
            if (this.tail == this.capacity){
                this.tail = 0;
            }
        }else {

            this.deque[this.tail] = value;
            this.tail++;
            if (this.tail == this.capacity){
                this.tail = 0;
            }

        }
        this.flag = 1;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (this.isEmpty()){
            return false;
        }
        this.head++;
        if (this.head == this.capacity){
            this.head = 0;
        }
        this.flag = 0;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (this.isEmpty()){
            return false;
        }
        this.tail--;
        if (this.tail == -1){
            this.tail = this.capacity -1;
        }
        this.flag = 0;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (this.isEmpty()){
            return -1;
        }
        return this.deque[this.head];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (this.isEmpty()){
            return -1;
        }
        if(this.tail == 0){
            return this.deque[this.capacity-1];
        }
        return this.deque[this.tail-1];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        if (this.head == this.tail && this.flag == 0){
            return true;
        }
        return false;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        if (this.tail == this.head && this.flag == 1){
            return true;
        }
        return false;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
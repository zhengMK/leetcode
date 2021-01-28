class MyCircularQueue {
    public int frontPtr, rearPtr, size;
    public int[] array;
    public MyCircularQueue(int k) {
        array = new int[k];
        frontPtr = 0;
        rearPtr = 0;
        size = k;
    }
    
    public boolean enQueue(int value) {
        if (!isFull()) {
            array[rearPtr] = value;
            if (frontPtr <= rearPtr) {
                if (rearPtr < array.length - 1) rearPtr += 1;
                else rearPtr = 0;
            } else {
                rearPtr += 1;
            }
            size -= 1;
            return true;
        } else return false;
    }
    
    public boolean deQueue() {
        if (isEmpty()) return false;
        else {
            if (frontPtr < rearPtr) {
                frontPtr += 1;
            } else {
                if (frontPtr == array.length - 1) frontPtr = 0;
                else frontPtr += 1;
            }
            size += 1;
            return true;
        }
    }
    
    public int Front() {
        if (isEmpty()) return -1;
        return array[frontPtr];
    }
    
    public int Rear() {
        if (isEmpty()) return -1;
        else {
            if (rearPtr - 1 < 0) return array[array.length - 1];
            else return array[rearPtr - 1];
        }
    }
    
    public boolean isEmpty() {
        return size == array.length;
    }
    
    public boolean isFull() {
        return size == 0;
    }

//    public static void main(String[] args) {
//        MyCircularQueue queue = new MyCircularQueue(3);
//        for(int i = 0; !queue.isFull(); i++) queue.enQueue(i);
////        System.out.println(queue.Front());
////        System.out.println(queue.Rear());
//        for (int i = 5; !queue.isEmpty(); i++) {
//            System.out.println(queue.Front());
//            System.out.println(queue.Rear());
//            queue.deQueue();
//            queue.enQueue(i);
//        }
//    }
}
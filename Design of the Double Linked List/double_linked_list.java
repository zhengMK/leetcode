class MyLinkedList {
    Node head;
    int size;

    class Node {
        int val;
        Node prev;
        Node next;
        public Node() {
            this.val = 0;
            next = null;
        }
        public Node(int val) {
            this.val = val;
            next = null;
        }
    }


    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = null;
        size = 0;
        // printLinkedList();
    }

    public MyLinkedList(int val) {
        this.head = new Node(val);
        this.size = 1;
        head.next = null;
        head.prev = null;
        // printLinkedList();
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        Node ptr = head;
        return get(ptr, index);
    }
    private int get(Node ptr, int index) {
        if (index == 0) {
            return ptr.val;
        }
        return get(ptr.next, index - 1);
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if (head == null) {
            head = new Node(val);
            size += 1;
            // printLinkedList();
            return;
        }
        head.prev = new Node(val);
        head.prev.next = head;
        head = head.prev;
        this.size += 1;
        // printLinkedList();
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (head == null) {
            head = new Node(val);
            size += 1;
            // printLinkedList();
            return;
        }
        Node ptr = head;
        while(ptr.next != null) {
            ptr = ptr.next;
        }
        this.size += 1;
        ptr.next = new Node(val);
        ptr.next.prev = ptr;
        // printLinkedList();
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;
        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }
        Node ptr = head;
        addAtIndex(ptr, index, val);
    }
    private void addAtIndex(Node ptr, int index, int val) {
        if (index == 0) {
            Node temp = ptr.prev;
            ptr.prev = new Node(val);
            ptr.prev.next = ptr;
            temp.next = ptr.prev;
            ptr.prev.prev = temp;
            size += 1;
            // printLinkedList();
            return;
        }
        addAtIndex(ptr.next, index - 1, val);
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0|| index >= size) return;
        if (index == 0) {
            size -= 1;
            if (size == 0) {
                head = null;
                // printLinkedList();
                return;
            }
            head.next.prev = null;
            head = head.next;
            // printLinkedList();
            return;
        }

        Node ptr = head;
        deleteAtIndex(ptr, index);
    }
    private void deleteAtIndex(Node ptr, int index) {
        if (index == 0) {
            size -= 1;
            if (ptr.next == null) {
                ptr.prev.next = null;
                // printLinkedList();
                return;
            }
            ptr.prev.next = ptr.next;
            ptr.next.prev = ptr.prev;
            // printLinkedList();
            return;
        }
        deleteAtIndex(ptr.next, index - 1);
    }

    public void printLinkedList() {
        for (Node ptr = head; ptr != null; ptr = ptr.next) {
            System.out.print(ptr.val + "\t");
        }
        System.out.println();
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
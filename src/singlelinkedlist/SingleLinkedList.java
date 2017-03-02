package singlelinkedlist;

/**
 * 单链表.
 *
 * @author Yohann.
 */
public class SingleLinkedList<T> {
    private Node<T> head; // 头指针
    private Node<T> tail; // 尾指针
    private int size;     // 链表长度

    /**
     * 构造一个单链表.
     *
     * @param data
     */
    public SingleLinkedList(T data) {
        Node<T> newNode = new Node<>(data, null);
        head = newNode;
        tail = newNode;
        size = 1;
    }

    /**
     * 在链表首部添加结点.
     *
     * @param data
     */
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data, null);
        newNode.next = head;
        head = newNode;
        size++;
    }

    /**
     * 在链表尾部添加结点.
     *
     * @param data
     */
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data, null);
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    /**
     * 在链表指定索引处添加结点.
     *
     * @param index
     * @param data
     */
    public void add(int index, T data) {
        // 参数检验
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index越界 index=" + index);
        }

        // 特殊索引
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size) {
            addLast(data);
            return;
        }

        Node<T> newNode = new Node<>(data, null);
        Node<T> p = head;
        for (int i = 0; i < index - 1; i++) {
            p = p.next;
        }
        newNode.next = p.next;
        p.next = newNode;
        size++;
    }

    /**
     * 删除链表头部结点.
     */
    public void removeFirst() {
        Node<T> temp = head;
        head = head.next;
        temp.next = null;
        size--;
    }

    /**
     * 删除链表尾部结点.
     */
    public void removeLast() {
        Node<T> p = head;
        while (p.next != null) {
            if (p.next.next == null) {
                p.next = null;
                size--;
                return;
            }
            p = p.next;
        }
    }

    /**
     * 删除链表指定索引处的结点.
     *
     * @param index
     */
    public void remove(int index) {
        // 参数检验
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("index越界 index=" + index);
        }

        // 特殊索引
        if (index == 0) {
            removeFirst();
            return;
        }
        if (index == size - 1) {
            removeLast();
            return;
        }

        Node<T> p = head;
        for (int i = 0; i < index - 1; i++) {
            p = p.next;
        }
        p.next = p.next.next;
        p.next.next = null;
        size--;
    }

    @Override
    public String toString() {
        String list = "";

        if (size == 1) {
            list = head.toString();
        }
        if (size > 1) {
            Node<T> p = head;
            list = p.toString();
            while (p.next != null) {
                list = list + " --> " + p.next.toString();
                p = p.next;
            }
        }

        return list;
    }
}

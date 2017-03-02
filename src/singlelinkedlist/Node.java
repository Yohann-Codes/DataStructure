package singlelinkedlist;

/**
 * 结点类.
 *
 * @author Yohann.
 */
public class Node<T> {
    public T data;       // 数据域
    public Node<T> next; // 地址域

    /**
     * 构造一个结点.
     *
     * @param data
     * @param next
     */
    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}

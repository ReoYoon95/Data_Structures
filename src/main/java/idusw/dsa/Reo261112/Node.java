package idusw.dsa.Reo261112;

public class Node <E> {
    public E data;
    public Node<E> next;

    public Node(E data) {
        this.data = data;
        this.next = null;
    }

    public Node(E newItem, Node<E> next) {
        this.data = newItem;
        this.next = next;
    }
}

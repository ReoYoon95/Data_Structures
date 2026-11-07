package idusw.dsa.Reo261107_HW;

public interface MyList<E> {
    public void add(int i, E x);
    public void append(E x);
    public E remove(int i);
    public boolean removeItem(E x);
    public E get(int i);
    public void set(int i, E x);
    public int indexOf(E x);
    public int size();
    public boolean isEmpty();
    public void clear();
    MyLinkedList<E> subList(int from, int to);
    int getMax();
    int getMin();
    MyLinkedList<E> sortByAsc();
    MyLinkedList<E> sortByDesc();
}


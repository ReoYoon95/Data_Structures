package idusw.dsa.Reo261112;

public interface StackInterface<E> {
    public void push(E newItem);
    public E pop();
    public E top();
    public boolean isEmpty();
    public void popAll();

}

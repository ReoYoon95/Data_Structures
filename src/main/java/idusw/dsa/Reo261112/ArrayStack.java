package idusw.dsa.Reo261112;

public class ArrayStack<E> implements StackInterface<E> {
    private E[] stack;
    private int topIndex;
    private static final int DEFAULT_CAPACITY = 64;


    public ArrayStack() {
        this.stack = (E[]) new Object[DEFAULT_CAPACITY];
        this.topIndex = -1;
    }

    public ArrayStack(int n) {
        stack = (E[]) new Object[n];
        topIndex = -1;
    }

    public void push(E newItem){
        if (topIndex == stack.length - 1) {
            // Stack is full, need to resize
        }
        stack[++topIndex] = newItem;
    }

    public E pop(){
        if (isEmpty()) {
            return null;
        }
        E item = stack[topIndex];
        stack[topIndex--] = null; // Help GC
        return item;
    }

    public E top(){
        if (isEmpty()) {
            return null;
        }
        return stack[topIndex];
    }

    public boolean isEmpty(){
        return topIndex == -1;
    }

    public void popAll(){
        while (!isEmpty()) {
            pop();
        }
    }
}
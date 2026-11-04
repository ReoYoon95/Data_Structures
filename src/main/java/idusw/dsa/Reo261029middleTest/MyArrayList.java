package idusw.dsa.Reo261029middleTest;


public class MyArrayList<E> implements ListInterface<E> {

    private E[] item;
    private int numItems;
    private static final int DEFAULT_CAPACITY = 64;
    private static final int Not_FOUND = -1;

    public MyArrayList() {
        item = (E[]) new Object[DEFAULT_CAPACITY];
        numItems = 0;
    }

    public MyArrayList(int n) {
        item = (E[]) new Object[n];
        numItems = 0;
    }

    public void add(int k, E x) {
        if (numItems >= item.length || k <0 || k > numItems) {
            throw new IndexOutOfBoundsException();
        }

        else {
            for (int i = numItems - 1; i >= k; i--) {
                item[i + 1] = item[i];
            }
            item[k] = x;
            numItems++;
        }
    }

    public void add(E x) {
        add(numItems, x);
    }

    public String toString(int from, int to) {
        if (from < 0 || to > numItems || from > to) {
            throw new IndexOutOfBoundsException();
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = from; i < to; i++) {
            sb.append(item[i]);
            if (i < to - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}

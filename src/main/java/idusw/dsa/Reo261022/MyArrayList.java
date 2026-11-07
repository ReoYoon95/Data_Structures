package idusw.dsa.Reo261022;

public class MyArrayList<E> implements ListInterface<E> {
    private E[] item;
    private int numItems;
    //    private Integer[] item;
//    private int numItems;
    private static final int DEFAULT_CAPACITY = 64;
    private static final int NOT_FOUND = -1;

    public MyArrayList() {  // 생성자 1
        item = (E[]) new Object[DEFAULT_CAPACITY];
        numItems = 0;
    }

    public MyArrayList(int n) {  // 생성자 2
//        item = new Integer[n];
        item = (E[]) new Object[n];
        numItems = 0;
    }

    public void add(int k, E x) {
        if (numItems >= item.length || k < 0 || k > numItems) { // 이 부분 채워야함 /*에러 처리*/
            throw new IndexOutOfBoundsException("인덱스 범위 초과 또는 용량 부족: k=" + k);
        }    // 배열 용량 초과
        else {
            for (int i = numItems - 1; i >= k; i--)
                item[i + 1] = item[i];   // shift right
            item[k] = x;
            numItems++;
        }
    }

    //append -> add로 수정
//    void add(Integer x) {
    public void add(E x) {
//        //파라미터 한개만 받고 append 에서 add로 이름만 바꿔서 append처럼 작동하게 할경우
//        if (numItems >= item.length) {
//            throw new IndexOutOfBoundsException("인덱스 범위 초과 또는 용량 부족");
//        }
//        else
//            item[numItems++] = x;

        // 8페이지 조건: add(k, x)를 호출하여 맨 끝(numItems)에 추가
        //조건 -> 배열 리스트를 구현할 때 append(x) 메소드를 구현하는데 add(k,x)를 호출하는 방식으로 수정하시오.
        add(numItems, x);
    }

    //    Integer remove(int k) {  // 리턴값 추가
    public E remove(int k) {  // 리턴값 추가
        if (isEmpty() || k < 0 || k > numItems - 1)
            return null;
        else {
            E tmp = item[k];
            for (int i = k; i <= numItems - 2; i++)
                item[i] = item[i + 1];   // shift left
            numItems--;
            return tmp;
        }
    }

    public boolean removeItem(E x) {
        int k = 0;
        while (k < numItems && item[k] != x)
            k++;
        if (k == numItems) return false;
        else {
            for (int i = k; i <= numItems - 2; i++)
                item[i] = item[i + 1];   // shift left
            numItems--;
            return true;
        }
    }

    public E get(int i) {
        if (i >= 0 && i <= numItems - 1)
            return item[i];
        else return null;
    }

    public void set(int i, E x) {
        if (i >= 0 && i <= numItems - 1)
            item[i] = x;
        else { /* 에러 처리 */
            throw new IndexOutOfBoundsException("유효하지 않은 인덱스입니다: i = " + i);
        }
    }

    public int indexOf(E x) {
        int i = 0;
        while (i < numItems && item[i] != x)
            i++;
        if (i == numItems) return NOT_FOUND;
        else return i;  // x = item[i]는 i번 원소
    }

    public int size() {
        return numItems;
    }

    public boolean isEmpty() {
        return numItems == 0;
    }

    public void clear() {
        item = (E[]) new Object[item.length];
        numItems = 0;
    }

    public String toString() {
        //  구현 필요

        String str = "[";
        for (int i = 0; i < numItems; i++) {
            str += item[i];
            if (i < numItems - 1) {
                str += ", ";
            }
        }
        str += "]";
        return str;
    }

    public int getMaxIdx() {
        if (isEmpty()) {
            throw new IllegalStateException("리스트가 비어 있습니다.");
        }
        int max = (Integer) item[0];
        int index = 0;
        for (int i = 0; i < numItems; i++) {
            int current = (Integer) item[i];
            if (max < current) {
                max = current;
                index = i;
            }
        }
        return index;
    }

    public int getMinIdx() {
        if (isEmpty()) {
            throw new IllegalStateException("리스트가 비어 있습니다.");
        }
        int min = (Integer) item[0];
        int index = 0;
        for (int i = 0; i < numItems; i++) {
            int current = (Integer) item[i];
            if (min > current) {
                min = current;
                index = i;
            }
        }
        return index;
    }

    public MyArrayList<E> subList(int from, int to) {
        if (from < 0 || to >= numItems || from > to) {
            throw new IndexOutOfBoundsException("유효하지 않은 인덱스 범위입니다.");
        }

        MyArrayList<E> ret = new MyArrayList<>(to - from + 1);
        for (int i = from; i <= to; i++) {
            ret.add(item[i]);
        }
        return ret;
    }

    public MyArrayList<E> cloneList(int start, int end) {
        return this.subList(start, end);
    }
}

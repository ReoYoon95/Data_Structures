package idusw.dsa.Reo261107_HW;

public class MyArrayList {
    private Integer[] item;
    private int numItems;
    private static final int DEFAULT_CAPACITY = 64;
    private static final int NOT_FOUND = -1;

    public MyArrayList() {  // 생성자 1
        item = new Integer[DEFAULT_CAPACITY];
        numItems = 0;
    }

    public MyArrayList(int n) {  // 생성자 2
        item = new Integer[n];
        numItems = 0;
    }

    void add(int k , Integer x) { // k < numItems - 1
        if (numItems >= item.length)
        { /*에러 처리*/ }    // 배열 용량 초과
        else {
            for (int i = numItems-1; i >= k; i--)
                item[i+1] = item[i];   // shift right
            item[k] = x;
            numItems++;
        }
    }
    void append(Integer x) { // overloading : 중첩
        add(numItems, x);
        /*
        if (numItems >= item.length) {  }
        else
            item[numItems++] = x;

         */
    }
    Integer remove(int k) {  // 리턴값 추가
        if (isEmpty() || k < 0 || k > numItems-1)
            return null;
        else {
            Integer tmp = item[k];
            for (int i = k; i <= numItems-2; i++)
                item[i] = item[i+1];   // shift left
            numItems--;
            return tmp;
        }
    }
    boolean removeItem(Integer x) {
        int k = 0;
        while (k < numItems && item[k] != x)
            k++;
        if (k == numItems) return false;
        else {
            for (int i = k; i <= numItems-2; i++)
                item[i] = item[i+1];   // shift left
            numItems--;
            return true;
        }
    }
    Integer get(int i) {
        if (i >= 0 && i <= numItems-1)
            return item[i];
        else return null;
    }
    void set(int i, Integer x) {
        if (i >= 0 && i <= numItems-1)
            item[i] = x;
        else { /* 에러 처리 */ }
    }
    int indexOf(Integer x) {
        int i = 0;
        while (i < numItems && item[i] != x)
            i++;
        if (i == numItems) return NOT_FOUND;
        else return i;  // x = item[i]는 i번 원소
    }
    int size() {
        return numItems;
    }
    boolean isEmpty() {
        return numItems == 0;
    }
    void clear() {
        item = new Integer[item.length];
        numItems = 0;
    }
    public String toStr() {
        // 메소드 이름을 toString()으로 변경하는 경우 : overriding(재정의)
        // 자바의 모든 클래스는 Object 클래스로 부터 상속
        // Object 클래스에는 toString() 이 정의되어 있음
        String str = "[";
        for(int i = 0; i < numItems - 1; i++)
            str += item[i] + ",";
        str += item[numItems-1];
        return str + "]";
    }

    public String toStr2() {
        String str = "{";
        for(int i = 0; i < numItems; i++) { // 원소수(numItems) : 7, 인덱스 0 ~ 6 (numItems - 1)
            str = str + item[i]; // + : add 연산자 아님, concatenation(연결 연산자)
            if(i < numItems-1) // 6 < 6 : 논리적으로 false 임
                str = str + ",";
        }
        return str + "}";
    }
    public MyArrayList subList(int from, int to) {
        MyArrayList list = new MyArrayList();
        for (int i = from; i <= to; i++) { // from ~ to 인덱스 까지
            list.append(item[i]);
        }
        return list;
    }
    public int getMax() { // 최대값을 갖는 원소의 인덱스 반환
        int max = item[0];
        int idx = 0;
        for(int i = 1; i < numItems; i++) {
            if(item[i] > max) {
                max = item[i];
                idx = i;
            }
        }
        return idx;
    }
    public int getMin() { // 최소값을 갖는 원소의 인덱스 반환
        int min = item[0];
        int idx = 0;
        for(int i = 1; i < numItems; i++) {
            if(item[i] < min) {
                min = item[i];
                idx = i;
            }
        }
        return idx;
    }
}

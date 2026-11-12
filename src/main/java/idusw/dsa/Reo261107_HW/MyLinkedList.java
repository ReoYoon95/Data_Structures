package idusw.dsa.Reo261107_HW;

public class MyLinkedList<E> implements MyList<E> {
    private Node<E> head;
    private int numItems;
    public MyLinkedList() {
        numItems = 0;
        head = new Node<>(null, null);
    }

    public void add(int index, E x) { // 첫번째 원소를 0번째 원소로 표기
        if (index >= 0 && index <= numItems) {
            Node<E> prevNode = getNode(index - 1);
            Node<E> newNode = new Node<>(x, prevNode.next);
            prevNode.next = newNode;
            numItems++;
        } else {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + numItems);
            }
    }
    public void append(E x) {
        add(numItems, x);

//        Node<E> prevNode = head;  // 더미 헤드
//        while (prevNode.next != null)
//            prevNode = prevNode.next;
//        Node<E> newNode = new Node<>(x, null);
//        prevNode.next = newNode;
//        numItems++;
    }
    public E remove(int index) {
        if (index >= 0 && index <= numItems-1) {
            Node<E> prevNode = getNode(index - 1);
            Node<E> currNode = prevNode.next;
            prevNode.next = currNode.next;
            numItems--;
            return currNode.item;
        } else return null; // 에러
    }

    public boolean removeItem(E x) {
        Node<E> currNode = head;  // dummy node
        for (int i = 0; i <= numItems-1; i++) {
            Node<E> prevNode = currNode;
            currNode = prevNode.next;
            if (((Comparable)(currNode.item)).compareTo(x) == 0) {
                prevNode.next = currNode.next;
                numItems--;
                return true;
            }
        }
        return false;
    }
    public E get(int index) { // 첫번째 원소를 0번째 원소로 표기
        if (index >= 0 && index <= numItems-1)
            return getNode(index).item;
        else return null; // 에러
    }
    public void set(int index, E x) {
        if (index >= 0 && index <= numItems-1)
            getNode(index).item = x;
        else { /* 에러 처리 */ }
    }
    private Node<E> getNode(int index) { // 첫번째 노드를 0번째 노드로 표기
        // return reference to indexth node
        if (index >= -1 && index <= numItems-1) {
            Node<E> currNode = head;  // dummy head
            for (int i = 0; i <= index; i++)
                currNode = currNode.next;
            return currNode;
        } else return null; // 에러
    }
    private final int NOT_FOUND = -1;
    public int indexOf(E x) { // return item x's index
        Node<E> currNode = head;  // 더미 헤드
        for (int i = 0; i <= numItems-1; i++) {
            currNode = currNode.next;
            if (((Comparable)(currNode.item)).compareTo(x) == 0) return i;
        }
        return NOT_FOUND;
    }
    public int size() {
        return numItems;
    }
    public boolean isEmpty() {
        return numItems == 0;
    }
    public void clear() {
        numItems = 0;
        head = new Node(null, null);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        //더미헤드방식이라 현노드를 헤드 다음에 연결.
        Node<E> currNode = head.next;
        // 현재 노드가 null이 아닐 때까지 반복
        while (currNode != null) {
            sb.append(currNode.item);
            if (currNode.next != null) {
                sb.append(", ");
            }
            //위 조건 끝났으니 다음 노드 이동
            currNode = currNode.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public MyLinkedList<E> subList(int from, int to) {
        MyLinkedList<E> subList = new MyLinkedList<>();
        Node<E> currNode = head.next;
        //시작할 위치로 이동
        for(int i = 0; i < from && currNode != null; i++) {
            currNode = currNode.next;
        }
        //서브리스트 프롬부터 투까지 이동
        for(int i = from; i < to && currNode != null; i++) {
            subList.append(currNode.item);
            currNode = currNode.next;
        }

        return subList;
    }

    public int getMax() {
        if (isEmpty()) {
            throw new IllegalStateException("리스트가 비어 있습니다.");
        }
        Node<E> currNode = head.next;
        E max = currNode.item;
        int maxIndex = 0;
        int currIndex = 0;

        while(currNode != null) {
            if (((Comparable)(currNode.item)).compareTo(max) > 0) {
                max = currNode.item;
                maxIndex = currIndex;
            }
            currNode = currNode.next;
            currIndex++;
        }
        return maxIndex;
    }

    public int getMin() {
        if (isEmpty()) {
            throw new IllegalStateException("리스트가 비어 있습니다.");
        }
        Node<E> currNode = head.next;
        E min = currNode.item;
        int minIndex = 0;
        int currIndex = 0;

        while(currNode != null) {
            if (((Comparable)(currNode.item)).compareTo(min) < 0) {
                min = currNode.item;
                minIndex = currIndex;
            }
            currNode = currNode.next;
            currIndex++;
        }
        return minIndex;
    }

    public MyLinkedList<E> sortByAsc() {
        //원소가 한개 이하일때
        if (numItems <= 1){
            return this.subList(0, numItems -1);
        }

        MyLinkedList<E> sortedList = this.subList(0, numItems -1);
        quickSort(sortedList, 0, sortedList.size() -1, true);

        return sortedList;
    }

    public MyLinkedList<E> sortByDesc() {
        if (numItems <= 1) {
            return this.subList(0, numItems - 1);
        }

        MyLinkedList<E> sortedList = this.subList(0, numItems - 1);
        quickSort(sortedList, 0, sortedList.size() - 1, false);

        return sortedList;
    }

    private void quickSort(MyLinkedList<E> list, int low, int high, boolean isAsc) {
        if (low < high) {
            //피벗 인덱스 값
            int pivotIndex = partition(list, low, high, isAsc);

            //왼쪽구역정렬
            quickSort(list, low, pivotIndex - 1, isAsc);
            //오른쪽구역정렬
            quickSort(list, pivotIndex + 1, high, isAsc);
        }
    }

    // 피벗을 기준으로 리스트를 작은 구역과 큰 구역으로 나누고, 피벗의 최종 위치를 반환하는 메서드(로무토방식)
    private int partition(MyLinkedList<E> list, int low, int high, boolean isAsc) {
        //피벗값
        E pivot = list.get(high);

        // i는 피벗보다 작은 원소들이 들어갈 구역의 마지막 경계 인덱스.
        int i = low - 1;


        for (int j = low; j < high; j++) {
            int cmp = ((Comparable<E>) list.get(j)).compareTo(pivot);
            boolean shouldSwap = isAsc ? (cmp <= 0) : (cmp >= 0);

            // isAsc가 true면 cmp <= 0(피벗 이하인 값 수집)
            // isAsc가 false면 cmp >= 0(피벗 이상인 값 수집)
            if (shouldSwap) {
                i++; // 작은 원소 구역의 경계를 한 칸 확장합니다.

                // i값과 j값 위치 변경
                E temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }

        //원래 피벗위치와 하이 위치 변경
        E temp = list.get(i + 1);
        list.set(i + 1, list.get(high));
        list.set(high, temp);

        // 피벗위치 인덱스
        return i + 1;
    }

}

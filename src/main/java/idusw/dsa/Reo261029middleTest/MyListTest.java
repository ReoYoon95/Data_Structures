package idusw.dsa.Reo261029middleTest;


public class MyListTest {
    public static void main(String[] args) {
        ListInterface<Integer> list = new MyArrayList<>();
        MyLinkedList linkedList = new MyLinkedList();

        for (int i =1; i <= 5; i++) {
            list.add(i);
            linkedList.add(i);
        }

        System.out.println("ArrayList: " + list.toString(0, 5));
        System.out.println("LinkedList: " + linkedList.toString());


    }
}

package idusw.dsa.Reo261022;

public class MyArrayListTest {
    public static void main(String[] args) {

// 1. 인터페이스 규격에 맞춰 Integer 제네릭 리스트 생성
        ListInterface<Integer> list = new MyArrayList<>();

        for (int i = 1; i <= 7; i++) {
            list.add(i);
        }
        list.add(2, 99);
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//        list.add(6);
//        list.add(7);
        list.getMinIdx();
        list.getMaxIdx();
        System.out.println("Min index: " + list.getMinIdx());
        System.out.println("Max index: " + list.getMaxIdx());
        System.out.println(list.toString());

    }
}

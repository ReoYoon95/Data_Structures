package idusw.dsa.Reo261107_HW;

import java.util.Random;

public class MyLinkedListTest {
    public static void main(String[] args) {
        Random rand = new Random();
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        for (int i = 0; i < 10; i++)
            linkedList.append(rand.nextInt(100));

        for (int i = 0; i < linkedList.size(); i++) {
            System.out.print(linkedList.get(i));
            if(i < linkedList.size() - 1) {
                System.out.print(",");
            }
        }

        System.out.println("\n생성된 난수 리스트 (toString)  : " + linkedList.toString());

        int maxIdx = linkedList.getMax();
        int minIdx = linkedList.getMin();
        System.out.println("최댓값: " + linkedList.get(maxIdx) + " (인덱스: " + maxIdx + ")");
        System.out.println("최솟값: " + linkedList.get(minIdx) + " (인덱스: " + minIdx + ")");

        MyLinkedList<Integer> sub = linkedList.subList(2, 6);
        System.out.println("subList(2, 6) 결과: " + sub);

        MyLinkedList<Integer> ascList = linkedList.sortByAsc();
        System.out.println("오름차순 정렬 (sortByAsc) : " + ascList);

        MyLinkedList<Integer> descList = linkedList.sortByDesc();
        System.out.println("내림차순 정렬 (sortByDesc): " + descList);

    }
}

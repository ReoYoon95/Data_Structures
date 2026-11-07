package idusw.dsa.Reo261107_HW;
import java.util.Random;

public class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        Random rand = new Random();
        for(int i = 0; i < 10; i++)
            list.append(rand.nextInt(100)); // 인덱스 0

        System.out.println(list.toStr());
        list.remove(1); // 1번 인덱스 즉, 2번째 원소 제거
        System.out.println(list.toStr2());
        list.add(4, 10); // 4번 인덱스 즉, 5번째 원소로 10을 추가
        System.out.println(list.toStr2());
        // subList(from, to) : from 인덱스에서 to 인덱스까지 원소로 구성된 리스트 반환, to - 1 까지 원소가 아님
        System.out.println(list.subList(3, 5)); // print 문의 매개변수가 객체인 경우 객체의 toString() 메소드를 호출
        String sub = "Induk University";
        System.out.println(sub.substring(3, 5)); // begin 부터 end - 1까지 문자열을 추출
        System.out.println(list.get(list.getMax()) + ":" + list.get(list.getMin()));
    }
}

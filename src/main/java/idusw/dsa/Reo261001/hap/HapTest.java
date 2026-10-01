package idusw.dsa.Reo261001.hap;

import java.util.Scanner;

public class HapTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("시작값을 입력하시오: ");
        int start = input.nextInt();
        System.out.println("끝값을 입력하시오: ");
        int end = input.nextInt(); //nextInt가 다음에 오는숫자만 가지고옴.
        input.nextLine(); //아직 널문자가 남아있기에 정리

//        long stime = System.currentTimeMillis();
        long stime = System.nanoTime();
        HapUsingLoop loop = new HapUsingLoop(start, end);
        System.out.println("누적합은 : " + loop.sum());
        //        long etime = System.currentTimeMillis();
        long etime = System.nanoTime();
        System.out.println("소요 시간은 : " + (etime - stime) + " ns");

//        long stime2 = System.currentTimeMillis();
        long stime2 = System.nanoTime();
        HapUsingGauss gauss = new HapUsingGauss(start, end);
        System.out.println("가우스는 : " + gauss.sum());
        //        long etime2 = System.currentTimeMillis();
        long etime2 = System.nanoTime();
        System.out.println("소요 시간은 : " + (etime2 - stime2) + " ns");

    }
}

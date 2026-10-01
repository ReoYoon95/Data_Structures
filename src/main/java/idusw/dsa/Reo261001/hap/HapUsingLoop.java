package idusw.dsa.Reo261001.hap;

public class HapUsingLoop {
    int from, to; // 필드, 인스턴스 변수

    public HapUsingLoop(int start, int end) {
        from = start;
        to = end;
    }

    public int sum() {
        int result = 0;
        for (int i = from; i <= to; i++)
            result = result + i;
        return result;
    }
}



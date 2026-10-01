package idusw.dsa.Reo261001.hap;

public class HapUsingGauss {
    int from, to; // 필드, 인스턴스 변수

    public HapUsingGauss(int start, int end) {
        from = start;
        to = end;
    }

    public int sum() {
        int result = (from + to) * (to - from + 1) / 2;
        return result;
    }
}

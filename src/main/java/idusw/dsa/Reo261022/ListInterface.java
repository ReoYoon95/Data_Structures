package idusw.dsa.Reo261022;

public interface ListInterface<E> {

    public void add(int i, E x);       // 특정 위치(i)에 원소(x) 삽입
    public void add(E x);              // 맨 끝에 원소(x) 추가 (append 대체 오버로딩)
    public E remove(int i);            // i번째 원소 삭제 후 반환
    public boolean removeItem(E x);    // 원소 x를 찾아 삭제 성공 여부 반환
    public E get(int i);               // i번째 원소 조회
    public void set(int i, E x);       // i번째 원소를 x로 수정
    public int indexOf(E x);           // 원소 x의 인덱스 검색
    public int size();                 // 현재 원소 개수 반환
    public boolean isEmpty();          // 비어있는지 확인
    public void clear();               // 전체 비우기
    public int getMaxIdx();
    public int getMinIdx();
}
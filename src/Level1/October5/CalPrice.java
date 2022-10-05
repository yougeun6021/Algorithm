package Level1.October5;

public class CalPrice { // 부족한 금액 계산하기
    public static void main(String[] args) {
        int price = 3;
        int money = 20;
        int count = 4;
        System.out.println(solution(price,money,count));

    }

    public static long solution(int price, int money, int count) {
        long a = price*((long) count *(1+count)/2)-money;
        return a>0? a:0;

    }
}

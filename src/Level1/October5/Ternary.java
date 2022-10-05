package Level1.October5;

public class Ternary { // 3진법 뒤집기
    public static void main(String[] args) {
        int n = 45;
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        StringBuilder stringBuilder = new StringBuilder(Integer.toString(n, 3));
        stringBuilder.reverse();

        return Integer.parseInt(stringBuilder.toString(),3);
    }
}

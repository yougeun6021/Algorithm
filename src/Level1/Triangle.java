package Level1;


public class Triangle { // 삼각형의 완성 조건
    public static void main(String[] args) {
        int[] sides={11, 7};
        System.out.println(solution(sides));

    }

    public static int solution(int[] sides) {
        int min = Math.min(sides[0],sides[1]);

        return 2*min-1;
    }
}

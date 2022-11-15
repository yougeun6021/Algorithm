package Level1;

public class SquareNumber {
    public static void main(String[] args) {
        int n =144;
        System.out.println(solution(144));
    }

    public static int solution(int n) {
        double sqrt = Math.sqrt(n);
        return sqrt==Math.ceil(sqrt) ? 1:2;
    }
}

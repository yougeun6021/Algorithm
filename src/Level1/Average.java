package Level1;


public class Average { // 폍균구하기
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(solution(arr));
    }

    public static double solution(int[] arr) {
        double answer = 0;
        for (int j : arr) {
            answer += j;
        }
        return answer/arr.length;
    }

}

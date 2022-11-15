package Level2;


public class TargetNumber { //타겟 넘버
    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(solution(numbers,target));

    }

    public static int  solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    public static int dfs(int[] numbers, int target, int depth, int sum) {
        int targetCount = 0;

        if (depth == numbers.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }

        targetCount += dfs(numbers, target, depth + 1, sum + numbers[depth]);
        targetCount += dfs(numbers, target, depth + 1, sum - numbers[depth]);
        return targetCount;
    }

}

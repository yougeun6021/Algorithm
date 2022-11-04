package Level1.November4;

public class FoodFighter { //푸드파이터 대회
    public static void main(String[] args) {
        int[] food = {1, 3, 4, 6};
        System.out.println(solution(food));
    }
    public static String solution(int[] food) {
        StringBuilder answer = new StringBuilder();
        StringBuilder reverseAnswer = new StringBuilder();
        for(int i=1; i<food.length;i++){
            for(int j=1; j<=food[i]/2;j++){
                answer.append(i);
                reverseAnswer.append(i);
            }
        }
        answer.append("0");
        answer.append(reverseAnswer.reverse());

        return answer.toString();
    }
}

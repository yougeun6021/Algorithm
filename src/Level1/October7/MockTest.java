package Level1.October7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MockTest { //모의고사
    public static void main(String[] args) {
        int[] answers = {1,2,3,4,5};
        System.out.println(Arrays.toString(solution(answers)));
    }

    public static int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int[] oneAnswer = {1, 2, 3, 4, 5};
        int[] twoAnswer = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] threeAnswer = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] point = new int[3];
        for(int i=0; i<answers.length;i++){
            if(oneAnswer[i% oneAnswer.length]==answers[i]){
                point[0]++;
            }
            if(twoAnswer[i%twoAnswer.length]==answers[i]){
                point[1]++;
            }
            if(threeAnswer[i% threeAnswer.length]==answers[i]){
                point[2]++;
            }
        }
        int max = Math.max(Math.max(point[0],point[1]),point[2]);
        for(int j=0; j<3;j++){
            if(max==point[j]){
                answer.add(j+1);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}

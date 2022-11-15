package Level2;

import java.util.Arrays;


public class HIndex { //H-Index
    public static void main(String[] args) {
        int[] citations = {6, 5, 5, 5, 3, 2, 1, 0};
        System.out.println(solution(citations));
    }

    public static int solution(int[] citations) {
        int answer = 0;
        int upCount = 0;
        int downCount =0;
        Arrays.sort(citations);
        for(int i=0; i< citations.length;i++){
            for (int citation : citations) {
                if (i <= citation) {
                    upCount++;
                } else {
                    downCount++;
                }
            }
            if(i<=upCount && i>=downCount){
                answer = i;
            }
            upCount =0;
            downCount =0;
        }

        return answer;
    }

    public static int solution2(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for(int i=0; i<citations.length; i++){
            int min = Math.min(citations[i], citations.length-i);
            answer = Math.max(answer, min);
        }
        return answer;
    }
}

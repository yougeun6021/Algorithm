package Level1.October30;

import java.util.*;

public class Ranking { //등수 매기기
    public static void main(String[] args) {
        int[][] score = {{80, 70},{70, 80},{30, 50},{90, 100},{100,90},{100, 100},{10, 30}};
        System.out.println(Arrays.toString(solution(score)));

    }

    public static int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i=0; i<score.length;i++){
            hashMap.put(i,score[i][0]+score[i][1]);
        }

        List<Integer> list = new ArrayList<>(hashMap.keySet());
        list.sort((o1, o2) -> hashMap.get(o2)-hashMap.get(o1));

        int ranking =1;
        int sameCount =0;
        answer[list.get(0)] = 1;

        for(int i=1; i<list.size();i++){
            if(hashMap.get(list.get(i-1)).equals(hashMap.get(list.get(i)))){
                answer[list.get(i)] = ranking;
                sameCount++;
                continue;
            }
            ranking += sameCount;
            sameCount = 0;
            answer[list.get(i)] = ++ranking;
        }

        return answer;
    }

    public static int[] solution2(int[][] score) {
        List<Integer> scoreList = new ArrayList<>();
        for(int[] t : score){
            scoreList.add(t[0] + t[1]);
        }
        scoreList.sort(Comparator.reverseOrder());

        int[] answer = new int[score.length];
        for(int i=0; i<score.length; i++){
            answer[i] = scoreList.indexOf(score[i][0] + score[i][1])+1;
        }
        return answer;
    }

}

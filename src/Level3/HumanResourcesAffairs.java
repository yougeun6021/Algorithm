package Level3;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HumanResourcesAffairs { // 인사 고과
    public static void main(String[] args) {
        int[][] scores = {{2,2},{1,4},{3,2},{3,2},{2,1}};
        System.out.println(solution(scores));

    }

    public static int solution(int[][] scores) {
        int answer =1;
        int attitude = scores[0][0];
        int colleague = scores[0][1];
        int sum = attitude+colleague;
        List<Score> list = new ArrayList<>();

        for(int i=1; i<scores.length;i++){
            int aScore = scores[i][0];
            int cScore = scores[i][1];

            if(attitude<aScore && colleague<cScore){
                return -1;
            }
            if(sum<aScore+cScore){
                list.add(new Score(aScore,cScore));
                answer++;
            }
        }

        Collections.sort(list);

        for(int i=0; i<list.size()-1;i++){
            Score s1 = list.get(i);
            int aScore= s1.getAttitude();
            int cScore = s1.getColleague();

            for(int j=i+1;j<list.size();j++){
                Score s2 = list.get(j);
                if(aScore<s2.getAttitude() && cScore<s2.getColleague()){
                    answer--;
                    break;
                }
            }
        }

        return answer;
    }

    static class Score implements Comparable<Score>{
        int attitude;
        int colleague;

        Score(int attitude,int colleague){
            this.attitude = attitude;
            this.colleague = colleague;
        }

        public int getAttitude() {
            return attitude;
        }

        public int getColleague() {
            return colleague;
        }


        @Override
        public int compareTo(Score o) {
            return (this.attitude+this.colleague)-(o.attitude+o.colleague);
        }

        @Override
        public String toString() {
            return "Score{" +
                    "attitude=" + attitude +
                    ", colleague=" + colleague +
                    '}';
        }
    }
}

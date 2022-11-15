package Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DefiniteIntegral { //우박수열 정적분
    public static void main(String[] args) {
        int k = 5;
        int[][] ranges = {{0,0},{0,-1},{2,-3},{3,-3}};
        System.out.println(Arrays.toString(solution(k, ranges)));

    }

    public static double[] solution(int k, int[][] ranges) {
        List<Integer> yList = getCollatzList(k);

        double[] sumArea = getSumArea(yList);

        return getAnswer(sumArea,ranges);
    }

    private static List<Integer> getCollatzList(int k){
        List<Integer> yList = new ArrayList<>();
        yList.add(k);

        while (k!=1){
            if(k%2==0){
                k=k/2;
            }else{
                k = 3*k+1;
            }
            yList.add(k);
        }

        return yList;
    }

    private static double[] getSumArea(List<Integer> yList){
        double[] sumArea = new double[yList.size()];
        double sum = 0.0;
        for(int i=0; i<yList.size()-1;i++){
            sum += (yList.get(i)+yList.get(i+1))/2.0;
            sumArea[i+1] = sum;
        }

        return sumArea;
    }

    private static double[] getAnswer(double[] sumArea,int[][] ranges){
        double[] answer = new double[ranges.length];

        for(int i=0; i<ranges.length;i++){
            if(ranges[i][0]> sumArea.length-1+ranges[i][1]){
                answer[i] = -1.0;
            }else{
                answer[i] = sumArea[sumArea.length-1+ranges[i][1]]-sumArea[ranges[i][0]];
            }
        }
        return answer;
    }
}

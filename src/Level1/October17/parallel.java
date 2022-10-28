package Level1.October17;

import java.util.ArrayList;
import java.util.List;

public class parallel { // 평행
    public static void main(String[] args) {
        int[][] dots = {{1,4},{2,4},{2,4},{2,3}};
        System.out.println(solution(dots));
    }

    public static int solution(int[][] dots) {
        List<Double> gradientList =new ArrayList<>();
        for(int i=0; i< dots.length-1;i++){
            for(int j=i+1; j<dots.length;j++){

                if(dots[j][1]-dots[i][1]==0){
                    if(gradientList.contains(Double.MAX_VALUE)){
                        return 1;
                    }
                    gradientList.add(Double.MAX_VALUE);
                    continue;
                }

                if(dots[j][0]-dots[i][0]==0){
                    if(gradientList.contains(Double.MIN_VALUE)){
                        return 1;
                    }
                    gradientList.add(Double.MIN_VALUE);
                    continue;
                }

                double gradient = (double)(dots[j][0]-dots[i][0])/(dots[j][1]-dots[i][1]);
                if(gradientList.contains(gradient)){
                    return 1;
                }
                gradientList.add(gradient);
            }
        }
        return 0;
    }
}

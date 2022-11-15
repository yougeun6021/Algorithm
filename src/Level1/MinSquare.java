package Level1;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinSquare { //최소 직사각형
    public static void main(String[] args) {
        int[][] sizes= {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println(solution(sizes));

    }

    public static int solution(int[][] sizes) {
        List<Integer> maxList = new ArrayList<>();
        List<Integer> minList = new ArrayList<>();
        for (int[] size : sizes) {
            maxList.add(Math.max(size[0], size[1]));
            minList.add(Math.min(size[0], size[1]));
        }
        return Collections.max(maxList)*Collections.max(minList);
    }
}

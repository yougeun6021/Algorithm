package Level1.October7;

import java.util.Arrays;
import java.util.HashSet;

public class Phonkemon {
    public static void main(String[] args) {
        int[] nums = {3,1,2,3};
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }
        return Math.min(set.size(), nums.length / 2);

    }
}
